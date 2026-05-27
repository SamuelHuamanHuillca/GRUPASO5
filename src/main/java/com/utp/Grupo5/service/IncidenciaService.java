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

    public List<Incidencia> listarIncidencias() {
        return incidenciaRepository.findAll();
    }

    public Incidencia guardarIncidencia(Incidencia incidencia) {
        incidencia.setEstado("PENDIENTE"); // estado inicial siempre
        return incidenciaRepository.save(incidencia);
    }

    // Solo actualiza el estado — PUT /api/incidencias/{id}/estado
    public Incidencia actualizarEstado(Long id, String nuevoEstado) {
        Optional<Incidencia> optional = incidenciaRepository.findById(id);
        if (optional.isPresent()) {
            Incidencia incidencia = optional.get();
            incidencia.setEstado(nuevoEstado);
            return incidenciaRepository.save(incidencia);
        }
        return null;
    }
}