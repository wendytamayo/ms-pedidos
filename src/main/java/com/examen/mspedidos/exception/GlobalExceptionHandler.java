package com.examen.mspedidos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse manejarNoEncontrado(RecursoNoEncontradoException ex) {
        return new ErrorResponse(
                "Pedido no encontrado",
                ex.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse manejarValidaciones(MethodArgumentNotValidException ex) {
        String detalle = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getDefaultMessage())
                .orElse("Datos inválidos");

        return new ErrorResponse(
                "Datos inválidos",
                detalle,
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse manejarErrorGeneral(Exception ex) {
        return new ErrorResponse(
                "Error interno",
                ex.getMessage(),
                LocalDateTime.now()
        );
    }
}