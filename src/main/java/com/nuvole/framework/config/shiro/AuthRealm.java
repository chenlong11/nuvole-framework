package com.nuvole.framework.config.shiro;

import com.nuvole.framework.dto.SysModuleDTO;
import com.nuvole.framework.dto.SysRoleDTO;
import com.nuvole.framework.dto.SysUserDTO;
import com.nuvole.framework.service.moudle.SysModuleService;
import com.nuvole.framework.service.role.SysRoleService;
import com.nuvole.framework.service.user.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
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
@Slf4j
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysModuleService sysModuleService;

    @Autowired
    private SysRoleService sysRoleService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userName = (String) token.getPrincipal();
        SysUserDTO user = sysUserService.findByLoginName(userName);
        if (null == user) {
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getId(), user.getPassword(), this.getClass().getName());
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {

        String userId = (String) principal.getPrimaryPrincipal();
        List<String> permissions = getPermissions(userId);
        List<String> roles = getRoles(userId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);

        return info;
    }

    private List<String> getRoles(String userId) {
        List<String> roles = new ArrayList<>();
        List<SysRoleDTO> roleList = sysRoleService.findByUserId(userId);
        for (SysRoleDTO sysRole : roleList) {
            roles.add(sysRole.getRoleCode());
        }
        return roles;
    }

    private List<String> getPermissions(String userId) {
        List<String> permissions = new ArrayList<>();
        List<SysModuleDTO> moduleList = sysModuleService.findListByUserId(userId);
        for (SysModuleDTO sysModule : moduleList) {
            permissions.add(sysModule.getMenuCode());
        }
        return permissions;
    }

    public void clearAuthz(){
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

}
