package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDao {

	@PersistenceContext
	private EntityManager em;
	
	public Material findById(Long id){
		return em.find(Material.class, id);
	}
}
