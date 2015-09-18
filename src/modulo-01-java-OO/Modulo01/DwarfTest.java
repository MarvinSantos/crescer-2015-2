

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeVida(){
        Dwarf gimili = new Dwarf("fizz");
        assertEquals(110, gimili.getLife());
            
    }
    
    @Test
    public void dwarfLevouFlechadaEPerdeu10DeVida(){
        Dwarf outroAnao = new Dwarf("zoro");
        outroAnao.recebeFlechada();
        assertEquals(100,outroAnao.getLife());
        
    }
    
    @Test
    public void dwarfLeva11FlechadasEAVidaEZero(){
        //Arrange
        Dwarf outroAnao = new Dwarf("gigante");
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
        Dwarf outroAnao = new Dwarf("globin");
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
    
    @Test
    public void statusDoDwarfEMorto(){
        //arrange
        Dwarf anaoDeTeste = new Dwarf("balin");
        //act
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        anaoDeTeste.recebeFlechada();
        //assert
        assertEquals(Status.MORTO, anaoDeTeste.getStatus());
    } 
    
    @Test
    public void nomeDoDwarfNaoNull(){
        Dwarf dwarfvelho = new Dwarf("anao");
        assertNotNull(dwarfvelho.getNome());
    }
    
    @Test
    public void dwarfNasceComZeroDeExperiencia(){
        Dwarf dwarfSemEXP = new Dwarf("gorgon");
        assertEquals(0, dwarfSemEXP.getExperiencia());
    }
    
    @Test
    public void dwarfNasceNaData1Do1Do1(){
        //arrange
        Dwarf ledesma = new Dwarf("ledessma");
        int dia = ledesma.getDataDeNascimento().getDia();
        int mes = ledesma.getDataDeNascimento().getMes();
        int ano = ledesma.getDataDeNascimento().getAno();
        //act
        //assert
        assertEquals(1,dia);
        assertEquals(1,mes);
        assertEquals(1,ano);
    }    
}