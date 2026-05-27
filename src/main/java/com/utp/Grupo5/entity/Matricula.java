// src/main/java/com/utp/Grupo5/entity/Matricula.java
package com.utp.Grupo5.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreEstudiante;

    @Column(nullable = false)
    private String codigoEstudiante;

    @Column(nullable = false)
    private String turno; // "MAÑANA", "TARDE", "NOCHE"

    private LocalDate fechaMatricula;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @PrePersist
    public void prePersist() {
        this.fechaMatricula = LocalDate.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombreEstudiante() { return nombreEstudiante; }
    public void setNombreEstudiante(String nombreEstudiante) { this.nombreEstudiante = nombreEstudiante; }

    public String getCodigoEstudiante() { return codigoEstudiante; }
    public void setCodigoEstudiante(String codigoEstudiante) { this.codigoEstudiante = codigoEstudiante; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public LocalDate getFechaMatricula() { return fechaMatricula; }
    public void setFechaMatricula(LocalDate fechaMatricula) { this.fechaMatricula = fechaMatricula; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}