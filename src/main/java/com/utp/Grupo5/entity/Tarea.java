
// src/main/java/com/utp/Grupo5/entity/Tarea.java
package com.utp.Grupo5.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tareas")
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String descripcion;

    @Column(nullable = false)
    private String curso;       // ← nombre del curso, campo simple

    @Column(nullable = false)
    private String estado;      // "PENDIENTE", "EN_PROGRESO", "COMPLETADA"

    @Column(nullable = false)
    private String prioridad;   // "ALTA", "MEDIA", "BAJA"  ← nuevo

    private LocalDate fechaVencimiento;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
}





