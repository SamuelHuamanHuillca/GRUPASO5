// src/main/java/com/utp/Grupo5/entity/Incidencia.java
package com.utp.Grupo5.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "incidencias")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String aula;        // ← nuevo

    @Column(nullable = false)
    private String equipo;      // ← nuevo

    @Column(nullable = false)
    private String tipo;        // ← nuevo ej: "HARDWARE", "SOFTWARE", "RED"

    private String descripcion;

    // "PENDIENTE", "EN_PROCESO", "ATENDIDA"
    @Column(nullable = false)
    private String estado;

    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAula() { return aula; }
    public void setAula(String aula) { this.aula = aula; }

    public String getEquipo() { return equipo; }
    public void setEquipo(String equipo) { this.equipo = equipo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}