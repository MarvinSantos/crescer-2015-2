package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;


public class ProdutoServiceTest extends AbstractInfrastructureTest {

    @Autowired
    private ProdutoService produtoService;

    @Test
    public void testBuscarValor() throws Exception {

        BigDecimal valor = produtoService.buscarValor(1L);

        Assert.assertNotNull(valor);

    }

}
