package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public Produto findById(Long id){
		return em.find(Produto.class, id);
	}
}
