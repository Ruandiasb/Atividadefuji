package com.rodrigofujioka.dev.web.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Produto;
import com.rodrigofujioka.dev.web.repository.ProdutoRepository;
import com.rodrigofujioka.dev.web.service.dto.ProdutoDTO;

import javassist.NotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> getProdutoByNomeAndMarca(String nome, String marca){
		return produtoRepository.findProdutoByNomeAndMarca(nome, marca);
	}
	
	public List<Produto> getProdutoByNomeAndDataVencimento(String nome, LocalDate dataVencimento){
		return produtoRepository.findProdutoByNomeAndDataVencimento(nome, dataVencimento);
	}
	public List<Produto> getProdutoByNomeAndCodigoBarras(String nome, String codigoBarras){
		return produtoRepository.findProdutoByNomeAndCodigoBarras(nome, codigoBarras);
	}
	public ProdutoDTO getProdutoById(Long id) throws NotFoundException{
		Optional<Produto> produto = produtoRepository.findById(id);
		if(!Produto.isEmpty())
			throw new NotFoundException("Produto não encontrado");
		return new ProdutoDTO(produto.get());
	}
	
	public void deleteProdutoById(Long id) throws NotFoundException{
		Optional<Produto> produto = produtoRepository.findById(id);
		if(!produto.isPresent())
			throw new NotFoundException("Produto não encontrado");
		produtoRepository.delete(produto.get());
	}
	
	public Produto salvar(Produto produto) {
		return produtoRepository.save(produto);
	}
	public Produto consultaById(Long id) {
		return produtoRepository.findById(id).get();
	}
	public void deleteById(Long id) {
		produtoRepository.deleteById(id);
	}
	public List<Produto> listar(){
		return produtoRepository.findAll();
	}
	public Produto update(Produto produto) {
		if(produto !=null) {
			return produtoRepository.save(produto);
		}
		throw new RuntimeException("ID não informado");
	}
	
	
	
}
