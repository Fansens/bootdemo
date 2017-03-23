/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.configuration;

import com.hoopoe.Dao.LoginUserRepository;
import com.hoopoe.mapper.UserMapper;
import com.hoopoe.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 *
 *  登录校验配置
 *
 * SecurityConfig 
 * @author fansensen
 * @create 2017/3/23 9:14
 * @since JDK 1.7
 * @description: <描述>
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

	@Autowired
	private LoginUserRepository loginUserRepository;

	@Override protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
		auth.userDetailsService(new UserDetailsService() {
			@Override public UserDetails loadUserByUsername( String userName ) throws UsernameNotFoundException {
				return loginUserRepository.findOne(userName);
			}
		});
	}

	@Override protected void configure( HttpSecurity http ) throws Exception {
		http.authorizeRequests()
				.antMatchers("/").access("hasRole('READER')")//登录者必须有reader角色
				.antMatchers("/**").permitAll()
				.and()
				.formLogin()
				.loginPage("/login")//登录表单路径
				.failureUrl("/login?error=true");
	}
}
