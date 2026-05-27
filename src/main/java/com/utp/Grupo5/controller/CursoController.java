// src/main/java/com/utp/Grupo5/controller/CursoController.java
package com.utp.Grupo5.controller;

import com.utp.Grupo5.entity.Curso;
import com.utp.Grupo5.entity.Matriculado;
import com.utp.Grupo5.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
@Tag(name = "Cursos", description = "API para gestión de cursos y matrículas")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // GET /api/cursos
    @GetMapping
    @Operation(summary = "Obtener todos los cursos")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    // POST /api/cursos/{cursoId}/matricular
    @PostMapping("/{cursoId}/matricular")
    @Operation(summary = "Matricular un alumno en un curso")
    public ResponseEntity<Matriculado> matricularAlumno(
            @PathVariable Long cursoId,
            @RequestBody Matriculado matriculado) {
        Matriculado nuevo = cursoService.matricularAlumno(cursoId, matriculado);
        if (nuevo == null) {
            return ResponseEntity.notFound().build(); // curso no existe
        }
        return ResponseEntity.ok(nuevo);
    }
}