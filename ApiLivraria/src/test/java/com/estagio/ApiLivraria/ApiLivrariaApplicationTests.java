package com.estagio.ApiLivraria;

import com.estagio.ApiLivraria.Service.LivroService;
import com.estagio.ApiLivraria.model.entity.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@SpringBootTest

class ApiLivrariaApplicationTests {
	@Autowired
    private LivroService livroService;

	private Livro LIVRO_TEST = new Livro();


    @Test
	void testCreate(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("12345678904221");
		livro.setAno(2021);
		ResponseEntity<Livro> criar = livroService.criar(livro);
		Livro body = criar.getBody();
        assert body != null;
        ResponseEntity<Livro> buscar = livroService.buscar(body.getId());
		Assertions.assertEquals(Objects.requireNonNull(buscar.getBody()).getTitulo(), livro.getTitulo());

	}

	@Test
	void testListar(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("1234567890874");
		livro.setAno(2021);
		livroService.criar(livro);
		List<Livro> list = livroService.listar();
        Assertions.assertFalse(list.isEmpty());
	}

	@Test
	void testBuscar(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("123456789078");
		livro.setAno(2021);
		livroService.criar(livro);
		ResponseEntity<Livro> buscar = livroService.buscar(livro.getId());
		Assertions.assertEquals(Objects.requireNonNull(buscar.getBody()).getIsbn(), livro.getIsbn());
	}

	@Test
	void testEditar(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("123456789065");
		livro.setAno(2021);
		ResponseEntity<Livro> criar = livroService.criar(livro);
		LIVRO_TEST.setTitulo("Livro 2");
		LIVRO_TEST.setAutor("Joao");
		LIVRO_TEST.setIsbn("123456789045");
		LIVRO_TEST.setAno(2005);
		livroService.editar(Objects.requireNonNull(criar.getBody()).getId(), LIVRO_TEST);

		ResponseEntity<Livro> buscar = livroService.buscar(criar.getBody().getId());
		Assertions.assertEquals(Objects.requireNonNull(buscar.getBody()).getTitulo(), LIVRO_TEST.getTitulo());
	}

	@Test
	void testExcluir(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("12345678903");
		livro.setAno(2021);
		ResponseEntity<Livro> criar = livroService.criar(livro);
		ResponseEntity<Void> excluir = livroService.excluir(criar.getBody().getId());
		Assertions.assertEquals(HttpStatus.NO_CONTENT, excluir.getStatusCode());


	}

}
