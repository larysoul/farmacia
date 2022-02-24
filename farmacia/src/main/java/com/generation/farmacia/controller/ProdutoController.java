package com.generation.farmacia.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.farmacia.model.Produto;
import com.generation.farmacia.repository.CategoriaRepository;
import com.generation.farmacia.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto) {
		return categoriaRepository.findById(produto.getCategoria().getId()).map(resposta -> {
			return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
		}).orElse(ResponseEntity.badRequest().build());
	}

	@PutMapping
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {
		return produtoRepository.findById(produto.getId()).map(resposta -> {
			return ResponseEntity.ok().body(produtoRepository.save(produto));
		}).orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduto(@PathVariable Long id) {
		return produtoRepository.findById(id).map(resposta -> {
			produtoRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/lab/{nome}/{laboratorio}")
	public ResponseEntity<List<Produto>> findByNomeLaboratorioProduto(@PathVariable String nome,
			@PathVariable String laboratorio) {
		return ResponseEntity.ok(produtoRepository
				.findAllByNomeContainingIgnoreCaseAndLaboratorioContainingIgnoreCase(nome, laboratorio));
	}

	@GetMapping("/entre/{menor}/{maior}")
	public ResponseEntity<List<Produto>> findByEntre(@PathVariable BigDecimal menor, @PathVariable BigDecimal maior) {
		return ResponseEntity.ok(produtoRepository.findAllByPrecoBetweenOrderByPreco(menor, maior));
	}
}
