package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;
import java.util.Date;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;

public class PedidoDTO {

    private Long idPedido;
 
    private Cliente cliente;

    private Date dataInclusao;

    private Date dataEntrega;

    private BigDecimal valorBruto;
  
    private PedidoSituacao situacao;   

    private BigDecimal valorDesconto;
    
    private BigDecimal valorFinal;
    
    

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
