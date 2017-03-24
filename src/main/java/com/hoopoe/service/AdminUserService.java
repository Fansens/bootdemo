/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.service;

import com.hoopoe.Dao.AdminUserDao;
import com.hoopoe.common.utils.EncryptUtils;
import com.hoopoe.model.AdminUser;
import com.hoopoe.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 *
 *  admin service
 *
 * AdminUserService 
 * @author fansensen
 * @create 2017/3/24 14:41
 * @since JDK 1.7
 * @description: <描述>
 */
@Service
public class AdminUserService implements UserDetailsService{
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(AdminUserService.class);

	@Autowired
	private AdminUserDao adminUserDao;

	@Override public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
		return adminUserDao.findOne(username);
	}

	public int addAdminUser(User user){
		AdminUser adminUser = new AdminUser(user);
		adminUser.setPassword(EncryptUtils.encrypt(adminUser.getPassword()));
		adminUser.setCreateDate(new Date());
		adminUserDao.saveAndFlush(adminUser);
		if ( adminUser != null )return 1;
		return 0;
	}

}
