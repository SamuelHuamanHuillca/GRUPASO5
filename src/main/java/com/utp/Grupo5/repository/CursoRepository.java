// src/main/java/com/utp/Grupo5/repository/CursoRepository.java
package com.utp.Grupo5.repository;

import com.utp.Grupo5.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
}