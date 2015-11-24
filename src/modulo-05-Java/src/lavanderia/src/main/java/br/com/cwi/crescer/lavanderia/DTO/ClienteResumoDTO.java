package br.com.cwi.crescer.lavanderia.DTO;

import br.com.cwi.crescer.lavanderia.domain.Cliente;

public class ClienteResumoDTO {

    private String nome;
    private String cpf;
    private String email;
    private Long id;

    public ClienteResumoDTO() {
    }

    public ClienteResumoDTO(Long id, String nome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public ClienteResumoDTO(Cliente cliente) {
        id = cliente.getIdCliente();
        nome = cliente.getNome();
        cpf = cliente.getCpf();
        email = cliente.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
