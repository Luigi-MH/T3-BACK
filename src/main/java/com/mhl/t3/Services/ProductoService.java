package com.mhl.t3.Services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mhl.t3.DTOs.ProductoResponseDTO;
import com.mhl.t3.Models.Producto;
import com.mhl.t3.Repositories.ProductoRepository;
import com.mhl.t3.mappers.ProductoMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService{

    @PersistenceContext
    private EntityManager entityManager;

    private final ProductoRepository productoRepository;

    //CREATE
    public Producto createProduct(Producto producto)
    {
        return productoRepository.save(producto);
    }

    //READ
    public List<Producto> findAllProducts()
    {
        return productoRepository.findAll();
    }

    //UPDATE
    public Producto updateProducto(Producto dataProducto, Integer idProducto)
    {
        Producto datos = productoRepository.findById(idProducto)
            .orElseThrow(() -> new NoSuchElementException("Producto con id " + idProducto + " not found"));
        datos.setNombreProducto(dataProducto.getNombreProducto());
        datos.setStockActual(dataProducto.getStockActual());
        datos.setStockMinimo(dataProducto.getStockMinimo());
        datos.setFechaActualizacion(dataProducto.getFechaActualizacion());
        Producto productoActualizado = productoRepository.save(datos);
        return productoActualizado;
    }

    //DELETE
    @Transactional
    public void deleteProducto(Integer idProducto)
    {
        entityManager.createQuery("DELETE FROM Movimiento m WHERE m.producto.idProducto = :idProducto")
                 .setParameter("idProducto", idProducto)
                 .executeUpdate(); 

    productoRepository.deleteById(idProducto);
    }

    //READ BY ID
    public Optional<ProductoResponseDTO> findByIdProduct(Integer idProducto)
    {
        try {
            Producto producto = entityManager.createQuery("SELECT p FROM Producto p WHERE p.idProducto = :idProducto", Producto.class)
                                                        .setParameter("idProducto", idProducto)
                                                        .getSingleResult();
            return Optional.of(ProductoMapper.toDTO(producto));
        } catch (NoResultException exception) {
            return Optional.empty();
        }
    }
}
