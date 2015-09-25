

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrcUrukHaiTest
{
    @Test
    public void atacandoElfoComEspada(){
        OrcUrukHai jhon = new OrcUrukHai("calr");
        Elfo elfo = new Elfo("legolas");
        int vidaElfoEsperada = 88;
        
        jhon.atacarElfo(elfo);
        
        assertEquals(vidaElfoEsperada, elfo.getVida());
    } 
    
    @Test
    public void orcTemEscudoDeUKRecebeAtaqueDoDwarfMorre(){
        OrcUrukHai orc = new OrcUrukHai("glem");
        int vidaEsperada = 0;
        Status statusEsperado = Status.MORTO;
        
        for(int i = 0; i < 30; i++){
            orc.receberAtaque();
        }
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(statusEsperado, orc.getStatus());
    } 
    
    @Test
    public void orcTemEscudoDeUKRecebeAtaqueDoDwarfEFicaCom144DeVida(){
        OrcUrukHai orc = new OrcUrukHai("jof");
        int vidaEsperada = 144;      
        
        orc.receberAtaque();
        
        assertEquals(vidaEsperada, orc.getVida());
        
    }  
         
    @Test
    public void recebendoAtaqueDoElfoEFicandoCom144DeVida(){
        OrcUrukHai orc = new OrcUrukHai("orqui");
        int vidaEsperada = 144;
        
        orc.receberAtaque();
        
        assertEquals(vidaEsperada, orc.getVida());
    } 
    
      @Test
    public void orcDoTipoUrukHaiNasceComEscudoEspadaE150DeVida(){
        OrcUrukHai orc = new OrcUrukHai("pedro");
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Espada",1));
        esperado.adicionarItem(new Item("Escudo Uruk-Hai",1));
        
        assertEquals(150,orc.getVida());       
        assertEquals(esperado,orc.getInventario());
    }  
    
          @Test
    public void orcUKRecebeAtaqueEMorre(){
        OrcUrukHai orc = new OrcUrukHai("rick");
        Status statusEsperado = Status.MORTO;
        
        for(int i = 0; i < 30; i++){
            orc.receberAtaque();
        }
        
        assertTrue(orc.getVida() <= 0);
        assertEquals(statusEsperado, orc.getStatus());
    }
    
       @Test
    public void orcDoTipoUrukHaiNasceComEscudoEspadaE150DeVidaMasDepoisPerdeAEspadaEGanhaUmArco(){
        OrcUrukHai orc = new OrcUrukHai("pedro");
        ElfoVerde elfoVerde = new ElfoVerde("robim");
        Item espada = new Item("Espada",1);
        Item arco = new Item("Arco",1);
        Item flecha = new Item("Flecha",1);
        orc.perderItem(espada);
        orc.adicionarItem(arco);
        orc.adicionarItem(flecha);
        orc.atacarElfo(elfoVerde);
        int vidaElfoEsperada = 92;
        
        assertEquals(vidaElfoEsperada,elfoVerde.getVida());       
        
    }
    
     @Test
    public void orcDoTipoUrukHaiNasceComEscudoMasPerdeEle(){
        OrcUrukHai orc = new OrcUrukHai("pedro");
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Espada",1));
        orc.perderItem(new Item("Escudo Uruk-Hai",1));
        
        assertEquals(150,orc.getVida());       
        assertEquals(esperado,orc.getInventario());
    }
    
      @Test
    public void orcDoTipoUrukHaiNasceComEscudoPerdeEleEToma10DeDanoDoElfo(){
        OrcUrukHai orc = new OrcUrukHai("pedro");
        Elfo elfo = new Elfo("jon");
        int orcVidaEsperada = 140;
        orc.perderItem(new Item("Escudo Uruk-Hai",1));
        elfo.atacarOrc(orc);
        
        assertEquals(orcVidaEsperada,orc.getVida());       
    }  
}
