package br.com.cwi.crescer.lavanderia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DTO.ClienteDTO;
import br.com.cwi.crescer.lavanderia.DTO.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.UserDTO;
import br.com.cwi.crescer.lavanderia.dao.AuthoritiesDao;
import br.com.cwi.crescer.lavanderia.dao.CidadeDao;
import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.dao.UserDao;
import br.com.cwi.crescer.lavanderia.domain.Authorities;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.domain.Users.SituacaoUser;
import br.com.cwi.crescer.lavanderia.domain.Users;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;
import br.com.cwi.crescer.lavanderia.mapper.UserMapper;

@Service
public class UserService {
	
	private UserDao userDao;
	private AuthoritiesDao authoritiesDao;

    @Autowired
    public UserService(UserDao userDao,AuthoritiesDao authoritiesDao) {
        super();
        this.userDao = userDao;
        this.authoritiesDao = authoritiesDao;
       
    }


    public UserDTO buscarPorId(String id) {
        Users user = userDao.findById(id);
        UserDTO dto = UserMapper.toDTO(user);
        Authorities permissao = authoritiesDao.findByUserName(id);
        if(permissao != null){
        	dto.setPermissao(permissao.getAuthority());
        }
        
        return dto;
        
    }

    public void atualizar(UserDTO userDTO) {
    	//TODO: arrumar
        Users user= userDao.findById(userDTO.getUserName());
        UserMapper.merge(userDTO, user);

        userDao.save(user);
    }

    public List<UserDTO> listarUsersAtivos() {
        List<Users> users = userDao.findBySituacao(SituacaoUser.ATIVO);
        List<UserDTO> dtos = new ArrayList<UserDTO>();

        for (Users user : users) {
        	UserDTO dto = new UserDTO(user);
        	Authorities permissao = authoritiesDao.findByUserName(dto.getUserName());
            if(permissao != null){
            	dto.setPermissao(permissao.getAuthority());
            }
            dtos.add(dto);
        }

        return dtos;
    }

    public void incluir(UserDTO userDto) {
    	//TODO: arrumar
    	Md5PasswordEncoder md5 = new Md5PasswordEncoder();
    	userDto.setPassword(md5.encodePassword(userDto.getPassword(),new Md5PasswordEncoder()));
    	Users userASalvar = UserMapper.getNewEntity(userDto);
        userDao.save(userASalvar);
    }

    public void remover(UserDTO userDTO) {
    	Users user = userDao.findById(userDTO.getUserName());
    	user.setSituacao(SituacaoUser.INATIVO);
        userDao.save(user);
    }
	
}
