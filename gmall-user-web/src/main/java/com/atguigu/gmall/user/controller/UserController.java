package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("/getAllUser")
    public List<UmsMember> getAllUser(){
        List<UmsMember> userMembers = userService.getAllUser();
        return userMembers;
    }

    @RequestMapping("/hello")
    public String index(){
        return "hello user";
    }

}
