// src/main/java/com/utp/Grupo5/service/TareaService.java
package com.utp.Grupo5.service;

import com.utp.Grupo5.entity.Tarea;
import com.utp.Grupo5.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea actualizarTarea(Long id, Tarea datosNuevos) {
        Optional<Tarea> optional = tareaRepository.findById(id);
        if (optional.isPresent()) {
            Tarea tarea = optional.get();
            tarea.setTitulo(datosNuevos.getTitulo());
            tarea.setDescripcion(datosNuevos.getDescripcion());
            tarea.setCurso(datosNuevos.getCurso());
            tarea.setEstado(datosNuevos.getEstado());
            tarea.setPrioridad(datosNuevos.getPrioridad());
            tarea.setFechaVencimiento(datosNuevos.getFechaVencimiento());
            return tareaRepository.save(tarea);
        }
        return null;
    }

    public boolean eliminarTarea(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}