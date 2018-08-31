package com.nuvole.framework.service.moudle;

import com.nuvole.framework.dao.moudle.SysModuleDao;
import com.nuvole.framework.domain.SysModule;
import com.nuvole.framework.dto.SysModuleDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:37
 */
@Service
public class SysModuleServiceImpl implements SysModuleService {

    @Autowired
    private SysModuleDao sysMoudleDao;

    @Override
    public List findListByUserId(String userId) {
        return sysMoudleDao.findListByUserId(userId);
    }

    @Override
    public List<SysModuleDTO> findAll() {
        List<SysModuleDTO> permissions = new ArrayList<SysModuleDTO>();
        List<SysModule> sysModules = sysMoudleDao.selectAll();
        sysModules.forEach(sysModule -> {
            SysModuleDTO sysModuleDTO = new SysModuleDTO();
            BeanUtils.copyProperties(sysModule,sysModuleDTO);
            permissions.add(sysModuleDTO);
        });
        return permissions;
    }

    @Override
    public List<SysModuleDTO> findAllByStatus(Integer status) {
        return sysMoudleDao.selectAllByStatus(status);
    }

}
