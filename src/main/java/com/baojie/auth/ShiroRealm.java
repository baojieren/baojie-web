package com.baojie.auth;

import org.springframework.stereotype.Component;

@Component
public class ShiroRealm  {

    // @Reference()
    // private UserService userService;

    // @Override
    // protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    //     SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    //     User user = (User) principalCollection.getPrimaryPrincipal();
    //     try {
    //         info.setRoles(userService.getRoleListByUserId(user.getId()));
    //         info.setStringPermissions(userService.getPermissionListByUserId(user.getId()));
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return info;
    // }
    //
    // @Override
    // protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    //     //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
    //     if (authenticationToken.getPrincipal() == null) {
    //         return null;
    //     }
    //     UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
    //     User user = null;
    //     try {
    //         User u = new User();
    //         u.setUsername(token.getUsername());
    //         user = userService.getUserByCond(u);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     if (user != null) {
    //         //盐值
    //         ByteSource salt = ByteSource.Util.bytes(user.getUsername());
    //         return new SimpleAuthenticationInfo(user, user.getPassword(), salt, this.getName());
    //     }
    //     return null;
    // }
}
