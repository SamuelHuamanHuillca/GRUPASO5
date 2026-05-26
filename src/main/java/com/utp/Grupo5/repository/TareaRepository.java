// src/main/java/com/utp/Grupo5/repository/TareaRepository.java
package com.utp.Grupo5.repository;

import com.utp.Grupo5.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
}