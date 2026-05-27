// src/main/java/com/utp/Grupo5/controller/MatriculaController.java
package com.utp.Grupo5.controller;

import com.utp.Grupo5.entity.Matricula;
import com.utp.Grupo5.service.MatriculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin(origins = "*")
@Tag(name = "Matrículas", description = "API solicitudes de matrícula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    @Operation(summary = "Registrar solicitud de matrícula")
    public ResponseEntity<Matricula> registrarMatricula(@RequestBody Matricula matricula) {
        Matricula nueva = matriculaService.registrarMatricula(matricula);
        if (nueva == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nueva);
    }
}