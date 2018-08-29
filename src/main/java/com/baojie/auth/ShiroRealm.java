package com.baojie.auth;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baojie.entity.User;
import com.baojie.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

//@Component
public class ShiroRealm extends AuthorizingRealm {

    @Reference(url = "${url}", timeout = 30000)
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        try {
            info.setRoles(userService.getRoleListByUserId(user.getId()));
            info.setStringPermissions(userService.getPermissionListByUserId(user.getId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = null;
        try {
            //user = userService.selectOne(new EntityWrapper<User>().eq("user_name", token.getUsername()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (user != null) {
            //盐值
            ByteSource salt = ByteSource.Util.bytes(user.getUserName());
            return new SimpleAuthenticationInfo(user, user.getPassword(), salt, this.getName());
        }
        return null;
    }
}
