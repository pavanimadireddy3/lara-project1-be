package com.example.stage1_signup;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>{
   public Person findByUsername(String username);
}
