package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;
	
	
	public Produto findById(Long id){
		return em.find(Produto.class, id);
	}

	@Transactional
	public Produto save(Produto produto) {
		
		if (produto.getIdProduto() == null) {
            em.persist(produto);

            return produto;
        }

        return em.merge(produto);
	}


	public List<Produto> findAll() {
		return em.createQuery("FROM Produto", Produto.class).getResultList();
	}
}
