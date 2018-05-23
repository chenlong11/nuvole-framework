package com.nuvole.framework.mapper;

import com.nuvole.framework.SuperMapper;
import com.nuvole.framework.domain.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：16:07
 */
public interface SysRoleMapper extends SuperMapper<SysRole> {

    @Select("select id ,rname from sys_role")
    List<SysRole> findByUserId(String uid);

}
