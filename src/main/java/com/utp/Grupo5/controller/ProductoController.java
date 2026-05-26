// src/main/java/com/utp/Grupo5/controller/ProductoController.java
package com.utp.Grupo5.controller;

import com.utp.Grupo5.entity.Producto;
import com.utp.Grupo5.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "API para gestión de productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // GET /api/productos
    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    // POST /api/productos
    @PostMapping
    @Operation(summary = "Insertar un nuevo producto")
    public ResponseEntity<Producto> guardarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.guardarProducto(producto));
    }
}