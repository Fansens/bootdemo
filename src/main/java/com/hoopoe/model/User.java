package com.hoopoe.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 * 普通用户
 * Created by wildcrab on 17-3-22.
 */
@Entity
@Table(name = "tb_user")
public class User implements UserDetails{

    public static final int user_normal = 0;
    public static final int user_vip = 1;
    public static final int user_svip = 5;
    public static final int user_boss = 9;
    /**
     * 用户ID
     */
    @Id
    private String userId;

    /**
     * 用户名
     */
    @Column(nullable = false,length = 100,name = "user_name")
    private String userName;

    /**
     * 用户出生日期
     */
    @Column(nullable = false,name = "user_birthday")
    private Date userBirthday;

    /**
     * 用户登陆名
     */
    @Column(nullable = false,unique = true,name = "user_login_name")
    private String userLoginName;

    /**
     * 用户登录密码
     */
    @Column(nullable = false,name = "user_login_password")
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
     * 用户等级（0普通 1会员 5超级会员 9老婆）
     */
    @Column(nullable = false)
    private int userLevel;

    /**
     * 性别
     */
    @Column(nullable = false)
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
    @Column(nullable = false)
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

    @Override public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("NORMAL"));
    }

    @Override public String getPassword() {
        return this.userLoginPassword;
    }

    @Override public String getUsername() {
        return this.userLoginName;
    }

    @Override public boolean isAccountNonExpired() {
        return true;
    }

    @Override public boolean isAccountNonLocked() {
        return true;
    }

    @Override public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override public boolean isEnabled() {
        return true;
    }
}
