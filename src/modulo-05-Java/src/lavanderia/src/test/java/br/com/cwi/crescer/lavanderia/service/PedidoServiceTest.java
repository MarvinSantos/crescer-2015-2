package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.cwi.crescer.lavanderia.AbstractInfrastructureTest;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;


public class PedidoServiceTest extends AbstractInfrastructureTest {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoDao pedidoDao;

    @Mock
    private ClienteDao clienteDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBuscarDataInclusao() throws Exception {

        Date data = pedidoService.buscarDataInclusao(1L);

        Assert.assertNotNull(data);
    }

    @Test
    public void deveIncluirUmPedidoInicialComValoresDefault() {
        // Arrangeg
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

}
