package com.digitalinovationone.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitalinovationone.dto.MessageResponseDTO;
import com.digitalinovationone.dto.PersonDTO;
import com.digitalinovationone.entites.Person;
import com.digitalinovationone.exception.PersonNotFoundException;
import com.digitalinovationone.mapper.PersonMapper;
import com.digitalinovationone.reporitory.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository repository;

	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		// PersonDTO para person, but how?
		Person savedPerson = personMapper.toModel(personDTO);

		savedPerson = repository.save(savedPerson);

		return MessageResponseDTO.builder().message("Created Person with ID " + savedPerson.getId()).build();

	}

	public List<PersonDTO> listAll() {
		List<Person> people = repository.findAll();

		return people.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyExists(id);
		return personMapper.toDTO(person);
	}

	public void delete(Long id) throws PersonNotFoundException {
		verifyExists(id);
		
		repository.deleteById(id);
	}
	
	public Person verifyExists(Long id) throws PersonNotFoundException {
		return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
		
	}

}
