// src/main/java/com/utp/Grupo5/repository/PedidoRepository.java
package com.utp.Grupo5.repository;

import com.utp.Grupo5.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}