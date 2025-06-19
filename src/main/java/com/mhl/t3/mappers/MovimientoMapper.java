package com.mhl.t3.mappers;

import com.mhl.t3.DTOs.MovimientoResponseTDO;
import com.mhl.t3.DTOs.MovimientoRequestDTO;
import com.mhl.t3.Models.Movimiento;
import com.mhl.t3.Models.Producto;

public class MovimientoMapper {
    public static Movimiento toEntity(MovimientoRequestDTO dto, Producto producto) {
        Movimiento movimiento = new Movimiento();
        movimiento.setProducto(producto);
        movimiento.setCantidad(dto.getCantidad());
        movimiento.setTipoMovimiento(dto.getTipoMovimiento());
        // fechaMovimiento será asignada automáticamente por la BD
        return movimiento;
    }

    public static MovimientoResponseTDO toDTO(Movimiento movimiento)
    {
        MovimientoResponseTDO dto = new MovimientoResponseTDO();
        dto.setMovimientoID(movimiento.getMovimientoID());
        dto.setProductoID(movimiento.getProducto().getIdProducto());
        dto.setNombreProducto(movimiento.getProducto().getNombreProducto());
        dto.setCantidad(movimiento.getCantidad());
        dto.setTipoMovimiento(movimiento.getTipoMovimiento().name());
        dto.setFechaMovimiento(movimiento.getFechaMovimiento());
        return dto;
    }
}
