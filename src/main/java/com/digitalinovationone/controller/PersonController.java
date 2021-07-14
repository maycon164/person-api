package com.digitalinovationone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinovationone.dto.MessageResponseDTO;
import com.digitalinovationone.dto.PersonDTO;
import com.digitalinovationone.service.PersonService;

@RestController
@RequestMapping("api/v1/people")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO cretePerson(@RequestBody PersonDTO personDTO) {
		return personService.createPerson(personDTO);
	}
	
}
