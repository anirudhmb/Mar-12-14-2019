package com.intuit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/findpeople")
public class FindingPeopleController {

	@Autowired
	private PersonRepository personRepository;
	
	
	@GetMapping("/agebetween/{min}/{max}")
	public List<Person> loadAllPersonsWithAgeBetween(@PathVariable int min, @PathVariable int max) {
		try {
			
		}
		catch(DataAccessException dex) {
			System.out.println(dex.getCause());
		}
		
		return personRepository.findAllPersonsWithAgeBetween(min, max);
	}
	
	@GetMapping("/id/{id}")
	public Person loadGivenId(@PathVariable int id) {
		//Assumming the id exists
		return personRepository.findById(id).get();
	}
	
	@GetMapping("/name/{name}/age/{age}")
	public Person loadGivenNameAndAge(@PathVariable String name, @PathVariable int age) {
		return personRepository.findByNameAndAge(name, age);
	}
	
	@GetMapping("/id/{id}/age/{age}")
	public Person loadGivenIdAndAge(@PathVariable int id, @PathVariable int age) {
		return personRepository.findByIdAndAge(id, age);
	}
	
}






