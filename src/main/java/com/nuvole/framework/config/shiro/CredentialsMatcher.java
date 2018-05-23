package com.nuvole.framework.config.shiro;

import com.nuvole.framework.domain.SysUser;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：17:01
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;
        //获得用户输入的密码:(可以采用加盐(salt)的方式去检验)
        String inPassword = new String(utoken.getPassword());
        //获得数据库中的密码
        String dbPassword=(String) info.getCredentials();
        //获取盐
        PrincipalCollection principals = info.getPrincipals();
        SysUser sysUser = (SysUser)principals.getPrimaryPrincipal();


        inPassword = new Sha512Hash(inPassword, sysUser.getUsername(), 2).toBase64();
        //进行密码的比对
        return this.equals(inPassword, dbPassword);

    }

}
