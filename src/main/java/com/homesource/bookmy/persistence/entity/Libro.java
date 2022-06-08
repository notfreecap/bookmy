package com.homesource.bookmy.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "libro")
@AllArgsConstructor @NoArgsConstructor @Builder
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String autor;

    @Column(name = "fecha_lanzamiento")
    private LocalDate fechaLanzamiento;

    private int paginas;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    private String estado;

    /*@OneToOne(cascade = CascadeType.ALL)
    @MapsId("id")
    @JoinColumn(name = "id", referencedColumnName = "id")*/
    //@ManyToOne(optional = false, cascade = CascadeType.ALL)
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private LibroStock libroStock;

}
