package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.cwi.crescer.lavanderia.domain.Item;

@Repository
public class ItemDao {

	@PersistenceContext
	private EntityManager em;
	
	public Item findById(Long id) {
		return em.find(Item.class, id);
	}

	@Transactional
	public Item save(Item item) {
		
		if (item.getIdItem() == null) {
            em.persist(item);

            return item;
        }

        return em.merge(item);
	}

	public List<Item> findAllByPedido(Long idPedido) {
		
		 return em.createQuery("FROM Item i WHERE i.pedido.idPedido = :idPedido", Item.class)
				 .setParameter("idPedido", idPedido)
				 .getResultList();
	}
}
