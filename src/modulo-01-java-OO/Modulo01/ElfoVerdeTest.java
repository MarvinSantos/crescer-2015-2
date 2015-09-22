

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{   
    @Test
    public void elfoVerdeAtacaDwarf(){
        ElfoVerde arrow = new ElfoVerde("arrow");
        Dwarf anao = new Dwarf("anao");
        arrow.atirarFlecha(anao);
        
        assertEquals(2, arrow.getExperiencia());
    }  
    
     @Test
    public void elfoVerdeAtacaDwarfEIrishDwarf(){
        ElfoVerde arrow = new ElfoVerde("arrow");
        Dwarf anao = new Dwarf("anao");
        arrow.atirarFlecha(anao);
        
        assertEquals(2, arrow.getExperiencia());
    }
    
     @Test
    public void elfoVerdeTemEspadaValiriada(){
        ElfoVerde arrow = new ElfoVerde("arrow");
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Espada de aço valiriano",1));
        arrow.adicionarItem(new Item("Espada de aço valiriano",1));
        
        assertEquals(esperado, arrow.getInventario());
    }
}
