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
        //variavel que serve pra guardar o item que vai ser realocado em outro lugar
        Item reservatorio;
        for(int x = 0; x < this.listaDeItens.size(); x++){
            for(int i = 0; i < this.listaDeItens.size(); i++){
                /* se a quantidade do item que varia de acordo com o indice "i" for menor do que a quantidade do item que tem o indice fixo(x)
                entao o "reservatorio" recebe o item do indice fixo(x) para não perdelo, e o item que tem o indice
                variando(i) toma o lugar do item que tem o indice fixo(x), depois o "reservatorio" coloca o item de indice fixo(x)
                no lugar onde estava o item com indice variando(i)*/
                /* em outras palavras, quando a quantidade do que esta em (i) é menor que a do que esta em (x) , o com a quantidade maior vai pra uma gaveta
                   separada para dar lugar ao que tem quantidade menor, depois o que esta na gaveta vai para o lugar onde estava o com
                   quantidade menor */
               
                if(this.listaDeItens.get(x).getQuantidade() < this.listaDeItens.get(i).getQuantidade()){
                    //carregador recebeu o que esta fixo
                    reservatorio = this.listaDeItens.get(x);
                    //o lugar do que esta fixo recebe o que esta variando
                    this.listaDeItens.set(x,this.listaDeItens.get(i));                   
                    //o lugar no indice que esta variando recebe o item dentro de "resrvatorio" que era o que estava fixo
                    this.listaDeItens.set(i,reservatorio);
                }    
            }    
        }    
    }
    
     public boolean equals(int valor){
       int valorEsperado = valor;
       
       return this.listaDeItens.get(0).getQuantidade() == valorEsperado;
   }   
}
