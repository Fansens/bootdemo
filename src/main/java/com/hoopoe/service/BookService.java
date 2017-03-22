/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.service;

import com.hoopoe.Dao.BookDao;
import com.hoopoe.common.utils.SerialNo;
import com.hoopoe.common.utils.StringUtils;
import com.hoopoe.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 *
 *
 *  书籍业务处理
 *
 * BookService 
 * @author fansensen
 * @create 2017/3/22 14:29
 * @since JDK 1.7
 * @description: <描述>
 */
@Service
public class BookService {
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);

	@Autowired
	private BookDao bookDao;

	public int addBook(Book book){
		if ( StringUtils.isEmpty(book.getBookId()) ) {
			book.setBookId(SerialNo.getUNID());
			book.setBookInStoreDate(new Date(System.currentTimeMillis()));
		}
		return bookDao.insertBook(book);
	}

	public Book findBookById(String bookId){
		return bookDao.getBookById(bookId);
	}

	public List<Book> findBooksByName(String bookName){
		return bookDao.getBooksByName(bookName);
	}

}
