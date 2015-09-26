import java.util.ArrayList;

public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque{
    ArrayList<Elfo> ordemDeAtaque = new ArrayList<>();
    
    public void atacar(ExercitoDeElfos exercito , ArrayList<Dwarf> dwarves){
        ordemDeAtaque.clear();
        ArrayList<Elfo> elfos = exercito.buscar(Status.VIVO);
        ArrayList<Elfo> elfosOrdenados = new ArrayList<>();
        
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoVerde){
                elfosOrdenados.add(elfo);
            }    
        } 
        
         for(Elfo elfo : elfos){
            if(elfo instanceof ElfoNoturno){
                elfosOrdenados.add(elfo);
            }    
        }             
               
         for(Elfo elfo : elfosOrdenados){
             
            ordemDeAtaque.add(elfo);                       
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);                   
            }  
        }    
        
    } 
    
    public ArrayList<Elfo> getOrdemDeAtaque(){
        return this.ordemDeAtaque;
    }    
    
}
