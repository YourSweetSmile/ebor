package com.example.ebor.config;

import com.example.ebor.security.SecuritySettings;
import com.example.ebor.security.auth.JwtAuthenticationProcessingFilter;
import com.example.ebor.security.auth.JwtAuthenticationProvider;
import com.example.ebor.security.auth.JwtAuthenticationRequestMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private SecuritySettings settings;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // We don't need CSRF for JWT based authentication
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint)

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .antMatchers(settings.getPermitUrl()).permitAll() // permit end-point

                .and()
                .authorizeRequests()
                .antMatchers(settings.getProtectUrl()).authenticated()

                .and()
                .addFilterBefore(buildAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class); // Protected API End-points

    }

    protected JwtAuthenticationProcessingFilter buildAuthenticationProcessingFilter() throws Exception {
        List<String> pathsToSkip = Arrays.asList(settings.getPermitUrl());
        List<String> pathsToProcess = Arrays.asList(settings.getProtectUrl());
        JwtAuthenticationRequestMatcher matcher = new JwtAuthenticationRequestMatcher(pathsToSkip, pathsToProcess);
        JwtAuthenticationProcessingFilter filter = new JwtAuthenticationProcessingFilter(settings, objectMapper, matcher);
        filter.setAuthenticationManager(this.authenticationManager);
        return filter;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(jwtAuthenticationProvider);
    }
}
