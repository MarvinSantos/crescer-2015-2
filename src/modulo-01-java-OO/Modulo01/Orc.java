public class Orc extends Personagem
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
  
 
    public Orc(String nome){
       super(nome);
    }
    
    public void receberAtaque() {
        
       boolean temEscudo = verificaSeTemEscudo(); 
       
       if(status != Status.MORTO){
            if(temEscudo) {
                vida -= 6; 
                verificarSeMorreu();
            }else{
                vida -= 10;
                verificarSeMorreu();
            }
        
       }
    }
    
    public void atacarDwarf(Dwarf dwarf) {
          dwarf.recebeAtaqueDoOrc(this);    
          if(getDanoDeAtaque() == 8){             
              this.mochila.diminuirQuantidadeItem(this.mochila.buscarItemPorDescricao("Flecha"),1);  
          }  
          
    }
    
    public void atacarElfo(Elfo elfo) {
          elfo.recebeAtaqueDoOrc(this); 
          if(getDanoDeAtaque() == 8){             
              Item itemASerDebitado = this.mochila.buscarItemPorDescricao("Flecha");
              this.mochila.diminuirQuantidadeItem(itemASerDebitado,1);  
          }  
          
    }
    
    public void atacar(Personagem personagem) {
          personagem.recebeAtaqueDoOrc(this); 
          if(getDanoDeAtaque() == 8){             
              Item itemASerDebitado = this.mochila.buscarItemPorDescricao("Flecha");
              this.mochila.diminuirQuantidadeItem(itemASerDebitado,1);  
          }  
          
    }
    
    public boolean verificaSeTemEspada(){
        if(this.mochila.buscarItemPorDescricao("Espada") != null){
            return true;
        }else{
            return false;
        } 
    } 
    
    public boolean verificaSeTemEscudo(){
      
        if(this.mochila.buscarItemPorDescricao("Escudo Uruk-Hai") != null){
            return true;
        }else{
            return false;
        } 
    }
    public boolean verificaSeTemArco(){
        if(this.mochila.buscarItemPorDescricao("Arco").getQuantidade() > 0){
            return true;
        }else{
            return false;
        } 
    }  
    
     public boolean verificaSeTemFlecha(){
        if(this.mochila.buscarItemPorDescricao("Flecha").getQuantidade() > 0){
            return true;
        }else{
            return false;
        } 
    }
    
     public int getVida(){
        return this.vida;
    }
    
     public Inventario getInventario() {
        return this.mochila;
    }
    
    public void verificarSeMorreu(){
        if(this.vida <= 0 && status == Status.VIVO){
            status = Status.MORTO;
        }    
    }
    
    public Status getStatus(){
        return this.status;
    }    
    
     public int getDanoDeAtaque(){
        if(verificaSeTemEspada()){
            return 12;
        } else 
        if(verificaSeTemFlecha() && verificaSeTemArco()){
            return 8;
        }else{
            status = status.FUGINDO;
            return 0;
        }   
    }
    
    public void tentarSorte(){}
    
}
