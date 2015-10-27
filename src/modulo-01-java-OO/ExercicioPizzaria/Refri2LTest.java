

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Refri2LTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Refri2LTest
{
    @Test
    public void refriEstaComNomeCorreto(){
        Refri2L refri = new Refri2L(MarcaRefrigerante.PEPSI);
        
        assertEquals("Refri 2L", refri.getNome());
    }
    
    @Test
    public void refriEstaComPrecoCorreto(){
        Refri2L refri = new Refri2L(MarcaRefrigerante.PEPSI);
        
        assertEquals(7, refri.getPreco(), 0.01);
    }
    
    @Test
    public void refriEstaComMarcaPepsi(){
        Refri2L refri = new Refri2L(MarcaRefrigerante.PEPSI);
        
        assertEquals(MarcaRefrigerante.PEPSI, refri.getMarca());
    }
    
    @Test
    public void refriEstaComMarcaCocaCola(){
        Refri2L refri = new Refri2L(MarcaRefrigerante.COCACOLA);
        
        assertEquals(MarcaRefrigerante.COCACOLA, refri.getMarca());
    }
}
