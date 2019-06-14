package com.example.ebor.service;

import com.example.ebor.model.TestSysUser;

import java.util.List;

public interface TestUserService {

    TestSysUser getUserById(Integer userId);
    List<TestSysUser> getList();
}