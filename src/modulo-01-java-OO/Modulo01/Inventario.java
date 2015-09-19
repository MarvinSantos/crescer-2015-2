import java.util.ArrayList;

public class Inventario{

    ArrayList<Item> listaDeItens;
    
    public Inventario(){
        listaDeItens = new ArrayList<Item>();
    }    
    
    public void perderItem(Item item){
        this.listaDeItens.remove(item);
    }  
    
    public void adcionarItem(Item item){
        this.listaDeItens.add(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.listaDeItens;
    }  
}
