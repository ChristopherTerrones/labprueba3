package com.example.labprueba3.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
@Getter
@Setter
@Entity
@Table(name = "receta")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreceta")
    private int idreceta;

    @Column(name = "nombre", length = 200)
    private String nombre;

    @Column(name = "instrucciones")
    private String instrucciones;

    @Column(name = "dificultad")
    private int dificultad;

    @Column(name = "tiempo_preparacion")
    private LocalTime tiempoPreparacion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idcategoria", nullable = false)
    private Categoria categoria;

}
