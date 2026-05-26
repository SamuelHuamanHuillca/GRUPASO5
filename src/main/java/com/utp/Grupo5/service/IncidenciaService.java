// src/main/java/com/utp/Grupo5/service/IncidenciaService.java
package com.utp.Grupo5.service;

import com.utp.Grupo5.entity.Incidencia;
import com.utp.Grupo5.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    // Obtener todas las incidencias
    public List<Incidencia> listarIncidencias() {
        return incidenciaRepository.findAll();
    }

    // Insertar nueva incidencia
    public Incidencia guardarIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    // Actualizar incidencia existente (solo estado y descripcion)
    public Incidencia actualizarIncidencia(Long id, Incidencia datosNuevos) {
        Optional<Incidencia> optional = incidenciaRepository.findById(id);
        if (optional.isPresent()) {
            Incidencia incidencia = optional.get();
            incidencia.setTitulo(datosNuevos.getTitulo());
            incidencia.setDescripcion(datosNuevos.getDescripcion());
            incidencia.setEstado(datosNuevos.getEstado());
            return incidenciaRepository.save(incidencia);
        }
        return null; // el controller maneja el 404
    }
}