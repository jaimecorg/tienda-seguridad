package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import com.jaimecorg.springprojects.tienda.model.Contacto;
import com.jaimecorg.springprojects.tienda.services.ContactosService;

public class ContactosServiceImpl implements ContactosService{
    
    @Value("${url.agenda.rest.service}")
    String urlAgenda;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Contacto> findAll() {
        
        Contacto[] ca = restTemplate.getForObject(urlAgenda + "contactos", Contacto[].class);
        List<Contacto> contactos  =Arrays.asList(ca);

        return contactos;
    }

    @Override
    public Contacto findByID(int id) {
        Contacto contacto = restTemplate.getForObject(urlAgenda + "contactos/{id}", Contacto.class, id);
        return contacto;
    }

    @Override
    public void insert(Contacto contacto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void update(Contacto contacto) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(int id) {
        restTemplate.delete(urlAgenda + "contactos/{id}", id);
        
    }
    
}
