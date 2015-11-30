package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;

import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;

public class ItemListaDTO {
	
	private Long idItem;
	
	private BigDecimal valorTotal;
	
	private SituacaoItem situacao;
	
	private String material;
	
	private String servico;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public SituacaoItem getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoItem situacao) {
		this.situacao = situacao;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
	
	
}
