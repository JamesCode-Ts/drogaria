package br.pro.james.drogaria.service;

import java.security.NoSuchAlgorithmException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pro.james.drogaria.Exception.CriptoExistsException;
import br.pro.james.drogaria.Exception.ServiceExc;
import br.pro.james.drogaria.Exception.UsernameException;
import br.pro.james.drogaria.domain.Usuario;
import br.pro.james.drogaria.repository.UsuarioRepository;
import br.pro.james.util.Util;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salvarUsuario(Usuario user) throws Exception{
	
		try	{
			
		
			if(usuarioRepository.findByUsername(user.getUsername()) != null) { // falta implementar a mensagem de retorno para o o front
				
				throw new UsernameException("Já existe um usuario cadastrado para:"+ user.getUsername());
			}
			user.setSenha(Util.md5(user.getSenha()));
			
		} catch (NoSuchAlgorithmException e){
			
			throw new CriptoExistsException("Erro na criptografia da senha");
		}
	usuarioRepository.save(user);
		
}
	
	public Usuario loginUser(String username, String senha)  throws ServiceExc{
		
		
		Usuario userLogin = usuarioRepository.buscarLogin(username, senha);
		
		return userLogin;
		
		
		
		
		
	}
}
