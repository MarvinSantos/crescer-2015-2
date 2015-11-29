package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DTO.ClienteDTO;
import br.com.cwi.crescer.lavanderia.DTO.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoListaDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;

@Service
public class PedidoService {
	
	private PedidoDao pedidoDao;
	private ClienteDao clienteDao;
	private ItemService itemService;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao, ClienteDao clienteDao, ItemService itemService){
		super();
		this.pedidoDao = pedidoDao;
		this.clienteDao = clienteDao;
		this.itemService = itemService;
	}
	
	public Pedido buscarPorId(Long id) {
        Pedido pedido = pedidoDao.findById(id);
        return pedido;
    }
	
	
	public Date buscarDataInclusao(Long id) {
		Date data = new Date(1L);
		Pedido pedido;
		
		pedido = pedidoDao.findById(id);
		if(pedido != null){
			data = pedido.getDataInclusao() ;
		}
		
		return data;
	}


	public List<PedidoListaDTO> listarPedidosListaDTO() {
		List<Pedido> pedidos =  pedidoDao.findAll();
		List<PedidoListaDTO> dtos = new ArrayList<PedidoListaDTO>();

        for (Pedido pedido : pedidos) {
            dtos.add(new PedidoListaDTO(pedido));
        }

        return dtos;	
	}


	public Pedido incluirInicial(PedidoResumoDTO pedidoResumo) {
		Cliente cliente = clienteDao.findById(pedidoResumo.getIdCliente());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		Date dataInclusao = new Date();
		pedido.setDataInclusao(dataInclusao);
		BigDecimal valorInicial = new BigDecimal(0); //valor inicial porque não há nenhum item quando o pedido é incluido pela primeira vez
		pedido.setValorBruto(valorInicial);
		pedido.setSituacao(PedidoSituacao.PENDENTE);
		pedidoDao.save(pedido);
		return pedido;
	}

	public Pedido atualizarComItem(Item incluido) {
		Pedido pedido = pedidoDao.findById(incluido.getPedido().getIdPedido());
		Date dataEntregaAtualizada = atualizarDataEntrega(pedido,incluido);
		
		if(pedido.getDataEntrega() == null){
			pedido.setDataEntrega(dataEntregaAtualizada);
		}else{
			if(dataEntregaAtualizada.after(pedido.getDataEntrega())){
				pedido.setDataEntrega(dataEntregaAtualizada);
			}
		}	
		
		pedido.setValorBruto(obterValorBrutoAtual(incluido,pedido));
		
		BigDecimal valorDesconto = obterValorDesconto(pedido, incluido);
		pedido.setValorDesconto(valorDesconto);
		pedido.setValorFinal(pedido.getValorBruto().subtract(valorDesconto));
		pedido = pedidoDao.save(pedido);
		return pedido;
	}
	
	public Date atualizarDataEntrega(Pedido pedido,Item item){
		Date dataEntregaAtualizar = pedido.getDataInclusao();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dataEntregaAtualizar);
		int diasAdd = item.getProduto().getPrazo().intValue();
		calendar.add(Calendar.DAY_OF_MONTH,diasAdd); 
		dataEntregaAtualizar = calendar.getTime();
		return dataEntregaAtualizar;
	}
	
	public BigDecimal obterValorBrutoAtual(Item item, Pedido pedido){
		BigDecimal valorBrutoAtual = pedido.getValorBruto();
		BigDecimal valorBrutoAtualizado = valorBrutoAtual.add(item.getValorTotal());
		return valorBrutoAtualizado;
	}
	
	public BigDecimal obterValorDesconto(Pedido pedido,Item item){
		BigDecimal valorDesconto = new BigDecimal(0); 
		BigDecimal valorTotalPedido = pedido.getValorBruto();
		
		BigDecimal percentual1 = new BigDecimal(0.08);
		BigDecimal percentual2 = new BigDecimal(0.0487);
		BigDecimal percentual3 = new BigDecimal(0.04);
		BigDecimal valorEspecificado = new BigDecimal(90);
		BigDecimal pesoEspecificado = new BigDecimal(15);
		BigDecimal somaDoPesoItens = itemService.somarPesoItensPedido(pedido);
		somaDoPesoItens = somaDoPesoItens.add(item.getPeso());
		
		GregorianCalendar gc = new GregorianCalendar();  
		gc.setTime(pedido.getDataInclusao());  
		int diaDaSemana = gc.get(GregorianCalendar.DAY_OF_WEEK); 
		diaDaSemana -= 1 ;
		if(diaDaSemana == diasDaSemana.SEGUNDA.ordinal() ||
				diaDaSemana == diasDaSemana.TERCA.ordinal() ||
				diaDaSemana == diasDaSemana.QUARTA.ordinal()){
			
			valorDesconto = valorTotalPedido.multiply(percentual1);
			return valorDesconto;
			
		}else if((valorTotalPedido.compareTo(valorEspecificado) > 0) ||
				  somaDoPesoItens.compareTo(pesoEspecificado) > 0){
			valorDesconto = valorTotalPedido.multiply(percentual2);
		}else{
			valorDesconto = valorTotalPedido.multiply(percentual3);
		}
		
		return valorDesconto;
		
	}
	
	public static enum diasDaSemana{
		DOMINGO,SEGUNDA,TERCA,QUARTA,QUINTA,SEXTA,SABADO
	}
}
