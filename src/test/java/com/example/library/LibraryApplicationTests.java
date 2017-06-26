package com.example.library;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.library.domain.Book;
import com.example.library.domain.BookReservation;
import com.example.library.domain.ReservationStatus;
import com.example.library.domain.User;
import com.example.library.domain.UserType;
import com.example.library.service.BookReservationServiceImpl;
import com.example.library.service.BookServiceImpl;
import com.example.library.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

	@Autowired
	UserServiceImpl userService;

	@Autowired
	BookServiceImpl bookService;

	@Autowired
	BookReservationServiceImpl bookReservationService;

	@Test
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
	
		BookReservation bookReservation= new BookReservation();
		bookReservation.setUser(userService.getUserById(2l));
		bookReservation.setBook(bookService.getBookById(1l));
		bookReservation.setBorrowDate(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(bookReservation.getBorrowDate());
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		bookReservation.setReturnDate(calendar.getTime());
		bookReservation.setStatus(ReservationStatus.BORROWED);
		bookReservationService.addBookReservation(bookReservation);
	}

}
