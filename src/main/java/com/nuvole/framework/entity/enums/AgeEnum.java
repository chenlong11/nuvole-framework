package com.nuvole.framework.entity.enums;

import com.baomidou.mybatisplus.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

/**
 * Created by chenlong
 * Date：2018/1/16
 * time：10:22
 */
public enum AgeEnum implements IEnum {

    ONE(1, "一岁"),
    TWO(2, "二岁");

    private int value;
    private String desc;

    AgeEnum(final int value, final String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Serializable getValue() {
        return this.value;
    }

    @JsonValue
    public String getDesc(){
        return this.desc;
    }

}
