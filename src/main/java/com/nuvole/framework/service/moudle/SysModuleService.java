package com.nuvole.framework.service.moudle;

import com.nuvole.framework.dto.SysModuleDTO;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：21:26
 */
public interface SysModuleService {

    List findListByUserId(String userId);

    List<SysModuleDTO> findAll();

    List<SysModuleDTO> findAllByStatus(Integer status);
}
