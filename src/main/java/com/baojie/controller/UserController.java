package com.baojie.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.baojie.entity.User;
import com.baojie.service.UserService;
import com.baomidou.mybatisplus.mapper.Condition;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Reference(url = "${url}", timeout = 30000)
    private UserService userService;

    @RequestMapping("/user.html")
    @ResponseBody
    public String hello(Model model, Integer id) {
        User u = new User();
        u.setId(id);
        User user = userService.selectOne(new EntityWrapper<>(u));
        return JSON.toJSONString(user);
    }
}