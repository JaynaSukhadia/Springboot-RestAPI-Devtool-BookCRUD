package com.aurosoft.bookrestapi.service;

import java.util.List;

import com.aurosoft.bookrestapi.model.Book;



public interface BookService {

	List<Book> listAllByBooks();
	Book getBookById(int id);
	Book insertBook(Book book);
	Book updateBook(Book book,int id);
	void deleteBook(int id);
}
