package com.intuit;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	//JPA QL
	@Query("select p from Person p where p.age > :p1 and p.age < :p2")
	List<Person> findAllPersonsWithAgeBetween(@Param("p1") int min, @Param("p2") int max);
	
	//findBy Methods 
	
	Person findByNameAndAge(String name, int age);
	Person findByIdAndAge(int id, int age);
	Person findByNameAndId(String name, int id);
	Person findByAgeAndName(int age, String name);
	
	
	//findAllBy Methods 
	
	List<Person> findAllByNameAndAge(String name, int age);
	List<Person> findAllByIdAndAge(int id, int age);
	List<Person> findAllByNameAndId(String name, int id);
	List<Person> findAllByAgeAndName(int age, String name);
}
