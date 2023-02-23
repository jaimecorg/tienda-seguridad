package com.jaimecorg.springprojects.tienda.services;

import java.util.Date;
import java.util.List;

import com.jaimecorg.springprojects.tienda.model.Nota;

public interface NotasService {

    public List<Nota> findAll();
    public Nota findByID(int id);
    public Nota insert(Nota nota);
    public void update(Nota nota);
    public void delete(int id);
    public List<Nota> findByTituloYFecha(String titulo, Date fecha);

}
