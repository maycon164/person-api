package com.digitalinovationone.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalinovationone.entites.Person;
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
