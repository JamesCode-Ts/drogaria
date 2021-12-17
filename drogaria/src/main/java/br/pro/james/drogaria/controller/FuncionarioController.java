package br.pro.james.drogaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.pro.james.drogaria.domain.Funcionario;
import br.pro.james.drogaria.domain.Pessoa;
import br.pro.james.drogaria.repository.FuncionarioRepository;
import br.pro.james.drogaria.repository.PessoaRepository;

@Controller
public class FuncionarioController {
	
	
	@SuppressWarnings("unused")
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@SuppressWarnings("unused")
	@Autowired
    private PessoaRepository pessoaRepository;
	

	
	@GetMapping("/cadastroFun")	
	public ModelAndView cadastrarFuncionario(Pessoa pessoa,Funcionario funcionario){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Funcionario/cadastrarFun");	
		mv.addObject("funcionario",new Funcionario());
		mv.addObject("pessoa",new Pessoa());
		
		
		
		return mv;	
		
	}
	
	@RequestMapping("/salvarFun")
	public ModelAndView salvarFuncionario(@Valid Funcionario funcionario,Pessoa pessoa, BindingResult br) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			
			mv.setViewName("Funcionario/cadastrarFun");
            mv.addObject("funcionario");
            mv.addObject("pessoa");
    		
            
		}else {
			
			mv.setViewName("redirect:/Funcionarios-adicionados");
			
			funcionario.setPessoa(pessoa);
			pessoaRepository.save(pessoa);
			funcionarioRepository.save(funcionario);
			
			
		}
	
		
		
		return mv;	
		

}
	
	
	

	@GetMapping("/Funcionarios-adicionados")	
	public ModelAndView listagemFuncionarios(){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Funcionario/listFun");
	
		
		mv.addObject("FuncionarioList",funcionarioRepository.findAll());
		
		return mv;	
	}
	
	
	@GetMapping("/editarFun/{codigo}")
	public ModelAndView alterar(@PathVariable("codigo") Short codigo){
		
		 ModelAndView mv = new ModelAndView();
		  mv.setViewName("Funcionario/editarFun");
	      Funcionario funcionario = funcionarioRepository.getById(codigo);
	      mv.addObject("pessoa", new Pessoa());
		  mv.addObject("funcionario", funcionario);
		     
		     return mv;
	}
	

	
	@GetMapping("excluirFun/{codigo}")
	public ModelAndView  excluirfuncionario(@PathVariable("codigo") Short codigo){	
		ModelAndView mv = new ModelAndView();
		
      
		funcionarioRepository.deleteById(codigo); 
	
		mv.setViewName("redirect:/Funcionarios-adicionados");
		return mv;
		
		
	}
	

}

	

