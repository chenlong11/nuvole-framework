package com.nuvole.framework.dao.user;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nuvole.framework.domain.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenlong
 * Date：2018/6/30
 * time：23:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserDaoTest {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    public void paging() {
        PageHelper.startPage(1, 10);
        List<SysUser> sysUsers = sysUserDao.selectAll();
        PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
        System.out.println(JSON.toJSONString(pageInfo.getList()));

    }

}