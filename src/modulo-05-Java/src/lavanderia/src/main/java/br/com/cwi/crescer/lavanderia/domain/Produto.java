package br.com.cwi.crescer.lavanderia.domain;

import java.math.BigDecimal;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;

@Entity
@Table(name="Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME,sequenceName = Produto.SEQUENCE_NAME)
public class Produto {

    public static final String SEQUENCE_NAME = "SEQ_Produto";

    @Id
    @Column(name="IDProduto")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    private Long idProduto;

    @ManyToOne
    @JoinColumn(name="IDServico")
    @Basic(optional = false)
    private Servico servico;

    @ManyToOne
    @JoinColumn(name="IDMaterial")
    @Basic(optional = false)
    private Material material;


    @Column(name="Valor")
    @Basic(optional = false)
    private BigDecimal valor;
    
    @Column(name="Prazo")
    @Basic(optional = false)
    private BigDecimal prazo;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "Situacao", length = 1)
    private SituacaoProduto situacao;

    public static enum SituacaoProduto {
        ATIVO, INATIVO
    }

    @OneToMany(mappedBy="produto")
    private List<Item> itens;

    public Long getIdProduto() {
        return idProduto;
    }
    
    public void setPrazo(BigDecimal prazo) {
		this.prazo = prazo;
	}
    
    public BigDecimal getPrazo() {
		return prazo;
	}
    
    public void setSituacao(SituacaoProduto situacao) {
		this.situacao = situacao;
	}
    
    public SituacaoProduto getSituacao() {
		return situacao;
	}


    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }
    
    public List<Item> getItens() {
		return itens;
	}
    
    public void setItens(List<Item> itens) {
		this.itens = itens;
	}


    public Servico getServico() {
        return servico;
    }


    public void setServico(Servico servico) {
        this.servico = servico;
    }


    public Material getMaterial() {
        return material;
    }


    public void setMaterial(Material material) {
        this.material = material;
    }


    public BigDecimal getValor() {
        return valor;
    }


    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
