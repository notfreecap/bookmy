package com.homesource.bookmy.persistence.repository.jpa;

import com.homesource.bookmy.persistence.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaJpaRepository extends JpaRepository<Factura, Long> {
}
