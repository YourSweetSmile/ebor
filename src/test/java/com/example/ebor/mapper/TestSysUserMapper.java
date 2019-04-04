package com.example.ebor.mapper;

import com.example.ebor.model.TestSysUser;
import com.example.ebor.model.TestSysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestSysUserMapper {
    long countByExample(TestSysUserExample example);

    int deleteByExample(TestSysUserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(TestSysUser record);

    int insertSelective(TestSysUser record);

    List<TestSysUser> selectByExample(TestSysUserExample example);

    TestSysUser selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TestSysUser record, @Param("example") TestSysUserExample example);

    int updateByExample(@Param("record") TestSysUser record, @Param("example") TestSysUserExample example);

    int updateByPrimaryKeySelective(TestSysUser record);

    int updateByPrimaryKey(TestSysUser record);
}