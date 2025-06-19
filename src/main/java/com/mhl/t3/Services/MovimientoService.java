package com.mhl.t3.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mhl.t3.DTOs.MovimientoRequestDTO;
import com.mhl.t3.DTOs.MovimientoResponseTDO;
import com.mhl.t3.Models.Movimiento;
import com.mhl.t3.Models.Producto;
import com.mhl.t3.Repositories.MovimientoRepository;
import com.mhl.t3.Repositories.ProductoRepository;
import com.mhl.t3.mappers.MovimientoMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;
    private final ProductoRepository productoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    //CREATE
    @Transactional
    public Optional<MovimientoResponseTDO> createMI(MovimientoRequestDTO dataMI) {
        try {
            Producto prod = productoRepository.findById(dataMI.getProductoID())
                .orElseThrow(() -> new NoSuchElementException("Producto con ID " + dataMI.getProductoID() + " no encontrado"));

            // Validar stock solo si es salida
            if (dataMI.getTipoMovimiento() == Movimiento.TipoMovimiento.Salida) {
                if (dataMI.getCantidad() > prod.getStockActual()) {
                    return Optional.empty(); // stock insuficiente
                }
                prod.setStockActual(prod.getStockActual() - dataMI.getCantidad());
            } else {
                // Entrada
                prod.setStockActual(prod.getStockActual() + dataMI.getCantidad());
            }

            prod.setFechaActualizacion(LocalDateTime.now());
            productoRepository.save(prod); // guardar el nuevo stock

            Movimiento nuevomMovimiento = MovimientoMapper.toEntity(dataMI, prod);
            Movimiento movimientoGuardado = movimientoRepository.save(nuevomMovimiento);

            MovimientoResponseTDO movimientoResponse = MovimientoMapper.toDTO(movimientoGuardado);
            return Optional.of(movimientoResponse);

        }
        catch (Exception e) {
            return Optional.empty();
        }
    }

    //READ
    public List<Movimiento> findAllMovimientos()
    {
        return movimientoRepository.findAll();
    }

    //READ BY ID
    public List<Movimiento> findAllMIById(Integer idProducto) {
        return entityManager.createQuery(
            "SELECT m FROM Movimiento m WHERE m.producto.idProducto = :idProducto",
            Movimiento.class)
        .setParameter("idProducto", idProducto)
        .getResultList();
    }

    
}
