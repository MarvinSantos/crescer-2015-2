package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pessoa;

@Repository
public class PessoaDao {

	@PersistenceContext
	private EntityManager em;
	
	public Pessoa findById(Long id) {
		return em.find(Pessoa.class, id);
	}
}
