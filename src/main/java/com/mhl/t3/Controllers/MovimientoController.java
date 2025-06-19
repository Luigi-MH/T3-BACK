package com.mhl.t3.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhl.t3.Services.MovimientoService;
import com.mhl.t3.response.JSendResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mhl/movimiento")
@RequiredArgsConstructor
public class MovimientoController {

    private final MovimientoService movimientoService;

    //CREATE

    //READ
    @GetMapping
    public ResponseEntity<?> getAll()
    {
        return ResponseEntity.ok(JSendResponse.success(movimientoService.findAllMovimientos()));
    }
}
