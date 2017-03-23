/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;

/**
 *
 *
 *  登录用户
 *
 * LoginUser 
 * @author fansensen
 * @create 2017/3/23 13:49
 * @since JDK 1.7
 * @description: <描述>
 */
@Entity
@Table(name = "tb_login_user")
public class LoginUser implements UserDetails {
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(LoginUser.class);

	private String userId;//user主键

	@Id
	@GeneratedValue
	private String username;//登录名

	private String password;//登录密码

	private String fullname;//全名

	private String nakedname;//昵称

	public String getUserId() {
		return userId;
	}

	public void setUserId( String userId ) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname( String fullname ) {
		this.fullname = fullname;
	}

	public String getNakedname() {
		return nakedname;
	}

	public void setNakedname( String nakedname ) {
		this.nakedname = nakedname;
	}

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("READER"));
	}

	@Override public String getPassword() {
		return password;
	}

	@Override public String getUsername() {
		return username;
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
