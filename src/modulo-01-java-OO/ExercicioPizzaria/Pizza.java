import java.util.*;

/**
 * Write a description of class Pizza here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Pizza extends Produto
{
    private ArrayList<String> sabores;
    private int maximoDeSabores;
    
    public Pizza(String nome, double preco, int maximoDeSabores){
        super(nome, preco);
        this.sabores = new ArrayList<>();
        this.maximoDeSabores = maximoDeSabores;
    }
    
    public void adicionarSabor(String sabor){
        
        if(this.sabores.size() < this.maximoDeSabores){
            this.sabores.add(sabor);
        }
    }
    
    public ArrayList<String> getSabores(){
        return this.sabores;
    }
    
    public String getDescricaoComprovante() {
        String desc = super.getDescricaoComprovante() + ", Sabores: ";
        int nrSabores = this.sabores.size();
        
        for(int i = 0; i < nrSabores; i++){
            desc += this.sabores.get(i);
            
            if(i + 1 < nrSabores) {
                desc += ", ";
            }
        }
        
        return desc;
    }
}
