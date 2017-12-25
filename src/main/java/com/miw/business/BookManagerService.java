package com.miw.business;

import java.util.Vector;

import com.miw.model.Book;

public interface BookManagerService {
	public Vector<Book> getBooks() throws Exception;

	public abstract Book getSpecialOffer() throws Exception;	
	
	public Book newBook(Book book) throws Exception;
}
