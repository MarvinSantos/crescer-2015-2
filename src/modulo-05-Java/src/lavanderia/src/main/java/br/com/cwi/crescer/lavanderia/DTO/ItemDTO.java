package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ItemDTO {

	
    private Long idItem;
    
    @NotNull
    private Long  idPedido;

    @NotNull
    private Long idMaterial;
    
    @NotNull
    private Long idServico;

    @NotNull
    private BigDecimal peso;
 

	public Long getIdItem() {
		return idItem;
	}


	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdPedido() {
		return idPedido;
	}
	
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}
	
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	
	public Long getIdServico() {
		return idServico;
	}
	
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
    
    
	
}
