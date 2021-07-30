package org.generation.lojaDeGamesDaBabi.controller;

import java.util.List;

import org.generation.lojaDeGamesDaBabi.model.Produto;
import org.generation.lojaDeGamesDaBabi.repository.ProdutoRepository;
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

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController
{
@Autowired
private ProdutoRepository repository;

	@GetMapping
	public ResponseEntity<List<Produto>> GetAllProduto() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> GetByIDProduto(@PathVariable long id){ 
        return repository.findById(id) //metodo
        .map(resp -> ResponseEntity.ok(resp)) //.map tem dentro do objeto optional/retorna o ok
        .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> GetByTituloProduto (@PathVariable String titulo){
		return ResponseEntity.status(200).body(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	@PostMapping
	public ResponseEntity<Produto> PostProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping //testar o put 
	public ResponseEntity<Produto> PutProduto(@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
	@DeleteMapping ("/{id}")
	public void deleteProduto (@PathVariable long id) {
		repository.deleteById(id);
	}
}
