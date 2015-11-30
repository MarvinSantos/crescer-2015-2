package br.com.cwi.crescer.lavanderia.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.lavanderia.DTO.ItemDTO;
import br.com.cwi.crescer.lavanderia.DTO.ItemListaDTO;
import br.com.cwi.crescer.lavanderia.domain.Item;

public class ItemMapper {
	
	public static Item getNewEntity(ItemDTO dto) {
		Item entity = new Item();
        entity.setPeso(dto.getPeso());   
        return entity;
    }

	public static List<ItemListaDTO> toListaItemListaDTO(List<Item> itens) {
		List<ItemListaDTO> listaDTO = new ArrayList<ItemListaDTO>();
		for(Item item : itens){
			ItemListaDTO dto = new ItemListaDTO();
			dto.setIdItem(item.getIdItem());
			dto.setMaterial(item.getProduto().getMaterial().getDescricao());
			dto.setServico(item.getProduto().getServico().getDescricao());
			dto.setSituacao(item.getSituacao());
			dto.setValorTotal(item.getValorTotal());
			listaDTO.add(dto);
		}
		
		return listaDTO;
	}
}
