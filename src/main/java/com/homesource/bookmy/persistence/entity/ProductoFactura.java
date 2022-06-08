package com.homesource.bookmy.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "producto_factura")
@AllArgsConstructor @NoArgsConstructor @Builder
public class ProductoFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "tipo_servicio")
    private String tipoServicio; // COMPRA - PRESTAMO

    @ManyToOne(optional = false)
    private Libro libro;

    @Column(name = "factura_id")
    private Long facturaId;
}
