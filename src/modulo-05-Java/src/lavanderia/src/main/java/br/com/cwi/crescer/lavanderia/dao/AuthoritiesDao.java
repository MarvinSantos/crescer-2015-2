package br.com.cwi.crescer.lavanderia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Authorities;
import br.com.cwi.crescer.lavanderia.domain.Users;

@Repository
public class AuthoritiesDao {

	@PersistenceContext
    private EntityManager em;
	

	public Authorities findByUserName(String id) {  
        return em.createQuery("FROM Authorities a WHERE a.USERName = :USERName", Authorities.class)
                .setParameter("USERName", id)
                .getSingleResult();
    }


	public List<Authorities> listAll() {
		List<Authorities> permissoes = new ArrayList<Authorities>();
		Authorities permicaoAdm = new Authorities();
		Authorities permicaoUser = new Authorities();
		permicaoAdm.setAuthority("ROLE_ADMIN");
		permicaoUser.setAuthority("ROLE_USER");
		
		permissoes.add(permicaoUser);
		permissoes.add(permicaoAdm);
		return permissoes;
	}
	
	
}
