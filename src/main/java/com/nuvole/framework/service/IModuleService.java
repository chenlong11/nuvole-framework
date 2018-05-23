package com.nuvole.framework.service;

import com.baomidou.mybatisplus.service.IService;
import com.nuvole.framework.domain.SysModule;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：16:52
 */
public interface IModuleService extends IService<SysModule> {

    List<SysModule> findByUserId(Long userid);

}
