public class Elfo{
    private String nome;
    private int flechas;
    private int experiencia = 0;
    
    public Elfo(String n){
        nome = n;
        flechas = 42;
    }     
    
    public Elfo(String n, int flech){
        nome = n; 
        flechas = flech;
               
    }
    
    public void atirarFlecha(){
        experiencia += 10;
        flechas--;
    }   
}   