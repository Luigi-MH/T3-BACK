package com.mhl.t3.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mhl.t3.Models.Producto;
import com.mhl.t3.Repositories.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService{

    private final ProductoRepository productoRepository;

    //CREATE


    //READ
    public List<Producto> findAllProducts()
    {
        return productoRepository.findAll();
    }

}
