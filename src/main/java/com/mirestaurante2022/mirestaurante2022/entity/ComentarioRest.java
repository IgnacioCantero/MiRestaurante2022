package com.mirestaurante2022.mirestaurante2022.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comentario_rest")
@Getter
@Setter
public class ComentarioRest {
    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "puntuacion")
    private int puntuacion;

    //RELACIONES:
    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    @JsonBackReference
    private Restaurante restaurante;
}
