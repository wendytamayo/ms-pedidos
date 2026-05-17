package com.examen.mspedidos.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoPedidoRequest {

    @NotBlank(message = "El estado es obligatorio")
    private String estado;
}