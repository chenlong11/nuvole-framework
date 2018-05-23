package com.nuvole.framework.domain;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class SysUser extends SuperEntity<SysUser> {

    @TableField("username")
    private String username;

    private String password;

    public SysUser(Long id, String username, String password) {
        this.setId(id);
        this.username = username;
        this.password = password;
    }
}
