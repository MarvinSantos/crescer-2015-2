package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DTO.ItemDTO;
import br.com.cwi.crescer.lavanderia.dao.ItemDao;
import br.com.cwi.crescer.lavanderia.dao.MaterialDao;
import br.com.cwi.crescer.lavanderia.dao.PedidoDao;
import br.com.cwi.crescer.lavanderia.dao.ProdutoDao;
import br.com.cwi.crescer.lavanderia.dao.ServicoDao;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.mapper.ItemMapper;

@Service
public class ItemService {


    private ItemDao itemDao;
    private ProdutoDao produtoDao;
    private MaterialDao materialDao;
    private ServicoDao servicoDao;
    private PedidoDao pedidoDao;

    @Autowired
    public ItemService(ItemDao itemDao,ProdutoDao produtoDao,
    				   MaterialDao materialDao,ServicoDao servicoDao,PedidoDao pedidoDao) {
        super();
        this.itemDao = itemDao;
        this.produtoDao = produtoDao;
        this.materialDao = materialDao;
        this.servicoDao = servicoDao;
        this.pedidoDao = pedidoDao;
    }

    public BigDecimal buscarValorUnitario(Long id) {
        Item item;
        BigDecimal valorUnit = new BigDecimal(0);

        item = itemDao.findById(id);
        if(item != null){
            valorUnit = item.getValorUnitario();
        }

        return valorUnit;
    }
    
    public Item incluirItem(ItemDTO itemDTO){
    	Produto produto = obterProduto(itemDTO);
		
		Item item = ItemMapper.getNewEntity(itemDTO);
		item.setValorUnitario(produto.getValor());
		item.setPedido(pedidoDao.findById(itemDTO.getIdPedido()));
		item.setProduto(produto);
		item.setPeso(itemDTO.getPeso());
		BigDecimal valorTotal = item.getValorUnitario().multiply(item.getPeso());
		item.setValorTotal(valorTotal);
		item.setSituacao(SituacaoItem.PENDENTE);
		
		return itemDao.save(item);
	
    }
    
    public Produto obterProduto(ItemDTO itemDTO){
    	Produto produtoBuscar = new Produto();
		produtoBuscar.setMaterial(new Material());
		produtoBuscar.setServico(new Servico());
		produtoBuscar.getMaterial().setIdMaterial(itemDTO.getIdMaterial());
		produtoBuscar.getServico().setIdServico(itemDTO.getIdServico());
		Produto produto = produtoDao.buscarPorMaterialEServico(produtoBuscar);
		return produto;
    }
    
    public List<Item> buscarPorPedido(Pedido pedido){
    	
    	return itemDao.findAllByPedido(pedido.getIdPedido());
    }

	public BigDecimal somarPesoItensPedido(Pedido pedido) {
		BigDecimal pesoTotal = new BigDecimal(0);
		List<Item> itens = buscarPorPedido(pedido);
		for(Item item : itens){
			pesoTotal.add(item.getPeso());
		}
		
		return pesoTotal;
	}
}
