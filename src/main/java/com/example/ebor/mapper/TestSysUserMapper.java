package com.example.ebor.mapper;

import com.example.ebor.model.TestSysUser;
import com.example.ebor.model.TestSysUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestSysUserMapper {
    long countByExample(TestSysUserExample example);

    int deleteByExample(TestSysUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(TestSysUser record);

    int insertSelective(TestSysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table test_sys_user
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    TestSysUser selectOneByExample(TestSysUserExample example);

    List<TestSysUser> selectByExample(TestSysUserExample example);

    TestSysUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") TestSysUser record, @Param("example") TestSysUserExample example);

    int updateByExample(@Param("record") TestSysUser record, @Param("example") TestSysUserExample example);

    int updateByPrimaryKeySelective(TestSysUser record);

    int updateByPrimaryKey(TestSysUser record);
}