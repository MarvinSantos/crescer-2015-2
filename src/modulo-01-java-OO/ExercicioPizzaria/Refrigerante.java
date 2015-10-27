
/**
 * Write a description of class Refrigerante here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Refrigerante extends Produto
{
    private MarcaRefrigerante marca;
    
    public Refrigerante(String nome, double preco, MarcaRefrigerante marca){
        super(nome, preco);
        this.marca = marca;
    }
    
    public MarcaRefrigerante getMarca(){
        return this.marca;
    }
    
    public String getDescricaoComprovante() {
        return 
            super.getDescricaoComprovante()
                + ", Marca: " + getNomeMarca();
    }
    
    private String getNomeMarca(){
        
        if(marca == MarcaRefrigerante.PEPSI) return "Pepsi";
        else if(marca == MarcaRefrigerante.COCACOLA) return "Coca Cola";
        else if(marca == MarcaRefrigerante.GUARANAANTARTICA) return "Guarana Antartica";
        else return "";
    }
}
