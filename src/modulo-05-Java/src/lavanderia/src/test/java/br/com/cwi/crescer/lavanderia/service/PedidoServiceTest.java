package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.DTO.PedidoListaDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoVisualizarDTO;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;
import br.com.cwi.crescer.lavanderia.domain.Produto;


public class PedidoServiceTest extends AbstractInfrastructureTest {

    @InjectMocks
    private PedidoService pedidoService;
    
    
    @Mock
    private ItemService itemService;

    @Mock
    private PedidoDao pedidoDao;

    @Mock
    private ClienteDao clienteDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deveIncluirUmPedidoInicialComValoresDefault() {
        // Arrange
        PedidoResumoDTO pedidoResumo = new PedidoResumoDTO();
        pedidoResumo.setIdCliente(1L);
        Cliente cliente = new Cliente();
        Mockito.when(clienteDao.findById(pedidoResumo.getIdCliente())).thenReturn(cliente);
        Pedido pedido = new Pedido();
        BigDecimal valorInicial = new BigDecimal(0);
        pedido.setValorBruto(valorInicial);
        pedido.setSituacao(PedidoSituacao.PENDENTE);

        // Act
        Pedido pedidoSalvo = pedidoService.incluirInicial(pedidoResumo);

        // Assert
        Assert.assertEquals(pedido.getSituacao(), pedidoSalvo.getSituacao());
        Assert.assertEquals(pedido.getValorBruto(), pedidoSalvo.getValorBruto());
        Assert.assertNotNull(pedidoSalvo.getDataInclusao());
    }
    
    
    @Test
    public void deveBuscarUmaListaDePedidoListaDTO() {
        // Arrange
    	List<PedidoListaDTO> dtos = new ArrayList<PedidoListaDTO>();
    	List<Pedido> pedidos = new ArrayList<Pedido>();
    	Pedido pedido1 = new Pedido();
    	pedido1.setValorBruto(new BigDecimal("40"));
    	pedido1.setSituacao(PedidoSituacao.PROCESSADO);
    	
    	Pedido pedido2 = new Pedido();
    	pedido2.setValorBruto(new BigDecimal("50"));
    	pedido2.setSituacao(PedidoSituacao.CANCELADO);
    	
    	pedidos.add(pedido1);
    	pedidos.add(pedido2);
    	
        Mockito.when(pedidoDao.findAll()).thenReturn(pedidos);
       
        // Act
        dtos = pedidoService.listarPedidosListaDTO();

        // Assert
       
        Assert.assertNotNull(dtos);
        Assert.assertEquals(dtos.get(0).getSituacao() , PedidoSituacao.PROCESSADO);
        Assert.assertEquals(dtos.get(0).getValorBruto() , new BigDecimal("40"));
        
        Assert.assertEquals(dtos.get(1).getSituacao() , PedidoSituacao.CANCELADO);
        Assert.assertEquals(dtos.get(1).getValorBruto() , new BigDecimal("50"));
      
    }
    
    
    
    @Test
    public void deveAtualizarOPedidoConformeOItemAdicionadoNaDataAtual() {
        // Arrange
    	
    	Produto produto = new Produto();
    	produto.setPrazo(new BigDecimal("3"));
    	
    	Pedido pedido = new Pedido();
    	pedido.setDataInclusao(new Date(11/30/2015));
    	pedido.setIdPedido(1L);
    	pedido.setValorBruto(new BigDecimal("40"));
    	pedido.setSituacao(PedidoSituacao.PROCESSADO);
    	
    	Item item = new Item();
    	item.setPedido(pedido);
    	item.setProduto(produto);
    	item.setValorTotal(new BigDecimal("60"));
    	item.setPeso(new BigDecimal("5"));
    	BigDecimal valorTotalItem = item.getValorTotal();
    	BigDecimal valorbrutoPedidoEsperado = valorTotalItem.add(pedido.getValorBruto());
    	BigDecimal desconto = valorbrutoPedidoEsperado.multiply(new BigDecimal("0.08"));
    	Pedido pedidoAtualizado = new Pedido();
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
        Mockito.when(itemService.somarPesoItensPedido(pedido)).thenReturn(new BigDecimal("0"));
       
        // Act
        pedidoAtualizado = pedidoService.atualizarComItem(item);

        // Assert
       
        Assert.assertEquals(pedidoAtualizado.getValorBruto(), new BigDecimal("100"));
        
        Assert.assertEquals( desconto , pedidoAtualizado.getValorDesconto());
        Assert.assertEquals(pedidoAtualizado.getValorFinal() , new BigDecimal("100").subtract(desconto));
      
    }
    
    
    @Test
    public void deveAtualizarOPedidoConformeOItemAdicionadoeDandoDescontoDeValorDoPedidoPassandoDe100Reais() {
        // Arrange
    	
    	Produto produto = new Produto();
    	produto.setPrazo(new BigDecimal("3"));
    	
    	Date dataInclusao = new Date();
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInclusao);
		int diasAdd = 3;
		calendar.add(Calendar.DAY_OF_MONTH,diasAdd); 
		dataInclusao = calendar.getTime();
    	
    	
    	Pedido pedido = new Pedido();
    	pedido.setDataInclusao(dataInclusao);
    	pedido.setIdPedido(1L);
    	pedido.setValorBruto(new BigDecimal("40"));
    	pedido.setSituacao(PedidoSituacao.PROCESSADO);
    	
