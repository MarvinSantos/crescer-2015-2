package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDao {

    @PersistenceContext
    private EntityManager em;


    public ClienteDao(){

    }

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> findBySituacao(SituacaoCliente situacao) {
        return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class).setParameter("situacao", situacao).getResultList();
    }

    public List<Cliente> findAll() {
        return em.createQuery("FROM Cliente", Cliente.class).getResultList();
    }

    @Transactional
    public Cliente save(Cliente cliente) {

        if (cliente.getIdCliente() == null) {
            em.persist(cliente);

            return cliente;
        }

        return em.merge(cliente);
    }

    @Transactional
    public void remove(Long id){
        em.remove(em.getReference(Cliente.class, id));
    }

    public List<Cliente> listarPorNomeParcial(String nome) {

        return em.createQuery("FROM Cliente c WHERE c.nome LIKE :nome", Cliente.class)
                .setParameter("nome", nome + "%")
                .getResultList();

    }

}
