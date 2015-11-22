package br.com.cwi.crescer.lavanderia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.dao.ItemDao;
import br.com.cwi.crescer.lavanderia.domain.Item;

@Service
public class ItemService {

	
	private ItemDao itemDao;
	
	@Autowired
	public ItemService(ItemDao itemDao) {
		super();
		this.itemDao = itemDao;
	}
	
	public double buscarValorUnitario(Long id) {
		Item item;
		double valorUnit = 0.00;
		
		item = itemDao.findById(id);
		if(item != null){
			valorUnit = item.getValorUnitario();
		}
		
		return valorUnit;
	}
}
