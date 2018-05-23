package com.nuvole.framework.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nuvole.framework.domain.SysModule;
import com.nuvole.framework.mapper.SysModuleMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：16:53
 */
@Service
public class IModuleServiceImpl extends ServiceImpl<SysModuleMapper, SysModule> implements IModuleService {
    @Override
    public List<SysModule> findByUserId(Long userid) {
        return baseMapper.findByUserId(userid);
    }
}
