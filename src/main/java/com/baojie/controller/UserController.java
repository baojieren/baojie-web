package com.baojie.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.baojie.entity.User;
import com.baojie.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class UserController {

    @Reference(url = "${url}", timeout = 30000)
    private UserService userService;

    @RequestMapping("/user.html")
    @ResponseBody
    public String hello(Model model, Integer id) {
        User u = new User();
        u.setUsername("baojie");
        u.setPassword("123123");
        u.setAddTime(LocalDateTime.now());
        Integer integer = userService.saveUser(u);
        return JSON.toJSONString(integer);
    }

    @RequestMapping("/signUp.html")
    @ResponseBody
    public String signUp(User user) {
        //参数一:加密方式
        //参数二:需要加密的字符串
        //参数三:盐
        //参数四:加密次数
        user.setAddTime(LocalDateTime.now());
        String password2md5 = new SimpleHash("MD5", user.getPassword(), user.getUsername(), 1024).toString();
        user.setPassword(password2md5);
        Integer integer = userService.saveUser(user);
        if (null != integer) {
            return JSON.toJSONString("ok");
        }
        return null;
    }
}