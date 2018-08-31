package com.nuvole.framework.service.role;

import com.nuvole.framework.dao.role.SysRoleDao;
import com.nuvole.framework.dto.SysRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:17
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public List<SysRoleDTO> findByUserId(String id) {
        return sysRoleDao.findByUserId(id);
    }

}
