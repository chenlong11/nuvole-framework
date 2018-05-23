package com.nuvole.framework.mapper;

import com.nuvole.framework.SuperMapper;
import com.nuvole.framework.domain.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:03
 */
public interface SysUserMapper extends SuperMapper<SysUser> {

    @Select("select id ,username ,password from sys_user")
    List<SysUser> selectListBySQL();

    @Select("select id ,username ,password from sys_user where username = #{username}  ")
    SysUser findByUserName(String username);

}
