package br.pro.james.drogaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.james.drogaria.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Short>{

	
}
