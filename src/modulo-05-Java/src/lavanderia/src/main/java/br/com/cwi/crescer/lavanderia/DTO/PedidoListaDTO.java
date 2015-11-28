package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;
import java.util.Date;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;

public class PedidoListaDTO {
	
	private Long idPedido;
	private Cliente cliente;
	private Date dataInclusao;
	private BigDecimal valorBruto;
	private PedidoSituacao situacao;
	
	
	public PedidoListaDTO(Pedido pedido){
		this.idPedido = pedido.getIdPedido();
		this.cliente = pedido.getCliente();
		this.dataInclusao = pedido.getDataInclusao();
		this.valorBruto = pedido.getValorBruto();
		this.situacao = pedido.getSituacao();
	}
	
	public String getSituacaoName(){
		return situacao.name();
	}
	
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
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
	
	
	
}
