// src/main/java/com/utp/Grupo5/repository/MatriculaRepository.java
package com.utp.Grupo5.repository;

import com.utp.Grupo5.entity.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}