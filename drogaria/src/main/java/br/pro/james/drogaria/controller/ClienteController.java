package br.pro.james.drogaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.pro.james.drogaria.domain.Cliente;
import br.pro.james.drogaria.domain.Pessoa;
import br.pro.james.drogaria.repository.ClienteRepository;
import br.pro.james.drogaria.repository.PessoaRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@SuppressWarnings("unused")
	@Autowired
    private PessoaRepository pessoaRepository;
	

	
	@GetMapping("/formCliente")	
	public ModelAndView cadastrarClientes(Pessoa pessoa,Cliente cliente){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cliente/formCliente");	
		mv.addObject("cliente",new Cliente());
		mv.addObject("pessoa",new Pessoa());
		
		
		
		return mv;	
		
	}
	@RequestMapping("/salvarClientes")
	public ModelAndView salvarCliente(@Valid Cliente cliente,Pessoa pessoa, BindingResult br) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			
			mv.setViewName("Cliente/formCliente");
            mv.addObject("cliente");
            mv.addObject("pessoa");
    		
            
		}else {
			
			mv.setViewName("redirect:/clientes-adicionadas");
			
			cliente.setPessoa(pessoa);
			pessoaRepository.save(pessoa);
			clienteRepository.save(cliente);
			
			
		}
	
		
		
		return mv;	
		

}
	
	@GetMapping("clientes-adicionadas")	
	public ModelAndView listagemClientes(){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Cliente/listClientes");
	
		
		mv.addObject("clienteList",clienteRepository.findAll());
		
		return mv;	
	}
	
	
	
	@GetMapping("/editarCliente/{codigo}")
	public ModelAndView alterar(@PathVariable("codigo") Short codigo){
		
		 ModelAndView mv = new ModelAndView();
		 
		  mv.setViewName("Cliente/editarCliente");
		
		  // solução provisória, para retornar os valores dos atributos no formulário.
		  // Funciona apenas se a chaves primárias tiverem o mesmo valor.

		// Pessoa pessoa = pessoaRepository.getById(codigo);
		 Cliente cliente = clienteRepository.getById(codigo);
	
		 
		 
		// Pessoa pessoa = new Pessoa();	 
	//	Short pessoa = cliente.getPessoa().getCodigo();
		 
		
		 
		    mv.addObject("pessoa", new Pessoa());
			
			
		     mv.addObject("cliente",cliente);
		         	     
		  
		    // pessoaRepository.deleteById(codigo);
		     // Bug, ao carregar a pagina ele retornar os valores dos atributos,
		     // Mas também deleta o id atual, se voltar sem chamar o post a pagina não vai aparecer.
		     //Pois o mesmo foi deletado, Para resolver basta remover o  clienteRepository.deleteById(codigo);
		     // Mas não vai atualizar automaticamente quando chamar um post, ou seja, vai ter que remover manualmente.
		     // Vantagem deleta os dados antigos antes da editção automaticamente.
		     // Desvantagem já foi citada.
		
		 
		
		
		 
		 
		 return mv;
	}
	
	@PostMapping("/editarCliente")
	public ModelAndView alterar(Cliente cliente, Pessoa pessoa){
		
		ModelAndView mv = new ModelAndView();
		
		cliente.setPessoa(pessoa);
		
		clienteRepository.save(cliente);
		mv.setViewName("redirect:/clientes-adicionadas");
		
		
		return mv;	
	
	}
	
	
	
	
	
	
	
	@GetMapping("excluirCliente/{codigo}")
	public ModelAndView  excluirCliente(@PathVariable("codigo") Short codigo){	
		ModelAndView mv = new ModelAndView();
		
      
		clienteRepository.deleteById(codigo); 
	
		mv.setViewName("redirect:/clientes-adicionadas");
		return mv;
		
		
	}
	

}
