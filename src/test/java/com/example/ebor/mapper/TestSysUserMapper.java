package com.example.ebor.mapper;

import com.example.ebor.model.TestSysUser;
import com.example.ebor.model.TestSysUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface TestSysUserMapper {
    @SelectProvider(type=TestSysUserSqlProvider.class, method="countByExample")
    long countByExample(TestSysUserExample example);

    @DeleteProvider(type=TestSysUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestSysUserExample example);

    @Delete({
        "delete from test_sys_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into test_sys_user (user_id, login_no, ",
        "user_name, user_amount, ",
        "create_time)",
        "values (#{userId,jdbcType=INTEGER}, #{loginNo,jdbcType=VARCHAR}, ",
        "#{userName,jdbcType=VARCHAR}, #{userAmount,jdbcType=DECIMAL}, ",
        "#{createTime,jdbcType=VARCHAR})"
    })
    int insert(TestSysUser record);

    @InsertProvider(type=TestSysUserSqlProvider.class, method="insertSelective")
    int insertSelective(TestSysUser record);

    @SelectProvider(type=TestSysUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_no", property="loginNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_amount", property="userAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    List<TestSysUser> selectByExample(TestSysUserExample example);

    @Select({
        "select",
        "user_id, login_no, user_name, user_amount, create_time",
        "from test_sys_user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="login_no", property="loginNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_amount", property="userAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    TestSysUser selectByPrimaryKey(Integer userId);

    @UpdateProvider(type=TestSysUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TestSysUser record, @Param("example") TestSysUserExample example);

    @UpdateProvider(type=TestSysUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TestSysUser record, @Param("example") TestSysUserExample example);

    @UpdateProvider(type=TestSysUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TestSysUser record);

    @Update({
        "update test_sys_user",
        "set login_no = #{loginNo,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_amount = #{userAmount,jdbcType=DECIMAL},",
          "create_time = #{createTime,jdbcType=VARCHAR}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TestSysUser record);
}