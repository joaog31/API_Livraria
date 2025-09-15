package com.estagio.ApiLivraria.controllers;

import com.estagio.ApiLivraria.Service.LivroService;
import com.estagio.ApiLivraria.model.entity.Livro;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/livros")

public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        return livroService.criar(livro);
    }

    @GetMapping
    public List<Livro> listarLivros() {
        return livroService.listar();
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> buscar(@PathVariable Long id) {
        return livroService.buscar(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        return livroService.editar(id, livro);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return livroService.excluir(id);
    }
}
