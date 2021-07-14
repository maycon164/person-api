package com.digitalinovationone.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.digitalinovationone.dto.PersonDTO;
import com.digitalinovationone.entites.Person;

@Mapper
public interface PersonMapper {

	PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);
	
}
