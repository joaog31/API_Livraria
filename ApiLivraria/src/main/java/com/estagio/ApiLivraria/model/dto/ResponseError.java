package com.estagio.ApiLivraria.model.dto;

import com.estagio.ApiLivraria.model.entity.Livro;

import java.time.LocalDateTime;

public record ResponseError(String message, LocalDateTime timestamp, Integer statusCode) {
}
