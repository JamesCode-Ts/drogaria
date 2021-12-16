package br.pro.james.drogaria.controller;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.pro.james.drogaria.Exception.RecursoNaoEncontadoException;
import br.pro.james.drogaria.domain.Categoria;

import br.pro.james.drogaria.service.CategoriaService;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;  // renomeou 
	
	
	@GetMapping
	public List<Categoria> listar(){
		List<Categoria> categorias = categoriaService.listar();
		
		return categorias;
	}
	
	@GetMapping("/{codigo}")
	public Categoria buscarPorCodigo(@PathVariable Short codigo) {
		
		try {
		Categoria categoria = categoriaService.buscarPorCodigo(codigo);
	    return categoria;
	    
		} catch (RecursoNaoEncontadoException exececao){
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "categoria não encontrada", exececao);
			
		}
		
	}
	
	
	
	
	@PostMapping
	public Categoria inserir(@RequestBody Categoria categoria) {
		
		Categoria categoriaSalva = categoriaService.inserir(categoria);
		
		return categoriaSalva;
	}
	
	
	@DeleteMapping("/{codigo}")
	public Optional<Categoria> excluir(@PathVariable Short codigo){ 
	Optional<Categoria> categoria = categoriaService.excluir(codigo);
    return categoria;
	 
	}
	

	
	@PutMapping
	public Categoria editar(@RequestBody Categoria categoria) {
	Categoria categoriaEditada = categoriaService.editar(categoria);
	return categoriaEditada;
	}
	
}
