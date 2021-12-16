package br.pro.james.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.james.drogaria.domain.Cliente;
import br.pro.james.drogaria.domain.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Short>{

}
