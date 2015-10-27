

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PedidoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PedidoTest
{
    @Test
    public void pedidoComPizzaTitanicCusta90(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new PizzaTitanic());
        
        double valorPedidoEsperado = 90;
        double valorAtualPedido = pedido.getValorTotal();
        
        assertEquals(valorPedidoEsperado, valorAtualPedido, 0.01);
    }
    
    @Test
    public void pedidoComPizzaPequenaCusta24_50(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new PizzaPequena());
        
        double valorPedidoEsperado = 24.5;
        double valorAtualPedido = pedido.getValorTotal();
        
        assertEquals(valorPedidoEsperado, valorAtualPedido, 0.01);
    }
    
    @Test
    public void pedidoComPizzaMediaCusta44_50(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new PizzaMedia());
        
        double valorPedidoEsperado = 44.5;
        double valorAtualPedido = pedido.getValorTotal();
        
        assertEquals(valorPedidoEsperado, valorAtualPedido, 0.01);
    }
    
    @Test
    public void pedidoComPizzaPequenaERefri2LCusta31_50(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new PizzaPequena());
        pedido.adicionarProduto(new Refri2L(MarcaRefrigerante.PEPSI));
        
        double valorPedidoEsperado = 31.5;
        double valorAtualPedido = pedido.getValorTotal();
        
        assertEquals(valorPedidoEsperado, valorAtualPedido, 0.01);
    }
    
    @Test
    public void pedidoComPizzaMediaERefriLataCusta48(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new PizzaMedia());
        pedido.adicionarProduto(new RefriLata(MarcaRefrigerante.PEPSI));
        
        double valorPedidoEsperado = 48;
        double valorAtualPedido = pedido.getValorTotal();
        
        assertEquals(valorPedidoEsperado, valorAtualPedido, 0.01);
    }
    
    @Test
    public void pedidoSemPizzaComDoisRefris2LCusta18_50(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        pedido.adicionarProduto(new Refri2L(MarcaRefrigerante.PEPSI));
        pedido.adicionarProduto(new Refri2L(MarcaRefrigerante.PEPSI));
        
        double valorPedidoEsperado = 18.5;
        double valorAtualPedido = pedido.getValorTotal();
        
        assertEquals(valorPedidoEsperado, valorAtualPedido, 0.01);
    }
    
    @Test
    public void pedidoComPizzaTitanicERefriDoisLitrosRecebe100ETem3_70DeTroco(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        
        pedido.adicionarProduto(new PizzaTitanic());
        pedido.adicionarProduto(new Refri2L(MarcaRefrigerante.PEPSI));
        
        pedido.setValorEmMaosDoCliente(100.0);
        
        // total do pedido: 107,00
        // total com desconto 10%: 96,3
        
        double trocoEsperado = 3.7;
        double trocoDoPedido = pedido.getTroco();
        
        assertEquals(trocoEsperado, trocoDoPedido, 0.01);
    }
    
    @Test
    public void pedidoComPizzaPequenaRecebe30ETem5_50DeTroco(){
        Cliente cliente = new Cliente(null, null, null);
        Pedido pedido = new Pedido(cliente);
        
        pedido.adicionarProduto(new PizzaPequena());
        
        pedido.setValorEmMaosDoCliente(30.0);
        
        // total do pedido: 24,50 (pizza 20, entrega 4,50)
        
        double trocoEsperado = 5.5;
        double trocoDoPedido = pedido.getTroco();
        
        assertEquals(trocoEsperado, trocoDoPedido, 0.01);
    }
    
}
