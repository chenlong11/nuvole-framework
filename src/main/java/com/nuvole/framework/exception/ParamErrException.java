package com.nuvole.framework.exception;

/**
 * Created by chenlong
 * Date：2018/6/30
 * time：23:55
 */
public class ParamErrException extends RuntimeException {

    public ParamErrException() {
    }

    public ParamErrException(String msg) {
        super(msg);
    }

}
