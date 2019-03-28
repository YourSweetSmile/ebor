package com.example.ebor.mapper;

import com.example.ebor.model.TestSysUser;

public interface TestSysUserMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(TestSysUser record);

    int insertSelective(TestSysUser record);

    TestSysUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(TestSysUser record);

    int updateByPrimaryKey(TestSysUser record);
}