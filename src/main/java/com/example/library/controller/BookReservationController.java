package com.example.library.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.BookReservation;
import com.example.library.domain.BookReservationDTO;
import com.example.library.service.BookReservationService;
import com.example.library.service.BookService;
import com.example.library.service.UserService;

@RestController
@RequestMapping("/reservations")
public class BookReservationController {

	@Autowired
	BookReservationService bookReservationService;

	@Autowired
	BookService bookService;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<BookReservation> getAll() {
		return bookReservationService.getBookReservations();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BookReservation add(@RequestBody BookReservationDTO request) {
		BookReservation bookReservation = new BookReservation();
		bookReservation.setBook(bookService.getBookById(request.getBookId()));
		bookReservation.setUser(userService.getUserById(request.getUserId()));
		bookReservation.setBorrowDate(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(bookReservation.getBorrowDate());
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		bookReservation.setReturnDate(calendar.getTime());
		return bookReservation;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public BookReservation get(@RequestBody BookReservationDTO request) {
		return bookReservationService.getBookReservationById(request.getId());
	}
}
