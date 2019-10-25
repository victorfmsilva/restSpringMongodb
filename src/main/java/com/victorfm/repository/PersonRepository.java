package com.victorfm.repository;


import com.victorfm.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface PersonRepository extends MongoRepository<Person, String> {

    //Optional<Person> findById(String id);

}

