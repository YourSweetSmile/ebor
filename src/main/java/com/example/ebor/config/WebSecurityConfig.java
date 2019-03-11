package com.example.ebor.config;

import java.util.Arrays;
import java.util.List;

import com.example.ebor.security.SecuritySettings;
import com.example.ebor.security.auth.JwtAuthenticationProcessingFilter;
import com.example.ebor.security.auth.JwtAuthenticationProvider;
import com.example.ebor.security.auth.JwtAuthenticationRequestMatcher;
import com.example.ebor.security.auth.RestAuthenticationEntryPoint;
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

import com.fasterxml.jackson.databind.ObjectMapper;

 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private RestAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private JwtAuthenticationProvider jwtAuthenticationProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private SecuritySettings settings;
	
	@Autowired 
	private ObjectMapper objectMapper;

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
                .antMatchers(settings.getProtectUrl()).authenticated() // Protected API End-points
        .and()
            .addFilterBefore(buildAuthenticationProcessingFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
