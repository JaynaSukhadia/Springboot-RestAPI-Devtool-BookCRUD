package com.aurosoft.bookrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurosoft.bookrestapi.model.Book;
import com.aurosoft.bookrestapi.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
// build create(insert) Books Rest API
	@PostMapping()
	public ResponseEntity<Book> saveBook(@RequestBody Book  book)
	{
		return new ResponseEntity<Book>(bookService.insertBook(book), HttpStatus.CREATED);
	}
//build all Books
	
	@GetMapping
	public List<Book> getAllBooks()
	{
		return bookService.listAllByBooks();
	}
	
	//build Book with id
	
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id")int bookId)
	{
		return new ResponseEntity<Book>(bookService.getBookById(bookId), HttpStatus.OK);		
	}
	
	// build update Books Rest API
		@PutMapping("{id}")
		public ResponseEntity<Book> updateBook(@PathVariable("id")int id,
											   @RequestBody Book book)
		{
			return new ResponseEntity<Book>(bookService.updateBook(book,id), HttpStatus.OK);		
		}
		
		@DeleteMapping("{id}")
		public ResponseEntity<String> deleteBook(@PathVariable("id")int id)
		{
			bookService.deleteBook(id);
			return new ResponseEntity<String>("Book Deleted Successfully",HttpStatus.OK);
		}
}
