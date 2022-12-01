package com.mirestaurante2022.mirestaurante2022.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plato_pedido")
@Getter
@Setter
public class PlatoPedido {
    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cantidad")
    private int cantidad;

    //RELACIONES:
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    @JsonBackReference
    private Pedido pedido;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plato_id", referencedColumnName = "id")
    private PlatoRestaurante platoRestaurante;
}
