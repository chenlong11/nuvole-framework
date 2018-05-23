package com.nuvole.framework.domain;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：16:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class SysRole extends SuperEntity<SysRole>{

    private String rname;

}
