package br.com.cwi.crescer.lavanderia.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DTO.ClienteDTO;
import br.com.cwi.crescer.lavanderia.DTO.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoEditarDTO;
import br.com.cwi.crescer.lavanderia.DTO.ProdutoResumoDTO;
import br.com.cwi.crescer.lavanderia.dao.MaterialDao;
import br.com.cwi.crescer.lavanderia.dao.ProdutoDao;
import br.com.cwi.crescer.lavanderia.dao.ServicoDao;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;

@Service
public class ProdutoService {

    private ProdutoDao produtoDao;
    private MaterialDao materialDao;
    private ServicoDao servicoDao;

    @Autowired
    public ProdutoService(ProdutoDao produtoDao,MaterialDao materialDao,ServicoDao servicoDao){
        super();
        this.materialDao = materialDao;
        this.servicoDao = servicoDao;
        this.produtoDao = produtoDao;
    }

    public BigDecimal buscarValor(Long id) {
        BigDecimal valor;
        Produto produto;

        produto =  produtoDao.findById(id);
        if(produto != null){
            valor = produto.getValor();
        }else{
            valor = new BigDecimal(0);
        }

        return valor;
    }

	public boolean incluir(ProdutoDTO produto) {
		
		Produto produtoASalvar = ProdutoMapper.getNewEntity(produto);
		Material material = materialDao.findById(produto.getMaterial());
		Servico servico = servicoDao.findById(produto.getServico());
		produtoASalvar.setMaterial(material);
		produtoASalvar.setServico(servico);
		if(!produtoExiste(produtoASalvar)){	
			produtoASalvar.setSituacao(SituacaoProduto.ATIVO);
			produtoDao.save(produtoASalvar);
			return true;
		}else{
			return false;
		}
		
		
	}

	public List<ProdutoResumoDTO> listarProdutos() {
		
		List<Produto> produtos = produtoDao.findAll();
        List<ProdutoResumoDTO> dtos = new ArrayList<ProdutoResumoDTO>();

        for (Produto produto : produtos) {
            dtos.add(new ProdutoResumoDTO(produto));
        }

        return dtos;
	
	}

	public ProdutoDTO buscarPorId(Long id) {
		
		Produto produto = produtoDao.findById(id);
	     return ProdutoMapper.toDTO(produto);
	}
	
	
	public void atualizar(ProdutoEditarDTO produtoEditarDTO) {
		ProdutoDTO produtoDTO = ProdutoMapper.deEditarDTOtoDTO(produtoEditarDTO);
        Produto produto= produtoDao.findById(produtoDTO.getIdProduto());
        ProdutoMapper.merge(produtoDTO, produto);
       
        produtoDao.save(produto);
    }

	public List<SituacaoProduto> listarSituacoes() {
		ArrayList<SituacaoProduto> situacoes = new ArrayList<SituacaoProduto>();
        situacoes.add(SituacaoProduto.ATIVO);
        situacoes.add(SituacaoProduto.INATIVO);
        return situacoes;
	}
	
	public boolean produtoExiste(Produto produto){
		Produto produto2 = produtoDao.buscarPorMaterialEServico(produto);
		if(produto2 != null){
			return true;
		}else{
			return false;
		}
	}
	
	public Produto buscarProduto(Produto produto){
		Produto produto2 = produtoDao.buscarPorMaterialEServico(produto);
		return produto2;
	}
	
	
}
