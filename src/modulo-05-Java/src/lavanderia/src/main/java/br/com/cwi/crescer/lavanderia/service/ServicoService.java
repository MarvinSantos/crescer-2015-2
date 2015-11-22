package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ServicoDao;
import br.com.cwi.crescer.lavanderia.domain.Servico;

@Service
public class ServicoService {
	
	private ServicoDao servicoDao;
	
	@Autowired
	public ServicoService(ServicoDao servicoDao){
		super();
		this.servicoDao = servicoDao;
	}
	
	
	public String buscarDescricao(Long id){
		String descricao;
		Servico servico;
		
		servico = servicoDao.findById(id);
		if(servico != null){
			descricao = servico.getDescricao();
		}else{
			descricao = "o servico não foi encontrado" ;
		}
		
		return descricao.toUpperCase();
	}
}
