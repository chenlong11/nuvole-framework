package com.nuvole.framework.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：18:34
 */
@Slf4j
public class ThymeleafInterceptor extends HandlerInterceptorAdapter {


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception arg3) throws Exception {

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView view) throws Exception {
        if (view != null) {

            view.addObject("ctxPath", request.getContextPath());
        }
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

}
