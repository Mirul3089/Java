package com.humber.eap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humber.eap.model.Department;
import com.humber.eap.model.Employees;
import com.humber.eap.repo.DepartmentRepository;
import com.humber.eap.repo.EmployeeRepository;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository er;
	
	@Autowired
	private DepartmentRepository dr;
	
	
	@GetMapping("/")
	public String home(Model model)
	{
		model.addAttribute("employees", er.findAll());
		return "home";
	}
	
	@PostMapping("/employee")
	public String employeebyid(@RequestParam int emp_id,Model model)
	{
		model.addAttribute("employees", er.findById(emp_id).get());
		return "employee";
	}
	
	@GetMapping("/employeeid")
	public String employeeid(@RequestParam int emp_id,Model model)
	{
		model.addAttribute("employees", er.findById(emp_id).get());
		return "employee";
	}
	
	@PostMapping("/searchemployee")
	public String searchemployee(@RequestParam String search,Model model)
	{
		model.addAttribute("emps", er.searchByAll(search));
		return "home" ;
	}
	
	@GetMapping("/addemployee")
	public String addemployee(Model model)
	{
		model.addAttribute("departments",dr.findAll());
		model.addAttribute("emp",new Employees());
		
		//model.addAttribute("pets",new Pet());
		return "addemployee.html";
	}

	@PostMapping("/saveEmployee")
	public String addPet(@ModelAttribute Employees emp) {
		er.save(emp);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public void logout(HttpSecurity http) throws Exception {
		http.logout();
		
	}

}
