// src/main/java/com/utp/Grupo5/service/CursoService.java
package com.utp.Grupo5.service;

import com.utp.Grupo5.entity.Curso;
import com.utp.Grupo5.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }
}