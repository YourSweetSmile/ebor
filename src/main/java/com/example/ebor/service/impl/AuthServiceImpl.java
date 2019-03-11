package com.example.ebor.service.impl;

import com.example.ebor.model.SysRole;
import com.example.ebor.model.SysUser;
import com.example.ebor.security.JwtTokenUtil;
import com.example.ebor.security.UserContext;
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

    @Override
    public Map<String, String> login(SysUser user) {

        //与数据库用户记录对比校验
        SysUser dbUser = new SysUser();
        dbUser.setUserId(1);
        dbUser.setUserName("testUser");
        dbUser.setPassword("123456");
        //封装登录用户信息
        Map<String, String> tokenMap = packageLoginUser(dbUser);

        //登录日志记录
        //logLogin(dbUser);

        return null;
    }

    private Map<String, String> packageLoginUser(SysUser dbUser){
        //构造用户权限
        //UserAuthority userAuthority = contructUserAuthority(dbUser.getUserId());
        //将该用户权限换成到redis中
        //userAuthorityDao.set(dbUser.getUserId()+"", userAuthority);

        //封装登录用户信息
        List<SysRole> roles= new ArrayList<>();
        SysRole sysRole = new SysRole();
        sysRole.setId(1);
        sysRole.setName("menu");
        roles.add(sysRole);
        UserContext userContext = UserContext.create(1,"testUser", mapToGrantedAuthorities(roles));
        Map<String, String> tokenMap = new HashMap();
        tokenMap.put("token", tokenFactory.createAccessToken(userContext));
        tokenMap.put("refreshToken", tokenFactory.createRefreshToken(userContext));
        tokenMap.put("userName", userContext.getUserName());

//        //验证服务是否授权
//        String isAuthority = licenseAuthorityService.checkLicenseAuthority();
//        tokenMap.put("authority", isAuthority);
//
//        //license剩余时长
//        long remainTime = licenseAuthorityService.getRemainingTime();
//        tokenMap.put("remainDays", String.valueOf(remainTime));

        return tokenMap;
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<SysRole> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (SysRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public Map<String, String> reLogin() {
        return null;
    }
}
