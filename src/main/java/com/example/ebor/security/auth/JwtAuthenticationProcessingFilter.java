package com.example.ebor.security.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ebor.config.ResponseInfo;
import com.example.ebor.security.JwtTokenUtil;
import com.example.ebor.security.SecuritySettings;
import com.example.ebor.security.UserContext;
import com.example.ebor.utils.SysUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
public class JwtAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private SecuritySettings settings;

    private ObjectMapper mapper;

    @Autowired
    private JwtTokenUtil tokenFactory;

    @Autowired
    public JwtAuthenticationProcessingFilter(SecuritySettings settings, ObjectMapper objectMapper, RequestMatcher matcher) {
        super(matcher);
        this.settings = settings;
        this.mapper = objectMapper;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String tokenPayload = request.getHeader(settings.getTokenHeaderParam());
        if (StringUtils.isBlank(tokenPayload)) {
            throw new AuthenticationServiceException("认证失败！令牌不能为空！");
        }
        log.debug("token is {}", tokenPayload);
        return getAuthenticationManager().authenticate(new JwtAuthenticationToken(tokenPayload));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);

        JwtTokenUtil tokenFactory = SysUtil.getBean("jwtTokenUtil", JwtTokenUtil.class);
        String newToken = tokenFactory.createAccessToken((UserContext)authResult.getPrincipal());
        response.setHeader("token", newToken);

        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException e) throws IOException, ServletException {
        SecurityContextHolder.clearContext();
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        mapper.writeValue(response.getWriter(), new ResponseInfo<String>(false, e.getMessage(), request.getRequestURL().toString()));
    }
}
