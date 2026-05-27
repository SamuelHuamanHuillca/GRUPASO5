// src/main/java/com/utp/Grupo5/controller/IncidenciaController.java
package com.utp.Grupo5.controller;

import com.utp.Grupo5.entity.Incidencia;
import com.utp.Grupo5.service.IncidenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*")
@Tag(name = "Incidencias", description = "API para gestión de incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    // GET /api/incidencias
    @GetMapping
    @Operation(summary = "Obtener todas las incidencias")
    public ResponseEntity<List<Incidencia>> listarIncidencias() {
        return ResponseEntity.ok(incidenciaService.listarIncidencias());
    }

    // POST /api/incidencias
    @PostMapping
    @Operation(summary = "Registrar una nueva incidencia")
    public ResponseEntity<Incidencia> guardarIncidencia(@RequestBody Incidencia incidencia) {
        return ResponseEntity.ok(incidenciaService.guardarIncidencia(incidencia));
    }

    // PUT /api/incidencias/{id}
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una incidencia existente")
    public ResponseEntity<Incidencia> actualizarIncidencia(
            @PathVariable Long id,
            @RequestBody Incidencia incidencia) {
        Incidencia actualizada = incidenciaService.actualizarIncidencia(id, incidencia);
        if (actualizada == null) {
            return ResponseEntity.notFound().build(); // 404
        }
        return ResponseEntity.ok(actualizada); // 200
    }
}