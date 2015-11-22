package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDao;

@Service
public class ClienteService {

	
private ClienteDao clienteDao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDAO) {
		super();
		this.clienteDao = clienteDAO;
	}
	
	public String buscarNome(Long id) {
		
		String nome = clienteDao.findById(id).getNome();
		
		return nome.toUpperCase();
	}
	
}
