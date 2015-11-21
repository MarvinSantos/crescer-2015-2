package br.com.cwi.crescer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.PessoaDao;

@Service
public class PessoaService {
	
	private PessoaDao pessoaDao;
	
	@Autowired
	public PessoaService(PessoaDao pessoaDAO) {
		super();
		this.pessoaDao = pessoaDAO;
	}
	
	public String buscarNome(Long id) {
		
		String nome = pessoaDao.findById(id).getNome();
		
		return nome.toUpperCase();
	}

}
