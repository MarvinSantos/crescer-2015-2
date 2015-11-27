package br.com.cwi.crescer.lavanderia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.AuthoritiesDao;
import br.com.cwi.crescer.lavanderia.domain.Authorities;


@Service
public class AuthoritiesService {

	private AuthoritiesDao authoritiesDao;

    @Autowired
    public AuthoritiesService(AuthoritiesDao authoritiesDao){
        super();
        this.authoritiesDao = authoritiesDao;
    }
    
    
    public List<Authorities> listar() {
        return authoritiesDao.listAll();
    }
}
