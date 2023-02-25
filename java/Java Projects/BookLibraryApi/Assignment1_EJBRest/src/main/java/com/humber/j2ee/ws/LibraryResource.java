package com.humber.j2ee.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	public List<Book> getBo(){
		return ls.getBook();
	}
	
	@GET()
	@Produces("application/json")
	@Path("/byauthor/{name}")
	public List<Book> getByAname(@PathParam("name") String name){
		return ls.getBookByAuthor(name);
	}
	
	@GET()
	@Produces("application/json")
	@Path("/bygenre/{name}")
	public List<Book> getByName(@PathParam("name") String name){
		return ls.getBookByGenre(name);
	}
	
	@POST()
	@Consumes("application/json")
	@Path("/add")
	public Response addStudent(Book book){
		ls.addBook(book);
		return Response.created(null).build();
	}
	
	@PUT()
	@Consumes("application/json")
	@Path("/update/{id}")
	public Response updatebook(@PathParam("id") int id,Book book) throws Exception{
		ls.updateBook(id,book);
		return Response.created(null).build();
	}
	
	@DELETE()
	@Consumes("application/json")
	@Path("/delete/{id}")
	public Response deleteBook(@PathParam("id") int id) throws Exception{
		ls.deleteBook(id);
		return Response.created(null).build();
	}
	
}
