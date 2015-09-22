
public class ElfoVerde extends Elfo
{
   public ElfoVerde(String nome){
        super(nome);
   }    
    
   public void atirarFlecha(Dwarf dwarf){
        super.atirarFlecha(dwarf);
        this.experiencia++;           
    }
    
   public void adicionarItem(Item item){
       boolean podeAdicionar = 
            item != null &&
            (item.getDescricao().equals("Espada de aço valiriano")
            ||
            item.getDescricao().equals("Arco e Flecha de Vidro"));
            
            if(podeAdicionar){
                super.adicionarItem(item);
            }    
   }    
    
}
