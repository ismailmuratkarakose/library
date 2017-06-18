package com.example.library.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.library.domain.BookReservation;

public interface IBookReservationRepository extends CrudRepository<BookReservation, Long> {

}
