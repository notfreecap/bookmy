package com.homesource.bookmy.persistence.repository.jpa;

import com.homesource.bookmy.persistence.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaJpaRepository extends JpaRepository<Persona, Long> {
}
