package com.victorfm.controller;

import com.victorfm.domain.Person;
import com.victorfm.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    private Object Person;

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public List<Person> getAllperson() {
        return personRepository.findAll();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Person getOnePerson(@PathVariable("id") String id) {
        return personRepository.findOne(id);
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/person/edit/{id}", method = RequestMethod.PUT)
    public Person updatePerson(@PathVariable String id, @RequestBody Person newPersonName) {

        Person person1 = personRepository.findOne(id);
        person1.setNome(newPersonName.getNome());
        return personRepository.save(person1);
    }
    @RequestMapping(value = "/person/delete/{id}", method = RequestMethod.DELETE)
    public void deletePersonId(@PathVariable("id") String id){
        personRepository.delete(id);
    }
}

