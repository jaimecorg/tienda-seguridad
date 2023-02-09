package com.jaimecorg.springprojects.tienda.dao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.jaimecorg.springprojects.tienda.model.Producto;

public interface ProductosDAO {

    public Page<Producto> findAll(Pageable page);
    public Producto findByID(int codigo);
    public void insert(Producto producto);
    public void update(Producto producto);
    public void delete(int codigo);
    public void updateImg(Producto producto);
}
