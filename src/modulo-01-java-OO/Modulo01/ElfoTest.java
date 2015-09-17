

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
    public void elfoCriadoComNomeNull(){
        Elfo elfonullo = new Elfo(null);
        assertNull(elfonullo.getNome());
    } 
    
    
    @Test
    public void elfoCriadoComNomeVazio(){
        Elfo elfoNomeVazio = new Elfo("");
        assertEquals("",elfoNomeVazio.getNome());
    }  
    
    @Test
    public void elfoNasceComZeroDeExperiencia(){
        Elfo elfo2 = new Elfo("legolas2");
        assertEquals(0, elfo2.getExperiencia());
    }
    
    @Test
    public void nomeDoElfoNaoNull(){
        Elfo elfo3 = new Elfo("legolas3");
        assertNotNull(elfo3.getNome());
    }
    
    @Test
    public void perdaDeFlechasDoElfoEPerdaDeVidaDoDwarf(){
        //Arrange
        Elfo elfo4 = new Elfo("legolas4");
        Dwarf dwarf1 = new Dwarf("oana");
        int qtdFlechasEsperada = 41;
        int qtdExperienciaEsperada = 1;
        int vidaEsperada = 100;
        //Act
        elfo4.atirarFlecha(dwarf1);
        //Assert
        assertEquals(qtdExperienciaEsperada, elfo4.getExperiencia());
        assertEquals(qtdFlechasEsperada, elfo4.getFlechas());
        assertEquals(vidaEsperada, dwarf1.getLife());
    }
    
    @Test
    public void doisElfosAtirandoEm1Dwarf(){
        Elfo elfo5 = new Elfo("legolas5");
        Elfo elfo6 = new Elfo("legolas6");
        Dwarf dwarf2 = new Dwarf("umDwarf");
        elfo5.atirarFlecha(dwarf2);
        elfo6.atirarFlecha(dwarf2);
        assertEquals(90, dwarf2.getLife());
    } 
    
     @Test
    public void umElfoAtirandoEm2Dwarfs(){
        Elfo elfo7 = new Elfo("legolas7");
        Dwarf dwarf3 = new Dwarf("tritao");
        Dwarf dwarf4 = new Dwarf("anaoIlluminat");
        elfo7.atirarFlecha(dwarf3);
        elfo7.atirarFlecha(dwarf4);
        assertEquals(40, elfo7.getFlechas());
    } 
    
     @Test
    public void umElfoAtirandoEm4Dwarfs(){
        Elfo elfo8 = new Elfo("legolas8");
        Dwarf dwarf5 = new Dwarf("golez");
        Dwarf dwarf6 = new Dwarf("jhon");
        Dwarf dwarf7 = new Dwarf("locao");
        Dwarf dwarf8 = new Dwarf("fedor");
        elfo8.atirarFlecha(dwarf5);
        elfo8.atirarFlecha(dwarf6);
        elfo8.atirarFlecha(dwarf7);
        elfo8.atirarFlecha(dwarf8);
        assertEquals(38, elfo8.getFlechas());
    } 
    
     @Test
    public void elfoAtirandoEmUmDwarf(){
        //Arrange
        Elfo elfo9 = new Elfo("legolas9");  
        Dwarf dwarf9 = new Dwarf("batman");
        //Act
        elfo9.atirarFlecha(dwarf9);  
        //Assert
        assertEquals(41,elfo9.getFlechas());
    } 
    
     @Test
    public void doisElfosAtiramEm2anoes(){
        //Arrange
        Elfo elfoI = new Elfo("legolasI");
        Elfo elfoII = new Elfo("legolasII");
        Dwarf dwarfI = new Dwarf("robin");
        Dwarf dwarfII = new Dwarf("pitter");
        int qtdFlechasEsperada = 40;
        int qtdExperienciaEsperada = 2;
        int vidaEsperada = 90;
        //Act
        elfoI.atirarFlecha(dwarfI);
        elfoI.atirarFlecha(dwarfI);
        elfoII.atirarFlecha(dwarfII);
        elfoII.atirarFlecha(dwarfII);
        //Assert
        assertEquals(qtdExperienciaEsperada, elfoI.getExperiencia());
        assertEquals(qtdFlechasEsperada, elfoI.getFlechas());
        assertEquals(vidaEsperada, dwarfI.getLife());
    }
    
    
     @Test
    public void elfoComDuasFlechas(){
        //Arrange
        Elfo elfoh = new Elfo("legolashumilde",2);  
        //Act 
        //Assert
        assertEquals(2,elfoh.getFlechas());
    } 
    
     @Test
    public void elfoComMuitasFlechasIlluminat(){
        //Arrange
        Elfo elfoIlluminat = new Elfo("legolasIlluminat",3570);  
        //Act 
        //Assert
        assertEquals(3570,elfoIlluminat.getFlechas());
    } 
    
      @Test
    public void elfoDevendoFlechas(){
        //Arrange
        Elfo elfoCaloteiro = new Elfo("legolasC",-3570);  
        //Act 
        //Assert
        assertEquals(-3570,elfoCaloteiro.getFlechas());
    } 
    
    @Test
    public void metodoToStringComElfoInicial(){
        Elfo elfo14 = new Elfo("legolas14", 200);              
        assertEquals("legolas14 possui 200 flechas e 0 niveis de experiência.",elfo14.toString());    
    } 
    
     @Test
    public void metodoToStringComElfoCom1Flecha(){
        Elfo elfo14 = new Elfo("legolas14", 1);              
        assertEquals("legolas14 possui 1 flecha e 0 niveis de experiência.",elfo14.toString());    
    } 
    
     @Test
    public void elfoCom1DeExperienciaToString(){
        Elfo elfoK = new Elfo(null);
        elfoK.atirarFlecha(new Dwarf("nano"));
        assertEquals(null + " possui 41 flechas e 1 nivel de experiência.",elfoK.toString());    
    } 
    
    @Test
    public void elfoNasceVivo(){
        Elfo legolasS = new Elfo("legolasS");
        assertEquals(Status.VIVO, legolasS.getStatus());
    }   
        
}
