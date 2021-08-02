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

import com.generation.Farmacia.model.Categoria;
import com.generation.Farmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoriafarmacia")
@CrossOrigin("*")
public class CategoriaController
{
	@Autowired //garante que todos serviços da interface repository seja acessado a partir do  controller
	private CategoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() { //acesso/ tipo de retorno <entidade/classe>/nome do método/(parametros)
		return ResponseEntity.ok(repository.findAll());
	}
	
	/*@GetMapping("{id_categoria}")
	public ResponseEntity<Categoria> findById(@PathVariable long id_categoria) {
		return ResponseEntity.ok(repository.findById(id_categoria).get());
	}
	*/
	@GetMapping("{id_categoria}")
	public ResponseEntity<Categoria> findById(@PathVariable long id_categoria) {
		return repository.findById(id_categoria).map(resp-> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping ("/descricao/{descricao}")
	public ResponseEntity<List<Categoria>> findByDescricao (@PathVariable String descricao){
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}
	@PostMapping 
	public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria){
		return ResponseEntity.status(201).body(repository.save(categoria));
	}
	@PutMapping
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
	}
	@DeleteMapping ("/{id_categoria}")
	public void deleteCategoria(@PathVariable long id_categoria) {
		repository.deleteById(id_categoria);
	}
	

}
