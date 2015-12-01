package br.com.cwi.crescer.lavanderia.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.lavanderia.domain.Material;

@Repository
public class MaterialDao {

    @PersistenceContext
    private EntityManager em;

    public Material findById(Long id){
        return em.find(Material.class, id);
    }

    public List<Material> listAll() {

        return em.createQuery("FROM Material", Material.class)
                .getResultList();
    }

    public List<Material> listAll2() {
        return em.createQuery("from Material where idmaterial in (select material from Produto)", Material.class).getResultList();
    }

}
