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
    
    public String getDescricaoItens(){
        
        String itensNoInventario = "";
        
        for(int i = 0; i < listaDeItens.size(); i++){
            itensNoInventario += listaDeItens.get(i).getDescricao();
            if( i < listaDeItens.size() -1){
                itensNoInventario += ", ";
            }
            if(i == listaDeItens.size() -1){
                itensNoInventario += ".";
            }    
        }
        return itensNoInventario;
    }
    
    public Item getItemComMaiorQuantidade(){
        Item itemMaiorQuantidade = this.getItens().get(0);
        int quantidadeMaior =this.getItens().get(0).getQuantidade();
        
        for(int i = 0; i < this.getItens().size(); i++){
            if(this.getItens().get(i).getQuantidade() > quantidadeMaior){
                quantidadeMaior = this.getItens().get(i).getQuantidade();
                itemMaiorQuantidade = this.getItens().get(i); 
            }    
        }
        return itemMaiorQuantidade;
    }    
}
