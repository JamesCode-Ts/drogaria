package br.pro.james.drogaria.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.pro.james.drogaria.Exception.RecursoNaoEncontadoException;
import br.pro.james.drogaria.domain.Categoria;
import br.pro.james.drogaria.repository.CategoriaRepository;

@Service
public class CategoriaService {

@Autowired	
	private CategoriaRepository categoriaRepository;
	
	
	 public Categoria buscarPorCodigo(Short codigo) {
		Optional<Categoria> resultado = categoriaRepository.findById(codigo);
		
		
		if(resultado.isEmpty()) {
			throw new RecursoNaoEncontadoException();
		}
		
		Categoria categoria = resultado.get();
		return categoria;
		
}
	 public List<Categoria> listar(){
		 List<Categoria> resultado = categoriaRepository.findAll();
		 return resultado;
		 
		 
	 }
	 
	 
	 public Categoria inserir(Categoria categoria) {
			
			Categoria categoriaSalva = categoriaRepository.save(categoria);
			
			return categoriaSalva;
		}
		
	 public Optional<Categoria> excluir(Short codigo){ 	
		
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		categoriaRepository.delete(categoria.get());
	 	return categoria;
	 }	 

	        public Categoria editar(Categoria categoria) {
			Categoria categoriaEditada = categoriaRepository.save(categoria);
			return categoriaEditada;
			}
			
	 
	 
}