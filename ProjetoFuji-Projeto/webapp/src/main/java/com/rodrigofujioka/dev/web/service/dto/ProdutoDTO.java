package com.rodrigofujioka.dev.web.service.dto;

import java.time.LocalDate;

import com.rodrigofujioka.dev.web.domain.Produto;

public class ProdutoDTO {
	
	private Long id;
	private String nome;
	private String marca;
	private int anoFabricacao;
	
	private String codigoBarras;
	private String localFabricacao;
	private LocalDate dataVencimento;
	private LocalDate dataCriacao;
	private LocalDate dataAlteracao;
	
	public ProdutoDTO (Produto produto) {
		this.id= produto.getId();
		this.nome= produto.getNome();
		this.marca= produto.getMarca();
		this.codigoBarras= produto.getCodigoBarras();
		this.localFabricacao=produto.getLocalFabricacao();
		this.dataVencimento= produto.getDataVencimento();
		this.dataCriacao= produto.getDataCriacao();
		this.dataAlteracao=produto.getDataAlteracao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getLocalFabricacao() {
		return localFabricacao;
	}

	public void setLocalFabricacao(String localFabricacao) {
		this.localFabricacao = localFabricacao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(LocalDate dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
}
