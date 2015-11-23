package br.com.cwi.crescer.lavanderia.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;


public class ServicoServiceTest extends AbstractInfrastructureTest {

    @Autowired
    private ServicoService servicoService;

    @Test
    public void testBuscarDescricao() throws Exception {

        String descricao = servicoService.buscarDescricao(1L);

        Assert.assertNotNull(descricao);
    }

}
