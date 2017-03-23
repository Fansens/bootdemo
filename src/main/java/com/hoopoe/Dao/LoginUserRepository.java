/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.Dao;

import com.hoopoe.model.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *
 *  登录验证
 *
 * LoginUserRepository 
 * @author fansensen
 * @create 2017/3/23 15:06
 * @since JDK 1.7
 * @description: <描述>
 */
public interface LoginUserRepository extends JpaRepository<LoginUser,String>{
}
