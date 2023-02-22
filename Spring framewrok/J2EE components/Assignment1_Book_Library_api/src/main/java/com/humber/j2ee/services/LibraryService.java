package com.humber.j2ee.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.humber.j2ee.model.Author;
import com.humber.j2ee.model.Book;

@Stateless
public class LibraryService {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Books");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	@PostConstruct
	public void init() {
		
		Author a1= new Author("Robert","Kiyosaki",1);
		Author a2= new Author("Robert","Kiyosaki",2);
		Author a3= new Author("Robert","Kiyosaki",3);
		Author a4= new Author("Robert","Kiyosaki",4);
		Author a5= new Author("Robert","Kiyosaki",5);
		
		Book b1 = new Book("RichDadPoorDad",100, "finacial knowledge");
		Book b2 = new Book("RichDadPoorDad",100, "finacial knowledge");
		Book b3 = new Book("RichDadPoorDad",100, "finacial knowledge");
		Book b4 = new Book("RichDadPoorDad",100, "finacial knowledge");
		Book b5 = new Book("RichDadPoorDad",100, "finacial knowledge");
		
		b1.setAuth(a1);
		b2.setAuth(a2);
		b3.setAuth(a3);
		b4.setAuth(a4);
		b5.setAuth(a5);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(b1);
		entityManager.persist(b2);
		entityManager.persist(b3);
		entityManager.persist(b4);
		entityManager.persist(b5);
		
		entityManager.getTransaction().commit();
		
		 System.out.println(
	                "Transaction Successfully Completed!");
	}
	public List<Book> getBook(){
		  return entityManager.createQuery("from Book").getResultList();	
		}
}
