package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoDAO dao;
	
	@RequestMapping("/products/form")
	public String form(){
		return "products/form";
	}
	
	@RequestMapping("/products")
	public String save(Produto produto){
		this.dao.persist(produto);
		
		return "products/ok";
	}
}
