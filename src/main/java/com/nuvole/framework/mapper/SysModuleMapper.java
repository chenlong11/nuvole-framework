package com.nuvole.framework.mapper;

import com.nuvole.framework.SuperMapper;
import com.nuvole.framework.domain.SysModule;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：16:43
 */
public interface SysModuleMapper extends SuperMapper<SysModule> {

    @Select("select " +
            "  m.id," +
            "  m.mname " +
            "from " +
            "   sys_module m, sys_role r, sys_user u, sys_user_role ur, sys_module_role mr " +
            "where" +
            "   m.id = mr.mid and r.id = mr.rid and u.id = ur.uid and r.id = ur.rid " +
            "   and u.id = #{userid} " +
            "group by m.id")
    List<SysModule> findByUserId(Long userid);

}
