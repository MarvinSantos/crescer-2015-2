

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrcTest
{
    @Test
    public void orcDoTipoUrukHaiNasceComEscudoEspeadaE150DeVida(){
        Orc orc = new Orc("Uruk-Hai");
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Espada",1));
        esperado.adicionarItem(new Item("Escudo Uruk-Hai",1));
        
        assertEquals(150,orc.getVida());       
        assertEquals(esperado,orc.getInventario());
    }  
    
    @Test
    public void orcDoTipoSnagaNasceComArcoFlechaE70DeVida(){
        Orc orc = new Orc("Snaga");
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Arco",1));
        esperado.adicionarItem(new Item("Flecha",5));
        
        assertEquals(70,orc.getVida());        
        assertEquals(esperado,orc.getInventario());
    } 
    
    @Test
    public void recebendoAtaqueDoElfoEFicandoCom142DeVida(){
        Orc orc = new Orc("Uruk-Hai");
        int vidaEsperada = 142;
        
        orc.receberAtaqueDeElfo();
        
        assertEquals(vidaEsperada, orc.getVida());
    } 
    
     @Test
    public void orcTemEscudoDeUKRecebeAtaqueDoDwarfEFicaCom145DeVida(){
        Orc orc = new Orc("Uruk-Hai");
        int vidaEsperada = 145;      
        
        orc.receberAtaqueDeDwarf();
        
        assertEquals(vidaEsperada, orc.getVida());
        
    }  
    
     @Test
    public void orcTemEscudoDeUKRecebeAtaqueDoDwarfMorre(){
        Orc orc = new Orc("Uruk-Hai");
        int vidaEsperada = 0;
        Status statusEsperado = Status.MORTO;
        
        for(int i = 0; i < 30; i++){
            orc.receberAtaqueDeDwarf();
        }
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(statusEsperado, orc.getStatus());
    } 
    
     @Test
    public void orcSnagaRecebeAtaqueDoElfoEMorre(){
        Orc orc = new Orc("Snaga");
        int vidaEsperada = -2;
        Status statusEsperado = Status.MORTO;
        
        for(int i = 0; i < 9; i++){
            orc.receberAtaqueDeElfo();
        }
        
        assertEquals(vidaEsperada, orc.getVida());
        assertEquals(statusEsperado, orc.getStatus());
    } 
    
       @Test
    public void atacandoElfoComEspada(){
        Orc orc = new Orc("Uruk-Hai");
        Elfo elfo = new Elfo("legolas");
        int vidaElfoEsperada = 68;
        
        orc.atacarElfo(elfo);
        
        assertEquals(vidaElfoEsperada, elfo.getVida());
    } 
    
    @Test
    public void orcMedrosoEstaFugindo(){
        Orc orc = new Orc("medroso");
        Dwarf dwarf = new Dwarf("dwarf");
        Status statusEsperadoAntesDoAct = Status.VIVO;
        Status statusEsperadoDepoisDoAct = Status.FUGINDO;
        assertEquals(statusEsperadoAntesDoAct,orc.getStatus());
        //act
        orc.atacarDwarf(dwarf);
        
        assertEquals(statusEsperadoDepoisDoAct,orc.getStatus());
        
        
    }    
}
