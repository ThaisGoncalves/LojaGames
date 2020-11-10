package com.supergames.loja_games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supergames.loja_games.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
	public List<Produtos> findAllByNomeJogoContainingIgnoreCase(String nomeJogo);
}
