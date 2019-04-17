package com.baojie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    // @RequestMapping("/test.html")
    // @ResponseBody
    // public String test() throws Exception {
    //     Set<String> permissionListByUserId = userService.getPermissionListByUserId(1);
    //     return JSON.toJSONString(permissionListByUserId);
    // }
    //
    // @PostMapping("/signIn.html")
    // @ResponseBody
    // public String signIn(HttpServletRequest request, User user) {
    //     ResultBean resultBean = new ResultBean();
    //     try {
    //         //登陆验证
    //         UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
    //         Subject subject = SecurityUtils.getSubject();
    //         subject.login(token);
    //         request.getSession().setAttribute("userInfo", (User) subject.getPrincipal());
    //     } catch (UnknownAccountException e) {
    //         return JSON.toJSONString(resultBean.failure("用户不存在"));
    //     } catch (AuthenticationException e) {
    //         return JSON.toJSONString(resultBean.failure("用户名或密码错误"));
    //     }
    //     return JSON.toJSONString(resultBean.success("登陆成功"));
    // }
    //
    // @PostMapping("/signUp.html")
    // @ResponseBody
    // public String signUp(HttpServletRequest request, User user) {
    //     //参数一:加密方式
    //     //参数二:需要加密的字符串
    //     //参数三:盐
    //     //参数四:加密次数
    //     String oldPassword = user.getPassword();
    //     user.setAddTime(LocalDateTime.now());
    //     String password2md5 = new SimpleHash("MD5", user.getPassword(), user.getUsername(), 1024).toString();
    //     user.setPassword(password2md5);
    //     ResultBean resultBean = userService.saveUser(user);
    //     if (resultBean.isSuccess()) {
    //         //登陆
    //         UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), oldPassword);
    //         Subject subject = SecurityUtils.getSubject();
    //         subject.login(token);
    //         request.getSession().setAttribute("userInfo", (User) subject.getPrincipal());
    //         return JSON.toJSONString(resultBean);
    //     }
    //     return JSON.toJSONString(resultBean);
    // }

}