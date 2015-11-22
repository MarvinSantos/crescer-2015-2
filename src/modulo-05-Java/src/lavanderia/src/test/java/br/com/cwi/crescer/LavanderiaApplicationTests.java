package br.com.cwi.crescer;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import java.util.Date;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import br.com.cwi.crescer.lavanderia.LavanderiaApplication;
import br.com.cwi.crescer.lavanderia.dao.ItemDao;
import br.com.cwi.crescer.lavanderia.service.CidadeService;
import br.com.cwi.crescer.lavanderia.service.ClienteService;
import br.com.cwi.crescer.lavanderia.service.ItemService;
import br.com.cwi.crescer.lavanderia.service.MaterialService;
import br.com.cwi.crescer.lavanderia.service.PedidoService;
import br.com.cwi.crescer.lavanderia.service.ProdutoService;
import br.com.cwi.crescer.lavanderia.service.ServicoService;
import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LavanderiaApplication.class)
@WebAppConfiguration
public class LavanderiaApplicationTests {

	@Resource
	private ItemService itemService;
	
	@Resource
	private CidadeService cidadeService;
	
	@Resource
	private ClienteService clienteService;
	
	@Resource
	private MaterialService materialService; 
	
	@Resource
	private PedidoService pedidoService;
	
	@Resource
	private ProdutoService produtoService;
	
	@Resource
	private ServicoService servicoService;
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	public void oValorUnitarioDoItemDeveSer100Ponto5() {
		
		double valorUnit = 0.00;
		try{
			valorUnit = itemService.buscarValorUnitario(1L);  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		assertEquals(100.5,valorUnit,0.1);
		
	
	}
	
	
	@Test
	public void oNomeDaCidadeDeveSerEsteio() {
		String nome = "";
		String nomeEsperado ="ESTEIO";
		try{
			nome = cidadeService.buscarNome(1L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		nome = nome.toUpperCase();
		nomeEsperado = nomeEsperado.toUpperCase();
		assertEquals(nomeEsperado,nome);
		
	
	}
	
	

	@Test
	public void oNomeDoClienteDeveSerMarvin() {
		String nome = "";
		String nomeEsperado ="MARVIN";
		try{
			nome = clienteService.buscarNome(2L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		nome = nome.toUpperCase();
		nomeEsperado = nomeEsperado.toUpperCase();
		assertEquals(nomeEsperado,nome);
		
	
	}
	
	
	@Test
	public void aDescricaoDoMaterialDeveSerSabaoEmPo() {
		String descricao = "";
		String descricaoEsperada ="SABÃO EM PÓ";
		try{
			descricao = materialService.buscarDescricao(1L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		descricao = descricao.toUpperCase();
		descricaoEsperada = descricaoEsperada.toUpperCase();
		assertEquals(descricaoEsperada,descricao);
		
	
	}
	
	
	@Test
	public void aDataDeInclusaoDoPedidoDeveSer05_OCT_10() {
		Date data = null;
		String dataString = "";
		String dataEsperadaString = "2010-10-05";
		try{
			data = pedidoService.buscarDataInclusao(3L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		if(data != null){
			dataString = data.toString();
			dataString = dataString.toUpperCase();
			dataEsperadaString = dataEsperadaString.toUpperCase();
		}
			
		
		assertEquals(dataEsperadaString,dataString);
		
	
	}
	
	
	@Test
	public void oValorDoProdutoDeveSer50ponto5() {
		double valor = 0.00;
		String valorString = "";
		String valorEsperadoString = "50.5";
		try{
			valor = produtoService.buscarValor(1L);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(valor != 0.00){
			valorString = Double.toString(valor).toUpperCase();
		}
			
		
		assertEquals(valorEsperadoString,valorString);
		
	
	}
	
	
	@Test
	public void aDescricaoDoServicoDeveSerLavagemSimples() {
		String descricao = "";
		String descricaoEsperada = "LAVAGEM SIMPLES";
		try{
			descricao = servicoService.buscarDescricao(1L) ; 
		}catch(Exception e){
			e.printStackTrace();
		}
	
	    descricao = descricao.toUpperCase();			
		
		assertEquals(descricaoEsperada,descricao);
		
	}
	
	
	
	
	// testando se os testes vao dar errado quando é esperado um valor não existente no banco
	
	
	
	@Test
	public void oValorUnitarioDoItemDeveSerDiferenteDoEsperado() {
		
		double valorUnit = 0.00;
		double valorEsperado = 500;
		try{
			valorUnit = itemService.buscarValorUnitario(1L);  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		assertFalse(valorEsperado == valorUnit);
		
	
	}
	
	
	@Test
	public void oNomeDaCidadeDeveSerDiferenteDoEsperado() {
		String nome = "";
		String nomeEsperado ="CANOAS";
		try{
			nome = cidadeService.buscarNome(1L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		nome = nome.toUpperCase();
		nomeEsperado = nomeEsperado.toUpperCase();
		assertFalse(nomeEsperado == nome);
		
	
	}
	
	

	@Test
	public void oNomeDoClienteDeveSerDiferenteDoEsperado() {
		String nome = "";
		String nomeEsperado ="todo mundo odeia o chris";
		try{
			nome = clienteService.buscarNome(2L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		nome = nome.toUpperCase();
		nomeEsperado = nomeEsperado.toUpperCase();
		assertFalse(nomeEsperado == nome);
		
	
	}
	
	
	@Test
	public void aDescricaoDoMaterialDeveSerDiferenteDoEsperado() {
		String descricao = "";
		String descricaoEsperada ="cimento";
		try{
			descricao = materialService.buscarDescricao(1L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		
		descricao = descricao.toUpperCase();
		descricaoEsperada = descricaoEsperada.toUpperCase();
		assertFalse(descricaoEsperada == descricao);
		
	
	}
	
	
	@Test
	public void aDataDeInclusaoDoPedidoDeveSerDiferenteDaEsperada() {
		Date data = null;
		String dataString = "";
		String dataEsperadaString = "2005-06-06";
		try{
			data = pedidoService.buscarDataInclusao(3L) ;  
		}catch(Exception e){
			e.printStackTrace();
		}
		if(data != null){
			dataString = data.toString();
			dataString = dataString.toUpperCase();
			dataEsperadaString = dataEsperadaString.toUpperCase();
		}
			
		
		assertFalse(dataEsperadaString == dataString);
		
	
	}
	
	
	@Test
	public void oValorDoProdutoDeveSerDiferenteDoEsperado() {
		double valor = 0.00;
		String valorString = "";
		String valorEsperadoString = "3526.655";
		try{
			valor = produtoService.buscarValor(1L);
		}catch(Exception e){
			e.printStackTrace();
		}
		if(valor != 0.00){
			valorString = Double.toString(valor).toUpperCase();
		}
			
		
		assertFalse(valorEsperadoString == valorString);
		
	
	}
	
	
	@Test
	public void aDescricaoDoServicoDeveSerDiferenteDaEsperada() {
		String descricao = "";
		String descricaoEsperada = "LAVAGEM SIMPLES só que não";
		try{
			descricao = servicoService.buscarDescricao(1L) ; 
		}catch(Exception e){
			e.printStackTrace();
		}
	
	    descricao = descricao.toUpperCase();			
		
		assertFalse(descricaoEsperada == descricao);
		
	}

}
