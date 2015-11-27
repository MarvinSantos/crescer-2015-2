package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.cwi.crescer.lavanderia.domain.Users.SituacaoUser;
import br.com.cwi.crescer.lavanderia.domain.Users;

@Repository
public class UserDao {
	
	@PersistenceContext
    private EntityManager em;
	

//	public Users findById(String userName) {
//        return em.find(Users.class, userName);
//    }
	
	public Users findById(String userName) {
        return em.createQuery("FROM Users u WHERE u.userName = :userName", Users.class)
                .setParameter("userName", userName)
                .getSingleResult();
    }

    public List<Users> findBySituacao(SituacaoUser enabled) {
    	return em.createQuery("FROM Users u WHERE u.enabled = :enabled", Users.class)
                .setParameter("enabled", enabled)
                .getResultList();
    }

    @Transactional
    public Users save(Users user) {

    	//TODO: arrumar 1
        if (user.getUserName() == null) {
        	user.setSituacao(SituacaoUser.ATIVO);
            em.persist(user);

            return user;
        }

        return em.merge(user);
    }

    @Transactional
    public void remove(String id){
        em.remove(em.getReference(Users.class, id));
    }

}
