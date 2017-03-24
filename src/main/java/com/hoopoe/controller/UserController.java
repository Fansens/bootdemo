package com.hoopoe.controller;

import com.hoopoe.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hoopoe.model.User;
import com.hoopoe.service.UserService;

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

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @RequestMapping(value = "/addUser",method = {RequestMethod.POST,RequestMethod.GET})
    public int addUser(@RequestBody User user){
        if ( user != null ) {
            if ( User.user_normal < user.getUserLevel() ) {
                return adminUserService.addAdminUser(user);
            }
            return userService.addUser(user);
        }
        return 0;
    }
}
