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
import br.com.cwi.crescer.lavanderia.DTO.PedidoVisualizarDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoListaDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
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
		pedidoDao.save(pedido);
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
		BigDecimal valorDesconto = new BigDecimal("0"); 
		BigDecimal valorTotalPedido = pedido.getValorBruto();
		
		BigDecimal percentual1 = new BigDecimal("0.08");
		BigDecimal percentual2 = new BigDecimal("0.0487");
		BigDecimal percentual3 = new BigDecimal("0.04");
		BigDecimal valorEspecificado = new BigDecimal("90");
		BigDecimal pesoEspecificado = new BigDecimal("15");
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
		}else if(diaDaSemana == diasDaSemana.QUINTA.ordinal() ||
				 diaDaSemana == diasDaSemana.SEXTA.ordinal()){
			valorDesconto = valorTotalPedido.multiply(percentual3);
		}
		
		return valorDesconto;
		
	}
	
	public static enum diasDaSemana{
		DOMINGO,SEGUNDA,TERCA,QUARTA,QUINTA,SEXTA,SABADO
	}
	
	public Pedido mudarStatusParaProcessando(Long id){
		Pedido pedido = pedidoDao.findById(id);
		pedido.setSituacao(PedidoSituacao.PROCESSANDO);
		pedidoDao.save(pedido);
		return pedido;
	}

	public Pedido cancelar(Long id) {
		Pedido pedido = pedidoDao.findById(id);
		pedido.setSituacao(PedidoSituacao.CANCELADO);
		pedidoDao.save(pedido);
		return pedido;
	}

	public PedidoVisualizarDTO visualizarPedidoDTO(Long id) {
		
		Pedido pedido = pedidoDao.findById(id);
		PedidoVisualizarDTO pedidoVisu = PedidoMapper.toPedidoVisualizarDTO(pedido);
		
		return pedidoVisu;
	}

	public Pedido verificarSituacaoItensEAtualizar(Long idPedido) {
		Pedido pedido = pedidoDao.findById(idPedido);
		boolean itensForamProcessados = verficarSeItensForamProcessados(pedido.getItens());
		if(itensForamProcessados){
			pedido.setSituacao(PedidoSituacao.PROCESSADO);
			pedidoDao.save(pedido);
			return pedido;
		}else{
			return null;
		}
		
	}
	
	public boolean verficarSeItensForamProcessados(List<Item> itens){
		for(Item item : itens){
			if(item.getSituacao() == SituacaoItem.PENDENTE){
				return false;
			}
		}
		return true;
	}

	public Pedido encerrar(Long id) {
		Pedido pedido = pedidoDao.findById(id);
		
		if(pedido.getSituacao() == PedidoSituacao.PROCESSADO){
			pedido.setSituacao(PedidoSituacao.ENCERRADO);
			pedidoDao.save(pedido);
			return pedido;
		}
		return null;
	}

	public boolean processarPedido(Long idPedido) {
		Pedido pedido = pedidoDao.findById(idPedido);
		List<Item> itens = pedido.getItens();
		
		for(Item item : itens){
			if(item.getSituacao() != SituacaoItem.PROCESSADO){
				itemService.processarItem(item.getIdItem());
			}
			
		}
		
		Pedido pedidoProcessou = verificarSituacaoItensEAtualizar(pedido.getIdPedido());
		if(pedidoProcessou != null){	
			return true;
		}else{
			return false;
		}	
	}

	public List<PedidoListaDTO> listarPedidosListaDTOPorCPF(String cpf) {
		List<Pedido> pedidos =  pedidoDao.findByCpf(cpf);
		List<PedidoListaDTO> dtos = new ArrayList<PedidoListaDTO>();

        for (Pedido pedido : pedidos) {
            dtos.add(new PedidoListaDTO(pedido));
        }

        return dtos;	
	}

	public List<PedidoListaDTO> listarPedidosListaDTOPorSituacao(PedidoSituacao situacao) {
		List<Pedido> pedidos =  pedidoDao.findBySituacao(situacao);
		List<PedidoListaDTO> dtos = new ArrayList<PedidoListaDTO>();

        for (Pedido pedido : pedidos) {
            dtos.add(new PedidoListaDTO(pedido));
        }

        return dtos;
	}

	public List<PedidoSituacao> listarSituacoes() {
		ArrayList<PedidoSituacao> situacoes = new ArrayList<PedidoSituacao>();
        situacoes.add(PedidoSituacao.PENDENTE);
        situacoes.add(PedidoSituacao.PROCESSANDO);
        situacoes.add(PedidoSituacao.PROCESSADO);
        situacoes.add(PedidoSituacao.ENCERRADO);
        situacoes.add(PedidoSituacao.CANCELADO);
        return situacoes;
	        
	  
	}
}
