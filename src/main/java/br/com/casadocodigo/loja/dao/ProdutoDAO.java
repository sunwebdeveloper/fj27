package br.com.casadocodigo.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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

	public Produto find(Long id) {
		TypedQuery<Produto> query = this.em.createQuery("select distinct(p) from Produto p left join fetch p.precos where p.id=:id", Produto.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
}
