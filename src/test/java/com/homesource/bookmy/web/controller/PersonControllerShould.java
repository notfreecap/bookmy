package com.homesource.bookmy.web.controller;

import com.homesource.bookmy.domain.dto.PersonDto;
import com.homesource.bookmy.domain.repository.PersonRepository;
import com.homesource.bookmy.domain.service.PersonService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonControllerShould {

    @Autowired
    PersonController personController = new PersonController();

    PersonDto mockPersonDto;

    @BeforeEach
    void setUp() {
        mockPersonDto = PersonDto.builder()
                .numberId("9098989")
                .firstName("Jessica")
                .lastName("Ramirez")
                .birthDate(LocalDate.of(2022, 6, 4))
                .profile("USER").build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
        ResponseEntity<List<PersonDto>> response = personController.getAll();
        assertEquals(1, response.getBody().size());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void createPerson() {
        ResponseEntity<PersonDto> response = personController.createPerson(mockPersonDto);
        assertEquals(mockPersonDto.getNumberId(), response.getBody().getNumberId());
        assertEquals(mockPersonDto.getFirstName(), response.getBody().getFirstName());
        assertEquals(mockPersonDto.getLastName(), response.getBody().getLastName());
    }

    @Test
    void findPersonById() {
        ResponseEntity<PersonDto> response = personController.findPersonById((long) 1);
        assertEquals(mockPersonDto.getFirstName(), response.getBody().getFirstName());
        assertEquals(mockPersonDto.getLastName(), response.getBody().getLastName());
    }

    @Test
    void updatePerson() {
        mockPersonDto.setNumberId("555555");
        ResponseEntity<PersonDto> response = personController.updatePerson((long)1, mockPersonDto);
        assertEquals(mockPersonDto.getPersonId(), response.getBody().getPersonId());
        assertEquals("555555", response.getBody().getNumberId());
        assertEquals(mockPersonDto.getFirstName(), response.getBody().getFirstName());
        assertEquals(mockPersonDto.getLastName(), response.getBody().getLastName());
    }
}