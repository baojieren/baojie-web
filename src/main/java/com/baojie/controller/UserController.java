package com.baojie.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.baojie.entity.User;
import com.baojie.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Reference(url = "${url}", timeout = 30000)
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public String hello(Model model) {
        User byId = userService.getById(2);
        System.out.println(byId);
        User one = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getId, 1));
        return JSON.toJSONString(one);
    }
}