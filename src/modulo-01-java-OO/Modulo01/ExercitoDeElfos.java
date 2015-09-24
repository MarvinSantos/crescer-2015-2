import java.util.*;
import java.util.ArrayList;

public class ExercitoDeElfos
{
    
    private HashMap<String,Elfo> exercito = new HashMap<>();
    private HashMap<Status,ArrayList<Elfo> > agrupadosPorStatus = new HashMap<>();
    ArrayList<Elfo> listaDeElfos = new ArrayList<>();
    
    
    public ExercitoDeElfos(){    
    }    
    
    public void alistar(Elfo elfo){
        String nomeDoElfo = elfo.getNome();
        exercito.put(nomeDoElfo,elfo);
    }    
    
    public Elfo buscarElfoPeloNome(String nomeDoElfo){              
        return exercito.get(nomeDoElfo);
    }
    
    public HashMap getExercito(){
        return this.exercito;
    }    
    
    public void agruparPorStatus(Status status){
        //ESTE TRECHO DEVE SER MELHORADO
        agrupadosPorStatus.put(status,listaDeElfos);
        for(Map.Entry<String,Elfo > chave : this.exercito.entrySet()){
            if(chave.getValue().getStatus().equals(status)){              
                agrupadosPorStatus.get(status).add(chave.getValue());              
            }   
            
        }   
            
    }     
    
    public HashMap<Status,ArrayList<Elfo>> getElfosAgrupadosPorStatus(){
        return this.agrupadosPorStatus;
    } 
    
    public ArrayList<Elfo> buscar(Status status){ 
        agruparPorStatus(status);
        return this.agrupadosPorStatus.get(status);
    } 
    
   
}
