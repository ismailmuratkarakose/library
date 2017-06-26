package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.domain.Book;
import com.example.library.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public Book getBookById(Long id) {
		return bookRepository.findOne(id);
	}

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public void deleteBook(Book book) {
		bookRepository.delete(book);

	}
}
