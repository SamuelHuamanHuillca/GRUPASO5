// src/main/java/com/utp/Grupo5/repository/MatriculadoRepository.java
package com.utp.Grupo5.repository;

import com.utp.Grupo5.entity.Matriculado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculadoRepository extends JpaRepository<Matriculado, Long> {
}