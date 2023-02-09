package com.jaimecorg.springprojects.tienda.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaimecorg.springprojects.tienda.model.Cliente;
import com.jaimecorg.springprojects.tienda.repository.ClienteRepository;
import com.jaimecorg.springprojects.tienda.services.ClientesService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    ClienteRepository repository;

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Cliente findByID(int codigo) {
        Optional<Cliente> findById = repository.findById(codigo);
        if(findById != null){
            return findById.get();
        }
        return null;
    }

    @Override
    public void insert(Cliente cliente) {
        repository.save(cliente);   
    }

    @Override
    public void update(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void delete(int codigo) {
        repository.deleteById(codigo);
    }

    /* CON DAO

    @Autowired
    ClientesDAO clientesDAO;

    @Override
    public Page<Cliente> findAll(Pageable page) {
        return clientesDAO.findAll(page);
    }

    @Override
    public Cliente findByID(int codigo){
        return clientesDAO.findByID(codigo);
    }

    @Override
    public void insert(Cliente cliente){
        clientesDAO.insert(cliente);
    }

    @Override
    public void update(Cliente cliente){
        clientesDAO.update(cliente);
    }

    @Override
    public void delete(int codigo){
        clientesDAO.delete(codigo);
    }
    */
}
