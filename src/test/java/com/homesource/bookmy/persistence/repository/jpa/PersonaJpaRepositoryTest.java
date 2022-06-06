package com.homesource.bookmy.persistence.repository.jpa;

import com.homesource.bookmy.persistence.entity.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonaJpaRepositoryTest {

    @Autowired
    PersonaJpaRepository personaJpaRepository;

    Persona persona;

    @BeforeEach
    void setUp() {
        persona = Persona.builder()
                .nombres("test")
                .apellidos("test")
                .build();
    }

    @Test
    void shouldCreateNewPersona(){
        Persona result = personaJpaRepository.save(persona);

        assertEquals(persona.getNombres(), result.getNombres());
    }
}