package com.humber.j2ee.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.ws.rs.Path;


import com.humber.j2ee.model.Author;
import com.humber.j2ee.model.Book;

@Stateless
@Path("/")
public class LibraryService {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Books");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	
	@PostConstruct
	public void init() {
		
		Book b1 = new Book("RichDadPoorDad",100, "Finacial knowledge");
		Book b2 = new Book("CenturyIsNotEnough",100, "motivational");
		Book b3 = new Book("Atomic Habits",100, "Dailylife");
		Book b4 = new Book("Beating the street",100, "finacial knowledge");
		Book b5 = new Book("ZeroToOne",100, "Business");
		
		Author a1= new Author("robert","kiyosaki",10);
		Author a2= new Author("Saurav","Ganguly",10);
		Author a3= new Author("James","Clear",10);
		Author a4= new Author("Peter","Lynch",10);
		Author a5= new Author("Peter","Thiel",10);
		Author a6= new Author("Pablo","Escobar",5);
		
		b1.getAuthors().add(a1);
		b2.getAuthors().add(a2);
		b3.getAuthors().add(a3);
		b4.getAuthors().add(a4);
		b5.getAuthors().add(a5);
		b5.getAuthors().add(a6);
		
	
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
	
	public List<Book> getBookByAuthor(String name){
		  Query query= entityManager.createQuery("Select b.Name,a.firstName from Book b,Author a where a.ID=b.ID and a.firstName = :name");
		  query.setParameter("name", name);
		  return query.getResultList();
		}
	
	public List<Book> getBookByGenre(String name){
		  Query query= entityManager.createQuery("from Book where genre = :name");
		  query.setParameter("name", name);
		  return query.getResultList();
		}
	
	public void addBook(Book book) {
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.getTransaction().commit();
	}
	
	@Transactional
	 public void updateBook(int id,Book book) throws Exception {
		 entityManager.getTransaction().begin();
		 Book b1 = new Book(id,book.getName(),book.getPrice(),book.getGenre(),book.getAuthors());
		 //if(id != student.getId()) throw new Exception("Student not found with given Id");
		 entityManager.merge(b1);
		 entityManager.getTransaction().commit();
		}
	
	 @Transactional
    public void deleteBook(int id) throws Exception {
		entityManager.getTransaction().begin();
		Book book=entityManager.find(Book.class,id);  
		if (book == null) throw new Exception("Book not found with given Id");
	    entityManager.remove(book);
		entityManager.getTransaction().commit();
	}
}
