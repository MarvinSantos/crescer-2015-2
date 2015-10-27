

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class RefriLataTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RefriLataTest
{
    @Test
    public void refriEstaComNomeCorreto(){
        RefriLata refri = new RefriLata(MarcaRefrigerante.PEPSI);
        
        assertEquals("Refri Lata", refri.getNome());
    }
    
    @Test
    public void refriEstaComPrecoCorreto(){
        RefriLata refri = new RefriLata(MarcaRefrigerante.PEPSI);
        
        assertEquals(3.5, refri.getPreco(), 0.01);
    }
    
    @Test
    public void refriEstaComMarcaPepsi(){
        RefriLata refri = new RefriLata(MarcaRefrigerante.PEPSI);
        
        assertEquals(MarcaRefrigerante.PEPSI, refri.getMarca());
    }
    
    @Test
    public void refriEstaComMarcaCocaCola(){
        RefriLata refri = new RefriLata(MarcaRefrigerante.COCACOLA);
        
        assertEquals(MarcaRefrigerante.COCACOLA, refri.getMarca());
    }
}
