package com.example.ebor.security.auth;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

/**
 * 存储登录用户权限信息
 * 
 * @author yinjw
 *
 */
public class UserContext {

	private final int id;
	private final String userName;
	private final List<GrantedAuthority> authorities;

	private UserContext(int id, String userName, List<GrantedAuthority> authorities) {
		this.id = id;
		this.userName = userName;
		this.authorities = authorities;
	}

	public static UserContext create(int id, String userName, List<GrantedAuthority> authorities) {
		return new UserContext(id, userName, authorities);
	}

	public int getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
