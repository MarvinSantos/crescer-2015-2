package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;

public class PedidoVisualizarDTO {
	
	private Long idPedido;
	 
    private ClientePedidoDTO cliente;

    private Date dataInclusao;

    private Date dataEntrega;

    private BigDecimal valorBruto;
  
    private PedidoSituacao situacao;   

    private BigDecimal valorDesconto;
    
    private BigDecimal valorFinal;
    
    private List<ItemListaDTO> itens;
    
    private String situacaoName;

	
    
    public String getSituacaoName(){
    	situacaoName = situacao.name();
		return situacaoName;
	}
    
    
    public List<ItemListaDTO> getItens() {
		return itens;
	}
    
    public void setItens(List<ItemListaDTO> itens) {
		this.itens = itens;
	}
    
    public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public ClientePedidoDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClientePedidoDTO cliente) {
		this.cliente = cliente;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public PedidoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(PedidoSituacao situacao) {
		this.situacao = situacao;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
    
    
	
}
