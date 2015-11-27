package br.com.cwi.crescer.lavanderia.mapper;


import br.com.cwi.crescer.lavanderia.DTO.ClienteDTO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;

public class ClienteMapper {


    public static Cliente getNewEntity(ClienteDTO dto) {
        Cliente entity = new Cliente();
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setBairro(dto.getBairro());
        entity.setEndereco(dto.getEndereco());
        entity.setCep(dto.getCep());
        return entity;
    }

    public static ClienteDTO toDTO(Cliente entity) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(entity.getIdCliente());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setBairro(entity.getBairro());
        dto.setCep(entity.getCep());
        dto.setEndereco(entity.getEndereco());
        dto.setSituacao(entity.getSituacao());
        if(entity.getCidade() != null){
            dto.setIdCidade(entity.getCidade().getIdCidade());
        }
        return dto;
    }

    public static Cliente merge(ClienteDTO dto, Cliente entity) {
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setBairro(dto.getBairro());
        entity.setCep(dto.getCep());
        entity.setEndereco(dto.getEndereco());
        entity.setSituacao(dto.getSituacao());
        return entity;
    }

}
