import java.util.*;

public class EstrategiaAtaqueBalanceado implements EstrategiaDeAtaque{
    
    ArrayList<Elfo> ordemDeAtaque = new ArrayList<>();
    ArrayList<Elfo> elfosOrdenados = new ArrayList<>();
    
    public void atacar(ExercitoDeElfos exercito , ArrayList<Dwarf> dwarves){
        ordemDeAtaque.clear();
        elfosOrdenados.clear();
        ArrayList<Elfo> elfos = exercito.buscar(Status.VIVO);      
        int numeroElfosVerdes = 0 , numeroElfosNoturnos = 0;
        int tamanhoDaLista = elfos.size();
        Elfo ultimoAdicionado;     
        
        for(Elfo elfo : elfos){
            if(elfo instanceof ElfoVerde){
                numeroElfosVerdes++;
            }else{
                numeroElfosNoturnos++;
            }    
        }
        if(numeroElfosVerdes == numeroElfosNoturnos){ 
            ultimoAdicionado = elfos.get(0);
            do{
                for(int i = 0;tamanhoDaLista != 0; i ++){
                    if( i >= tamanhoDaLista){
                        i = 0;
                    }    
                    
                    if(elfos.get(i) instanceof ElfoVerde && ultimoAdicionado instanceof ElfoNoturno){
                        elfosOrdenados.add(elfos.get(i));
                        ultimoAdicionado = elfos.get(i);
                        elfos.remove(elfos.get(i));
                        tamanhoDaLista--;
                    }else if(elfos.get(i) instanceof ElfoNoturno && ultimoAdicionado instanceof ElfoVerde){
                        elfosOrdenados.add(elfos.get(i));
                        ultimoAdicionado = elfos.get(i);
                        elfos.remove(elfos.get(i));
                        tamanhoDaLista--;
                    }
                }    
            }while(tamanhoDaLista > 0);
            
            for(Elfo elfo : elfosOrdenados){
                ordemDeAtaque.add(elfo);
                for(Dwarf dwarf : dwarves){
                    elfo.atirarFlecha(dwarf);
                }    
            }    
        }  
    } 
    
    public ArrayList<Elfo> getOrdemDeAtaque(){
        return this.ordemDeAtaque;
    }    
    
    
}
