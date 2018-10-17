package com.baojie.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baojie.service.UserService;
import com.baojie.service.VipVideoUrlService;

public class BaseController {

    @Reference()
    UserService userService;
    @Reference()
    VipVideoUrlService vipVideoUrlService;
}
