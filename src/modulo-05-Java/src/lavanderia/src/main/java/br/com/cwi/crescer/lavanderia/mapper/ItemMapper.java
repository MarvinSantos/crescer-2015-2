package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.DTO.ItemDTO;
import br.com.cwi.crescer.lavanderia.domain.Item;

public class ItemMapper {
	
	public static Item getNewEntity(ItemDTO dto) {
		Item entity = new Item();
        entity.setPeso(dto.getPeso());   
        return entity;
    }
}
