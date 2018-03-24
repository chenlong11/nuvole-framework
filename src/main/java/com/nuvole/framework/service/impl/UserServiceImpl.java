package com.nuvole.framework.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nuvole.framework.entity.User;
import com.nuvole.framework.mapper.UserMapper;
import com.nuvole.framework.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:32
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean deleteAll() {
        return retBool(baseMapper.deleteAll());
    }

    @Override
    public List<User> selectListBySQL() {
        return baseMapper.selectListBySQL();
    }
}
