// src/main/java/com/utp/Grupo5/controller/CursoController.java
package com.utp.Grupo5.controller;

import com.utp.Grupo5.entity.Curso;
import com.utp.Grupo5.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@Tag(name = "Cursos", description = "API consulta de cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    @Operation(summary = "Obtener todos los cursos")
    public ResponseEntity<List<Curso>> listarCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener curso por ID")
    public ResponseEntity<Curso> obtenerCurso(@PathVariable Long id) {
        return cursoService.obtenerCursoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}