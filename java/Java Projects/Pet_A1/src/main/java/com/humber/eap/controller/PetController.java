package com.humber.eap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humber.eap.model.Owner;
import com.humber.eap.model.Pet;
import com.humber.eap.repo.OwnerRepository;
import com.humber.eap.repo.PetRepository;

@Controller
public class PetController {

	@Autowired
	private OwnerRepository or;
	
	@Autowired
	private PetRepository pr;
	
	
	@GetMapping("/all")
	public String home(Model model) {
		model.addAttribute("owners", or.findAll());
		return "home.html";
	}
	
	@GetMapping("/delete")
	public String addCategory(Model model) {
		model.addAttribute("owners",or.findAll());
		model.addAttribute("pet",pr.findAll());
		return "home.html";
	}
	
	@GetMapping("/pet")
	public String newpet(Model model) {
		//model.addAttribute("owners",new Owner());
		model.addAttribute("pet",new Pet());
		model.addAttribute("pettype",pr.findAll());
		return "addpet.html";
	}
	
	@PostMapping("/addPet")
	public String addPet(@ModelAttribute Pet pet) {
		pr.save(pet);
		return "redirect:/allpet";
	}
	
	@GetMapping("/allpet")
	public String homepet(Model model) {
		model.addAttribute("pets", pr.findAll());
		return "homepet.html";
	}
	
	@GetMapping("/owner")
	public String newowner(Model model) {
		//List <Pet> petcatagories = pr.findAll();
		model.addAttribute("petcatagories",pr.findAll());
		model.addAttribute("owners",new Owner());
		
		//model.addAttribute("pets",new Pet());
		return "addown.html";
	}
	

	@PostMapping("/addOwner")
	public String addOwner(@ModelAttribute Owner own) {
		or.save(own);
		return "redirect:/all";
	}
	
	@PostMapping("/deletevalue")
	@Query("DELETE * from Owner where pet_id=?1")
	String findOwnerById(Integer pet_id) {
		or.deleteById(pet_id);
		return "redirect:/all";
	}
}
