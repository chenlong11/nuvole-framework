package com.nuvole.framework.service.user;

import com.nuvole.framework.dto.SysUserDTO;
import com.nuvole.framework.service.BaseService;

/**
 * Created by chenlong
 * Date：2018/7/1
 * time：20:00
 */
public interface SysUserService extends BaseService {

    SysUserDTO findByLoginName(String loginName);

    SysUserDTO findById(String userId);

}
