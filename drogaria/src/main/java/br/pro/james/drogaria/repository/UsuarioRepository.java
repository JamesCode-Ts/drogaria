package br.pro.james.drogaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.pro.james.drogaria.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Short>{
	
	
	@Query("select i from Usuario i where i.username = :username") 
   public Usuario findByUsername(String username);
	
	@Query("select j from Usuario j where j.username = :username and j.senha = :senha")
	public Usuario buscarLogin(String username, String senha);
	
}
