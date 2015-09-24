

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
        
       exercitoElfo.agruparPorStatus(Status.MORTO);
       
       assertEquals(elfoVerde, exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).get(0));
       assertEquals(elfoVerde2, exercitoElfo.getElfosAgrupadosPorStatus().get(Status.MORTO).get(1));
       
    } 
    
    /* @Test
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
        
       exercitoElfo.agruparPorStatus(Status.MORTO);
       
       assertEquals(elfoVerde, exercitoElfo.getElfosAgrupadosPorStatus().get(0));
       assertEquals(elfoVerde2, exercitoElfo.getElfosAgrupadosPorStatus().get(1));
       assertEquals(elfoVerde3, exercitoElfo.getElfosAgrupadosPorStatus().get(2));
       assertEquals(noturno2, exercitoElfo.getElfosAgrupadosPorStatus().get(3));
       assertEquals(noturno3, exercitoElfo.getElfosAgrupadosPorStatus().get(4));
       assertEquals(noturno4, exercitoElfo.getElfosAgrupadosPorStatus().get(5));
       
    }  */
    
     @Test
   public void buscaElfoPorStatus(){
       ElfoVerde elfoVerde = new ElfoVerde("sortudo");  
       ExercitoDeElfos exercitoElfo = new ExercitoDeElfos();
       exercitoElfo.alistar(elfoVerde);
         
       assertEquals(elfoVerde,exercitoElfo.buscar(Status.VIVO).get(0));
       
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
       
       assertEquals(elfoVerde, exercitoElfo.buscar(Status.MORTO ).get(0));
       assertEquals(elfoVerde2, exercitoElfo.buscar(Status.MORTO ).get(1));
       assertEquals(noturno, exercitoElfo.buscar(Status.VIVO ).get(0));
   }  
   
   /* @Test
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
       
       assertEquals(elfoVerde, exercitoElfo.buscar(Status.MORTO).get(0));
       assertEquals(elfoVerde2, exercitoElfo.buscar(Status.MORTO).get(1));
       assertEquals(elfoVerde3, exercitoElfo.buscar(Status.MORTO).get(2));
       assertEquals(noturno2, exercitoElfo.buscar(Status.MORTO).get(3));
       assertEquals(noturno3, exercitoElfo.buscar(Status.MORTO).get(4));
       assertEquals(noturno4, exercitoElfo.buscar(Status.MORTO).get(5));
       
    }  */
}
