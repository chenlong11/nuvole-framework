package com.nuvole.framework.handler;

import com.nuvole.framework.exception.ParamErrException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/6/30
 * time：23:58
 */
@ControllerAdvice
public class Exceptionhandler {

    @ExceptionHandler(value = ParamErrException.class)
    @ResponseBody
    private Map<String,Object> ParamExceptionHandler(HttpServletRequest req,ParamErrException e) {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("errMsg", e.getMessage());
        return modelMap;
    }

}
