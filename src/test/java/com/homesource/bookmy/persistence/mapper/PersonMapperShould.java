package com.homesource.bookmy.persistence.mapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonMapperShould {

    @Mock
    PersonMapper personMapper;

    @Test
    void map_persona_to_personDto(){
        /*Persona persona = new Persona();
        persona.setId(1L);

        PersonDto personDto = personMapper.personaToPersonDto(persona);
        assertEquals(personDto.getPersonId(), 1L);*/
    }

}