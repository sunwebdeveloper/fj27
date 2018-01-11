package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoDoLivro;
import br.com.casadocodigo.loja.validator.ProdutoValidator;

@Controller
@RequestMapping("/products")
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/form")
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("tipos", TipoDoLivro.values());
		
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@Transactional
	public ModelAndView save(@Valid Produto produto, BindingResult bindingResult, RedirectAttributes attr){ 
		if(bindingResult.hasErrors()){
			return this.form();
		}
		this.dao.persist(produto);
		
		attr.addFlashAttribute("sucesso",produto);
		return new ModelAndView("redirect:products");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("livros", dao.listarTodos());		
		return modelAndView;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.addValidators(new ProdutoValidator());
	}
}
