package com.nuvole.framework.mapper;

import com.nuvole.framework.domain.SysUser;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysUserMapper {
    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_user (id, login_name, ",
        "mobile, user_name, ",
        "user_code, password, ",
        "sequence, gmt_create, ",
        "gmt_update, status)",
        "values (#{id,jdbcType=VARCHAR}, #{loginName,jdbcType=VARCHAR}, ",
        "#{mobile,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{userCode,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{sequence,jdbcType=BIGINT}, #{gmtCreate,jdbcType=BIGINT}, ",
        "#{gmtUpdate,jdbcType=BIGINT}, #{status,jdbcType=TINYINT})"
    })
    int insert(SysUser record);

    @Select({
        "select",
        "id, login_name, mobile, user_name, user_code, password, sequence, gmt_create, ",
        "gmt_update, status",
        "from sys_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SysUser selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, login_name, mobile, user_name, user_code, password, sequence, gmt_create, ",
        "gmt_update, status",
        "from sys_user"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_code", property="userCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SysUser> selectAll();

    @Update({
        "update sys_user",
        "set login_name = #{loginName,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR},",
          "user_code = #{userCode,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "sequence = #{sequence,jdbcType=BIGINT},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_update = #{gmtUpdate,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysUser record);
}