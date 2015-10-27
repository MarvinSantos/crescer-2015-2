

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PizzaGrandeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PizzaTitanicTest
{
    @Test
    public void pizzaEstaComNomeCorreto(){
        PizzaTitanic p = new PizzaTitanic();
        assertEquals("Pizza Titanic", p.getNome());
    }
    
    @Test
    public void pizzaEstaComPrecoCorreto(){
        PizzaTitanic p = new PizzaTitanic();
        assertEquals(100, p.getPreco(), 0.01);
    }
    
    @Test
    public void pizzaTemSoDoisSabores(){
        PizzaTitanic p = new PizzaTitanic();
        p.adicionarSabor("Camarão");
        p.adicionarSabor("Frango");
        
        int countSabores = p.getSabores().size();
        
        assertEquals(2, countSabores);
    }
    
    @Test
    public void pizzaTemSoSeis(){
        PizzaTitanic p = new PizzaTitanic();
        p.adicionarSabor("Camarão1");
        p.adicionarSabor("Camarão2");
        p.adicionarSabor("Camarão3");
        p.adicionarSabor("Camarão4");
        p.adicionarSabor("Camarão5");
        p.adicionarSabor("Camarão6");
        p.adicionarSabor("Camarão7");
        
        int countSabores = p.getSabores().size();
        
        assertEquals(6, countSabores);
    }
}
