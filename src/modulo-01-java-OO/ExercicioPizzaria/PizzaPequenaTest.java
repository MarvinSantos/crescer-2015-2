

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PizzaPequenaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PizzaPequenaTest
{
    @Test
    public void pizzaEstaComNomeCorreto(){
        PizzaPequena p = new PizzaPequena();
        assertEquals("Pizza Pequena", p.getNome());
    }
    
    @Test
    public void pizzaEstaComPrecoCorreto(){
        PizzaPequena p = new PizzaPequena();
        assertEquals(20, p.getPreco(), 0.01);
    }
    
    @Test
    public void pizzaSoTemUmSabor(){
        PizzaPequena p = new PizzaPequena();
        p.adicionarSabor("Camarão");
        p.adicionarSabor("Frango");
        
        int countSabores = p.getSabores().size();
        
        assertEquals(1, countSabores);
    }
}
