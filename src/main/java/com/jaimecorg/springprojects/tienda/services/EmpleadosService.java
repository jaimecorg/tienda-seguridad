package com.jaimecorg.springprojects.tienda.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.springprojects.tienda.model.Empleado;

public interface EmpleadosService {
    public Page<Empleado> findAll(Pageable page);

    public List<Empleado> findAll();

    public Empleado findByID(int codigo);

    public void insert(Empleado empleado);

    public void update(Empleado empleado);

    public void delete(int codigo);
}
