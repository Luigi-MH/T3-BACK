package com.mhl.t3.DTOs;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductoResponseDTO {
    private Integer idProducto;
    private String nombrePrducto;
    private int stockActual;
    private int stockMinimo;
    private LocalDateTime fechaActualizacion;
}
