// src/main/java/com/utp/Grupo5/entity/Curso.java
package com.utp.Grupo5.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;      // ej: "CS101"

    @Column(nullable = false)
    private String nombre;

    private Integer creditos;

    private String modalidad;   // "PRESENCIAL", "VIRTUAL", "HÍBRIDO"

    private Integer vacantes;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Integer getCreditos() { return creditos; }
    public void setCreditos(Integer creditos) { this.creditos = creditos; }

    public String getModalidad() { return modalidad; }
    public void setModalidad(String modalidad) { this.modalidad = modalidad; }

    public Integer getVacantes() { return vacantes; }
    public void setVacantes(Integer vacantes) { this.vacantes = vacantes; }
}