package com.example.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "book")
public class Book {
	// Kitap id, adı, yazarı, yayıncı ve adet bilgilerinin girilerek
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@NotEmpty
	@Size(min = 3, max = 20)
	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@NotEmpty
	@Size(min = 6, max = 20)
	@Column(name = "author", nullable = false)
	private String author;

	@NotEmpty
	@Column(name = "publisher", nullable = false)
	private String publisher;

	@NotEmpty
	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	public Book(String name, String author, String publisher, Integer quantity) {
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.quantity = quantity;
	}

	public Book() {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public Integer getQuantity() {
		return quantity;
	}

}
