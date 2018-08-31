package com.nuvole.framework.mapper;

import com.nuvole.framework.domain.SysModuleRole;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysModuleRoleMapper {
    @Delete({
        "delete from sys_module_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_module_role (id, role_id, ",
        "module_id)",
        "values (#{id,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR}, ",
        "#{moduleId,jdbcType=VARCHAR})"
    })
    int insert(SysModuleRole record);

    @Select({
        "select",
        "id, role_id, module_id",
        "from sys_module_role",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.VARCHAR)
    })
    SysModuleRole selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, role_id, module_id",
        "from sys_module_role"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="module_id", property="moduleId", jdbcType=JdbcType.VARCHAR)
    })
    List<SysModuleRole> selectAll();

    @Update({
        "update sys_module_role",
        "set role_id = #{roleId,jdbcType=VARCHAR},",
          "module_id = #{moduleId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysModuleRole record);
}