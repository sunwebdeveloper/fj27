package br.com.casadocodigo.loja.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoDoLivro;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/products/form")
	public ModelAndView form(){
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("tipos", TipoDoLivro.values());
		
		return modelAndView;
	}
	
	@RequestMapping("/products")
	@Transactional
	public String save(Produto produto){
		this.dao.persist(produto);
		
		return "products/ok";
	}
}
