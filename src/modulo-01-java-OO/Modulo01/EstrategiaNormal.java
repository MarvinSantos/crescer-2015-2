import java.util.ArrayList;

//C#
//public class EstrategiaNormal : EstrategiaDeAtaque 
public class EstrategiaNormal implements EstrategiaDeAtaque {
    ArrayList<Elfo> ordemDeAtaque = new ArrayList<>();
    
    
    public void atacar(ExercitoDeElfos exercito , ArrayList<Dwarf> dwarves){
        ordemDeAtaque.clear();
        ArrayList<Elfo> elfos = exercito.buscar(Status.VIVO);
        
        int tamanhoDoPelotaoElfos = elfos.size();
        int tamanhoDaOrdaDwarves = dwarves.size();
        int intencoesDeAtaque = tamanhoDoPelotaoElfos * tamanhoDaOrdaDwarves;
        double trintaPorcentoDasIntencoes = intencoesDeAtaque * 0.3;
        trintaPorcentoDasIntencoes = Math.floor(trintaPorcentoDasIntencoes);
        int contadorDeAtaquesDeNoturno = 0;
        
        
        
         for(Elfo elfo : elfos){
             
             if((elfo instanceof ElfoNoturno && contadorDeAtaquesDeNoturno < trintaPorcentoDasIntencoes) || elfo instanceof ElfoVerde){  
                   ordemDeAtaque.add(elfo);
             }
           
             for(Dwarf dwarf : dwarves){
               if(elfo instanceof ElfoNoturno && contadorDeAtaquesDeNoturno < trintaPorcentoDasIntencoes){  
                   elfo.atirarFlecha(dwarf);
                   contadorDeAtaquesDeNoturno++;
               }else if(elfo instanceof ElfoVerde){
                   elfo.atirarFlecha(dwarf);
                }    
               
            }  
        }    
        
    }    
    
    public ArrayList<Elfo> getOrdemDeAtaque(){
        return this.ordemDeAtaque;
    }    
}
