package com.mhl.t3.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MovimientoInventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MovimientoID")
    private Integer movimientoID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ProductoID", nullable = false)
    private Producto producto;

    @Column(name = "Cantidad", nullable = false)
    private int cantidad;

    @Enumerated(EnumType.STRING)
    @Column(name = "TipoMovimiento", nullable = false, columnDefinition = "ENUM('Entrada','Salida')")
    private TipoMovimiento tipoMovimiento;

    @Column(name = "FechaMovimiento", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP",  insertable = false, updatable = false)
    private LocalDateTime fechaMovimiento;

    public enum TipoMovimiento {
        Entrada,
        Salida
    }
}
