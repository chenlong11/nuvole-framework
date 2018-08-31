package com.nuvole.framework.config.shiro;

import com.nuvole.framework.cache.RedisCacheManager;
import com.nuvole.framework.session.CustomSessionManager;
import com.nuvole.framework.session.RedisSessionDao;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * Created by chenlong
 * Date：2018/3/24
 * time：17:03
 */
@Configuration
public class ShiroConfig {

//    @Bean
//    public ShiroFilterPermissionFactoryBean shiroFilterFactoryBean() {
//        return new ShiroFilterPermissionFactoryBean();
//    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterPermissionFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(manager);
        //配置登录的url和登录成功的url
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(new HashMap());
        return shiroFilterFactoryBean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm,
                                                     @Qualifier("sessionManager") CustomSessionManager sessionManager,
                                                     @Qualifier("cacheManager") RedisCacheManager cacheManager) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        manager.setSessionManager(sessionManager);
        manager.setCacheManager(cacheManager);
        return manager;
    }

    @Bean(name = "authRealm")
    public AuthRealm authRealm(@Qualifier("credentialsMatcher") CredentialsMatcher matcher) {
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }


    @Bean(name = "credentialsMatcher")
    public CredentialsMatcher credentialsMatcher() {
        return new CredentialsMatcher();
    }


    @Bean
    public CustomSessionManager sessionManager(RedisSessionDao redisSessionDao) {
        CustomSessionManager customSessionManager = new CustomSessionManager();
        customSessionManager.setSessionDAO(redisSessionDao);
        return customSessionManager;
    }

    @Bean
    public RedisSessionDao redisSessionDao() {
        return new RedisSessionDao();
    }

    @Bean
    public RedisCacheManager cacheManager() {
        return new RedisCacheManager();
    }



    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }


    //记住我
    @Bean
    public CookieRememberMeManager cookieRememberMeManager(SimpleCookie cookie) {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(cookie);
        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie cookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(20000000);
        return simpleCookie;
    }


}
