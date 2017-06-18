package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.domain.Book;

public interface IBookRepository extends CrudRepository<Book, Long> {

}