    	Item item = new Item();
    	item.setPedido(pedido);
    	item.setProduto(produto);
    	item.setValorTotal(new BigDecimal("60"));
    	item.setPeso(new BigDecimal("5"));
    	BigDecimal valorTotalItem = item.getValorTotal();
    	BigDecimal valorbrutoPedidoEsperado = valorTotalItem.add(pedido.getValorBruto());
    	BigDecimal desconto = valorbrutoPedidoEsperado.multiply(new BigDecimal("0.0487"));
    	Pedido pedidoAtualizado = new Pedido();
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
        Mockito.when(itemService.somarPesoItensPedido(pedido)).thenReturn(new BigDecimal("0"));
       
        // Act
        pedidoAtualizado = pedidoService.atualizarComItem(item);

        // Assert
       
        Assert.assertEquals(pedidoAtualizado.getValorBruto(), new BigDecimal("100"));
        
        Assert.assertEquals( desconto , pedidoAtualizado.getValorDesconto());
        Assert.assertEquals(pedidoAtualizado.getValorFinal() , new BigDecimal("100").subtract(desconto));
      
    }
    
    
    @Test
    public void deveAtualizarOPedidoConformeOItemAdicionadoComData3DiasAfrente() {
        // Arrange
    	
    	Produto produto = new Produto();
    	produto.setPrazo(new BigDecimal("3"));
    	
    	Date dataInclusao = new Date();
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInclusao);
		int diasAdd = 3;
		calendar.add(Calendar.DAY_OF_MONTH,diasAdd); 
		dataInclusao = calendar.getTime();
    	
    	
    	Pedido pedido = new Pedido();
    	pedido.setDataInclusao(dataInclusao);
    	pedido.setIdPedido(1L);
    	pedido.setValorBruto(new BigDecimal("20"));
    	pedido.setSituacao(PedidoSituacao.PROCESSADO);
    	
    	Item item = new Item();
    	item.setPedido(pedido);
    	item.setProduto(produto);
    	item.setValorTotal(new BigDecimal("20"));
    	item.setPeso(new BigDecimal("5"));
    	BigDecimal valorTotalItem = item.getValorTotal();
    	BigDecimal valorbrutoPedidoEsperado = valorTotalItem.add(pedido.getValorBruto());
    	BigDecimal desconto = valorbrutoPedidoEsperado.multiply(new BigDecimal("0.04"));
    	Pedido pedidoAtualizado = new Pedido();
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
        Mockito.when(itemService.somarPesoItensPedido(pedido)).thenReturn(new BigDecimal("0"));
       
        // Act
        pedidoAtualizado = pedidoService.atualizarComItem(item);

        // Assert
       
        Assert.assertEquals(pedidoAtualizado.getValorBruto(), new BigDecimal("40"));
        
        Assert.assertEquals( desconto , pedidoAtualizado.getValorDesconto());
        Assert.assertEquals(pedidoAtualizado.getValorFinal() , new BigDecimal("40").subtract(desconto));
      
    }
    
    
    @Test
    public void aSituacaoDoPedidoDeveSerPROCESSANDO() {
        // Arrange
    	
    	Pedido pedido = new Pedido();
    	pedido.setIdPedido(1L);    
    	pedido.setSituacao(PedidoSituacao.PENDENTE);
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
  
       
        // Act
        Pedido pedidoAtualizado = pedidoService.mudarStatusParaProcessando(1L);

        // Assert
        Assert.assertEquals(pedidoAtualizado.getSituacao() , PedidoSituacao.PROCESSANDO);
      
    }
    
    
    @Test
    public void aSituacaoDoPedidoDeveSerCANCELADO() {
        // Arrange
    	
    	Pedido pedido = new Pedido();
    	pedido.setIdPedido(1L);    
    	pedido.setSituacao(PedidoSituacao.PROCESSANDO);
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
  
       
        // Act
        Pedido pedidoAtualizado = pedidoService.cancelar(1L);

        // Assert
        Assert.assertEquals(pedidoAtualizado.getSituacao() , PedidoSituacao.CANCELADO);
      
    }
    
    @Test
    public void deveAtualizarASituacaoDoPedidoParaPROCESSADO() {
        // Arrange
    	
    	List<Item> itens = new ArrayList<Item>();
    	Item item1 = new Item();
    	item1.setSituacao(SituacaoItem.PROCESSADO);
    	item1.setIdItem(1L);
    	Item item2 = new Item();
    	item2.setSituacao(SituacaoItem.PROCESSADO);
    	item2.setIdItem(2L);
    	
    	itens.add(item1);
    	itens.add(item2);
    	
    	Pedido pedido = new Pedido();
    	pedido.setIdPedido(1L);
    	pedido.setSituacao(PedidoSituacao.PROCESSANDO);
    	pedido.setItens(itens);
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
        // Act
        boolean processou = pedidoService.processarPedido(1L);

        // Assert
       
        Assert.assertTrue(processou);
       
      
    }
    
    

    @Test
    public void deveListarUmaListaDeObjetosDoTipoPedidoListaDTO() {
        // Arrange
    	
    	List<Pedido> pedidos = new ArrayList<Pedido>();
    	List<PedidoListaDTO> dtos = new ArrayList<PedidoListaDTO>();
    		
    	Pedido pedido = new Pedido();
    	pedido.setIdPedido(1L);
    	pedido.setSituacao(PedidoSituacao.PROCESSANDO);
    	pedido.setValorBruto(new BigDecimal("50"));
    	Cliente cli = new Cliente();
    	cli.setCpf("123");
    	pedido.setCliente(cli);
    	
    	Pedido pedido2 = new Pedido();
    	pedido2.setIdPedido(1L);
    	pedido2.setSituacao(PedidoSituacao.PROCESSANDO);
    	pedido2.setValorBruto(new BigDecimal("50"));
    	pedido2.setCliente(cli);
    	
    	pedidos.add(pedido);
    	pedidos.add(pedido2);
    	
  
        Mockito.when(pedidoDao.findByCpf("123")).thenReturn(pedidos);
        // Act
        dtos = pedidoService.listarPedidosListaDTOPorCPF(cli.getCpf());

        // Assert
       
        Assert.assertNotNull(dtos);
        Assert.assertEquals(2, dtos.size());
       
      
    }
    
    
    
    @Test
    public void aSituacaoDoPedidoDeveSerENCERRADO() {
        // Arrange
    	
    	Pedido pedido = new Pedido();
    	pedido.setIdPedido(1L);    
    	pedido.setSituacao(PedidoSituacao.PROCESSADO);
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
  
       
        // Act
        Pedido pedidoAtualizado = pedidoService.encerrar(1L);

        // Assert
        Assert.assertEquals(pedidoAtualizado.getSituacao() , PedidoSituacao.ENCERRADO);
      
    }
    
    
    @Test
    public void oMetodoDeEncerrarPedidoDeveRetornarNullPorqueNaoPodeEncerrarPedidoQueNaoForStatusPROCESSADO() {
        // Arrange
    	
    	Pedido pedido = new Pedido();
    	pedido.setIdPedido(1L);    
    	pedido.setSituacao(PedidoSituacao.CANCELADO);
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
  
       
        // Act
        Pedido pedidoAtualizado = pedidoService.encerrar(1L);

        // Assert
        Assert.assertNull(pedidoAtualizado);
      
    }
    
    
    @Test
    public void tentaProcessarUmPedidoJaProcessado() {
        // Arrange
    	
    	List<Item> itens = new ArrayList<Item>();
    	Item item1 = new Item();
    	item1.setSituacao(SituacaoItem.PENDENTE);
    	item1.setIdItem(1L);
    	
    	itens.add(item1);
    	
    	
    	Pedido pedido = new Pedido();
    	pedido.setIdPedido(1L);
    	pedido.setSituacao(PedidoSituacao.PROCESSADO);
    	pedido.setItens(itens);
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
        // Act
        boolean processou = pedidoService.processarPedido(1L);

        // Assert
       
        Assert.assertFalse(processou);
       
      
    }
    
    
    @Test
    public void deveAtualizarOPedidoConformeOItemAdicionadoComDataDeEntregajaExistente() {
        // Arrange
    	
    	Produto produto = new Produto();
    	produto.setPrazo(new BigDecimal("8"));
    	
    	Date dataInclusao = new Date();
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataInclusao);
		int diasAdd = 3;
		calendar.add(Calendar.DAY_OF_MONTH,diasAdd); 
		dataInclusao = calendar.getTime();
    	
    	
    	Pedido pedido = new Pedido();
    	pedido.setDataInclusao(dataInclusao);
    	pedido.setIdPedido(1L);
    	pedido.setValorBruto(new BigDecimal("20"));
    	pedido.setSituacao(PedidoSituacao.PROCESSADO);
    	pedido.setDataEntrega(new Date());
    	
    	Item item = new Item();
    	item.setPedido(pedido);
    	item.setProduto(produto);
    	item.setValorTotal(new BigDecimal("20"));
    	item.setPeso(new BigDecimal("5"));
    	BigDecimal valorTotalItem = item.getValorTotal();
    	BigDecimal valorbrutoPedidoEsperado = valorTotalItem.add(pedido.getValorBruto());
    	BigDecimal desconto = valorbrutoPedidoEsperado.multiply(new BigDecimal("0.04"));
    	Pedido pedidoAtualizado = new Pedido();
    	
  
        Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
        Mockito.when(itemService.somarPesoItensPedido(pedido)).thenReturn(new BigDecimal("0"));
       
        // Act
        pedidoAtualizado = pedidoService.atualizarComItem(item);

        // Assert
       
        Assert.assertEquals(pedidoAtualizado.getValorBruto(), new BigDecimal("40"));
        
        Assert.assertEquals( desconto , pedidoAtualizado.getValorDesconto());
        Assert.assertEquals(pedidoAtualizado.getValorFinal() , new BigDecimal("40").subtract(desconto));
      
    }
    
    
    
    
    
        @Test
        public void deveListarTodasAsSituacoesDePedido() {
            // Arrange
        	ArrayList<PedidoSituacao> situacoes = new ArrayList<PedidoSituacao>();
            situacoes.add(PedidoSituacao.PENDENTE);
            situacoes.add(PedidoSituacao.PROCESSANDO);
            situacoes.add(PedidoSituacao.PROCESSADO);
            situacoes.add(PedidoSituacao.ENCERRADO);
            situacoes.add(PedidoSituacao.CANCELADO);
      
           
            // Act
            List<PedidoSituacao> situacoesListadas = pedidoService.listarSituacoes();

            // Assert
            for(int i = 0; i < situacoesListadas.size();i++){
            	Assert.assertEquals(situacoes.get(i) , situacoesListadas.get(i));
            }
            
          
        }
        
        
        @Test
        public void deveBuscarOPedidoPorID() {
            // Arrange
        	
        	Pedido pedido = new Pedido();  	
      
            Mockito.when(pedidoDao.findById(1L)).thenReturn(pedido);
      
           
            // Act
            Pedido pedidoBuscado = pedidoService.buscarPorId(1L);

            // Assert
            Assert.assertNotNull(pedidoBuscado);
          
        }
        
        
        @Test
        public void deveBuscarUmaListaDePedidoListaDTOPorSituacao() {
            // Arrange
        	List<PedidoListaDTO> dtos = new ArrayList<PedidoListaDTO>();
        	List<Pedido> pedidos = new ArrayList<Pedido>();
        	Pedido pedido1 = new Pedido();
        	pedido1.setValorBruto(new BigDecimal("40"));
        	pedido1.setSituacao(PedidoSituacao.PROCESSADO);
        	
        	pedidos.add(pedido1);
        	
        	
            Mockito.when(pedidoDao.findBySituacao(PedidoSituacao.PROCESSADO)).thenReturn(pedidos);
           
            // Act
            dtos = pedidoService.listarPedidosListaDTOPorSituacao(PedidoSituacao.PROCESSADO);

            // Assert
           
            Assert.assertNotNull(dtos);
          
        }
        
}
