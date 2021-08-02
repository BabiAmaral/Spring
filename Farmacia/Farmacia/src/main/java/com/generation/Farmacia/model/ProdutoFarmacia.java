package com.generation.Farmacia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_produto_farmacia")
public class ProdutoFarmacia
{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=5, max=130)
	private String titulo; 
	
	@NotNull
	private Double preco;
	
	@NotNull
	private boolean promocao;
	
	@ManyToOne
	@JsonIgnoreProperties("produtoFarmacia")
	private Categoria categoria;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public Double getPreco()
	{
		return preco;
	}

	public void setPreco(Double preco)
	{
		this.preco = preco;
	}

	public boolean isPromocao()
	{
		return promocao;
	}

	public void setPromocao(boolean promocao)
	{
		this.promocao = promocao;
	}
	
	
}
