

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest
{
    @Test
    public void elfoNasceCom42FlechasSeNaoIformadoAQuantidade(){
        Elfo elfo1 = new Elfo("legolas");
        assertEquals(42, elfo1.getFlechas());
    }
    
    @Test
    public void elfoNasceComZeroDeExperiencia(){
        Elfo elfo2 = new Elfo("legolas2");
        assertEquals(0, elfo2.getExperiencia());
    }
    
    @Test
    public void nomeDoElfoNaoNull(){
        Elfo elfo3 = new Elfo("legolas3");
        assertEquals(elfo3.getNome() != null, elfo3.getNome() != null);
    }
    
    @Test
    public void perdaDeFlechasDoElfoEPerdaDeVidaDoDwarf(){
        Elfo elfo4 = new Elfo("legolas4");
        Dwarf dwarf1 = new Dwarf();
        elfo4.atirarFlecha(dwarf1);
        assertEquals(10, elfo4.getExperiencia());
        assertEquals(41, elfo4.getFlechas());
        assertEquals(100, dwarf1.getLife());
    }
    
    
    
}
