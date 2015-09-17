public class Elfo{
    private String nome;
    private int flechas;
    private int experiencia;
    
    /*type initializer
     * {
     *     flechas = 42;
     *     }
     */
    
    public Elfo(String nome){
        this(nome,42);
    }     
    
    public Elfo(String nome, int flechas){
        this.nome = nome; 
        this.flechas = flechas;
        experiencia = 0;              
    }
    public String getNome(){
        return this.nome;
    }
    public int getExperiencia(){
        return this.experiencia;
    }    
    
    public int getFlechas(){
        return this.flechas;
    }    
       
    public void atirarFlecha(Dwarf dwarf){
        flechas--;
        dwarf.recebeFlechada();
        experiencia++;
           
    }
    
    public String toString(){
        return this.nome + " possui " + this.flechas + " flechas e " + this.experiencia + " niveis de experiencia" ;
    }    
        
    
    
    
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