import java.util.*;
/**
 * Write a description of class Pedido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pedido
{
    private final double VALOR_TELE_ENTREGA = 4.5;
    private final double PORCENTAGEM_DESCONTO = 10;
    
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private double valorSomadoDosProdutos = 0;
    private double valorEmMaosDoCliente = 0;
    
    public Pedido(Cliente cliente){
        this.cliente = cliente;
        produtos = new ArrayList<Produto>();
    }
    
    public void adicionarProduto(Produto produto){
        produtos.add(produto);
        valorSomadoDosProdutos += produto.getPreco();
    }
    
    public void setValorEmMaosDoCliente(double valor){
        valorEmMaosDoCliente = valor;
    }
    
    public double getValorTotal() {
        double valorFinalDoPedido = valorSomadoDosProdutos;
        valorFinalDoPedido += getValorTeleEntrega();
        valorFinalDoPedido -= getValorDesconto();
        return valorFinalDoPedido;
    }
    
    public double getTroco() {
        double troco = valorEmMaosDoCliente - getValorTotal();
        
        if(troco < 0) {
            troco = 0;
        }
        
        return troco;
    }
    
    public String imprimirComprovante(){
        
        String comprovante = "";
        
        comprovante += "CLIENTE ---------------- \n";
        comprovante += "Nome: " + this.cliente.getNome() + "\n";
        comprovante += "Endereco: " + this.cliente.getEndereco() + "\n";
        comprovante += "Telefone: " + this.cliente.getTelefone() + "\n";
        
        comprovante += "\n\nPRODUTOS ---------------- \n";
        
        for(Produto prod : this.produtos) {
            comprovante += prod.getDescricaoComprovante() + "\n";
        }
        
        comprovante += "\n\nSERVICOS ---------------- \n";
        comprovante += "Tele-Entrega: " + String.format("%.2f", getValorTeleEntrega()) + "\n";
        
        comprovante += "\n\nTOTAIS ---------------- \n";
        comprovante += "Total dos Produtos: " + String.format("%.2f", valorSomadoDosProdutos) + "\n";
        comprovante += "Desconto: " + String.format("%.2f", getValorDesconto()) + "\n";
        comprovante += "\nTotal Final: " + String.format("%.2f", getValorTotal()) + "\n";
        comprovante += "Valor no Cliente: " + String.format("%.2f", valorEmMaosDoCliente) + "\n";
        comprovante += "Troco: " + String.format("%.2f", getTroco()) + "\n";
        
        return comprovante;
    }
    
    private double getValorTeleEntrega(){
        return valorSomadoDosProdutos < 60.0 ? VALOR_TELE_ENTREGA : 0.0;
    }
    
    private double getValorDesconto(){
        return valorSomadoDosProdutos >= 100.0 
            ? 
                valorSomadoDosProdutos * (PORCENTAGEM_DESCONTO / 100)
                :
                0;
    }
}
