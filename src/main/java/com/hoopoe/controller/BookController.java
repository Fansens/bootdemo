/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.controller;

import com.hoopoe.model.Book;
import com.hoopoe.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 *
 *  书籍请求
 *
 * BookController 
 * @author fansensen
 * @create 2017/3/22 11:43
 * @since JDK 1.7
 * @description: <描述>
 */
@RestController
@RequestMapping("/book")
public class BookController {
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	@RequestMapping("/getBook/{bookId}")
	public Book getBookById(@PathVariable("bookId") String bookId){
		return bookService.findBookById(bookId);
	}

	@RequestMapping(value = "/addBook" ,method = { RequestMethod.POST})
	public int addBook(@RequestBody Book book){
		if ( book != null ) {
			return bookService.addBook(book);
		} else {
			logger.warn("无书籍信息，无法插入！");
			return -1;
		}
	}
}
