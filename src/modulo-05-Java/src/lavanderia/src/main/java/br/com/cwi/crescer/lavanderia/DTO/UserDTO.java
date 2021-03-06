package br.com.cwi.crescer.lavanderia.DTO;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import br.com.cwi.crescer.lavanderia.domain.Users;
import br.com.cwi.crescer.lavanderia.domain.Users.SituacaoUser;



public class UserDTO {

    @NotBlank
    @Length(max = 100)
    private String userName;

    @NotBlank
    @Length(max = 32)
    private String password;

    @NotBlank
    private String permissao;

    @NotBlank
    private SituacaoUser situacao;

    public UserDTO(Users user){
        this.userName = user.getUserName();
        this.password = user.getPassword();
    }

    public UserDTO(){

    }

    public SituacaoUser getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoUser situacao) {
        this.situacao = situacao;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
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


}
