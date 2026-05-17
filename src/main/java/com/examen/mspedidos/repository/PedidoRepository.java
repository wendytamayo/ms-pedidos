package com.examen.mspedidos.repository;

import com.examen.mspedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
