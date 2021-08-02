package com.generation.Farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.Farmacia.model.ProdutoFarmacia;

public interface ProdutoFarmaciaRepository extends JpaRepository<ProdutoFarmacia, Long>
{
	public List<ProdutoFarmacia> findAllByTituloContainingIgnoreCase (String titulo);

}
