package com.example.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.BookReservation;
import com.example.library.domain.BookReservationDTO;
import com.example.library.service.BookReservationServiceImpl;
import com.example.library.service.BookServiceImpl;
import com.example.library.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class BookReservationController {

	@Autowired
	BookReservationServiceImpl bookReservationService;

	@Autowired
	BookServiceImpl bookService;

	@Autowired
	UserServiceImpl userService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<BookReservation> getAll() {
		return bookReservationService.getBookReservations();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BookReservation add(@RequestBody BookReservationDTO request) {
		BookReservation bookReservation = new BookReservation();
		bookReservation.setBook(bookService.getBookById(request.getBookId()));
		bookReservation.setUser(userService.getUserById(request.getUserId()));
		bookReservation.setBorrowDate(request.getBorrowDate());
		bookReservation.setReturnDate(request.getReturnDate());
		bookReservation.setStatus(request.getStatus());
		bookReservation=bookReservationService.addBookReservation(bookReservation);
		return bookReservation;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public BookReservation update(@RequestBody BookReservationDTO request) {
		BookReservation bookReservation = new BookReservation();
		bookReservation.setId(request.getId());
		bookReservation.setBook(bookService.getBookById(request.getBookId()));
		bookReservation.setUser(userService.getUserById(request.getUserId()));
		bookReservation.setBorrowDate(request.getBorrowDate());
		bookReservation.setReturnDate(request.getReturnDate());
		bookReservation.setStatus(request.getStatus());
		bookReservation=bookReservationService.addBookReservation(bookReservation);
		return bookReservation;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public BookReservation get(@RequestBody BookReservationDTO request) {
		return bookReservationService.getBookReservationById(request.getId());
	}
}
