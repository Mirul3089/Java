package com.humber.j2ee.service;

import javax.ejb.LocalBean;
import java.util.*;
import java.util.stream.IntStream;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.humber.j2ee.model.Customer;


@Stateless
@LocalBean
@Path("/")
public class CustomerServcie {
   
	ArrayList<Customer> customerlist = new ArrayList<> ();

    public CustomerServcie() {
        
    }
    
    
    public List<Customer> getCustomers()
	{
		return this.customerlist;
	}
    
    public void addCustomer(Customer cus) throws Exception
    {
    	boolean isExist = this.customerlist.stream()
				.anyMatch(s -> s.getId() == cus.getId());
		
		if(isExist) throw new Exception ("unique id requires");
		// TODO Auto-generated method stub
		this.customerlist.add(cus);
    }
    public void updateCustomer(int id,Customer cs) throws Exception {
		int index = IntStream.range(0, this.customerlist.size())
				.filter(i -> this.customerlist.get(i).getId() == id)
				.findFirst()
				.orElse(-1);
		
		if(index == -1) throw new Exception("Customer not found with given Id");
		
		this.customerlist.set(index,cs);
	}
    public void deleteCustomer(int id) throws Exception {
		int index = IntStream.range(0, this.customerlist.size())
				.filter(i -> this.customerlist.get(i).getId() == id)
				.findFirst()
				.orElse(-1);
		
		if(index == -1) throw new Exception("Customer not found with given Id");
		
		this.customerlist.remove(index);
	}
	

}
