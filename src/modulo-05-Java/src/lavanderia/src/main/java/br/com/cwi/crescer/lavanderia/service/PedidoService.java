package br.com.cwi.crescer.lavanderia.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.domain.Pedido;

@Service
public class PedidoService {
	
	private PedidoDao pedidoDao;
	
	@Autowired
	public PedidoService(PedidoDao pedidoDao){
		super();
		this.pedidoDao = pedidoDao;
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
}
