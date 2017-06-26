package com.example.library.service;

import java.util.List;

import com.example.library.domain.Book;

public interface BookService {
	Book getBookById(Long id);
	Book addBook(Book Book);
	Book updateBook(Book Book);
	List<Book> getBooks();
	void deleteBook(Book Book);

}
