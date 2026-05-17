package com.examen.mspedidos.service;

import com.examen.mspedidos.dto.EstadoPedidoRequest;
import com.examen.mspedidos.dto.PedidoRequest;
import com.examen.mspedidos.entity.Pedido;
import com.examen.mspedidos.exception.RecursoNoEncontradoException;
import com.examen.mspedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public Pedido crearPedido(PedidoRequest request) {
        BigDecimal total = request.getPrecioUnitario()
                .multiply(BigDecimal.valueOf(request.getCantidad()));

        Pedido pedido = Pedido.builder()
                .cliente(request.getCliente())
                .correoCliente(request.getCorreoCliente())
                .productoId(request.getProductoId())
                .nombreProducto(request.getNombreProducto())
                .cantidad(request.getCantidad())
                .precioUnitario(request.getPrecioUnitario())
                .total(total)
                .estado("REGISTRADO")
                .fechaPedido(LocalDateTime.now())
                .build();

        return pedidoRepository.save(pedido);
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Pedido no encontrado con ID: " + id));
    }

    public Pedido actualizarEstado(Long id, EstadoPedidoRequest request) {
        Pedido pedido = buscarPorId(id);
        pedido.setEstado(request.getEstado());
        return pedidoRepository.save(pedido);
    }

    public void eliminarPedido(Long id) {
        Pedido pedido = buscarPorId(id);
        pedido.setEstado("CANCELADO");
        pedidoRepository.save(pedido);
    }
}