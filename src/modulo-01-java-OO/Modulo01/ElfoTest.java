

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
    
    @Test
    public void doisElfosAtirandoEm1Dwarf(){
        Elfo elfo5 = new Elfo("legolas5");
        Elfo elfo6 = new Elfo("legolas6");
        Dwarf dwarf2 = new Dwarf();
        elfo5.atirarFlecha(dwarf2);
        elfo6.atirarFlecha(dwarf2);
        assertEquals(90, dwarf2.getLife());
    } 
    
     @Test
    public void umElfoAtirandoEm2Dwarfs(){
        Elfo elfo7 = new Elfo("legolas7");
        Dwarf dwarf3 = new Dwarf();
        Dwarf dwarf4 = new Dwarf();
        elfo7.atirarFlecha(dwarf3);
        elfo7.atirarFlecha(dwarf4);
        assertEquals(40, elfo7.getFlechas());
    } 
    
     @Test
    public void umElfoAtirandoEm4Dwarfs(){
        Elfo elfo8 = new Elfo("legolas8");
        Dwarf dwarf5 = new Dwarf();
        Dwarf dwarf6 = new Dwarf();
        Dwarf dwarf7 = new Dwarf();
        Dwarf dwarf8 = new Dwarf();
        elfo8.atirarFlecha(dwarf5);
        elfo8.atirarFlecha(dwarf6);
        elfo8.atirarFlecha(dwarf7);
        elfo8.atirarFlecha(dwarf8);
        assertEquals(38, elfo8.getFlechas());
    } 
    
     @Test
    public void cincoElfosAtirandoEm1Dwarf(){
        Elfo elfo9 = new Elfo("legolas9");
        Elfo elfo10 = new Elfo("legolas10");
        Elfo elfo11 = new Elfo("legolas11");
        Elfo elfo12 = new Elfo("legolas12");
        Elfo elfo13 = new Elfo("legolas13");
        Dwarf dwarf9 = new Dwarf();
        elfo9.atirarFlecha(dwarf9);
        elfo10.atirarFlecha(dwarf9);
        elfo11.atirarFlecha(dwarf9);
        elfo12.atirarFlecha(dwarf9);
        elfo13.atirarFlecha(dwarf9);
        assertEquals(60, dwarf9.getLife());
    } 
        
}
