package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Pedido;


public class PedidoDaoTest extends AbstractInfrastructureTest {

    @Autowired
    private PedidoDao pedidoDao;

    @Test
    public void deveBuscarOPedidoComClienteNaoNulo() throws Exception {

        Pedido pedido = pedidoDao.findById(1L);

        Assert.assertNotNull(pedido.getCliente());
    }

}
