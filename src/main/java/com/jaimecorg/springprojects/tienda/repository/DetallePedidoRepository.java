package com.jaimecorg.springprojects.tienda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaimecorg.springprojects.tienda.model.DetallePedido;
import com.jaimecorg.springprojects.tienda.model.DetallePedidoKey;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, DetallePedidoKey>{
    
    public void deleteByPedidoCodigo(int codigo_pedido);
    public List<DetallePedido> findByPedidoCodigo(int codigo_pedido);

}
