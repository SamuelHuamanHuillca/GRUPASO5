// src/main/java/com/utp/Grupo5/service/MatriculaService.java
package com.utp.Grupo5.service;

import com.utp.Grupo5.entity.Curso;
import com.utp.Grupo5.entity.Matricula;
import com.utp.Grupo5.repository.CursoRepository;
import com.utp.Grupo5.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Matricula registrarMatricula(Matricula matricula) {
        Optional<Curso> curso = cursoRepository.findById(
                matricula.getCurso().getId()
        );
        if (curso.isEmpty()) return null;
        matricula.setCurso(curso.get());
        return matriculaRepository.save(matricula);
    }
}