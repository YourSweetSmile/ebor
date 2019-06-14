package com.example.ebor.service.impl;

import com.example.ebor.mapper.TestSysUserMapper;
import com.example.ebor.model.TestSysUser;
import com.example.ebor.service.TestUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private TestSysUserMapper testSysUserMapper;

    @Override
    public TestSysUser getUserById(Integer userId) {
        return testSysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<TestSysUser> getList(){
        return testSysUserMapper.selectByExample(null);
    }
}
