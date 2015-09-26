

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class EstrategiaNoturnosPorUltimoTest
{
    @Test
    public void doisElfosVerdesAtacamPrimeiroQueONoturnos(){
       //arrange
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoNoturno noturno = new ElfoNoturno("jean"); 
       ArrayList<Elfo> ordemEsperada = new ArrayList<>(Arrays.asList(elfoVerde,elfoVerde2,noturno));  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(noturno); 
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
            
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       dwarves.add(anao1);
       dwarves.add(anao2);
       int vidaAnaoEsperada = 80;   
       //act
       exercitoElfo.mudarEstrategia(new EstrategiaNoturnosPorUltimo());
       exercitoElfo.atacar(exercitoElfo,dwarves);
       
       assertEquals(ordemEsperada,exercitoElfo.getEstrategia().getOrdemDeAtaque());  
       assertEquals(vidaAnaoEsperada, anao1.getVida());
    
    }
    
      @Test
    public void doisElfosVerdesAtacamPrimeiroQueOs3Noturnos(){
       //arrange
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoNoturno noturno = new ElfoNoturno("jean");
       ElfoNoturno noturno2 = new ElfoNoturno("jean2"); 
       ElfoNoturno noturno3 = new ElfoNoturno("jean3"); 
       ArrayList<Elfo> ordemEsperada = new ArrayList<>(Arrays.asList(elfoVerde,elfoVerde2,noturno,noturno3,noturno2));  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(noturno); 
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
            
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       dwarves.add(anao1);
       dwarves.add(anao2);
       int vidaAnaoEsperada = 60;   
       //act
       exercitoElfo.mudarEstrategia(new EstrategiaNoturnosPorUltimo());
       exercitoElfo.atacar(exercitoElfo,dwarves);
       
       assertEquals(ordemEsperada,exercitoElfo.getEstrategia().getOrdemDeAtaque());  
       assertEquals(vidaAnaoEsperada, anao1.getVida());
    
    }  
}
