package br.com.cwi.crescer.lavanderia.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;


public class PedidoServiceTest extends AbstractInfrastructureTest {

    @Autowired
    private PedidoService pedidoService;

    @Test
    public void testBuscarDataInclusao() throws Exception {

        Date data = pedidoService.buscarDataInclusao(1L);

        Assert.assertNotNull(data);
    }

}
