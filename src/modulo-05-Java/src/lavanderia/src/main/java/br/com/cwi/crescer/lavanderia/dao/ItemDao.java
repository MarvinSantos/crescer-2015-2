package br.com.cwi.crescer.lavanderia.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Item;

@Repository
public class ItemDao {

	@PersistenceContext
	private EntityManager em;
	
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}
}
