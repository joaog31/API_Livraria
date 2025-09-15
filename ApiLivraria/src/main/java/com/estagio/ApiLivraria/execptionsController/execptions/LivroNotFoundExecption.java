package com.estagio.ApiLivraria.execptionsController.execptions;

public class LivroNotFoundExecption extends RuntimeException {
    public LivroNotFoundExecption(String message) {
        super(message);
    }
}
