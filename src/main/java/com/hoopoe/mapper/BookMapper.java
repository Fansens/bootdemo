/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.mapper;

import com.hoopoe.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 *
 *  书籍数据库操作接口
 *
 * BookMapper 
 * @author fansensen
 * @create 2017/3/22 11:22
 * @since JDK 1.7
 * @description: <描述>
 */
@Mapper
public interface BookMapper {

	int insert(Book book);

	@Select("select * from tb_book where book_id = #{bookId}")
	@ResultMap("com.hoopoe.mapper.BookMapper.bookMap")
	Book getById(@Param("bookId") String bookId);

	@Select("select * from tb_book where book_title like %#{bookName}%")
	@ResultMap("com.hoopoe.mapper.BookMapper.bookMap")
	List<Book> likeName(@Param("bookName") String bookName);
}
