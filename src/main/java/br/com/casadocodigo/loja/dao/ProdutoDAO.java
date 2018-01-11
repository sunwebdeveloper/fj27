package br.com.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.casadocodigo.loja.models.Produto;

@Repository
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void persist(Produto produto){
		this.em.persist(produto);
	}

	public Object listarTodos() {
		return this.em.createQuery("select distinct(p) from Produto p left join fetch p.precos").getResultList();
	}
}
