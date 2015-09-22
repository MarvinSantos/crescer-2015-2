

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
    public void orcTemEscudoDeUKrecebeAtaqueDoDwarfEFicaCom145DeVida(){
        Orc orc = new Orc("Uruk-Hai");
        int vidaEsperada = 145;
        
        orc.receberAtaqueDeDwarf();
        
        assertEquals(vidaEsperada, orc.getVida());
    }    
}
