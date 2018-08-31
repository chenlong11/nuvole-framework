package com.nuvole.framework.mapper;

import com.nuvole.framework.domain.SysModule;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysModuleMapper {
    @Delete({
        "delete from sys_module",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into sys_module (id, menu_code, ",
        "menu_name, data_url, ",
        "pid, level, menu_type, ",
        "sequence, gmt_create, ",
        "gmt_update, status)",
        "values (#{id,jdbcType=VARCHAR}, #{menuCode,jdbcType=VARCHAR}, ",
        "#{menuName,jdbcType=VARCHAR}, #{dataUrl,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=VARCHAR}, #{level,jdbcType=CHAR}, #{menuType,jdbcType=CHAR}, ",
        "#{sequence,jdbcType=BIGINT}, #{gmtCreate,jdbcType=BIGINT}, ",
        "#{gmtUpdate,jdbcType=BIGINT}, #{status,jdbcType=TINYINT})"
    })
    int insert(SysModule record);

    @Select({
        "select",
        "id, menu_code, menu_name, data_url, pid, level, menu_type, sequence, gmt_create, ",
        "gmt_update, status",
        "from sys_module",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_url", property="dataUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.CHAR),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.CHAR),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SysModule selectByPrimaryKey(String id);

    @Select({
        "select",
        "id, menu_code, menu_name, data_url, pid, level, menu_type, sequence, gmt_create, ",
        "gmt_update, status",
        "from sys_module"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_code", property="menuCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_url", property="dataUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.CHAR),
        @Result(column="menu_type", property="menuType", jdbcType=JdbcType.CHAR),
        @Result(column="sequence", property="sequence", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_update", property="gmtUpdate", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SysModule> selectAll();

    @Update({
        "update sys_module",
        "set menu_code = #{menuCode,jdbcType=VARCHAR},",
          "menu_name = #{menuName,jdbcType=VARCHAR},",
          "data_url = #{dataUrl,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=CHAR},",
          "menu_type = #{menuType,jdbcType=CHAR},",
          "sequence = #{sequence,jdbcType=BIGINT},",
          "gmt_create = #{gmtCreate,jdbcType=BIGINT},",
          "gmt_update = #{gmtUpdate,jdbcType=BIGINT},",
          "status = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysModule record);
}