package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.Book;
import com.example.library.domain.BookDTO;
import com.example.library.service.BookServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookServiceImpl bookService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Book> getAll() {
		return bookService.getBooks();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody BookDTO request) {
		try {
			bookService.deleteBook(bookService.getBookById(request.getId()));
			return "SUCCESS";
		} catch (Exception e) {
			return "FAIL";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Book add(@RequestBody BookDTO request) {
		Book book = new Book();
		book.setName(request.getName());
		book.setAuthor(request.getAuthor());
		book.setPublisher(request.getPublisher());
		book.setQuantity(request.getQuantity());
		book = bookService.addBook(book);
		return book;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Book update(@RequestBody BookDTO request) {
		Book book = new Book();
		book.setName(request.getName());
		book.setAuthor(request.getAuthor());
		book.setPublisher(request.getPublisher());
		book.setQuantity(request.getQuantity());
		book = bookService.updateBook(book);
		return book;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public Book get(@RequestBody BookDTO request) {
		return bookService.getBookById(request.getId());
	}
}
