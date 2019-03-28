package com.example.ebor.service;

import com.example.ebor.model.TestSysUser;

import java.util.Map;

public interface AuthService {

    Map login(TestSysUser user);
}
