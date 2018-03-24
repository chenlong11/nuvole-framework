package com.nuvole.framework.service;

import com.baomidou.mybatisplus.service.IService;
import com.nuvole.framework.entity.User;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:31
 */
public interface IUserService extends IService<User> {

    boolean deleteAll();

    List<User> selectListBySQL();

}
