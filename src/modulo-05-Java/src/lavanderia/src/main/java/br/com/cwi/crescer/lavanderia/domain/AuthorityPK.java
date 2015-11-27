package br.com.cwi.crescer.lavanderia.domain;

import java.io.Serializable;

public class AuthorityPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String USERName;
    private String authority;
 
    public AuthorityPK(){
        
    }
 
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AuthorityPK){
        	AuthorityPK authoritiePK = (AuthorityPK) obj;
 
            if(!authoritiePK.getUserName().equals(USERName)){
                return false;
            }
 
            if(!authoritiePK.getAuthority() .equals(authority)){
                return false;
            }
 
            return true;
        }
 
        return false;
    }
    
    @Override
    public int hashCode() {
        return USERName.hashCode() + authority.hashCode();
    }

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
