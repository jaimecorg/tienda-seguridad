package com.jaimecorg.springprojects.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.Proveedor;

public interface ProveedorRepository  extends JpaRepository<Proveedor, Integer>{
    
}
