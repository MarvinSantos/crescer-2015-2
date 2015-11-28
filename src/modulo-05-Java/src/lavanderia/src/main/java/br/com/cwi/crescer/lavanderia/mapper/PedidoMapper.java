package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.DTO.PedidoDTO;
import br.com.cwi.crescer.lavanderia.DTO.PedidoResumoDTO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;

public class PedidoMapper {
	
	public static Pedido getNewEntity(PedidoDTO dto) {
		Pedido entity = new Pedido();
        entity.setCliente(dto.getCliente());
        entity.setDataEntrega(dto.getDataEntrega());
        entity.setDataInclusao(dto.getDataInclusao());
        entity.setIdPedido(dto.getIdPedido());
        entity.setSituacao(dto.getSituacao());
        entity.setValorBruto(dto.getValorBruto());
        entity.setValorDesconto(dto.getValorDesconto());
        entity.setValorFinal(dto.getValorFinal()); 
        return entity;
    }
}
