package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;

public class ProdutoResumoDTO {

	private Long idProduto;
	private Servico servico;
  
    private Material material;
 
    private BigDecimal valor;  

    private BigDecimal prazo;
    
    private SituacaoProduto situacao;
	
	public ProdutoResumoDTO(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.servico = produto.getServico();
		this.material = produto.getMaterial();
		this.valor = produto.getValor();
		this.prazo = produto.getPrazo();
		this.situacao = produto.getSituacao();
    }

	public Long getIdProduto() {
		return idProduto;
	}
	
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getPrazo() {
		return prazo;
	}

	public void setPrazo(BigDecimal prazo) {
		this.prazo = prazo;
	}

	public SituacaoProduto getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoProduto situacao) {
		this.situacao = situacao;
	}
	
	
}
