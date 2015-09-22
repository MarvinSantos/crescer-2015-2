

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
        outroAnao.recebeFlechada(10);
        assertEquals(100,outroAnao.getLife());
        
    }
    
    @Test
    public void dwarfLeva11FlechadasEAVidaEZero(){
        //Arrange
        Dwarf outroAnao = new Dwarf("gigante");
        //Act
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        //Assert
        assertEquals(0 , outroAnao.getLife());
    }
    
    @Test
    public void dwarfLeva7FlechadasEAVidaE40(){
        //Arrange
        Dwarf outroAnao = new Dwarf("globin");
        //Act
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);
        outroAnao.recebeFlechada(10);       
        //Assert
        assertEquals(40 , outroAnao.getLife());
    } 
    
    @Test
    public void statusDoDwarfEMorto(){
        //arrange
        Dwarf anaoDeTeste = new Dwarf("balin");
        //act
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        //assert
        assertEquals(Status.MORTO, anaoDeTeste.getStatus());
    } 
    
      @Test
    public void dawrfComZeroDeVidaENaoFicaDevendoRecebe13Flechas(){
        //arrange
        Dwarf anaoDeTeste = new Dwarf("balin");
        int vidaEsperada = 0;
        //act
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        //assert
        assertEquals(vidaEsperada, anaoDeTeste.getLife());
    } 
    
       @Test
    public void dawrfRecebe9FlechasasEEsperaseQueOStatusSejaVivo(){
        //arrange
        Dwarf anaoDeTeste = new Dwarf("balin");
        Status statusEsperado = Status.VIVO;
        //act
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        anaoDeTeste.recebeFlechada(10);
        
        //assert
        assertEquals(statusEsperado, anaoDeTeste.getStatus());
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
    public void dwarfNasceNaData1Do1Do1ComUmAssertDeComparacaoPraOvjetos(){
        //arrange
        Dwarf ledesma = new Dwarf("ledessma");
        DataTerceiraEra dataEsperada = new DataTerceiraEra(1,1,1);
        //act
        //assert
        assertEquals(dataEsperada, ledesma.getDataDeNascimento());
    }
    
    @Test
    public void seAVidaDoDwarfEstiverEntre80E90Esperase3333pontoZeroNegativos(){
        //arrange
        Dwarf dwarf55 = new Dwarf("ibraimovic",new DataTerceiraEra(1,1,2016));
        double valorEsperado = -3333.0;
        dwarf55.recebeFlechada(10);
        dwarf55.recebeFlechada(10);  
        //act
        dwarf55.recebeFlechada(10);  
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
        //arrange
        Dwarf meireles = new Dwarf("Meireles");
        double numeroEsperado = 33.0;
        meireles.recebeFlechada(10);
        //assert
        assertEquals(numeroEsperado, meireles.getNumeroSorte(), 0.01);
        assertEquals(0, meireles.getExperiencia());
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
        naoSeixas.recebeFlechada(10);
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
        naoMeireles.recebeFlechada(10);
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
        joao.recebeFlechada(10);
        joao.recebeFlechada(10);
        joao.getNumeroSorte();
        joao.recebeFlechada(10);
        
        //asserts
        assertEquals(vidaEsperada, joao.getLife());
        assertEquals(expEsperado, joao.getExperiencia());
    } 
    
     @Test
    public void dwarfTentaSorteEGanha(){
        //arrange
        Dwarf luck = new Dwarf("sortudo",new DataTerceiraEra(1,1,2016));
        luck.recebeFlechada(10);
        luck.recebeFlechada(10);  
        luck.recebeFlechada(10); 
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("poçao",1002));
        //act
        luck.getInventario().adicionarItem(new Item("poçao",2)); 
        luck.tentarSorte();
        //assert
        assertEquals(esperado,luck.getInventario());
        
    }
    
     
     @Test
    public void dwarfTentaSorteENaoGanha(){
        //arrange
        Dwarf luck = new Dwarf("sortudo",new DataTerceiraEra(1,1,2015));
        luck.recebeFlechada(10);
        luck.recebeFlechada(10);  
        luck.recebeFlechada(10);  
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("poção",2));
        //act
        luck.getInventario().adicionarItem(new Item("poção",2)); 
        luck.tentarSorte();
        //assert
        assertEquals(esperado,luck.getInventario());
        
    }
    
      @Test
    public void dwarfTentaSorte5VezesEGanha(){
        //arrange
        Dwarf luck = new Dwarf("sortudo",new DataTerceiraEra(1,1,2016));
        luck.recebeFlechada(10);
        luck.recebeFlechada(10);  
        luck.recebeFlechada(10); 
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("poçao",5002));
        //act
        luck.getInventario().adicionarItem(new Item("poçao",2)); 
        luck.tentarSorte();
        luck.tentarSorte();
        luck.tentarSorte();
        luck.tentarSorte();
        luck.tentarSorte();
        //assert
        assertEquals(esperado, luck.getInventario());
        
    }
}