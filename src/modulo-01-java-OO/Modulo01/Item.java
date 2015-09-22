

public class Item
{
    private String descricao;
    private int quantidade;
    
    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void quantidadeRecebeMaisMil(){
        this.quantidade += 1000;
    } 
    
    public void quantidadeRecebeMais2VezesEMaisMil(){         
        int soma = 0;
        for (int i= this.quantidade ; i >= 1; i--){
            soma += i;
        }
         
        this.quantidade += soma*1000;
    }
    
    public void diminuirQuantidade(int quantidade){
        this.quantidade -= quantidade;
    }    
    
    
    
    /* 
    public void shimbalaie() {
    int pa = this.quantidade * (this.quantidade +1) / 2;
    this.quantidade += 1000 * pa;
   } */
    
   public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
   }
}
