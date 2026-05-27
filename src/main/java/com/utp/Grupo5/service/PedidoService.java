// src/main/java/com/utp/Grupo5/service/PedidoService.java
package com.utp.Grupo5.service;

import com.utp.Grupo5.entity.Pedido;
import com.utp.Grupo5.entity.Producto;
import com.utp.Grupo5.repository.PedidoRepository;
import com.utp.Grupo5.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public Pedido registrarPedido(Pedido pedido) {
        // Validar que el producto existe
        Optional<Producto> producto = productoRepository.findById(
                pedido.getProducto().getId()
        );
        if (producto.isEmpty()) return null;
        pedido.setProducto(producto.get());
        return pedidoRepository.save(pedido);
    }
}