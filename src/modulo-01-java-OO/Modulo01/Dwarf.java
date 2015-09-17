public class Dwarf {
    private static int life;
   
    Dwarf (){
        life = 110;
    }    
    
    public static int getLife(){
        return life;
    }
    
    public static void recebeFlechada(){
        life -= 10;
    }    
}
    
