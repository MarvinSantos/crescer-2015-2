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
    
      
    
    public void atirarFlechaRefactory(){
    flechas--;
    boolean acertar = true;
    
    if(acertar){
        experiencia += 10;
    }
    }   
}   