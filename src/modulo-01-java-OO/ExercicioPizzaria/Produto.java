
/**
 * Write a description of class Produto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Produto
{
    private String nome;
    private double preco;
    
    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public double getPreco(){
        return this.preco;
    }
    
    public String getDescricaoComprovante() {
        return 
            "Produto: " + this.getNome()
            + ", Preco: " + String.format("%.2f", this.getPreco());
    }
}
