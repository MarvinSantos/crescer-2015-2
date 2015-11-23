package br.com.cwi.crescer.lavanderia.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE_NAME,sequenceName = Pedido.SEQUENCE_NAME)
public class Pedido {

    public static final String SEQUENCE_NAME = "SEQ_Pedido";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name="IDPedido")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    @Basic(optional = false)
    private Cliente cliente;


    @Column(name="DATAInclusao")
    @Basic(optional = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dataInclusao;


    @Column(name="DATAEntrega")
    @Temporal(value = TemporalType.DATE)
    private Date dataEntrega;

    @Column(name="Valor")
    @Basic(optional = false)
    private BigDecimal valor;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="Situacao",length = 1)
    private PedidoSituacao situacao;

    public static enum PedidoSituacao {
        PENDENTE, PROCESSANDO, PROCESSADO, ENCERRADO, CANCELADO
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

    public void setCliente(Cliente idCliente) {
        this.cliente = idCliente;
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public PedidoSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(PedidoSituacao situacao) {
        this.situacao = situacao;
    }



}
