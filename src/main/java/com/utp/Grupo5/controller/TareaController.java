// src/main/java/com/utp/Grupo5/controller/TareaController.java
package com.utp.Grupo5.controller;

import com.utp.Grupo5.entity.Tarea;
import com.utp.Grupo5.service.TareaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@Tag(name = "Tareas", description = "API para control de tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // GET /api/tareas
    @GetMapping
    @Operation(summary = "Obtener todas las tareas")
    public ResponseEntity<List<Tarea>> listarTareas() {
        return ResponseEntity.ok(tareaService.listarTareas());
    }

    // POST /api/tareas
    @PostMapping
    @Operation(summary = "Registrar una nueva tarea")
    public ResponseEntity<Tarea> guardarTarea(@RequestBody Tarea tarea) {
        return ResponseEntity.ok(tareaService.guardarTarea(tarea));
    }

    // PUT /api/tareas/{id}
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una tarea existente")
    public ResponseEntity<Tarea> actualizarTarea(
            @PathVariable Long id,
            @RequestBody Tarea tarea) {
        Tarea actualizada = tareaService.actualizarTarea(id, tarea);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    // DELETE /api/tareas/{id}
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        if (tareaService.eliminarTarea(id)) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.notFound().build(); // 404
    }
}