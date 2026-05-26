// src/main/java/com/utp/Grupo5/repository/IncidenciaRepository.java
package com.utp.Grupo5.repository;

import com.utp.Grupo5.entity.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
}