package com.estagio.ApiLivraria.Service;

import com.estagio.ApiLivraria.execptionsController.execptions.LivroNotFoundExecption;
import com.estagio.ApiLivraria.model.entity.Livro;
import com.estagio.ApiLivraria.model.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public ResponseEntity<Livro> criar(Livro livro) {
        Livro save = livroRepository.save(livro);
        return ResponseEntity.status(201).body(save);
    }

    public List<Livro> listar() {
        return livroRepository.findAll();
    }

    public ResponseEntity<Livro> buscar(Long id) {
        Optional<Livro> byId = livroRepository.findById(id);
        if (byId.isPresent()) {
            return ResponseEntity.status(200).body(byId.get());
        }
        throw new LivroNotFoundExecption("Livro Não Encontrado");
    }

    public ResponseEntity<Livro> editar(Long id, Livro livro) {
        Optional<Livro> byId = livroRepository.findById(id);
        if (byId.isPresent()) {
            byId.get().setTitulo(livro.getTitulo());
            byId.get().setAutor(livro.getAutor());
            byId.get().setIsbn(livro.getIsbn());
            byId.get().setAnoDePublicacao(livro.getAnoDePublicacao());
            livroRepository.save(byId.get());
            return ResponseEntity.status(200).body(byId.get());
        }
        throw new LivroNotFoundExecption("Livro Não Encontrado");
    }

    public ResponseEntity<Void> excluir(Long id) {
        Optional<Livro> byId = livroRepository.findById(id);
        if (byId.isPresent()) {
            livroRepository.delete(byId.get());
            return ResponseEntity.status(204).build();
        }
        throw new LivroNotFoundExecption("Livro Não Encontrado");
    }
}
