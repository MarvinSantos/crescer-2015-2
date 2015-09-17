public class Dwarf {
    private int life;
   
    Dwarf (){
        life = 110;
    }    
    
    public int getLife(){
        return life;
    }
    
    public void recebeFlechada(){
        life -= 10;
    }    
}
    
