package com.nuvole.framework.utils;

import com.nuvole.framework.config.shiro.AuthRealm;
import com.nuvole.framework.config.shiro.ShiroFilterPermissionFactoryBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

/**
 * Created by chenlong
 * Date：2018/7/26
 * time：16:34
 */
public class ShiroUtil {

    public static void clearAuth(){
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        AuthRealm realm = (AuthRealm)rsm.getRealms().iterator().next();
        realm.clearAuthz();
    }

    public static void reloadChainDefinitions(){
        ShiroFilterPermissionFactoryBean.reloadChainDefinitions();
    }


}
