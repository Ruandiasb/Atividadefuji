package com.rodrigofujioka.dev.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofujioka.dev.web.domain.Produto;
import com.rodrigofujioka.dev.web.service.ProdutoService;
import com.rodrigofujioka.dev.web.service.dto.ProdutoDTO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class ProdutoRest {

	@Autowired
	private ProdutoService produtoService;
	@PostMapping("/produto")
	public ResponseEntity<Produto> salvar(@RequestBody @Valid Produto produto){
		return ResponseEntity.ok(produtoService.salvar(produto));
	}
	public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Long id){
		try {
			ProdutoDTO produtoDTO = produtoService.getProdutoById(id);
			return ResponseEntity.ok(produtoDTO);
		} catch (NotFoundException e) {
			e.printStackTrace();
			return ResponseEntity.notFound().build();
		}
		
	}
	@PutMapping("/produto")
	public ResponseEntity<Produto> update(@RequestBody @Valid Produto produto){
		return ResponseEntity.ok(produtoService.update(produto));
	}
	@PutMapping("/produto/{id}")
	public ResponseEntity<Produto> consultaById(@PathVariable Long id){
		return ResponseEntity.ok(produtoService.consultaById(id));
	}
	@GetMapping("/produto")
	public ResponseEntity<List<Produto>> listar(){
		return ResponseEntity.ok(produtoService.listar());
	}
	@DeleteMapping("/produto/{id}")
	public ResponseEntity<Produto> deleteById(@PathVariable Long id) {
		try {
			produtoService.deleteById(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}
