package com.example.ebor.security.auth;

import java.util.ArrayList;
import java.util.List;

import com.example.ebor.security.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * token认证具体实现类
 * 
 * @author yinjw
 *
 */
@Component
@SuppressWarnings("unchecked")
public class JwtAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationProvider.class);
	
	@Autowired
	private JwtTokenUtil tokenUtil;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String rawAccessToken = (String) authentication.getCredentials();

        Jws<Claims> jwsClaims = tokenUtil.parseClaims(rawAccessToken);
        String subject = jwsClaims.getBody().getSubject();
        int userId = jwsClaims.getBody().get("userId", Integer.class);
        List<String> roles = jwsClaims.getBody().get("roles", List.class);
        logger.debug("username:{}, userid:{}, roles:{}", subject, userId, roles);
        UserContext context = UserContext.create(userId, subject, mapToGrantedAuthorities(roles));
        
        return new JwtAuthenticationToken(context, context.getAuthorities());
    }
    
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
