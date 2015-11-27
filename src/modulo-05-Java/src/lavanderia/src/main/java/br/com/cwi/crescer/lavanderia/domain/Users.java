package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Users")
public class Users {
	
	
	@Id
    @Column(name = "USERName", length = 100)
    private String userName;

    @Column(name = "password", length = 32)
    @Basic(optional = false)
    private String password;
    
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "enabled", length = 1)
    @Basic(optional = false)
    private SituacaoUser enabled;

    
    public static enum SituacaoUser{
         INATIVO,ATIVO
    }


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public SituacaoUser getSituacao() {
		return enabled;
	}


	public void setSituacao(SituacaoUser situacao) {
		this.enabled = situacao;
	}
    
	
	
}
