package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;


public class ItemServiceTest extends AbstractInfrastructureTest {

    @Autowired
    ItemService itemService;

    @Test
    public void testBuscarValorUnitario() throws Exception {

        BigDecimal valor = itemService.buscarValorUnitario(1L);

        Assert.assertNotNull(valor);
    }

}
