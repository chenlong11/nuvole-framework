package com.nuvole.framework.mapper;

import com.nuvole.framework.domain.SysRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysRoleMapper {
    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_role (id, role_name, ",
        "role_code, sequence, ",
        "gmt_create, gmt_update, ",
        "status)",
        "values (#{id,jdbcType=VARCHAR}, #{roleName,jdbcType=VARCHAR}, ",
        "#{roleCode,jdbcType=VARCHAR}, #{sequence,jdbcType=BIGINT}, ",
        "#{gmtCreate,jdbcType=BIGINT}, #{gmtUpdate,jdbcType=BIGINT}, ",
        "#{status,jdbcType=TINYINT})"
    })
    int insert(SysRole record);

    @Select({
        "select",
        "id, role_name, role_code, sequence, gmt_create, gmt_update, status",
        "from sys_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SysRole selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, role_name, role_code, sequence, gmt_create, gmt_update, status",
        "from sys_role"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SysRole> selectAll();

    @Update({
        "update sys_role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "role_code = #{roleCode,jdbcType=VARCHAR},",
          "sequence = #{sequence,jdbcType=BIGINT},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_update = #{gmtUpdate,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysRole record);
}