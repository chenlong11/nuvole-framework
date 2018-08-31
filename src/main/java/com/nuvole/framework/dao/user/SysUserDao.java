package com.nuvole.framework.dao.user;

import com.nuvole.framework.dto.SysUserDTO;
import com.nuvole.framework.mapper.SysUserMapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by chenlong
 * Date：2018/6/30
 * time：22:52
 */
public interface SysUserDao extends SysUserMapper {

    @Select(" select id, login_name, mobile, user_name, user_code ,password " +
            " from sys_user " +
            " where " +
            " login_name = #{loginName,jdbcType=VARCHAR} ")
    SysUserDTO findByLoginName(String loginName);

}
