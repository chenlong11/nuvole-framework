package com.nuvole.framework.dao.role;

import com.nuvole.framework.dto.SysRoleDTO;
import com.nuvole.framework.mapper.SysRoleMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:10
 */
public interface SysRoleDao extends SysRoleMapper{

    @Select({
            "select",
            "a.id, a.role_name, a.role_code, a.sequence, a.gmt_create, a.gmt_update, a.status",
            "from sys_role a,sys_user_role b",
            "where a.id = b.role_id and b.user_id = #{userId,jdbcType=INTEGER}"
    })
    List<SysRoleDTO> findByUserId(String userId);
}
