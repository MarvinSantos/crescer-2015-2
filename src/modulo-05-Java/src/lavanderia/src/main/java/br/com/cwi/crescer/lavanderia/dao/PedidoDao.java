package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;

@Repository
public class PedidoDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Pedido findById(Long id){
		return em.find(Pedido.class, id);
	}

	public List<Pedido> findAll() {
		return em.createQuery("FROM Pedido", Pedido.class).getResultList();
	}

	@Transactional
	public Pedido save(Pedido pedido) {

        if (pedido.getIdPedido() == null) {
            em.persist(pedido);

            return pedido;
        }

        return em.merge(pedido);
		
	}

	public List<Pedido> findByCpf(String cpf) {
		
		return em.createQuery("FROM Pedido p WHERE p.cliente.cpf = :cpf ", Pedido.class).setParameter("cpf",cpf ).getResultList();
	}

	public List<Pedido> findBySituacao(PedidoSituacao situacao) {
		return em.createQuery("FROM Pedido p WHERE p.situacao = :situacao ", Pedido.class)
				.setParameter("situacao",situacao )
				.getResultList();
		
	}
}
