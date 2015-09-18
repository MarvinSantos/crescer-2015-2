import java.util.ArrayList;

public class Inventario{

    ArrayList<Item> listaDeItens = new ArrayList<Item>();
    
    public Inventario(Item item){
        listaDeItens.add(item);
    }
    
    public void perderItem(int indice){
        listaDeItens.remove(indice);
    }  
    
    public void adcionarItem(Item item){
        listaDeItens.add(item);
    }    
}
