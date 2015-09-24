import java.util.*;
import java.util.ArrayList;

public class ExercitoDeElfos
{
    
    private HashMap<String,Elfo> exercito = new HashMap<>();
    private HashMap<Status,ArrayList<Elfo> > agrupadosPorStatus = new HashMap<>();
        
    
    public ExercitoDeElfos(){    
    }    
    
    public void alistar(Elfo elfo){
        if(elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno){
            String nomeDoElfo = elfo.getNome();
            exercito.put(nomeDoElfo,elfo);
        }    
    } 
        
    
    public Elfo buscarElfoPeloNome(String nomeDoElfo){              
        return exercito.get(nomeDoElfo);
    }
    
    public HashMap getExercito(){
        return this.exercito;
    }    
    
    public void agruparPorStatus(){
        agrupadosPorStatus.clear();
        
        for(Map.Entry<String,Elfo > chave : this.exercito.entrySet()){
            Elfo elfo = chave.getValue();
            Status status = elfo.getStatus();
                      
            if(!agrupadosPorStatus.containsKey(status)){
                agrupadosPorStatus.put(status,new ArrayList<>(Arrays.asList(elfo)));
           }else{
               agrupadosPorStatus.get(status).add(elfo);
            }
        }   
            
    }  
    
    /*   */
    
    public HashMap<Status,ArrayList<Elfo>> getElfosAgrupadosPorStatus(){
        return this.agrupadosPorStatus;
    } 
    
    public ArrayList<Elfo> buscar(Status status){ 
        agruparPorStatus();
        return this.agrupadosPorStatus.get(status);
    } 
    
   
}
