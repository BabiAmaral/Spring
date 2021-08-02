package com.generation.Farmacia.controller;

import java.util.List;

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

import com.generation.Farmacia.model.ProdutoFarmacia;
import com.generation.Farmacia.repository.ProdutoFarmaciaRepository;

@RestController
@RequestMapping("/produtofarmacia")
@CrossOrigin("*")
public class ProdutoFarmaciaController
{
	@Autowired
	private ProdutoFarmaciaRepository repository;
	
	@GetMapping
	public ResponseEntity <List<ProdutoFarmacia>> getAllProduto(){
		return ResponseEntity.status(200).body(repository.findAll());
	}
	@GetMapping("/{id}")
	public ResponseEntity <ProdutoFarmacia> getById (@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity <List<ProdutoFarmacia>> getByTitulo (@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PostMapping
	public ResponseEntity<ProdutoFarmacia> postProduto (@RequestBody ProdutoFarmacia produtoFarmacia){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtoFarmacia));
	}
	@PutMapping
	public ResponseEntity<ProdutoFarmacia> putProduto (@RequestBody ProdutoFarmacia produtoFarmacia){
		return ResponseEntity.ok(repository.save(produtoFarmacia));
	}
	@DeleteMapping("/{id}")
	public void deleteProduto (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
	
	
}
