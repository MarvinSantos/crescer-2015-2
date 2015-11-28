package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;

public class ProdutoEditarDTO {

	private Long idProduto;
 
    private BigDecimal valor;  

    private BigDecimal prazo;
    
    private SituacaoProduto situacao;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
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
