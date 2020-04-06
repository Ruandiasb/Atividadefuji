package com.rodrigofujioka.dev.web.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofujioka.dev.web.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    //listar da tabela o nome dos produtos e a marca
	List<Produto> findProdutoByNomeAndMarca(String nome, String marca);
	//listar nome do produto e codigo de barras
	List<Produto> findProdutoByNomeAndDataVencimento(String nome, LocalDate dataVencimento);
	//listar o nome e codigo
	List<Produto> findProdutoByNomeAndCodigoBarras(String nome, String codigoBarras);
}
