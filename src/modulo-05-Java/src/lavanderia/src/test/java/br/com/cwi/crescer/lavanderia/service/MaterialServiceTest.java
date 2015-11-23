package br.com.cwi.crescer.lavanderia.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;


public class MaterialServiceTest extends AbstractInfrastructureTest {

    @Autowired
    private MaterialService materialService;

    @Test
    public void testBuscarDescricao() throws Exception {

        String descricao = materialService.buscarDescricao(1L);

        Assert.assertNotNull(descricao);
    }

}
