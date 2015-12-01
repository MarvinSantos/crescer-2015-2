package br.com.cwi.crescer.lavanderia.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

public class ClienteDTO {

    private Long id;

    @NotBlank
    @Length(max = 70)
    private String nome;

    @Length(max = 11, min = 11)
    @NotBlank
    @CPF
    private String cpf;

    @Length(max = 100)
    @Email
    private String email;

    @Length(max = 50)
    private String endereco;

    @Length(max = 50)
    private String bairro;

    @NotNull
    private Long idCidade;

    @Max(99999999)
    @NotNull
    private BigDecimal cep;

    @NotNull
    private SituacaoCliente situacao;

    public SituacaoCliente getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoCliente situacao) {
        this.situacao = situacao;
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
