package com.hoopoe.Dao;

import com.hoopoe.mapper.UserMapper;
import com.hoopoe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 用户dao层
 *
 * Created by wildcrab on 17-3-22.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public User getUserById(String userId){
        return userMapper.getUserById(userId);
    }

    public User getUserByLogin(String loginName){
        return userMapper.getUserByLogin(loginName);
    }
}
