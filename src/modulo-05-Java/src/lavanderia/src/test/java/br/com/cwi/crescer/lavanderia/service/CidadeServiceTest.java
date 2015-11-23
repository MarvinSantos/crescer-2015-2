package br.com.cwi.crescer.lavanderia.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;


public class CidadeServiceTest extends AbstractInfrastructureTest {

    @Autowired
    private CidadeService cidadeService;

    @Test
    public void testBuscarNome() throws Exception {
        String nome = cidadeService.buscarNome(1L);

        Assert.assertNotNull(nome);
    }

}
