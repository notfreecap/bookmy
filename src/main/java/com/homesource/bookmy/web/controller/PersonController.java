package com.homesource.bookmy.web.controller;

import com.homesource.bookmy.domain.dto.PersonDto;
import com.homesource.bookmy.domain.service.PersonService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll(){
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @PostMapping ResponseEntity<PersonDto> createPerson(@RequestBody PersonDto personDto){
        log.info("Creating Person : {}", personDto);
        return new ResponseEntity<>(personService.createPerson(personDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable Long id){
        log.info("Fetching Person with {}", id);
        PersonDto personDto = personService.findPersonById(id);
        if (personDto == null) {
            log.error("Person not found with id {}", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable Long id, @RequestBody PersonDto personDto){
        log.info("Updating Person with : {}", personDto);
        personDto.setPersonId(id);
        PersonDto currentPersonDto = personService.updatePerson(personDto);
        if (currentPersonDto == null){
            log.error("Unable to update person with id {}, not found", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(currentPersonDto, HttpStatus.OK);
    }

}
