package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jaimecorg.springprojects.tienda.model.Nota;
import com.jaimecorg.springprojects.tienda.services.NotasService;

@Service
public class NotasServiceImpl implements NotasService{

    @Value("${url.nota.rest.service}")
    String urlNota;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Nota> findAll() {
        
        Nota[] ca = restTemplate.getForObject(urlNota + "notas", Nota[].class);
        List<Nota> notas = Arrays.asList(ca);

        return notas;
    }

    @Override
    public Nota findByID(int id) {
        Nota ca = restTemplate.getForObject(urlNota + "notas/" + id, Nota.class);

        return ca;
    }

    @Override
    public Nota insert(Nota nota) {
        Nota ca = restTemplate.postForObject(urlNota + "notas", nota, Nota.class);

        return ca;
    }

    @Override
    public void update(Nota nota) {
        restTemplate.put(urlNota + "notas/" + nota.getId(), nota);
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(urlNota + "notas/" + id);
    }

    @Override
    public List<Nota> findByTituloYFecha(String titulo, Date fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByTituloYFecha'");
    }
}
