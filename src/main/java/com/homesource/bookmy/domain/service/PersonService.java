package com.homesource.bookmy.domain.service;

import com.homesource.bookmy.domain.dto.PersonDto;
import com.homesource.bookmy.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonDto> getAll(){
        return personRepository.getAll();
    }

    public PersonDto createPerson(PersonDto personDto){
        return personRepository.save(personDto);
    }

    public PersonDto findPersonById(Long id){
        return personRepository.findById(id);
    }

    public PersonDto updatePerson(PersonDto personDto){
        return personRepository.update(personDto);
    }

}
