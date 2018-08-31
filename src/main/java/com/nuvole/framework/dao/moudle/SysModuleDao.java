package com.nuvole.framework.dao.moudle;

import com.nuvole.framework.dto.SysModuleDTO;
import com.nuvole.framework.mapper.SysModuleMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:30
 */
public interface SysModuleDao extends SysModuleMapper {

    @Select(" select a.id, a.menu_code, a.menu_name, a.data_url, a.pid, a.level, a.menu_type, a.sequence " +
            " from sys_module a,sys_module_role b,sys_user_role c  " +
            " where " +
            " a.id = b.module_id and b.role_id = c.role_id " +
            " and c.user_id = #{userId,jdbcType=VARCHAR}  ")
    List<SysModuleDTO> findListByUserId(String userId);

    @Select({
            "select",
            "id, menu_code, menu_name, data_url, pid, level, menu_type, sequence, gmt_create, ",
            "gmt_update, status",
            "from sys_module where status = #{status,jdbcType=TINYINT} "
    })
    List<SysModuleDTO> selectAllByStatus(Integer status);


}
