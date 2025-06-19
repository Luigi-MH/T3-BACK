package com.mhl.t3.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.t3.Services.ProductoService;
import com.mhl.t3.response.JSendResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mhl/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    //CREATE

    //READ
    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(JSendResponse.success(productoService.findAllProducts()));
    }

    
}
