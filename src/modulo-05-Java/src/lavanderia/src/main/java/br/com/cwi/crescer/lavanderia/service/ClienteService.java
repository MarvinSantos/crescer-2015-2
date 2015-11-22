package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ClienteDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;

@Service
public class ClienteService {

	private ClienteDao clienteDao;
	
	@Autowired
	public ClienteService(ClienteDao clienteDAO) {
		super();
		this.clienteDao = clienteDAO;
	}
	
	public String buscarNome(Long id) {
		String nome;
		Cliente cliente;
		
		cliente = clienteDao.findById(id);
		if(cliente != null){
			nome = cliente.getNome();
		}else{
			return "cliente não encontrado";
		}
						
		return nome.toUpperCase();
	}
	
}
