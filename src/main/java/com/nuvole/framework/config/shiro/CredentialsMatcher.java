package com.nuvole.framework.config.shiro;

import com.nuvole.framework.dto.SysUserDTO;
import com.nuvole.framework.service.user.SysUserService;
import com.nuvole.framework.utils.EncryptionUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：17:01
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        String inPassword = new String(utoken.getPassword());
        String dbPassword=(String) info.getCredentials();
        PrincipalCollection principals = info.getPrincipals();
        String userId = (String)principals.getPrimaryPrincipal();
        SysUserDTO userDTO = sysUserService.findById(userId);
        return EncryptionUtil.pwdEncryption(inPassword+userDTO.getLoginName()).equals(dbPassword);
    }



}
