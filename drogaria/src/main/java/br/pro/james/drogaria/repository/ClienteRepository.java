package br.pro.james.drogaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.pro.james.drogaria.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Short>{

}
