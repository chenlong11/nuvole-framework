package com.nuvole.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by chenlong
 * Date：2018/6/30
 * time：19:05
 */
@Configuration
@MapperScan({"com.nuvole.framework.mapper","com.nuvole.framework.dao"})
public class MybatisConfig {

}
