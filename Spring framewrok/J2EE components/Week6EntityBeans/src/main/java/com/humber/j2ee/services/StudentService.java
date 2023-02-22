package com.humber.j2ee.services;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.hibernate.query.Query;

import com.humber.j2ee.model.Student;

@Stateless
public class StudentService {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Students");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	
	@PostConstruct
	public void init() {
		
		Student student = new Student("Fred", "Smith", "ITS", "fred.smith@gmail.com");
		Student student1 = new Student("John", "smith", "ITS","john.smith@gmail.com");
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.persist(student1);
		entityManager.getTransaction().commit();
	}
	
	public List<Student> getStudents(){
	  return entityManager.createQuery("from Student").getResultList();	
	}
	
	 public void addstudent(Student student) {
		entityManager.getTransaction().begin();
		entityManager.persist(student);
		entityManager.getTransaction().commit();
	}
	 @Transactional
	 public void updateStudent(int id,String name,Student student) throws Exception {
		 entityManager.getTransaction().begin();
		 Student student123 = new Student(id,name,student.getLastName(),student.getProgram(),student.getEmail());
		 //if(id != student.getId()) throw new Exception("Student not found with given Id");
		 entityManager.merge(student123);
		 entityManager.getTransaction().commit();
		}
	 @Transactional
     public void deleteStudent(int id) throws Exception {
		entityManager.getTransaction().begin();
		Student student=entityManager.find(Student.class,id);  
		if (student == null) throw new Exception("Student not found with given Id");
	    entityManager.remove(student);
		entityManager.getTransaction().commit();
	}
}

