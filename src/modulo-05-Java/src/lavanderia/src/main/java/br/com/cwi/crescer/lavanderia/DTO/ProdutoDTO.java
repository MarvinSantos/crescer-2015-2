package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;

public class ProdutoDTO {

	
    private Long idProduto;
 
	@NotNull
    private Long servico;
   
	@NotNull
    private Long material;
    
	@NotNull
    private BigDecimal valor;
    
	@NotNull
    private BigDecimal prazo;
	
	
	private SituacaoProduto situacao;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getServico() {
		return servico;
	}

	public void setServico(Long servico) {
		this.servico = servico;
	}

	public Long getMaterial() {
		return material;
	}

	public void setMaterial(Long material) {
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
