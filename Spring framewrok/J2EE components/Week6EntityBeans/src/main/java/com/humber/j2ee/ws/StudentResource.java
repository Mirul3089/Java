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

import com.humber.j2ee.model.Student;
import com.humber.j2ee.services.StudentService;

@Path("/student")
@Stateless
public class StudentResource {

	@EJB 
	private StudentService ss;
	
	@GET()
	@Produces("text/plain")
	public String ping() {
		return "pong";
	}
	
	@GET()
	@Produces("application/json")
	@Path("/all")
	public List<Student> getStudents(){
		return ss.getStudents();
	}
	
	@POST()
	@Consumes("application/json")
	@Path("/add")
	public Response addStudent(Student student){
		ss.addstudent(student);
		return Response.created(null).build();
	}
	
	@PUT()
	@Consumes("application/json")
	@Path("/update/{id}")
	public Response updatestudent(@PathParam("id") int id,Student student) throws Exception{
		ss.updateStudent(id,student.getFirstName(), student);
		return Response.created(null).build();
	}
	
	@DELETE()
	@Consumes("application/json")
	@Path("/delete/{id}")
	public Response deletestudent(@PathParam("id") int id) throws Exception{
		ss.deleteStudent(id);
		return Response.created(null).build();
	}
	
	
	

}
