package com.example.ebor.service;

import com.example.ebor.model.SysUser;

import java.util.Map;

public interface AuthService {

    /**
     * 登录
     * @param user
     * @return
     */
    Map login(SysUser user);
}
