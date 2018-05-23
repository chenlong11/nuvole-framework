package com.nuvole.framework.config.shiro;

import com.nuvole.framework.domain.SysModule;
import com.nuvole.framework.domain.SysUser;
import com.nuvole.framework.service.IModuleService;
import com.nuvole.framework.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：14:28
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IModuleService moduleService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();
        SysUser user = userService.findByUsername(username);

        if (null == user){
            throw new UnknownAccountException("用户不存在");
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), this.getClass().getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SysUser user = (SysUser) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        List<String> permissions = new ArrayList<>();
        List<SysModule> moduleList = moduleService.findByUserId(user.getId());
        for (SysModule sysModule : moduleList) {
            permissions.add(sysModule.getMname());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);
        return info;
    }

}
