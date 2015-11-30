package br.com.cwi.crescer.lavanderia.DTO;

public class ClientePedidoDTO {
	
	private String nome;
    private String cpf;
    private Long idCliente;
	
    
    
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
    
    
	
}
