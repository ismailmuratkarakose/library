package com.example.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.library.domain.BookReservation;
import com.example.library.repository.IBookReservationRepository;

@Service
public class BookReservationService implements IBookReservationService {
	@Autowired
	IBookReservationRepository bookReservationRepository;

	@Override
	public BookReservation getBookReservationById(Long id) {
		return bookReservationRepository.findOne(id);
	}

	@Override
	public BookReservation addBookReservation(BookReservation bookReservation) {
		return bookReservationRepository.save(bookReservation);
	}

	@Override
	public List<BookReservation> getBookReservations() {
		return (List<BookReservation>) bookReservationRepository.findAll();
	}

}
