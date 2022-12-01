package com.mirestaurante2022.mirestaurante2022.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pedido")
@Getter
@Setter
public class Pedido {
    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "estado")
    private String estado;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    @Column(name = "fecha")
    private Date fecha;

    //RELACIONES:
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "direccion_id", nullable = false)
    @JsonBackReference
    private Direccion direccion;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    @JsonBackReference
    private Restaurante restaurante;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    @JsonManagedReference
    private Set<PlatoPedido> platosPedido;
}
