package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.MaterialDao;
import br.com.cwi.crescer.lavanderia.domain.Material;

@Service
public class MaterialService {

	private MaterialDao materialDao;
	
	@Autowired
	public MaterialService(MaterialDao materialDao){
		super();
		this.materialDao = materialDao;
	}
	
	
	public String buscarDescricao(Long id){
		String descricao;
		Material material;
		
		material = materialDao.findById(id);
		if(material != null){
			descricao = material.getDescricao();
		}else{
			descricao = "o material não foi encontrado";
		}
		
		return descricao.toUpperCase();
	}
}
