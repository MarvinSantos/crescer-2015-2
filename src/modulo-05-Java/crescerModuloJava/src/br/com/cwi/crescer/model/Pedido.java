package br.com.cwi.crescer.model;


public class Pedido {

    public Long idPedido;
    public Long idCliente;
    public String dsPedido;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getDsPedido() {
        return dsPedido;
    }

    public void setDsPedido(String dsPedido) {
        this.dsPedido = dsPedido;
    }

    @Override
    public String toString() {
        return " Descricao: " +this.dsPedido + "  id: "+this.idPedido ;
    }

}
