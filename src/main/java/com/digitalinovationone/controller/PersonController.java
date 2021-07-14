package com.digitalinovationone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinovationone.dto.MessageResponseDTO;
import com.digitalinovationone.entites.Person;
import com.digitalinovationone.reporitory.PersonRepository;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {
	
	@Autowired
	PersonRepository repository;
	
	@PostMapping
	public MessageResponseDTO cretePerson(@RequestBody Person p) {
		Person savedPerson = repository.save(p);
		return MessageResponseDTO
				.builder()
				.message("Created Person with ID " + savedPerson.getId())
				.build();
		
	}
	
}
