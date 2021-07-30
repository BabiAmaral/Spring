package org.generation.lojaDeGamesDaBabi.controller;

import java.util.List;

import org.generation.lojaDeGamesDaBabi.model.Categoria;
import org.generation.lojaDeGamesDaBabi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/categoria") // caminho
@CrossOrigin("*")
public class CategoriaController // Com 5 endpoints
{
	@Autowired
	private CategoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> GetAllCategoria(){
		return ResponseEntity.ok(repository.findAll()); //pega tudo da lista de repository
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> GetByIdCategoria(@PathVariable long id){
		return ResponseEntity.status(200).body(repository.findById(id).get());//pega tudo da lista de repository
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> GetByNomeCategoria(@PathVariable String nome){
		 return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping//inserção no postman
	public ResponseEntity<Categoria> postCategoria (@RequestBody Categoria categoria){//oq vem depois de Categoria é o "apelido" para esta classe
		 return ResponseEntity.status(201).body(repository.save(categoria));
	}
	
	@PutMapping //atualizar no postman
	public ResponseEntity<Categoria> putCategoria (@RequestBody Categoria categoria){//oq vem depois de Categoria é o "apelido" para esta classe
		 return ResponseEntity.ok(repository.save(categoria));
	}
	@DeleteMapping ("/{id}")
	public void deleteCategoria (@PathVariable long id) {
		repository.deleteById(id);
	}
	
	
	
	
}
