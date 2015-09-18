

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
    
    @Test
    public void seAVidaDoDwarfEstiverEntre80E90Esperase3333pontoZeroNegativos(){
        //arrange
        Dwarf dwarf55 = new Dwarf("ibraimovic",new DataTerceiraEra(1,1,2016));
        double valorEsperado = -3333.0;
        //act
        dwarf55.recebeFlechada();
        dwarf55.recebeFlechada();  
        //assert
        assertEquals(valorEsperado, dwarf55.getNumeroSorte(), 0.01);
        
    }    
    
    @Test
    public void seONomeDoDwarfForSeixasEsperase33_0DoNumeroDeSorte(){
        Dwarf seixas = new Dwarf("Seixas");
        double numeroEsperado = 33.0;
        assertEquals(numeroEsperado, seixas.getNumeroSorte(), 0.01);
    }
    
    @Test
    public void seONomeDoDwarfForMeirelesEsperase33_0DoNumeroDeSorte(){
        Dwarf meireles = new Dwarf("Meireles");
        double numeroEsperado = 33.0;
        assertEquals(numeroEsperado, meireles.getNumeroSorte(), 0.01);
    } 
    
    @Test
    public void seONomeDoDwarfForSeixasEsperaseQueEleNaoRecebaFlechadaENemEXP(){
        Dwarf seixas = new Dwarf("Seixas");
        int vidaEsperada = 110;
        int expEsperado = 0;
        assertEquals(vidaEsperada, seixas.getLife());
        assertEquals(expEsperado, seixas.getExperiencia());
    }
    
    @Test
    public void seONumeroEsperadoForMaiorDoQue100EONomenNaoEhSeixas(){
        //arrange
        Dwarf naoSeixas = new Dwarf("naoSeixas");        
        int vidaExperada = 100;
        int expEsperado = 0;
        //act
        naoSeixas.recebeFlechada();
        //assert
        assertEquals(vidaExperada, naoSeixas.getLife());
        assertEquals(expEsperado, naoSeixas.getExperiencia());
    } 
    
     @Test
    public void seONumeroEsperadoForMaiorDoQue100EONomeNaoEhMeireles(){
        //arrange
        Dwarf naoMeireles = new Dwarf("naoMeireles");        
        int vidaExperada = 100;
        int expEsperado = 0;
        //act
        naoMeireles.recebeFlechada();
        //assert
        assertEquals(vidaExperada, naoMeireles.getLife());
        assertEquals(expEsperado, naoMeireles.getExperiencia());
    }
    
    @Test
    public void dwarfTem2DeExpEEhImortalPorqueNasceuEmAnoBissexto(){
        //arrange
        Dwarf joao = new Dwarf("formiga",new DataTerceiraEra(1,1,2016));
        int vidaEsperada = 90;
        int expEsperado = 2;
        //act
        joao.recebeFlechada();
        joao.recebeFlechada();
        joao.getNumeroSorte();
        joao.recebeFlechada();
        joao.recebeFlechada();
        //asserts
        assertEquals(vidaEsperada, joao.getLife());
        assertEquals(expEsperado, joao.getExperiencia());
    }    
        
        
}