package com.hoopoe.service;

import com.hoopoe.Dao.UserDao;
import com.hoopoe.common.utils.EncryptUtils;
import com.hoopoe.common.utils.SerialNo;
import com.hoopoe.common.utils.StringUtils;
import com.hoopoe.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 用户服务层
 *
 * Created by wildcrab on 17-3-22.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增用户
     * @param user
     * @return
     */
    public int addUser(User user){
        if (StringUtils.isEmpty(user.getUserId())) {
            user.setUserId(SerialNo.getUNID());
        }
        //加密密码明文
        user.setUserLoginPassword(EncryptUtils.encrypt(user.getUserLoginPassword()));
        user.setUserCreateDate(new Date(System.currentTimeMillis()));
        return userDao.insertUser(user);
    }

    /**
     * 根据用户ID查询用户
     * @param userId
     * @return
     */
    public User findUser(String userId){
        return userDao.getUserById(userId);
    }

    /**
     * 用户登录授权
     * @param loginName
     * @param loginPswd
     * @return
     */
    public boolean authUser(String loginName, String loginPswd){
        User user =  userDao.getUserByLogin(loginName);
        if (user != null && EncryptUtils.checkMatch(user.getUserLoginPassword() ,loginPswd)) {
            return true;
        }
        return false;
    }
}
