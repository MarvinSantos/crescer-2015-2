package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ProdutoDao;
import br.com.cwi.crescer.lavanderia.domain.Produto;

@Service
public class ProdutoService {

	private ProdutoDao produtoDao;
	
	@Autowired
	public ProdutoService(ProdutoDao produtoDao){
		super();
		this.produtoDao = produtoDao;
	}
	
	public double buscarValor(Long id){
		double valor;
		Produto produto;
		
		produto =  produtoDao.findById(id);
		if(produto != null){
			valor = produto.getValor();
		}else{
			valor = 0.00;
		}
		
		return valor;
	}
}
