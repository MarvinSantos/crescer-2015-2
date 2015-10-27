

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PizzaMediaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PizzaMediaTest
{
    @Test
    public void pizzaEstaComNomeCorreto(){
        PizzaMedia p = new PizzaMedia();
        assertEquals("Pizza Média", p.getNome());
    }
    
    @Test
    public void pizzaEstaComPrecoCorreto(){
        PizzaMedia p = new PizzaMedia();
        assertEquals(40, p.getPreco(), 0.01);
    }
    
    @Test
    public void pizzaTemSoDoisSabores(){
        PizzaMedia p = new PizzaMedia();
        p.adicionarSabor("Camarão");
        p.adicionarSabor("Frango");
        p.adicionarSabor("Carne");
        
        int countSabores = p.getSabores().size();
        
        assertEquals(2, countSabores);
    }
    
    @Test
    public void pizzaTEmSoUmSabor(){
        PizzaMedia p = new PizzaMedia();
        p.adicionarSabor("Camarão");
        
        int countSabores = p.getSabores().size();
        
        assertEquals(1, countSabores);
    }
}
