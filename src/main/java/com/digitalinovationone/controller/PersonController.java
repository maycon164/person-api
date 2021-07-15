package com.digitalinovationone.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digitalinovationone.dto.MessageResponseDTO;
import com.digitalinovationone.dto.PersonDTO;
import com.digitalinovationone.exception.PersonNotFoundException;
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
	
	@GetMapping
	public List<PersonDTO> listAll(){
		return personService.listAll();
	}

	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		return personService.findById(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody  PersonDTO personDTO) throws PersonNotFoundException {
		return personService.update(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
		personService.delete(id);	
	}
}

