package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Authorities")
@IdClass(value=AuthorityPK.class)
public class Authorities {
	
	@Id
    @JoinColumn(name = "username")
    private String USERName;
	
    @Id
    @Column(name = "authority")
    private String authority;
    
	public String getUserName() {
		return USERName;
	}
	public void setUserName(String userName) {
		this.USERName = userName;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
    
	
	    
}
