package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DTO.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoListaDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;

@Service
public class PedidoService {
	
	private PedidoDao pedidoDao;
	private ClienteDao clienteDao;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao, ClienteDao clienteDao){
		super();
		this.pedidoDao = pedidoDao;
		this.clienteDao = clienteDao;
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
}
