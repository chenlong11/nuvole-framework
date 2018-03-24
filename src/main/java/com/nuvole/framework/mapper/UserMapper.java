package com.nuvole.framework.mapper;

import com.nuvole.framework.SuperMapper;
import com.nuvole.framework.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:03
 */
public interface UserMapper extends SuperMapper<User> {

    int deleteAll();

    @Select("select test_id as id, name, age, test_type from user")
    List<User> selectListBySQL();

}
