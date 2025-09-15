package com.estagio.ApiLivraria.execptionsController.handler;

import com.estagio.ApiLivraria.execptionsController.execptions.LivroNotFoundExecption;
import com.estagio.ApiLivraria.model.dto.ResponseError;
import com.estagio.ApiLivraria.model.entity.Livro;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExecptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(LivroNotFoundExecption.class)
    public ResponseError LivroNotFoundExecptionHandler(LivroNotFoundExecption Error) {
        return new ResponseError(Error.getMessage(), LocalDateTime.now(),404);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public ResponseError GenericExecptionHandler(RuntimeException Error) {
        return new ResponseError(Error.getMessage(), LocalDateTime.now(),404);
    }
}
