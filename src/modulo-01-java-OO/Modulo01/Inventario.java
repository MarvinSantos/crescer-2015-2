import java.util.ArrayList;

public class Inventario{

    ArrayList<Item> listaDeItens;
    
    public Inventario(){
        listaDeItens = new ArrayList<Item>();
    }    
    
    public void perderItem(Item item){
        this.listaDeItens.remove(item);
    }  
    
    public void adicionarItem(Item item){
        this.listaDeItens.add(item);
    }
    
    public ArrayList<Item> getItens(){
        return this.listaDeItens;
    }
    
    public void quantidadeAumentaEm1000(){
        for(int i = 0; i < listaDeItens.size(); i++){
            listaDeItens.get(i).quantidadeRecebeMaisMil();
        }    
    }  
    
     public void quantidadeAumentaEmMilESoma3VezesAAual(){
        for(int i = 0; i < listaDeItens.size(); i++){
            listaDeItens.get(i).quantidadeRecebeMais2VezesEMaisMil();
        }    
    } 
    
    public String getDescricaoItens(){
        
        String itensNoInventario = "";
        
        for(int i = 0; i < listaDeItens.size(); i++){
            itensNoInventario += listaDeItens.get(i).getDescricao();
            if( i < listaDeItens.size() -1){
                itensNoInventario += ",";
            }  
        }
        return itensNoInventario;
    }
    
    public Item getItemComMaiorQuantidade(){
        Item itemMaiorQuantidade = this.getItens().get(0);
        int quantidadeMaior =itemMaiorQuantidade.getQuantidade();
        
        for(int i = 1; i < this.getItens().size() ; i++){
            if(this.getItens().get(i).getQuantidade() > quantidadeMaior){
                quantidadeMaior = this.getItens().get(i).getQuantidade();
                itemMaiorQuantidade = this.getItens().get(i); 
            }    
        }
        return itemMaiorQuantidade;
    }
    
    public void ordenarItens(){
        Item reservatorio;
        for(int x = 0; x < this.listaDeItens.size(); x++){
            
            for(int i = 0; i < this.listaDeItens.size(); i++){
               
                if(this.listaDeItens.get(x).getQuantidade() < this.listaDeItens.get(i).getQuantidade()){
             
                    reservatorio = this.listaDeItens.get(i);                    
                    this.listaDeItens.set(i,this.listaDeItens.get(x));                                     
                    this.listaDeItens.set(x,reservatorio);
                }    
            }    
        }    
    }
    
    public boolean equals(Object obj){
       Inventario mochila = (Inventario)obj;
       
       return this.listaDeItens.equals(mochila.getItens());
    }  
    
     public void diminuirQuantidadeItem(Item item, int unidadesParaPerder){
       item.diminuirQuantidade(unidadesParaPerder);                  
    }    
}
