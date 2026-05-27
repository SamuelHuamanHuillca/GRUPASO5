// src/main/java/com/utp/Grupo5/controller/PedidoController.java
package com.utp.Grupo5.controller;

import com.utp.Grupo5.entity.Pedido;
import com.utp.Grupo5.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
@Tag(name = "Pedidos", description = "API pedidos cafetería UTP")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Operation(summary = "Registrar un nuevo pedido")
    public ResponseEntity<Pedido> registrarPedido(@RequestBody Pedido pedido) {
        Pedido nuevo = pedidoService.registrarPedido(pedido);
        if (nuevo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(nuevo);
    }
}