public class Elfo extends Personagem{
    protected int flechas;
    
 
    /*type initializer
     * {
     *     flechas = 42;
     *     }
     */
    
    public Elfo(String nome){
        this(nome,42);
    }     
      
    public Elfo(String nome, int flechas){
        super( nome);
        this.vida = 100;
        this.flechas = flechas;
    }     
    
    public int getFlechas(){
        return this.flechas;
    }    
    
    public void atirarFlecha(Dwarf dwarf){
        
        flechas--;
        dwarf.recebeFlechada();
        experiencia++;
           
    }
        
    public void atacarOrc(Orc orc){
        flechas--;
        orc.receberAtaque();
        this.experiencia++;
    }    
    
    public void recebeAtaqueDoOrc(Orc orc){
        if(this.status == Status.VIVO){      
           this.vida -= orc.getDanoDeAtaque();
           verificarSeMorreu();
        }         
    }    
    
    public String toString(){
        
        boolean ehSingular = Math.abs(this.flechas) == 1;
        String textoDeFlechas = ehSingular ? "flecha" : "flechas" ;
            
        boolean nivelNoSingular = Math.abs(this.experiencia) == 1;
        String textoNiveis = nivelNoSingular ? "nivel" : "niveis";  
       
         
        return String.format("%s possui %d %s e %d %s de experiência.",
        this.nome,
        this.flechas,
        textoDeFlechas,
        this.experiencia,
        textoNiveis);
    }    
    
    public void verificarSeMorreu(){
        if(this.vida <= 0 && status == Status.VIVO){
            status = Status.MORTO;
        }    
    }
    
    //ruby ou coffeScript;
    // #{nome} #{textoFlecha}
    //interpolação de string
    
    //c#
    // \{nome}
   
           
     /* 
      public Elfo(String nome, Integer flechas) {
         this(nome);
         if (flechas != null) {
             this.flechas = flechas;
         }
      }
+    */ 

    /*
     public void atirarFlechaRefactory(){
+            boolean acertar = true;
+            if (acertar) {
+                experiencia++;
+            }
+            flechas--;
         }
     */    
}   