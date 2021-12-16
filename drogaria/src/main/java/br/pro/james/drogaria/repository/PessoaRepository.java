package br.pro.james.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.pro.james.drogaria.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Short>{
}