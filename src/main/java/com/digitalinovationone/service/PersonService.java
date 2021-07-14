package com.digitalinovationone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinovationone.dto.MessageResponseDTO;
import com.digitalinovationone.entites.Person;
import com.digitalinovationone.reporitory.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository repository;
	
	public MessageResponseDTO createPerson (Person p) {
		Person savedPerson = repository.save(p);
		return MessageResponseDTO
				.builder()
				.message("Created Person with ID " + savedPerson.getId())
				.build();
		
	}
	

}
