package com.examen.mspedidos.controller;

import com.examen.mspedidos.dto.EstadoPedidoRequest;
import com.examen.mspedidos.dto.PedidoRequest;
import com.examen.mspedidos.entity.Pedido;
import com.examen.mspedidos.service.PedidoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public Pedido crearPedido(@Valid @RequestBody PedidoRequest request) {
        return pedidoService.crearPedido(request);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @PatchMapping("/{id}/estado")
    public Pedido actualizarEstado(
            @PathVariable Long id,
            @Valid @RequestBody EstadoPedidoRequest request
    ) {
        return pedidoService.actualizarEstado(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
    }
}