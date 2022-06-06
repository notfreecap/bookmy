package com.homesource.bookmy.persistence.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "producto_factura")
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

    /*@ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Factura factura;*/
    @Column(name = "factura_id")
    private Long facturaId;


}
