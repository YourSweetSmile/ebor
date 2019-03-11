package com.example.ebor.service;

import com.example.ebor.model.SysUser;

import java.util.Map;

public interface AuthService {

    /**
     * login
     * @param user
     * @return
     */
    Map<String, String> login(SysUser user);

    /**
     * reLogin
     * @return
     */
    Map<String, String> reLogin();
}
