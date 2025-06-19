package com.mhl.t3.DTOs;

import com.mhl.t3.Models.Movimiento.TipoMovimiento;

import lombok.Data;

@Data
public class MovimientoRequestDTO {
    private Integer productoID;
    private int cantidad;
    private TipoMovimiento tipoMovimiento;
}
