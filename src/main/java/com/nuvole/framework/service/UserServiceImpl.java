package com.nuvole.framework.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nuvole.framework.domain.SysUser;
import com.nuvole.framework.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:32
 */
@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements IUserService {

    @Override
    public List<SysUser> selectListBySQL() {
        return baseMapper.selectListBySQL();
    }

    @Override
    public SysUser findByUsername(String username) {
        return baseMapper.findByUserName(username);
    }
}
