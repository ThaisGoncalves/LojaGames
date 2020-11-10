package com.supergames.loja_games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supergames.loja_games.model.Categoria;
import com.supergames.loja_games.model.Produtos;
import com.supergames.loja_games.repository.ProdutosRepository;

@RestController
@RequestMapping("/games")
@CrossOrigin("*")

public class ProdutosController {
	@Autowired
	private ProdutosRepository repositoryProd;

	@GetMapping
	public ResponseEntity<List<Produtos>> GetAll() {
		return ResponseEntity.ok(repositoryProd.findAll());
	}
	
	@GetMapping ("/id")
	public ResponseEntity<Produtos> GetById(@PathVariable Integer id){
		return repositoryProd.findById(id)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
}