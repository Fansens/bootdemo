/******************************************************************************
 * Copyright (C) 2016 Wuhan Medical union Co.Ltd All Rights Reserved.
 * 本软件为武汉默联股份有限公司开发研制。 未经本公司正式书面同意，其他任何个人、
 * 团体不得使用、复制、修改或发布本软件.
 *****************************************************************************/
package com.hoopoe.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 *
 *
 *  书籍类
 *
 * Book 
 * @author fansensen
 * @create 2017/3/22 11:03
 * @since JDK 1.7
 * @description: <描述>
 */
public class Book {
	/** 日志 */
	private static final Logger logger = LoggerFactory.getLogger(Book.class);

	@Id
	private String bookId;

	private String bookTitle;

	private String bookSubscribe;

	private String bookLocation;

	private Date bookInStoreDate;

	private int bookStatus;

	private String bookRemark;

	public String getBookId() {
		return bookId;
	}

	public void setBookId( String bookId ) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle( String bookTitle ) {
		this.bookTitle = bookTitle;
	}

	public String getBookSubscribe() {
		return bookSubscribe;
	}

	public void setBookSubscribe( String bookSubscribe ) {
		this.bookSubscribe = bookSubscribe;
	}

	public String getBookLocation() {
		return bookLocation;
	}

	public void setBookLocation( String bookLocation ) {
		this.bookLocation = bookLocation;
	}

	public Date getBookInStoreDate() {
		return bookInStoreDate;
	}

	public void setBookInStoreDate( Date bookInStoreDate ) {
		this.bookInStoreDate = bookInStoreDate;
	}

	public int getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus( int bookStatus ) {
		this.bookStatus = bookStatus;
	}

	public String getBookRemark() {
		return bookRemark;
	}

	public void setBookRemark( String bookRemark ) {
		this.bookRemark = bookRemark;
	}
}
