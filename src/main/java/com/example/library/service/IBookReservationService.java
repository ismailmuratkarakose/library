package com.example.library.service;

import java.util.List;

import com.example.library.domain.BookReservation;

public interface IBookReservationService {

	BookReservation getBookReservationById(Long id);

	BookReservation addBookReservation(BookReservation bookReservation);

	List<BookReservation> getBookReservations();

}
