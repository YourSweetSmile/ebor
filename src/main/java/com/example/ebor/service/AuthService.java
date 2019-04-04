package com.example.ebor.service;

import com.example.ebor.model.SysUser;

import java.util.Map;

public interface AuthService {

    Map login(SysUser user);
}
