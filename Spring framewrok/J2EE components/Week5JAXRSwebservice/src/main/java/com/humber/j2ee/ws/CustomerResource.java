package com.humber.j2ee.ws;

import java.util.List;

import javax.annotation.PostConstruct;
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import com.humber.j2ee.model.Customer;
import com.humber.j2ee.service.CustomerServcie;

@Stateless
@Path("/api")
public class CustomerResource {

	@EJB
	private CustomerServcie cs;
	
	@PostConstruct
	public void init() throws Exception
	{
		this.cs.addCustomer(new Customer(1,"Mirul"));
		this.cs.addCustomer(new Customer(2,"Pablo"));
		this.cs.addCustomer(new Customer(3,"Chapo"));
		
	}
	
	@GET
	public String welcome() {
		return "Welcome Customer Resource!!";
	}	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<Customer> getCustomers()
	{
		return cs.getCustomers();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/add")
	public Response addCustomer(Customer cus)
	{
		try {
		cs.addCustomer(cus);
		return Response.status(Status.CREATED).build();
		}
		catch(Exception e)
		{
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	

	@PUT
	@Path("/update/{id}")//{name}
	public Response updateCustomerById(@PathParam("id") int id,Customer cus) {
		try {
			cs.updateCustomer(id,cus);
			return Response.status(200).build();
		} catch(Exception e) {
			return Response.serverError().entity(e.getMessage().toString()).build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteCustomerById(@PathParam("id") int id) {
		try {
			cs.deleteCustomer(id);
			return Response.status(204).build() ;
		} catch(Exception e) {
			return Response.serverError().entity(e.getMessage().toString()).build();
			
		}
	}
}
