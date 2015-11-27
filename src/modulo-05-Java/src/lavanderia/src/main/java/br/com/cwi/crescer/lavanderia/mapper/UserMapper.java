package br.com.cwi.crescer.lavanderia.mapper;

import br.com.cwi.crescer.lavanderia.DTO.UserDTO;
import br.com.cwi.crescer.lavanderia.domain.Users;

public class UserMapper {

	public static Users getNewEntity(UserDTO dto) {
        Users entity = new Users();
        entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        return entity;
    }

    public static UserDTO toDTO(Users entity) {
    	UserDTO dto = new UserDTO();
        dto.setUserName(entity.getUserName());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public static Users merge(UserDTO dto, Users entity) {
    	entity.setUserName(dto.getUserName());
        entity.setPassword(dto.getPassword());
        return entity;
    }
}
