

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimili = new Dwarf();
        assertEquals(110, gimili.getLife());
            
    }
    
    @Test
    public void dwarfLevouFlechadaEPerdeu10DeVida(){
        Dwarf outroAnao = new Dwarf();
        outroAnao.recebeFlechada();
        assertEquals(100,outroAnao.getLife());
        
    }
    
    @Test
    public void dwarfLeva11FlechadasEAVidaEZero(){
        //Arrange
        Dwarf outroAnao = new Dwarf();
        //Act
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        //Assert
        assertEquals(0 , outroAnao.getLife());
    }
    
    @Test
    public void dwarfLeva7FlechadasEAVidaE40(){
        //Arrange
        Dwarf outroAnao = new Dwarf();
        //Act
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();
        outroAnao.recebeFlechada();       
        //Assert
        assertEquals(40 , outroAnao.getLife());
    } 
}