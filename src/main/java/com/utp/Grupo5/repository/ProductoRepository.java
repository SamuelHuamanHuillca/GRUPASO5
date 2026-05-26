// src/main/java/com/utp/Grupo5/repository/ProductoRepository.java
package com.utp.Grupo5.repository;

import com.utp.Grupo5.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}