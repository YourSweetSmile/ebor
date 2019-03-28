package com.example.ebor.service.impl;

import com.example.ebor.model.TestSysUser;
import com.example.ebor.security.JwtTokenUtil;
import com.example.ebor.security.auth.UserContext;
import com.example.ebor.service.AuthService;
import org.assertj.core.util.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private JwtTokenUtil tokenFactory;

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public Map login(TestSysUser user) {

        List<String> temps = new ArrayList<>();
        temps.add("main");
        temps.add("head");

        //封装登录用户信息
        UserContext userContext = UserContext.create(Integer.parseInt(user.getUserId().toString()),user.getUserName(), mapToGrantedAuthorities(temps));

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", tokenFactory.createAccessToken(userContext));
        tokenMap.put("refreshToken", tokenFactory.createRefreshToken(userContext));
        tokenMap.put("userName", userContext.getUserName());

        return tokenMap;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
