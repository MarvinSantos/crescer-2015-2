

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class EstrategiaNormalTest
{
   @Test
   public void oExercitoDeElfosAtacaEOsNoturnosSóAtacam2Vezes(){
       //Arrange
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("ciclope");
       ElfoNoturno noturno3 = new ElfoNoturno("jean"); 
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       int vidaAnaoEsperada = 90;
       ArrayList<Elfo> ordemAtaqueEsperada = new ArrayList<>(Arrays.asList(elfoVerde, noturno3));
       //act
       exercitoElfo.alistar(noturno);
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(elfoVerde);
       
       dwarves.add(anao1);
       dwarves.add(anao2);    
       
       exercitoElfo.atacar(exercitoElfo,dwarves);
       
       //assert
       assertEquals(vidaAnaoEsperada,anao1.getVida());              
       assertEquals(ordemAtaqueEsperada,exercitoElfo.getEstrategia().getOrdemDeAtaque());
       
       
    } 
    
    @Test
   public void oExercitoDeElfosAtacaUmaOrdaDeDwarfs2vezes(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoVerde elfoVerde3 = new ElfoVerde("gim2");
       ElfoVerde elfoVerde4 = new ElfoVerde("sortudo3");
       ElfoVerde elfoVerde5 = new ElfoVerde("azarado2");
       ElfoVerde elfoVerde6 = new ElfoVerde("gim");
       ElfoVerde elfoVerde7 = new ElfoVerde("sortudo2");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("ciclope");
       ElfoNoturno noturno3 = new ElfoNoturno("jean");       
    
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();

       exercitoElfo.alistar(noturno);
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(elfoVerde3);
       exercitoElfo.alistar(elfoVerde4);
       exercitoElfo.alistar(elfoVerde5);
       exercitoElfo.alistar(elfoVerde6);
       exercitoElfo.alistar(elfoVerde7);
      
       
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao1");
       Dwarf anao3 = new Dwarf("anao2");
       Dwarf anao4 = new Dwarf("anao3");
       
       int vidaAnaoEsperada = 0;
       
       dwarves.add(anao1);
       dwarves.add(anao2);
       dwarves.add(anao3);
       dwarves.add(anao4);
       
       exercitoElfo.atacar(exercitoElfo,dwarves);
       exercitoElfo.atacar(exercitoElfo,dwarves);
       
       assertEquals(vidaAnaoEsperada,anao1.getVida());      
       
       
    } 
    
    @Test
   public void oExercitoDeelfosAtacaUmaOrdaDeDwarfs(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoVerde elfoVerde3 = new ElfoVerde("gim2");
       ElfoVerde elfoVerde4 = new ElfoVerde("sortudo3");
       ElfoVerde elfoVerde5 = new ElfoVerde("azarado2");
       ElfoVerde elfoVerde6 = new ElfoVerde("gim");
       ElfoVerde elfoVerde7 = new ElfoVerde("sortudo2");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("ciclope");
       ElfoNoturno noturno3 = new ElfoNoturno("jean");       
    
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();

       exercitoElfo.alistar(noturno);
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(elfoVerde3);
       exercitoElfo.alistar(elfoVerde4);
       exercitoElfo.alistar(elfoVerde5);
       exercitoElfo.alistar(elfoVerde6);
       exercitoElfo.alistar(elfoVerde7);
      
       
       ArrayList<Dwarf> dwarves = new ArrayList<>();
       Dwarf anao1 = new Dwarf("anao");
       Dwarf anao2 = new Dwarf("anao");
       Dwarf anao3 = new Dwarf("anao");
       Dwarf anao4 = new Dwarf("anao");
       
       int vidaAnaoEsperada = 10;
       
       dwarves.add(anao1);
       dwarves.add(anao2);
       dwarves.add(anao3);
       dwarves.add(anao4);
       
       exercitoElfo.getEstrategia().atacar(exercitoElfo,dwarves);
       
       assertEquals(vidaAnaoEsperada,anao1.getVida());      
       
       
    } 
}
