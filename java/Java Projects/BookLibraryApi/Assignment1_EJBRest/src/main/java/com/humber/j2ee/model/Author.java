package com.humber.j2ee.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author implements Serializable {

    @Id
    @GeneratedValue
	private int ID;
    
	private String firstName;
	private String lastName;
	private int no_books;
	
//	
	public Author(String firstName, String lastName, int no_books) {
		super();
		//this.author_id=author_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.no_books = no_books;
	}
	
}

