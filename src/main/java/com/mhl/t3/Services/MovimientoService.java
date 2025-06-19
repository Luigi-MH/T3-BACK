package com.mhl.t3.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mhl.t3.Models.Movimiento;
import com.mhl.t3.Repositories.MovimientoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoService {

    private final MovimientoRepository movimientoRepository;

    //CREATE 

    //READ
    public List<Movimiento> findAllMovimientos()
    {
        return movimientoRepository.findAll();
    }
}
