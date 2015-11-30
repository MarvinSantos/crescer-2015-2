package br.com.cwi.crescer.lavanderia.DTO;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.lavanderia.domain.Produto;

public class ProdutoDTOCombos {

    @NotNull
    private Long idMaterial;

    @NotNull
    private String descricaoMaterial;

    public ProdutoDTOCombos(Produto produto) {
        this.descricaoMaterial = produto.getMaterial().getDescricao();
        this.idMaterial = produto.getMaterial().getIdMaterial();
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getDescricaoMaterial() {
        return descricaoMaterial;
    }

    public void setDescricaoMaterial(String descricaoMaterial) {
        this.descricaoMaterial = descricaoMaterial;
    }

}
