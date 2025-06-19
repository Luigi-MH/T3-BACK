package com.mhl.t3.Models;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Producto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductoID")
    private Integer idProducto;

    @Column(name = "NombreProducto", length = 100, nullable = false)
    private String nombreProducto;

    @Column(name = "StockActual", nullable = false)
    private int stockActual;

    @Column(name = "StockMinimo", nullable = false)
    private int stockMinimo;

    @Column(name = "FechaActualizacion", insertable = false, updatable = false)
    private LocalDateTime fechaActualizacion;
}
