package com.mhl.t3.mappers;

import com.mhl.t3.DTOs.ProductoRequestDTO;
import com.mhl.t3.DTOs.ProductoResponseDTO;
import com.mhl.t3.Models.Producto;

public class ProductoMapper {

    // Convierte de DTO a Entidad
    public static Producto toEntity(ProductoRequestDTO dto) {
        Producto p = new Producto();
        p.setNombreProducto(dto.getNombreProducto());
        p.setStockActual(dto.getStockActual());
        p.setStockMinimo(dto.getStockMinimo());
        return p;
    }

    // Convierte de Entidad a DTO de respuesta
    public static ProductoResponseDTO toDTO(Producto p) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setIdProducto(p.getIdProducto());
        dto.setNombrePrducto(p.getNombreProducto());
        dto.setStockActual(p.getStockActual());
        dto.setStockMinimo(p.getStockMinimo());
        dto.setFechaActualizacion(p.getFechaActualizacion());
        return dto;
    }
}
