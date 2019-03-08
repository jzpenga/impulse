package com.msp.impulse.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("impulse/admin/adminManage")
@Api(value = "首页管理", tags = "首页管理", description = "管理平台-首页")
public class AdminHomeController {
}
