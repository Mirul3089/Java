package com.humber.j2ee.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.humber.j2ee.model.Book;
import com.humber.j2ee.services.LibraryService;

@Path("/book")
@Stateless
public class LibraryResource {

	@EJB 
	private LibraryService ls;
	
	@GET()
	@Produces("application/json")
	@Path("/all")
	public List<Book> getBooks(){
		return ls.getBook();
	}
}
