package br.pro.james.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.james.drogaria.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Short>{

}
