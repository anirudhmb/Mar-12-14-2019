package com.intuit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PeopleController {

	@Autowired
	private PersonRepository personRepository;
	
	
	@GetMapping("/info")
	public String getInfo() {
		String info = "Class Name: " + personRepository.getClass().getName() + "\n\n";
		info += "******IMPLEMENTED INTERFACES*******";
		for (Class interf : personRepository.getClass().getInterfaces()) {
			info += "\n";
			info += interf.getName();
		} 
		return info;
	}
	
	@PostMapping("/{name}/{age}")
	public String savePerson(@PathVariable String name, @PathVariable int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		person = personRepository.save(person);
		return "Person with id " + person.getId() + " is created";
	}
	
	@PutMapping("/{id}/{age}")
	public String updateAge(@PathVariable int id, @PathVariable int age) {
		Optional<Person> optPerson = personRepository.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			person.setAge(age);
			personRepository.save(person);
		}
		else {
			return "Person with id: " + id + " is not present";
		}
		return "Age updated";
	}
	
	@GetMapping("/all")
	public List<Person> getAllPersons() {
		List<Person> persons = new ArrayList();
		personRepository.findAll().forEach(it -> persons.add(it));
		return persons;
	}	
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		Optional<Person> optPerson = personRepository.findById(id);
		if(optPerson.isPresent()) {
			Person person = optPerson.get();
			personRepository.delete(person);
		}
		else {
			return "Person with id: " + id + " is not present";
		}
		return "Person deleted";
	}
	
	
}






