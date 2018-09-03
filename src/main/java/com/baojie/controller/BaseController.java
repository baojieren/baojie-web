package com.baojie.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baojie.service.UserService;

public class BaseController {

    @Reference()
    UserService userService;
}
