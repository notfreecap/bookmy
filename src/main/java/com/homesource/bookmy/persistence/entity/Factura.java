package com.homesource.bookmy.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "factura")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    @Column(name = "total_pago")
    private Double totalPago;

    @Column(name = "medio_pago")
    private String medioPago;

    @Column(name = "estado_pago")
    private String estadoPago;

    @ManyToOne(optional = false)
    private Persona cliente;

    @ManyToOne(optional = false)
    private Persona administrador;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "factura_id")
    private List<ProductoFactura> productos;
}
