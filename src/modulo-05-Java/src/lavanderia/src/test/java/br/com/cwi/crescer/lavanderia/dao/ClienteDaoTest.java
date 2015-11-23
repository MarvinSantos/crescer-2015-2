package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Cliente;


public class ClienteDaoTest extends AbstractInfrastructureTest {

    @Autowired
    private ClienteDao clienteDao;

    @Test
    public void aCidadeDoClienteNaoDeveSerNula() throws Exception {
        Cliente cliente = clienteDao.findById(1L);

        Assert.assertNotNull(cliente.getCidade());
    }

    @Test
    public void deveBuscarOClienteESuaListaDePedidos() throws Exception {
        Cliente cliente = clienteDao.findById(1L);

        Assert.assertNotNull(cliente.getPedidos());
    }

}
