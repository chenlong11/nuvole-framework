package com.nuvole.framework.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID , 这里故意演示注解可以无
     */
    private Long id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
