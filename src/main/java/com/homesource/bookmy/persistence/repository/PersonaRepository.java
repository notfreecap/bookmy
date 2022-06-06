package com.homesource.bookmy.persistence.repository;

import com.homesource.bookmy.domain.dto.PersonDto;
import com.homesource.bookmy.domain.repository.PersonRepository;
import com.homesource.bookmy.persistence.entity.Persona;
import com.homesource.bookmy.persistence.mapper.PersonMapper;
import com.homesource.bookmy.persistence.repository.jpa.PersonaJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonaRepository implements PersonRepository {

    @Autowired
    PersonaJpaRepository personaRepository;

    @Autowired
    PersonMapper mapper;

    @Override
    public List<PersonDto> getAll() {
        return mapper.toPersonDtoList(personaRepository.findAll());
    }

    @Override
    public PersonDto save(PersonDto personDto) {
        Persona persona = mapper.toPersona(personDto);
        persona.setEstado("CREADO");
        return mapper.toPersonDto(personaRepository.save(persona));
    }

    @Override
    public PersonDto findById(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return mapper.toPersonDto(persona);
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        Persona personaDB = personaRepository.findById(personDto.getPersonId()).orElse(null);
        if (personaDB == null)
            return null;

        personaDB.setDocumento(personDto.getNumberId());
        personaDB.setNombres(personDto.getFirstName());
        personaDB.setApellidos(personDto.getLastName());
        personaDB.setFechaNacimiento(personDto.getBirthDate());
        personaDB.setPerfil(personDto.getProfile());
        return mapper.toPersonDto(personaRepository.save(personaDB));
    }
}
