package br.com.cwi.crescer.lavanderia.DTO;

import br.com.cwi.crescer.lavanderia.domain.Pedido.PedidoSituacao;

public class FiltroDTO {

	
	private PedidoSituacao situacao;
	
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PedidoSituacao getSituacao() {
		return situacao;
	}

	public void setSituacao(PedidoSituacao situacao) {
		this.situacao = situacao;
	}
	
	
}
