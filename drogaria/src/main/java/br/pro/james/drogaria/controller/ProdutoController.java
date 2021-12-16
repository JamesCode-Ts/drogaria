package br.pro.james.drogaria.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.pro.james.drogaria.domain.Categoria;
import br.pro.james.drogaria.domain.Produto;
import br.pro.james.drogaria.repository.CategoriaRepository;
import br.pro.james.drogaria.repository.ProdutoRepository;



@RestController
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	

    @GetMapping("/inserirProdutos")	
	public ModelAndView InserirProdutos(Produto produto, Categoria categoria){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Produto/formProduto");
		mv.addObject("categoria",new Categoria());
		mv.addObject("produto",new Produto());
		
		return mv;	
		
	}

	
	
	
	@PostMapping("InserirProdutos")
	public ModelAndView inserirProdutos(@Valid Produto produto, Categoria categoria, BindingResult br) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		if(br.hasErrors()) {
			
			
			
			mv.setViewName("Produto/formProduto");
          //  mv.addObject("msg", "Já existe um produto com a mesma descrição");
            
		}else {
			
			
		
		
			mv.setViewName("Produto/formProduto");
			mv.addObject("msg","Salvo ");		
			produto.setCategoria(categoria);
			categoria.setProduto(produto);
			categoriaRepository.save(categoria);
			produtoRepository.save(produto);
			//mv.setViewName("redirect:/listagem-produtos");
			
			
			
		}
	
		
		
		return mv;	

}
	@GetMapping("listagem-produtos")	
	public ModelAndView listagemProdutos(Produto produto){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Produto/listProdutos");
		mv.addObject("listProdutos",produtoRepository.findAll());
		
		
		return mv;	
	}
	

	@GetMapping("/editarProduto/{codigo}")
	public ModelAndView alterar(@PathVariable("codigo") Short codigo){
		
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("Produto/editarProduto");
	     Produto produto = produtoRepository.getById(codigo); 
	     Categoria categoria = categoriaRepository.getById(codigo);
	     
	     mv.addObject("produto",produto);
	     mv.addObject("categoria",categoria);
		
		 
		 
		 return mv;
  }
	
	

	
	

	@PostMapping("/editarProduto")
	public ModelAndView alterar(@Valid Produto produto,Categoria categoria, BindingResult br){
		
		ModelAndView mv = new ModelAndView();
		
     if(br.hasErrors()) {
			
			mv.setViewName("Produto/editarProduto");
            mv.addObject("produto");
            
		}else {
			
			mv.setViewName("redirect:/listagem-produtos");
			produtoRepository.save(produto);
			categoriaRepository.save(categoria);
		}
	
		
		
		return mv;	
		
	
	
	}
	
	
	
	
	
	@GetMapping("excluirProduto/{codigo}")
	public ModelAndView  excluirProduto(@PathVariable("codigo") Short codigo){	
		ModelAndView mv = new ModelAndView();
		produtoRepository.deleteById(codigo);
		categoriaRepository.deleteById(codigo);
		mv.setViewName("redirect:/listagem-produtos");
		return mv;
		
		
	}
	
	
	
	
	
	
}
