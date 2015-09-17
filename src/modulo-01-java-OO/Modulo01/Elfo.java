public class Elfo{
    private String nome;
    private static int flechas;
    private static int experiencia;
    
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
    public static int getExperiencia(){
        return experiencia;
    }    
    
    public static int getFlechas(){
        return flechas;
    }    
       
    public void atirarFlecha(Dwarf dwarf){
        flechas--;
        dwarf.recebeFlechada();
        experiencia += 10;
           
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