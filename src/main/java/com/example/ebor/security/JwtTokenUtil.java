package com.example.ebor.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.example.ebor.exception.ExpiredTokenException;
import com.example.ebor.security.auth.UserContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

/**
 * jwt token工具类
 * 
 * @author yinjw
 *
 */
@Component
public class JwtTokenUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

	@Autowired
	private SecuritySettings settings;

	/**
	 * 创建AccessToken
	 * 
	 * @param userContext
	 * @return
	 */
	public String createAccessToken(UserContext userContext) {
		Claims claims = Jwts.claims().setSubject(userContext.getUserName());
		List<String> authorities = new ArrayList<>();
		for (GrantedAuthority authority : userContext.getAuthorities()) {
			authorities.add(authority.toString());
		}
		claims.put("roles", authorities);
		claims.put("userId", userContext.getId());

		String token = Jwts.builder().
				setClaims(claims).
				setIssuedAt(new Date()).
				setExpiration(new Date(System.currentTimeMillis() + settings.getTokenExpirationTime() * 1000)).
				signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey()).
				compact();

		return token;
	}

	/**
	 * 创建RefreshToken
	 * 
	 * @param userContext
	 * @return
	 */
	public String createRefreshToken(UserContext userContext) {

		Claims claims = Jwts.claims().setSubject(userContext.getUserName());
		claims.put("roles", Arrays.asList("TOKEN"));

		String token = Jwts.builder().
				setClaims(claims).
				setIssuedAt(new Date()).
				setId(UUID.randomUUID().toString()).
				setExpiration(new Date(System.currentTimeMillis() + settings.getTokenExpirationTime() * 1000)).
				signWith(SignatureAlgorithm.HS512, settings.getTokenSigningKey()).
				compact();

		return token;
	}
	
	/**
     * 解析并校验token
     * 
     * @throws BadCredentialsException
     * @throws ExpiredTokenException
     * 
     */
	public Jws<Claims> parseClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(settings.getTokenSigningKey()).parseClaimsJws(token);
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException | SignatureException ex) {
            logger.error("token校验错误", ex);
            throw new BadCredentialsException("认证失败！令牌校验错误", ex);
        } catch (ExpiredJwtException expiredEx) {
            logger.error("token过期", expiredEx);
            throw new ExpiredTokenException(token, "认证令牌过期，请重新登录", expiredEx);
        }
    }
}
