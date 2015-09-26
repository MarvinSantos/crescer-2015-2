

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaAtaqueBalanceadoTest
{
    
    @Test
    public void doisElfosVerdesE2NoturnosAtacamComEstrategiaBalanceada(){
       //arrange
       ElfoVerde elfoVerde = new ElfoVerde("verde1");
       ElfoVerde elfoVerde2 = new ElfoVerde("verde2");
       ElfoNoturno noturno = new ElfoNoturno("noturno1");
       ElfoNoturno noturno2 = new ElfoNoturno("noturno2"); 
       ArrayList<Elfo> ordemEsperada = new ArrayList<>(Arrays.asList(elfoVerde,noturno2,elfoVerde2,noturno));  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(noturno); 
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
            
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       dwarves.add(anao1);
       dwarves.add(anao2);
       int vidaAnaoEsperada = 70;   
       //act
       exercitoElfo.mudarEstrategia(new EstrategiaAtaqueBalanceado());
       exercitoElfo.atacar(exercitoElfo,dwarves);
       
       assertEquals(ordemEsperada,exercitoElfo.getEstrategia().getOrdemDeAtaque());  
       assertEquals(vidaAnaoEsperada, anao1.getVida());
    
    } 
    
    @Test
    public void doisElfosVerdesE3NoturnosTentamUtilizarEstrategiaBalanceadaMasNaoPodem(){
       //arrange
       ElfoVerde elfoVerde = new ElfoVerde("verde1");
       ElfoVerde elfoVerde2 = new ElfoVerde("verde2");
       ElfoNoturno noturno = new ElfoNoturno("noturno1");
       ElfoNoturno noturno2 = new ElfoNoturno("noturno2"); 
       ElfoNoturno noturno3 = new ElfoNoturno("noturno3"); 
       ArrayList<Elfo> ordemEsperada = new ArrayList<>();  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(noturno); 
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(noturno3);
            
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       dwarves.add(anao1);
       dwarves.add(anao2);
       int vidaAnaoEsperada = 110;   
       //act
       exercitoElfo.mudarEstrategia(new EstrategiaAtaqueBalanceado());
       exercitoElfo.atacar(exercitoElfo,dwarves);
       
       assertEquals(ordemEsperada,exercitoElfo.getEstrategia().getOrdemDeAtaque());  
       assertEquals(vidaAnaoEsperada, anao1.getVida());
    
    } 
    
    @Test
    public void quatroElfosVerdesE4NoturnosUtilizamAEstrategiaBalanceada(){
       //arrange
       ElfoVerde elfoVerde = new ElfoVerde("verde1");
       ElfoVerde elfoVerde2 = new ElfoVerde("verde2");
       ElfoVerde elfoVerde3 = new ElfoVerde("verde3");
       ElfoVerde elfoVerde4 = new ElfoVerde("verde4");
       ElfoNoturno noturno = new ElfoNoturno("noturno1");
       ElfoNoturno noturno2 = new ElfoNoturno("noturno2"); 
       ElfoNoturno noturno3 = new ElfoNoturno("noturno3");
       ElfoNoturno noturno4 = new ElfoNoturno("noturno4"); 
       ArrayList<Elfo> ordemEsperada = new ArrayList<>(Arrays.asList(noturno2,elfoVerde,noturno4,elfoVerde4,noturno3,elfoVerde2,noturno,elfoVerde3));  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(noturno); 
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(elfoVerde3);
       exercitoElfo.alistar(elfoVerde4);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(noturno4);
            
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       dwarves.add(anao1);
       dwarves.add(anao2);
       int vidaAnaoEsperada = 30;   
       //act
       exercitoElfo.mudarEstrategia(new EstrategiaAtaqueBalanceado());
       exercitoElfo.atacar(exercitoElfo,dwarves);
       
       assertEquals(ordemEsperada,exercitoElfo.getEstrategia().getOrdemDeAtaque());  
       assertEquals(vidaAnaoEsperada, anao1.getVida());
    
    } 
}
