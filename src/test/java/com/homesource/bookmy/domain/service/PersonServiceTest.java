package com.homesource.bookmy.domain.service;

import com.homesource.bookmy.domain.dto.PersonDto;
import com.homesource.bookmy.domain.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    private PersonDto personDto;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);

        personDto = PersonDto.builder()
                .firstName("pepe")
                .lastName("tester")
                .build();
    }

    @Test
    void getAll() {
        Mockito.when(personRepository.getAll()).thenReturn(Collections.singletonList(personDto));

        List<PersonDto> result = personService.getAll();
        assertEquals(personDto.getFirstName(), result.get(0).getFirstName());
        assertEquals(1, result.size());
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }
}