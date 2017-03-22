/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 *
 *  数据库相关设定
 *
 * MybatisConfig 
 * @author fansensen
 * @create 2017/3/22 13:43
 * @since JDK 1.7
 * @description: <描述>
 */
@Configuration
@MapperScan(basePackages = "com.hoopoe.mapper")
public class MybatisConfig {

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource()throws Exception{
		Properties props = new Properties();
		props.put("driverClassName" ,env.getProperty("datasource.driverClassName"));
		props.put("jdbcUrl", env.getProperty("datasource.url"));
		props.put("username", env.getProperty("datasource.username"));
		props.put("password", env.getProperty("datasource.password"));
		props.put("connectionTimeout", env.getProperty("datasource.connectionTimeout"));
		HikariConfig config = new HikariConfig(props);
		return new HikariDataSource(config);
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));
		factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
		return factoryBean.getObject();
	}
}
