package com.baojie.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    /**
     * 注册自定义Realm
     *
     * @return
     */
    // @Bean
    // public ShiroRealm shiroRealm() {
    //     ShiroRealm realm = new ShiroRealm();
    //     HashedCredentialsMatcher hashMatcher = new HashedCredentialsMatcher();
    //     hashMatcher.setHashAlgorithmName("MD5");
    //     //true:加密用的是Hex编码；false:用Base64编码
    //     hashMatcher.setStoredCredentialsHexEncoded(true);
    //     //加密次数
    //     hashMatcher.setHashIterations(1024);
    //     realm.setCredentialsMatcher(hashMatcher);
    //     return realm;
    // }
    //
    // @Bean
    // public SecurityManager securityManager(ShiroRealm shiroRealm) {
    //     DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //     securityManager.setRealm(shiroRealm);
    //     return securityManager;
    // }
    //
    // @Bean
    // public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    //     ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
    //     factoryBean.setSecurityManager(securityManager);
    //     Map<String, String> map = new HashMap<>(2);
    //     map.put("/logout.html", "logout");
    //     map.put("/**", "anon");
    //     factoryBean.setFilterChainDefinitionMap(map);
    //     factoryBean.setSuccessUrl("/index");
    //     factoryBean.setLoginUrl("/page/top.ftl");
    //     return factoryBean;
    // }
    //
    // @Bean
    // public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    //     AuthorizationAttributeSourceAdvisor sourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    //     sourceAdvisor.setSecurityManager(securityManager);
    //     return sourceAdvisor;
    // }
}
