public class Dwarf {
    private int life;
    private String nome;
    private int experiencia;
    private Status statusDwarf;
   
    Dwarf (String nome){
        this.nome = nome;
        this.experiencia = 0;
        this.life = 110;        
        statusDwarf = Status.VIVO;
    }    
    
    public int getLife(){
        return life;
    }
    
    public String getNome(){
        return this.nome;
    }    
    
    public void recebeFlechada(){
        life -= 10;
        checarStatusDwarf();
    } 
    
    public int getExperiencia(){
        return this.experiencia;
    }    
    
    public Status getStatus(){
        return statusDwarf;
    
    }
    
    public void checarStatusDwarf(){
        if(this.life == 0){
            statusDwarf = Status.MORTO;
         } 
    }     
}
    
