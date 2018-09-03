package com.baojie.controller;

import com.alibaba.fastjson.JSON;
import com.baojie.entity.ResultBean;
import com.baojie.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/test.html")
    @ResponseBody
    public String test() throws Exception {
        Set<String> permissionListByUserId = userService.getPermissionListByUserId(1);
        return JSON.toJSONString(permissionListByUserId);
    }

    @PostMapping("/signIn.html")
    @ResponseBody
    public String signIn(HttpServletRequest request, User user) {
        try {
            //登陆验证
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            request.getSession().setAttribute("userInfo", (User) subject.getPrincipal());
        } catch (UnknownAccountException e) {
            return JSON.toJSONString(ResultBean.failure("用户不存在"));
        } catch (AuthenticationException e) {
            return JSON.toJSONString(ResultBean.failure("用户名或密码错误"));
        }
        return JSON.toJSONString(ResultBean.success("登陆成功"));
    }

    @PostMapping("/signUp.html")
    @ResponseBody
    public String signUp(HttpServletRequest request, User user) {
        //参数一:加密方式
        //参数二:需要加密的字符串
        //参数三:盐
        //参数四:加密次数
        String oldPassword = user.getPassword();
        user.setAddTime(LocalDateTime.now());
        String password2md5 = new SimpleHash("MD5", user.getPassword(), user.getUsername(), 1024).toString();
        user.setPassword(password2md5);
        ResultBean resultBean = userService.saveUser(user);
        if (0 != resultBean.getState()) {
            //登陆
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), oldPassword);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            request.getSession().setAttribute("userInfo", (User) subject.getPrincipal());
            return JSON.toJSONString(ResultBean.success(resultBean.getId(), "注册成功"));
        }
        return JSON.toJSONString(resultBean.getMessage());
    }

}