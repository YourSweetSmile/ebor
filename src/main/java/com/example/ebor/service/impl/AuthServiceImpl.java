package com.example.ebor.service.impl;

import com.example.ebor.exception.SysRuntimeExeption;
import com.example.ebor.mapper.SysRoleMapper;
import com.example.ebor.mapper.SysUserMapper;
import com.example.ebor.model.SysRole;
import com.example.ebor.model.SysUser;
import com.example.ebor.security.JwtTokenUtil;
import com.example.ebor.security.auth.UserContext;
import com.example.ebor.service.AuthService;
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

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 登录
     * @param user
     * @return
     */
    @Override
    public Map login(SysUser user) {

        SysUser dbUser = sysUserMapper.selectByPrimaryKey(user.getUserId());
        if(null == dbUser){
            throw new SysRuntimeExeption("当前用户未找到");
        }

        if(!user.getPassword().equals(dbUser.getPassword())){
            throw new SysRuntimeExeption("密码错误");
        }

        return packageLoginUser(dbUser);
    }

    /**
     * 打包用户信息
     * @param user
     * @return
     */
    private Map packageLoginUser(SysUser user){

        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(user.getRoleId());
        String[] jurisdiction = sysRole.getJurisdiction().split("\\|");

        //封装登录用户信息
        UserContext userContext = UserContext.create(Integer.parseInt(user.getUserId().toString()),user.getUserName(),
                mapToGrantedAuthorities(jurisdiction));

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", tokenFactory.createAccessToken(userContext));
        tokenMap.put("refreshToken", tokenFactory.createRefreshToken(userContext));
        tokenMap.put("userName", userContext.getUserName());

        return tokenMap;
    }

    /**
     * 封装权限信息
     * @param roles
     * @return
     */
    private static List<GrantedAuthority> mapToGrantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }
}
