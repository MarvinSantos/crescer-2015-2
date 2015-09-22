public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected int vida;
    
    protected Inventario mochila = new Inventario();
    protected Status statusOrc;
    protected String tipoDeOrc;
    protected Item flecha;
    protected Item arco;
    protected Item escudoUk;
    protected Item espada;

 
    public Orc(String tipoDeOrc)
    {
        statusOrc = Status.VIVO;
        this.tipoDeOrc = tipoDeOrc;
        if(tipoDeOrc == "Uruk-Hai"){
            espada = new Item("Espada",1);
            escudoUk = new Item("Escudo Uruk-Hai",1);
            mochila.adicionarItem(espada);
            mochila.adicionarItem(escudoUk);
            this.vida = 150;
        }else if(tipoDeOrc == "Snaga"){
               arco = new Item("Arco",1);
               flecha = new Item("Flecha",5);
               mochila.adicionarItem(arco);
               mochila.adicionarItem(flecha);
               this.vida = 70;
        }   
    }
    
    public void receberAtaqueDeElfo() {
       if(statusOrc == Status.VIVO){
        vida -= 8;
        verificarSeMorreu();
       }
    }
    
    public void receberAtaqueDeDwarf() {
        
       boolean temEscudo = verificaSeTemEscudo(); 
       
       if(statusOrc == Status.VIVO){
            if(temEscudo) {
                vida -= 5;               
            }else{
                vida -= 10;
            }
        
       }
    }
    
    public void atacarDwarf(Dwarf dwarf) {
        boolean temEspada = verificaSeTemEspada();
        boolean temFlecha = verificaSeTemFlecha();
        boolean temArco = verificaSeTemArco();
        if (temEspada){
          dwarf.recebeFlechada(12);
        }else if (temFlecha && temArco){
          dwarf.recebeFlechada(8);
          this.mochila.diminuirQuantidadeItem(flecha,1);
        }
    }
    
    public void atacarElfo(Elfo elfo) {
        boolean temEspada = verificaSeTemEspada();
        boolean temFlecha = verificaSeTemFlecha();
        boolean temArco = verificaSeTemArco();
        if (temEspada){
          elfo.recebeAtaque(12);
        }else if (temFlecha && temArco){
          elfo.recebeAtaque(8);
          this.mochila.diminuirQuantidadeItem(flecha,1);
        }
    }
    
    
    
    public boolean verificaSeTemEspada(){
        boolean temEspada = false;
         for(Item item : this.mochila.getItens()){
            if (item.getDescricao() == "Espada" && item.getQuantidade() > 0){
                temEspada = true;
            }
        }
        return temEspada;
    } 
        
    public boolean verificaSeTemEscudo(){
        boolean temEscudo =false;
         for(Item item : this.mochila.getItens()){
            if (item.getDescricao() == "Escudo Uruk-Hai" && item.getQuantidade() > 0){
                temEscudo = true;
            }
        }
        return temEscudo;
    }
    public boolean verificaSeTemArco(){
        boolean temArco=false;
         for(Item item : this.mochila.getItens()){
            if (item.getDescricao() == "Arco" && item.getQuantidade() > 0){
                temArco = true;
            }
        }
        return temArco;
    }  
    
     public boolean verificaSeTemFlecha(){
         boolean temFlecha=false;
         for(Item item : this.mochila.getItens()){
            if (item.getDescricao() == "Flecha" && item.getQuantidade() > 0){
                temFlecha = true;
            }
        }
        return temFlecha;
    }
    
     public int getVida(){
        return this.vida;
    }
    
     public Inventario getInventario() {
        return this.mochila;
    }
    
    public void verificarSeMorreu(){
        if(this.vida <= 0 && statusOrc == Status.VIVO){
            statusOrc = Status.MORTO;
        }    
    }
    
}
