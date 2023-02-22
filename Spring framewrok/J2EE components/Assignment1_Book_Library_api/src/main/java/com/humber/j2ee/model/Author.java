package com.humber.j2ee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer auth_id;
	
	private String firstName;
	private String lastName;
	private int no_books;
	
	public Author(String firstName, String lastName, int no_books) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.no_books = no_books;
	}
}

