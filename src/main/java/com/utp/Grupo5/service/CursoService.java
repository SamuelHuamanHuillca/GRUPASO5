// src/main/java/com/utp/Grupo5/service/CursoService.java
package com.utp.Grupo5.service;

import com.utp.Grupo5.entity.Curso;
import com.utp.Grupo5.entity.Matriculado;
import com.utp.Grupo5.repository.CursoRepository;
import com.utp.Grupo5.repository.MatriculadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private MatriculadoRepository matriculadoRepository;

    // Obtener todos los cursos
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    // Insertar matriculado en un curso
    public Matriculado matricularAlumno(Long cursoId, Matriculado matriculado) {
        Optional<Curso> optional = cursoRepository.findById(cursoId);
        if (optional.isPresent()) {
            matriculado.setCurso(optional.get());
            return matriculadoRepository.save(matriculado);
        }
        return null; // el controller maneja el 404
    }
}