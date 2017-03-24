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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

/**
 *
 *
 *  超级用户
 *
 * LoginUser 
 * @author fansensen
 * @create 2017/3/23 13:49
 * @since JDK 1.7
 * @description: <描述>
 */
@Entity
@Table(name = "tb_admin_user")
public class AdminUser implements UserDetails{
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(AdminUser.class);

	private String userId;//user主键

	@Id
	@Column(length = 50,name = "user_name")
	private String username;//登录名

	@Column(nullable = false,length = 100)
	private String password;//登录密码

	@Column(length = 150,name = "full_name")
	private String fullname;//全名

	@Column(nullable = false,length = 150,name = "naked_name")
	private String nakedname;//昵称

	private Date createDate;

	public AdminUser() {
	}
	public AdminUser(User user) {
		this.fullname = user.getUsername();
		this.userId = user.getUserId();
		this.username = user.getUserLoginName();
		this.password = user.getUserLoginPassword();
		this.nakedname = user.getUserNakedName();
	}


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

	public void setUsername( String username ) {
		this.username = username;
	}

	public void setPassword( String password ) {
		this.password = password;
	}

	public String getNakedname() {
		return nakedname;
	}

	public void setNakedname( String nakedname ) {
		this.nakedname = nakedname;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate( Date createDate ) {
		this.createDate = createDate;
	}

	@Override public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
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
