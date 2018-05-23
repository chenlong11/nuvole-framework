package com.nuvole.framework.controller;

import com.nuvole.framework.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：17:20
 */
@Controller
public class IndexController {

    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String postlogin(String username, String password) {

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            Session session = subject.getSession();
            System.out.println(subject.isPermitted("add"));
            //SysUser user=(SysUser) subject.getPrincipal();
            return "index";
        } catch (UnknownAccountException uae) {
            //username wasn't in the system, show them an error message?
        } catch (IncorrectCredentialsException ice) {
            //password didn't match, try again?
        } catch (LockedAccountException lae) {
            //account for that username is locked - can't login.  Show them a message?
        } catch (AuthenticationException ae) {
            //unexpected condition - error?
        }
        return "login";
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "login";
    }


}
