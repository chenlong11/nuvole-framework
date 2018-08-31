package com.nuvole.framework.service.user;

import com.nuvole.framework.dao.user.SysUserDao;
import com.nuvole.framework.domain.SysUser;
import com.nuvole.framework.dto.SysUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：20:01
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUserDTO findByLoginName(String loginName) {
        return sysUserDao.findByLoginName(loginName);
    }

    @Override
    public SysUserDTO findById(String userId) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(userId);
        SysUserDTO userDTO = new SysUserDTO();
        BeanUtils.copyProperties(sysUser, userDTO);
        return userDTO;
    }

}
