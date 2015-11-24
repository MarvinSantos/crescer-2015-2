package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Item;


public class ItemDaoTest extends AbstractInfrastructureTest {

    @Autowired
    private ItemDao itemDao;

    @Test
    public void deveBuscarOPedidoNaoNulo() throws Exception {
    	Item item = itemDao.findById(1L);

        Assert.assertNotNull(item.getPedido());
    }
    
    
    @Test
    public void deveBuscarOProdutoNaoNulo() throws Exception {
    	Item item = itemDao.findById(1L);

        Assert.assertNotNull(item.getProduto());
    }

}

