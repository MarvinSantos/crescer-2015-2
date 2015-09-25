

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class ExercitoDeElfosTest
{
   @Test
   public void exercitoCom5ElfosDeTiposVariados(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("ciclope");
       ElfoNoturno noturno3 = new ElfoNoturno("jean");     
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(noturno);
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       
       assertEquals(elfoVerde,exercitoElfo.getExercito().get("sortudo"));
       assertEquals(elfoVerde2,exercitoElfo.getExercito().get("azarado"));
       assertEquals(noturno,exercitoElfo.getExercito().get("kurt"));
       assertEquals(noturno2,exercitoElfo.getExercito().get("ciclope"));
       assertEquals(noturno3,exercitoElfo.getExercito().get("jean"));
    }
    
     @Test
   public void exercitoCom10ElfosDeTiposVariados(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoVerde elfoVerde3 = new ElfoVerde("gim");
       ElfoVerde elfoVerde4 = new ElfoVerde("dean");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("ciclope");
       ElfoNoturno noturno3 = new ElfoNoturno("jean");       
       ElfoNoturno noturno4 = new ElfoNoturno("sam");
       ElfoNoturno noturno5 = new ElfoNoturno("boby");
       ElfoNoturno noturno6 = new ElfoNoturno("castiel"); 
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(elfoVerde3);
       exercitoElfo.alistar(elfoVerde4);
       exercitoElfo.alistar(noturno);
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(noturno4);
       exercitoElfo.alistar(noturno5);
       exercitoElfo.alistar(noturno6);
       
       
       assertEquals(elfoVerde,exercitoElfo.getExercito().get("sortudo"));
       assertEquals(elfoVerde2,exercitoElfo.getExercito().get("azarado"));
       assertEquals(elfoVerde3,exercitoElfo.getExercito().get("gim"));
       assertEquals(elfoVerde4,exercitoElfo.getExercito().get("dean"));
       assertEquals(noturno,exercitoElfo.getExercito().get("kurt"));
       assertEquals(noturno2,exercitoElfo.getExercito().get("ciclope"));
       assertEquals(noturno3,exercitoElfo.getExercito().get("jean"));
       assertEquals(noturno4,exercitoElfo.getExercito().get("sam"));
       assertEquals(noturno5,exercitoElfo.getExercito().get("boby"));
       assertEquals(noturno6,exercitoElfo.getExercito().get("castiel"));
    } 
    
    @Test
    public void doisElfosMorremEEhChamadoOMetodoParaAgruparOsElfosMortos(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       OrcUrukHai orc = new OrcUrukHai("kaos");
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(noturno);
       
       for(int i = 0; i<10; i++){
           elfoVerde.recebeAtaqueDoOrc(orc);
           elfoVerde2.recebeAtaqueDoOrc(orc); 
        }
        
       exercitoElfo.agruparPorStatus();
       
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(elfoVerde));
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(elfoVerde2));
       
    } 
    
     @Test
    public void seisElfosMorremEEhChamadoOMetodoParaAgruparOsElfosMortos(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoVerde elfoVerde3 = new ElfoVerde("gim");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("nekogal");
       ElfoNoturno noturno3 = new ElfoNoturno("jean");       
       ElfoNoturno noturno4 = new ElfoNoturno("sam");
       OrcUrukHai orc = new OrcUrukHai("kaos");
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(elfoVerde3);
       exercitoElfo.alistar(noturno);
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(noturno4);
       
       for(int i = 0; i<10; i++){
           elfoVerde.recebeAtaqueDoOrc(orc);
           elfoVerde2.recebeAtaqueDoOrc(orc);
           elfoVerde3.recebeAtaqueDoOrc(orc); 
           noturno2.recebeAtaqueDoOrc(orc);
           noturno3.recebeAtaqueDoOrc(orc);
           noturno4.recebeAtaqueDoOrc(orc);
        }
        
       exercitoElfo.agruparPorStatus();
       
       assertTrue(exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).contains(elfoVerde));
       assertTrue(exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).contains(elfoVerde2));
       assertTrue(exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).contains(elfoVerde3));
       assertTrue(exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).contains(noturno2));
       assertTrue(exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).contains(noturno3));
       assertTrue(exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).contains(noturno4));
       
       exercitoElfo.agruparPorStatus();
       assertTrue(exercitoElfo.getElfosAgrupadosPorStatus().get(Status.VIVO).contains(noturno));
       
    }  
    
     @Test
   public void buscaElfoPorStatus(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
         
       assertTrue(exercitoElfo.buscar(Status.VIVO).contains(elfoVerde));
       
    }
    
   public void buscaElfoPorStatusMortoEOutroVivo(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       OrcUrukHai orc = new OrcUrukHai("kaos");
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(noturno);
       
       for(int i = 0; i<10; i++){
           elfoVerde.recebeAtaqueDoOrc(orc);
           elfoVerde2.recebeAtaqueDoOrc(orc); 
        }
       
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(elfoVerde));
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(elfoVerde2));
       assertTrue(exercitoElfo.buscar(Status.VIVO).contains(noturno));
   }  
   
    @Test
    public void seisElfosMorremEEhChamadoOMetodoParaBuscarAListaDeElfosMortos(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");
       ElfoVerde elfoVerde2 = new ElfoVerde("azarado");
       ElfoVerde elfoVerde3 = new ElfoVerde("loucao");
       ElfoNoturno noturno = new ElfoNoturno("kurt");
       ElfoNoturno noturno2 = new ElfoNoturno("nekogal");
       ElfoNoturno noturno3 = new ElfoNoturno("shimbalaiê");       
       ElfoNoturno noturno4 = new ElfoNoturno("alcemar");
       OrcUrukHai orc = new OrcUrukHai("kaos");
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
       exercitoElfo.alistar(elfoVerde2);
       exercitoElfo.alistar(elfoVerde3);
       exercitoElfo.alistar(noturno);
       exercitoElfo.alistar(noturno2);
       exercitoElfo.alistar(noturno3);
       exercitoElfo.alistar(noturno4);
       
       for(int i = 0; i<10; i++){
           elfoVerde.recebeAtaqueDoOrc(orc);
           elfoVerde2.recebeAtaqueDoOrc(orc);
           elfoVerde3.recebeAtaqueDoOrc(orc); 
           noturno2.recebeAtaqueDoOrc(orc);
           noturno3.recebeAtaqueDoOrc(orc);
           noturno4.recebeAtaqueDoOrc(orc);
        }
       
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(elfoVerde));
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(elfoVerde2));
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(elfoVerde3));
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(noturno2));
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(noturno3));
       assertTrue(exercitoElfo.buscar(Status.MORTO).contains(noturno4));
       assertTrue(exercitoElfo.buscar(Status.VIVO).contains(noturno));
       
    }  
    
   @Test
   public void oRetornoDaBuscaPorElfosMortosDeveSerNull(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
         
       assertNull(exercitoElfo.buscar(Status.MORTO));
       
    }
    
    @Test
   public void tentandoAlistarUmElfoNormal(){
       Elfo elfo = new Elfo("impostor");  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfo);
         
       assertNull(exercitoElfo.buscarElfoPeloNome("impostor"));
       
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
    
 
}
