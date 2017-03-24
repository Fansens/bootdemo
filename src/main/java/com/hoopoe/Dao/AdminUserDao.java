/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.Dao;

import com.hoopoe.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 *  超级管理员dao
 *
 * AdminUserDao 
 * @author fansensen
 * @create 2017/3/24 14:39
 * @since JDK 1.7
 * @description: <描述>
 */
public interface AdminUserDao extends JpaRepository<AdminUser,String>{

}
