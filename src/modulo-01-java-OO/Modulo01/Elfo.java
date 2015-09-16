public class Elfo{
    private String nome;
    private int flechas = 42;
    private int experiencia = 0;
    
    Elfo(String n, int flech){
        nome = n; 
        if(flech == 0) {
            flechas = flech;
        }        
    }
    
    public void atirarFlecha(){
        experiencia += 10;
        flechas--;
    }   
}   