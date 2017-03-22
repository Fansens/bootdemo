package com.hoopoe.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wildcrab on 17-3-22.
 */
public class User implements Serializable{

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户出生日期
     */
    private Date userBirthday;

    /**
     * 用户登陆名
     */
    private String userLoginName;

    /**
     * 用户登录密码
     */
    private String userLoginPassword;

    /**
     * 用户联系方式
     */
    private String userPhoneNum;

    /**
     * 用户住址
     */
    private String userAddress;

    /**
     * 用户等级（0普通 1会员 2超级会员 3特级会员 9老婆）
     */
    private int userLevel;

    /**
     * 性别
     */
    private int userGender;

    /**
     * 备注
     */
    private String userRemark;

    /**
     * 创建时间
     */
    private Date userCreateDate;

    /**
     * 昵称
     */
    private String userNakedName;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getUserLoginPassword() {
        return userLoginPassword;
    }

    public void setUserLoginPassword(String userLoginPassword) {
        this.userLoginPassword = userLoginPassword;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark;
    }

    public Date getUserCreateDate() {
        return userCreateDate;
    }

    public void setUserCreateDate(Date userCreateDate) {
        this.userCreateDate = userCreateDate;
    }

    public String getUserNakedName() {
        return userNakedName;
    }

    public void setUserNakedName(String userNakedName) {
        this.userNakedName = userNakedName;
    }
}
