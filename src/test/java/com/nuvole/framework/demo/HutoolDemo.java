package com.nuvole.framework.demo;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.NetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;

import java.util.Date;

/**
 * Created by chenlong
 * Date：2018/1/15
 * time：16:08
 */
public class HutoolDemo {

    public static void main(String[] args) {
        System.out.println(NetUtil.localIpv4s());
        System.out.println(NetUtil.getLocalhostStr());
        System.out.println(NetUtil.getLocalMacAddress());

        System.out.println(RandomUtil.randomString(10));
        System.out.println(RandomUtil.randomLong(1000000));
        System.out.println(RandomUtil.randomNumbers(10));
        System.out.println(RandomUtil.simpleUUID());

        String str = "123456789";
        System.out.println(Convert.toLong(str));

        System.out.println(SecureUtil.md5(str));

        System.out.println(DateUtil.now());

        Date date = DateUtil.parse("2017-09-10");
        System.out.println(DateUtil.format(date,"yyyyMMdd"));

        System.out.println(StrUtil.isEmpty(null));

        System.out.println(IdcardUtil.isValidCard("411303198803111030"));
    }

}
