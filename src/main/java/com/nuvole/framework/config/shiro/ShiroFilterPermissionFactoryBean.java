package com.nuvole.framework.config.shiro;

import com.nuvole.framework.dto.SysModuleDTO;
import com.nuvole.framework.service.moudle.SysModuleService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chenlong
 * Date：2018/8/4
 * time：17:40
 */
@Slf4j
public class ShiroFilterPermissionFactoryBean extends ShiroFilterFactoryBean {

    private static ShiroFilterFactoryBean shiroFilterFactoryBean = null;

    private static SysModuleService staticSysModuleService;

    @Autowired
    private SysModuleService sysModuleService;

    public ShiroFilterPermissionFactoryBean() {
        super();
        shiroFilterFactoryBean = this;
    }

    @Override
    public void setFilterChainDefinitionMap(Map<String, String> filterChainDefinitionMap) {
        log.info(" setFilterChainDefinitionMap... ");
        super.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }


    public static LinkedHashMap<String, String> getFilterMap() {
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/**", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/login", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/logout", "logout");//登出
        List<SysModuleDTO> permissions = staticSysModuleService.findAllByStatus(1);
        permissions.forEach(permission -> {
            filterChainDefinitionMap.put(permission.getDataUrl(), "perms[" + permission.getMenuCode() + "]");
        });
//        filterChainDefinitionMap.put("/index", "roles[supper]");//表示需要认证才可以访问
//        filterChainDefinitionMap.put("/user/delete", "perms[user:delete]");//表示需要拥有权限才可以访问
        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        return filterChainDefinitionMap;
    }

    @PostConstruct
    public void init() {
        log.info(" staticSysModuleService init ... ");
        staticSysModuleService = sysModuleService;
        setFilterChainDefinitionMap(getFilterMap());
    }

    public static void reloadChainDefinitions() {
        log.info(" reloadChainDefinitions ... ");
        AbstractShiroFilter shiroFilter = null;
        try {
            shiroFilter = (AbstractShiroFilter) shiroFilterFactoryBean.getObject();
        } catch (Exception e) {
            log.error("getShiroFilter from shiroFilterFactoryBean error!", e);
        }

        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager manager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();

        // 清空老的权限控制
        manager.getFilterChains().clear();
        shiroFilterFactoryBean.getFilterChainDefinitionMap().clear();

        shiroFilterFactoryBean.setFilterChainDefinitionMap(getFilterMap());
        // 重新构建生成
        Map<String, String> chains = shiroFilterFactoryBean.getFilterChainDefinitionMap();
        for (Map.Entry<String, String> entry : chains.entrySet()) {
            String url = entry.getKey();
            String chainDefinition = entry.getValue().trim().replace(" ", "");
            manager.createChain(url, chainDefinition);
        }
    }

}
