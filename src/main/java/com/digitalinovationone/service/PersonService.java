package com.digitalinovationone.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

		return message(savedPerson.getId(), "Person created with id");
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
	
	public MessageResponseDTO update(Long id, @Valid PersonDTO personDTO) throws PersonNotFoundException {
		verifyExists(id);
		Person updatePerson = personMapper.toModel(personDTO);
		repository.save(updatePerson);
		return message(id, "person updated with id ");
	}

	private Person verifyExists(Long id) throws PersonNotFoundException {
		return repository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));

	}

	private MessageResponseDTO message(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}



}
