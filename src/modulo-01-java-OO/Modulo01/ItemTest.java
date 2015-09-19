

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ItemTest
{
    @Test
    public void itemCriadoComQuantidadeEDescricaoNaoNull(){
        Item poteDeMana = new Item("mana",5);
        
        assertNotNull(poteDeMana.getDescricao());
        assertNotNull(poteDeMana.getQuantidade());
    }
    
    @Test
    public void itemCriadoComQuantidade15EDescricaoArma(){
        Item arma = new Item("Arma",15);
        
        assertEquals("Arma",arma.getDescricao());
        assertEquals(15,arma.getQuantidade());
    }   
}
