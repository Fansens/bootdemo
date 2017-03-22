package com.hoopoe.controller;

import com.hoopoe.model.User;
import com.hoopoe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * Created by wildcrab on 17-3-22.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser",method = {RequestMethod.POST})
    public int addUser(User user){
        //须处理用户出生日期，及密码加密
        return userService.addUser(user);
    }
}
