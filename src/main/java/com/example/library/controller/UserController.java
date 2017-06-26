package com.example.library.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.domain.Book;
import com.example.library.domain.BookReservation;
import com.example.library.domain.ReservationStatus;
import com.example.library.domain.User;
import com.example.library.domain.UserDTO;
import com.example.library.domain.UserType;
import com.example.library.service.BookReservationServiceImpl;
import com.example.library.service.BookServiceImpl;
import com.example.library.service.UserServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserServiceImpl userService;

	@Autowired
	BookServiceImpl bookService;

	@Autowired
	BookReservationServiceImpl bookReservationService;

	public void contextLoads() {
		User user = new User();
		user.setEmail("karakose.ismailmurat@gmail.com");
		user.setPassword("Karakose.05");
		user.setName("Ismail Murat");
		user.setLastName("Karakose");
		user.setType(UserType.ADMIN);
		user.setPhone("05069452424");
		userService.addUser(user);

		user = new User();
		user.setEmail("stu.user@gmail.com");
		user.setPassword("student");
		user.setName("Ismail Murat");
		user.setLastName("Karakose");
		user.setType(UserType.STUDENT);
		user.setPhone("05069452424");
		userService.addUser(user);
		
		user = new User();
		user.setEmail("lib.user@gmail.com");
		user.setPassword("librarian");
		user.setName("Ismail Murat");
		user.setLastName("Karakose");
		user.setType(UserType.LIBRARIAN);
		user.setPhone("05069452424");
		userService.addUser(user);

		Book book = new Book();
		book.setName("Refactoring");
		book.setAuthor("Martin Fowler");
		book.setPublisher("Amazon");
		book.setQuantity(100);
		bookService.addBook(book);

		book = new Book();
		book.setName("TDD");
		book.setAuthor("Kent Beck");
		book.setPublisher("Amazon");
		book.setQuantity(100);
		bookService.addBook(book);

		BookReservation bookReservation = new BookReservation();
		bookReservation.setUser(userService.getUserById(2l));
		bookReservation.setBook(bookService.getBookById(1l));
		bookReservation.setBorrowDate(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(bookReservation.getBorrowDate());
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		bookReservation.setReturnDate(calendar.getTime());
		bookReservation.setStatus(ReservationStatus.BORROWED);
		bookReservationService.addBookReservation(bookReservation);
		
		bookReservation = new BookReservation();
		bookReservation.setUser(userService.getUserById(2l));
		bookReservation.setBook(bookService.getBookById(1l));
		bookReservation.setBorrowDate(new Date());
		calendar.setTime(bookReservation.getBorrowDate());
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		bookReservation.setReturnDate(calendar.getTime());
		bookReservation.setStatus(ReservationStatus.BORROWED);
		bookReservationService.addBookReservation(bookReservation);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<User> getAll() {
		return userService.getUsers();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestBody UserDTO request) {
		try {
			userService.deleteUser(userService.getUserByEmail(request.getEmail()));
			return "SUCCESS";
		} catch (Exception e) {
			return "FAIL";
		}
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public User add(@RequestBody UserDTO request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setLastName(request.getLastName());
		user.setPhone(request.getPhone());
		user.setType(request.getType());
		user = userService.addUser(user);
		return user;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public User update(@RequestBody UserDTO request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setName(request.getName());
		user.setPassword(request.getPassword());
		user.setLastName(request.getLastName());
		user.setPhone(request.getPhone());
		user.setType(request.getType());
		user = userService.updateUser(user);
		return user;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public User get(@RequestBody UserDTO request) {
		return userService.getUserByEmail(request.getEmail());
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public User login(@RequestBody UserDTO request) {
		contextLoads();
		User temp= userService.getUserByEmail(request.getEmail());
		if(!temp.getPassword().equals(request.getPassword())){
			return null;
		}
		return temp;
	}
}
