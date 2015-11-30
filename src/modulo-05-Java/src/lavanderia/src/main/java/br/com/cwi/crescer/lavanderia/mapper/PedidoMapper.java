package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.DTO.PedidoDTO;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.DTO.PedidoVisualizarDTO;

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

	public static PedidoVisualizarDTO toPedidoVisualizarDTO(Pedido pedido) {
		PedidoVisualizarDTO visualizarDTO = new PedidoVisualizarDTO();
		visualizarDTO.setCliente(ClienteMapper.toClientePedidoDTO(pedido.getCliente()));
		visualizarDTO.setDataEntrega(pedido.getDataEntrega());
		visualizarDTO.setDataInclusao(pedido.getDataInclusao());
		visualizarDTO.setIdPedido(pedido.getIdPedido());
		visualizarDTO.setItens(ItemMapper.toListaItemListaDTO(pedido.getItens()));
		visualizarDTO.setSituacao(pedido.getSituacao());
		visualizarDTO.setValorBruto(pedido.getValorBruto());
		visualizarDTO.setValorDesconto(pedido.getValorDesconto());
		visualizarDTO.setValorFinal(pedido.getValorFinal());
		return visualizarDTO;
	}
}
