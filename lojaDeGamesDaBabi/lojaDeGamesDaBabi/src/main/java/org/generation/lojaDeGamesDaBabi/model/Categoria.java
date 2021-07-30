package org.generation.lojaDeGamesDaBabi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="tb_categoria")
public class Categoria
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)//este é o auto do id
private long id;

@NotNull
private String nome;

@NotNull
@Size(min=10,max=100)
private String descricao;

@NotNull
private String cor;

@OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL) 
@JsonIgnoreProperties("categoria") 
private List<Produto> produto;


public long getId()
{
	return id;
}

public void setId(long id)
{
	this.id = id;
}

public String getNome()
{
	return nome;
}

public void setNome(String nome)
{
	this.nome = nome;
}

public String getDescricao()
{
	return descricao;
}

public void setDescricao(String descricao)
{
	this.descricao = descricao;
}

public String getCor()
{
	return cor;
}

public void setCor(String cor)
{
	this.cor = cor;
}



}
