/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.Dao;

import com.hoopoe.mapper.BookMapper;
import com.hoopoe.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 *
 *  书籍数据库操作
 *
 * BookDao 
 * @author fansensen
 * @create 2017/3/22 14:23
 * @since JDK 1.7
 * @description: <描述>
 */
@Repository
public class BookDao {

	@Autowired
	private BookMapper bookMapper;

	public int insertBook(Book book){
		return bookMapper.insert(book);
	}

	public Book getBookById(String bookId){
		return bookMapper.getById(bookId);
	}

	public List<Book> getBooksByName(String bookName){
		return bookMapper.likeName(bookName);
	}
}
