package com.estagio.ApiLivraria;

import com.estagio.ApiLivraria.Service.LivroService;
import com.estagio.ApiLivraria.model.entity.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

@SpringBootTest

class ApiLivrariaApplicationTests {
	@Autowired
    private LivroService livroService;

	private Livro LIVRO_TEST = new Livro();


    @Test
	void testcreate(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("1234567890");
		livro.setAno(2021);
		ResponseEntity<Livro> criar = livroService.criar(livro);
		Livro body = criar.getBody();
        assert body != null;
        ResponseEntity<Livro> buscar = livroService.buscar(body.getId());
		Assertions.assertEquals(Objects.requireNonNull(buscar.getBody()).getTitulo(), livro.getTitulo());

	}

	@Test
	void testlistar(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("1234567890");
		livro.setAno(2021);
		livroService.criar(livro);
		List<Livro> list = livroService.listar();
		Assertions.assertEquals(1, list.size());
	}

	@Test
	void testbuscar(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("1234567890");
		livro.setAno(2021);
		livroService.criar(livro);
		ResponseEntity<Livro> buscar = livroService.buscar(livro.getId());
		Assertions.assertEquals(Objects.requireNonNull(buscar.getBody()).getIsbn(), livro.getIsbn());
	}

	@Test
	void testeditar(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("1234567890");
		livro.setAno(2021);
		ResponseEntity<Livro> criar = livroService.criar(livro);
		LIVRO_TEST.setTitulo("Livro 2");
		LIVRO_TEST.setAutor("Joao");
		LIVRO_TEST.setIsbn("1234567890");
		LIVRO_TEST.setAno(2005);
		livroService.editar(Objects.requireNonNull(criar.getBody()).getId(), LIVRO_TEST);

		ResponseEntity<Livro> buscar = livroService.buscar(criar.getBody().getId());
		Assertions.assertEquals(Objects.requireNonNull(buscar.getBody()).getTitulo(), LIVRO_TEST.getTitulo());
	}

	@Test
	void testexcluir(){
		Livro livro = new Livro();
		livro.setTitulo("Livro 1");
		livro.setAutor("Joao");
		livro.setIsbn("1234567890");
		livro.setAno(2021);
		ResponseEntity<Livro> criar = livroService.criar(livro);
		livroService.excluir(criar.getBody().getId());
		ResponseEntity<Livro> buscar = livroService.buscar(criar.getBody().getId());
        Assertions.assertNull(buscar.getBody());

		//git branch -M main
	}

}
