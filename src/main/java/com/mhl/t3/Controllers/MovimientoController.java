package com.mhl.t3.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.t3.DTOs.MovimientoRequestDTO;
import com.mhl.t3.Services.MovimientoService;
import com.mhl.t3.response.JSendResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mhl/movimiento")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    //CREATE
    @PostMapping
    public ResponseEntity<?> create (@RequestBody MovimientoRequestDTO movimientoRequest)
    {
        return ResponseEntity.ok(JSendResponse.success(movimientoService.createMI(movimientoRequest)));
    }

    //READ
    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(JSendResponse.success(movimientoService.findAllMovimientos()));
    }

    //READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllMIById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(JSendResponse.success(movimientoService.findAllMIById(id)));
    }
}
