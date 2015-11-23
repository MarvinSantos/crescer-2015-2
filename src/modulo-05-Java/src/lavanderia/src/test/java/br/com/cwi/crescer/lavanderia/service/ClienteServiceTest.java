package br.com.cwi.crescer.lavanderia.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;

public class ClienteServiceTest extends AbstractInfrastructureTest {

    @Autowired
    private ClienteService clienteService;

    @Test
    public void deveBurcarClientePorNome() throws Exception {

        String nome = clienteService.buscarNome(1L);

        Assert.assertNotNull(nome);
    }

}
