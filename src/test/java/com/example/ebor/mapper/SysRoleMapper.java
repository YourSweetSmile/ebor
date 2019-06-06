package com.example.ebor.mapper;

import com.example.ebor.model.SysRole;
import com.example.ebor.model.SysRoleExample;
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

public interface SysRoleMapper {
    @SelectProvider(type=SysRoleSqlProvider.class, method="countByExample")
    long countByExample(SysRoleExample example);

    @DeleteProvider(type=SysRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleExample example);

    @Delete({
        "delete from sys_role",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer roleId);

    @Insert({
        "insert into sys_role (role_id, role_name, ",
        "role_remark, jurisdiction, ",
        "create_time)",
        "values (#{roleId,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleRemark,jdbcType=VARCHAR}, #{jurisdiction,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=VARCHAR})"
    })
    int insert(SysRole record);

    @InsertProvider(type=SysRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysRole record);

    @SelectProvider(type=SysRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_remark", property="roleRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="jurisdiction", property="jurisdiction", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    List<SysRole> selectByExample(SysRoleExample example);

    @Select({
        "select",
        "role_id, role_name, role_remark, jurisdiction, create_time",
        "from sys_role",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_remark", property="roleRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="jurisdiction", property="jurisdiction", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR)
    })
    SysRole selectByPrimaryKey(Integer roleId);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleExample example);

    @UpdateProvider(type=SysRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysRole record);

    @Update({
        "update sys_role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "role_remark = #{roleRemark,jdbcType=VARCHAR},",
          "jurisdiction = #{jurisdiction,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR}",
        "where role_id = #{roleId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysRole record);
}