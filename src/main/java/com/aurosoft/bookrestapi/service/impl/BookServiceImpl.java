package com.aurosoft.bookrestapi.service.impl;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aurosoft.bookrestapi.exception.ResourceNotFoundException;
import com.aurosoft.bookrestapi.model.Book;
import com.aurosoft.bookrestapi.repository.BookRepository;
import com.aurosoft.bookrestapi.service.BookService;
@Service
public class BookServiceImpl implements BookService{

	private BookRepository repo;
	
	public BookServiceImpl(BookRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public List<Book> listAllByBooks() {
		
		return repo.findAll();
	}

	@Override
	public Book getBookById(int id) {
		
//	Optional<Book> book=repo.findById(id);
//	
//	if(book.isPresent())
//	{
//		return book.get();
//	}else
//	{
//		throw new ResourceNotFoundException("Book", "Id", id);
//	}
		
	return	repo.findById(id).orElseThrow(()-> 
			new ResourceNotFoundException("Book", "Id", id));
	}

	@Override
	public Book insertBook(Book book) {
		
		return repo.save(book);
	}

	@Override
	public Book updateBook(Book book, int id) 
	{
		Book existingBook=repo.findById(id).orElseThrow(()->
				new ResourceNotFoundException("Book", "Id", id));
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setPrice(book.getPrice());
		
	repo.save(existingBook);
		return existingBook;
		
	}

	@Override
	public void deleteBook(int id) {
		repo.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Book","Id",id));	
		repo.deleteById(id);
		
	}

	
}
