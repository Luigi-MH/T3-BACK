package com.mhl.t3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mhl.t3.Models.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
