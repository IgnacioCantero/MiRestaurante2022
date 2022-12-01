package com.mirestaurante2022.mirestaurante2022.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "plato_restaurante")
@Getter
@Setter
public class PlatoRestaurante {
    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio_base")
    private BigDecimal precioBase;

    //RELACIONES:
    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    @JsonBackReference
    private Restaurante restaurante;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private PlatoPedido platoPedido;
}
