// src/main/java/com/utp/Grupo5/entity/Curso.java
package com.utp.Grupo5.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    private Integer capacidadMaxima;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Matriculado> matriculados;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getCapacidadMaxima() { return capacidadMaxima; }
    public void setCapacidadMaxima(Integer capacidadMaxima) { this.capacidadMaxima = capacidadMaxima; }

    public List<Matriculado> getMatriculados() { return matriculados; }
    public void setMatriculados(List<Matriculado> matriculados) { this.matriculados = matriculados; }
}