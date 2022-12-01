package com.mirestaurante2022.mirestaurante2022.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "restaurante")
@Getter
@Setter
public class Restaurante {
    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "img_logo")
    private String imgLogo;

    @Column(name = "localizacion")
    private String localizacion;

    @Column(name = "destacado")
    private boolean destacado;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "date_updated")
    @UpdateTimestamp
    private Date dateUpdated;

    @Column(name = "img_restaurante")
    private String imgRestaurante;

    //RELACIONES:
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    @JsonBackReference
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<Horario> horarios;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<ComentarioRest> comentarioRest;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<Pedido> pedidos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    @JsonManagedReference
    private Set<PlatoRestaurante> platoRestaurante;
}
