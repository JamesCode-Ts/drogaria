package br.pro.james.drogaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.pro.james.drogaria.domain.Pessoa;
import br.pro.james.drogaria.domain.Usuario;
import br.pro.james.drogaria.repository.PessoaRepository;

@RestController
public class PessoaController {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	
	@GetMapping("/inserirPessoa")	
	public ModelAndView InserirPessoas(Pessoa pessoa){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Pessoa/pessoaForm");
		mv.addObject("pessoa",new Pessoa());
		
		return mv;	
		
	}
	@PostMapping("InserirPessoas")
	public ModelAndView inserirPessoa(@Valid Pessoa pessoa, BindingResult br){
		
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			
			mv.setViewName("Pessoa/pessoaForm");
            mv.addObject("pessoa");
            
		}else {
			
			mv.setViewName("redirect:/pessoas-adicionadas");
			pessoaRepository.save(pessoa);
		}
	
		
		
		return mv;	
		

}
	
	@GetMapping("pessoas-adicionadas")	
	public ModelAndView listagemPessoas(Pessoa pessoa){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Pessoa/listPessoas");
		mv.addObject("pessoasList",pessoaRepository.findAll());
		

		return mv;	
	}

	
	@GetMapping("/editar/{codigo}")
	public ModelAndView alterar(@PathVariable("codigo") Short codigo){
		
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("Pessoa/editar");
		 
	     Pessoa pessoa = pessoaRepository.getById(codigo); 
	     mv.addObject("pessoa",pessoa);
	 
		 
		 
		 return mv;
  }
	
	@PostMapping("/editar")
	public ModelAndView alterar(@Valid Pessoa pessoa, BindingResult br){
		
		ModelAndView mv = new ModelAndView();
		
     if(br.hasErrors()) {
			
			mv.setViewName("Pessoa/editar");
           mv.addObject("pessoa");
            
		}else {
			
			mv.setViewName("redirect:/pessoas-adicionadas");
			pessoaRepository.save(pessoa);
}
	
		
		
return mv;	
		
	
	
	}
	
	@GetMapping("/voltar")
	public ModelAndView voltar(){
		
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("Pessoa/editar");
	    
		 mv.setViewName("redirect:/pessoas-adicionadas");
	   
		
		 
		 
		 return mv;
  }
	
	
	
	@GetMapping("excluir/{codigo}")
	public ModelAndView  excluirPessoa(@PathVariable("codigo") Short codigo){	
		ModelAndView mv = new ModelAndView();
		pessoaRepository.deleteById(codigo);
		mv.setViewName("redirect:/pessoas-adicionadas");
		return mv;
		
		
	}
	
	
	
}