package com.examen.mspedidos.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorResponse {

    private String mensaje;
    private String detalle;
    private LocalDateTime fecha;
}