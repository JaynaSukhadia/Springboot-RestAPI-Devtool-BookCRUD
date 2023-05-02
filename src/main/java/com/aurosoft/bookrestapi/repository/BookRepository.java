package com.aurosoft.bookrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurosoft.bookrestapi.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
