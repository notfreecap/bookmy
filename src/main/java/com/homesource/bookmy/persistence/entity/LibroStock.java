package com.homesource.bookmy.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "libro_stock")
public class LibroStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unidades_prestamo")
    private Integer unidadesPrestamo;

    @Column(name = "valor_prestamo")
    private Double valorPrestamo;

    @Column(name = "unidades_venta")
    private Integer unidadesVenta;

    @Column(name = "valor_venta")
    private Double valorVenta;

    /*@OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Libro libro;*/
    /*@Column(name = )
    private Long libroId;*/
}
