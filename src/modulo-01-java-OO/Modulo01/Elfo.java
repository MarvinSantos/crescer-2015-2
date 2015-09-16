public class Elfo{
    private String nome;
    private int flechas;
    private int experiencia;
    
    public Elfo(String n){
        nome = n;
        flechas = 42;
        experiencia = 0;
    }     
    
    public Elfo(String n, int flech){
        nome = n; 
        flechas = flech;
        experiencia = 0;
               
    }
    
    public boolean atingido(){
        return true;
    }    
    
    public void atirarFlechaRefactory(){
    this.flechas--;
    
    if(atingido() == true){
        this.experiencia += 10;
    }
    }   
}   