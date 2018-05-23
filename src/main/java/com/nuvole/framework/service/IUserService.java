package com.nuvole.framework.service;

import com.baomidou.mybatisplus.service.IService;
import com.nuvole.framework.domain.SysUser;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:31
 */
public interface IUserService extends IService<SysUser> {

    List<SysUser> selectListBySQL();

    SysUser findByUsername(String username);
}
