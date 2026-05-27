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
import java.util.Map;

@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*")
@Tag(name = "Incidencias", description = "API gestión de incidencias de laboratorio")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @GetMapping
    @Operation(summary = "Obtener todas las incidencias")
    public ResponseEntity<List<Incidencia>> listarIncidencias() {
        return ResponseEntity.ok(incidenciaService.listarIncidencias());
    }

    @PostMapping
    @Operation(summary = "Registrar nueva incidencia")
    public ResponseEntity<Incidencia> guardarIncidencia(@RequestBody Incidencia incidencia) {
        return ResponseEntity.ok(incidenciaService.guardarIncidencia(incidencia));
    }

    // PUT /api/incidencias/{id}/estado  ← exacto como pide el ejercicio
    @PutMapping("/{id}/estado")
    @Operation(summary = "Actualizar estado de una incidencia")
    public ResponseEntity<Incidencia> actualizarEstado(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {
        String nuevoEstado = body.get("estado");
        Incidencia actualizada = incidenciaService.actualizarEstado(id, nuevoEstado);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }
}