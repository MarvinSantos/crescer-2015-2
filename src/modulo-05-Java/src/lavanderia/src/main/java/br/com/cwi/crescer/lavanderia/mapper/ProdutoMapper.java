package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.DTO.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoEditarDTO;
import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoMapper {

	
	public static Produto getNewEntity(ProdutoDTO dto) {
        Produto entity = new Produto();
        entity.setValor(dto.getValor());
        entity.setPrazo(dto.getPrazo());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }

    public static ProdutoDTO toDTO(Produto entity) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValor());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }

    public static Produto merge(ProdutoDTO dto, Produto entity) {
    	entity.setIdProduto(dto.getIdProduto());
    	entity.setValor(dto.getValor());
        entity.setPrazo(dto.getPrazo());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }
    
    public static ProdutoDTO deEditarDTOtoDTO(ProdutoEditarDTO entity) {
        ProdutoDTO dto = new ProdutoDTO();
        dto.setIdProduto(entity.getIdProduto());
        dto.setPrazo(entity.getPrazo());
        dto.setValor(entity.getValor());
        dto.setSituacao(entity.getSituacao());
        return dto;
    }
}
