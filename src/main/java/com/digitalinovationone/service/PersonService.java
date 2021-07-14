package com.digitalinovationone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinovationone.dto.MessageResponseDTO;
import com.digitalinovationone.dto.PersonDTO;
import com.digitalinovationone.entites.Person;
import com.digitalinovationone.mapper.PersonMapper;
import com.digitalinovationone.reporitory.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository repository;
	
	private final PersonMapper personMapper = PersonMapper.INSTANCE;
	
	public MessageResponseDTO createPerson (PersonDTO personDTO) {
		//PersonDTO para person, but how?
		Person savedPerson = personMapper.toModel(personDTO);
		
		savedPerson = repository.save(savedPerson);
		
		return MessageResponseDTO
				.builder()
				.message("Created Person with ID " + savedPerson.getId())
				.build();
		
	}
	

}
