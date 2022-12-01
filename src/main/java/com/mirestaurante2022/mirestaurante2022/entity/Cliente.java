package com.mirestaurante2022.mirestaurante2022.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {
    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "dni")
    private String dni;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email")
    private String email;

    //RELACIONES:
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JsonManagedReference
    private Set<Pedido> pedidos;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    @JsonManagedReference
    private Set<Direccion> direccion;
}
