package com.example.ebor.security.auth;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * 决定哪些路径需要被JwtAuthenticationProcessingFilter处理
 * 
 * @author yinjunwu
 *
 */
public class JwtAuthenticationRequestMatcher implements RequestMatcher {
	
	private OrRequestMatcher skips;
	private OrRequestMatcher processes;

	public JwtAuthenticationRequestMatcher(List<String> pathsToSkip, List<String> processingPath) {
		List<RequestMatcher> skip = new ArrayList<>();
		for (String path : pathsToSkip) {
			skip.add(new AntPathRequestMatcher(path));
		}
		skips = new OrRequestMatcher(skip);
		
		List<RequestMatcher> process = new ArrayList<>();
		for (String path : processingPath) {
			process.add(new AntPathRequestMatcher(path));
		}
		processes = new OrRequestMatcher(process);
	}

	@Override
	public boolean matches(HttpServletRequest request) {
		if (skips.matches(request)) {
			return false;
		}
		return processes.matches(request) ? true : false;
	}
}
