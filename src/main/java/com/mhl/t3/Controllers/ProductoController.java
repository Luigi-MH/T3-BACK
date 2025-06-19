package com.mhl.t3.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.t3.DTOs.ProductoRequestDTO;
import com.mhl.t3.DTOs.ProductoResponseDTO;
import com.mhl.t3.Models.Producto;
import com.mhl.t3.Services.ProductoService;
import com.mhl.t3.mappers.ProductoMapper;
import com.mhl.t3.response.JSendResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mhl/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    //CREATE
    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductoRequestDTO productoResquet)
    {
        Producto productoNuevo = ProductoMapper.toEntity(productoResquet);
        Producto productoGuardado = productoService.createProduct(productoNuevo);
        ProductoResponseDTO productoResponse = ProductoMapper.toDTO(productoGuardado);
        return ResponseEntity.ok(JSendResponse.success(productoResponse));
    }

    //READ
    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(JSendResponse.success(productoService.findAllProducts()));
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity <?> upadate(@RequestBody ProductoRequestDTO producto, @PathVariable Integer id)
    {
        Producto nuevosdatos = ProductoMapper.toEntity(producto);
        Producto productoActualizado = productoService.updateProducto(nuevosdatos, id);
        ProductoResponseDTO productoActualizadoResponse = ProductoMapper.toDTO(productoActualizado);
        return ResponseEntity.ok(JSendResponse.success(productoActualizadoResponse));
    }

    //DELTE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id)
    {
        productoService.deleteProducto(id);
        return ResponseEntity.ok(JSendResponse.success("Eliminado"));
    }

    //READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(JSendResponse.success(productoService.findByIdProduct(id)));
    }

}
