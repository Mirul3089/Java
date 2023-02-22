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
public class Student implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String program;
	private String email;
	
//	@OneToOne
//	private program program;
//	@Cascade(Cascade.type)
	
	public Student(String firstName, String lastName, String program, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.program = program;
		this.email = email;
	}

}

