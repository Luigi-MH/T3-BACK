package com.mhl.t3.DTOs;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MovimientoResponseTDO {
    private Integer movimientoID;
    private Integer productoID;
    private String nombreProducto;
    private int cantidad;
    private String tipoMovimiento;
    private LocalDateTime fechaMovimiento;
}
