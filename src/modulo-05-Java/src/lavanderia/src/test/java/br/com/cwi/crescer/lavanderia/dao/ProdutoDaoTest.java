package br.com.cwi.crescer.lavanderia.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.domain.Produto;


public class ProdutoDaoTest extends AbstractInfrastructureTest {

    @Autowired
    private ProdutoDao produtoDao;

    @Test
    public void deveBuscarUmaListaDeItens() throws Exception {
    	Produto produto = produtoDao.findById(1L);
    	
    	Assert.assertNotNull(produto.getItens());
    }
    
    @Test
    public void deveBuscarUmServicoNaoNulo() throws Exception {
    	Produto produto = produtoDao.findById(1L);
    	
    	Assert.assertNotNull(produto.getServico());
    }
    
    @Test
    public void deveBuscarUmMaterialNaoNulo() throws Exception {
    	Produto produto = produtoDao.findById(1L);
    	
    	Assert.assertNotNull(produto.getMaterial());
    }

}
