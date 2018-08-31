package com.nuvole.framework.service.role;

import com.nuvole.framework.dto.SysRoleDTO;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/7/2
 * time：9:13
 */
public interface SysRoleService {
    List<SysRoleDTO> findByUserId(String id);
}
