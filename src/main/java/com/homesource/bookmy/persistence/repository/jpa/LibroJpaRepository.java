package com.homesource.bookmy.persistence.repository.jpa;

import com.homesource.bookmy.persistence.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroJpaRepository extends JpaRepository<Libro, Long> {
}
