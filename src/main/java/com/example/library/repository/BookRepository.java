package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
