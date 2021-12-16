package br.pro.james.drogaria.controller;

import java.security.NoSuchAlgorithmException;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.pro.james.drogaria.Exception.ServiceExc;
import br.pro.james.drogaria.domain.Usuario;
import br.pro.james.drogaria.repository.UsuarioRepository;
import br.pro.james.drogaria.service.UsuarioService;
import br.pro.james.util.Util;
@RestController
@Controller
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
@Autowired
private UsuarioService usuarioservice;	
	
	

@RequestMapping("/")	
	public ModelAndView login(){
	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Login/login");
		mv.addObject("usuario",new Usuario());
		
		return mv;	
		
	}
    
    
    
    @RequestMapping("/index")	
	public ModelAndView index(){
	
		ModelAndView mv = new ModelAndView("index");
		mv.setViewName("home/index");
		mv.addObject("usuario",new Usuario());
		
		return mv;	
		
	}
	

@GetMapping("/cadastro")	
public ModelAndView cadastrar(){

	ModelAndView mv = new ModelAndView();
	mv.addObject("usuario",new Usuario());
	mv.setViewName("Login/cadastro");
	
	
	return mv;	
	
}

@PostMapping("/salvarUsuario")
 public ModelAndView cadastrar(Usuario usuario) throws Exception{
	ModelAndView mv = new ModelAndView();
	usuarioservice.salvarUsuario(usuario);

	mv.setViewName("redirect:/index");
	
	
	return mv;
	
}






	
    @PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc{
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario",new Usuario());
		
		if(br.hasErrors()) {
			
			mv.setViewName("Login/login");

		}	
    	
		Usuario userLogin = usuarioservice.loginUser(usuario.getUsername(), Util.md5(usuario.getSenha()));
        if(userLogin == null) {
        	
        	mv.setViewName("Login/login");  
        	mv.addObject("msg","Usuario não encontrado.Tente novamente");
        	
        	
        } else {
        	session.setAttribute("usuarioLOgado", userLogin);
        	return index();
        }
        
      
        return mv;
    
    }}

