package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;

public class ClienteDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String bairro;
    private Long idCidade;
    private BigDecimal cep;

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public BigDecimal getCep() {
        return cep;
    }

    public void setCep(BigDecimal cep) {
        this.cep = cep;
    }
}
