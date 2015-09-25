

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class OrcSnagaTest
{
    
     @Test
    public void orcSnagaRecebeAtaqueDoElfoEMorre(){
        OrcSnaga orc = new OrcSnaga("rick");
        Status statusEsperado = Status.MORTO;
        
        for(int i = 0; i < 15; i++){
            orc.receberAtaque();
        }
        
        assertTrue(orc.getVida() <= 0);
        assertEquals(statusEsperado, orc.getStatus());
    } 
    
        @Test
    public void orcDoTipoSnagaNasceComArcoFlechaE70DeVida(){
        OrcSnaga orc = new OrcSnaga("orc Snaga");
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Arco",1));
        esperado.adicionarItem(new Item("Flecha",5));
        
        assertEquals(70,orc.getVida());        
        assertEquals(esperado,orc.getInventario());
    } 
    
    @Test
    public void orcDoTipoSnagaUsaTodasFlechasFicaSemEFoge(){
        OrcSnaga orc = new OrcSnaga("shaokan");
        Dwarf anao = new Dwarf("GG");
        Status statusEsperado = Status.FUGINDO;
        int quantidadeFlechaEsperada = 0;
        orc.atacarDwarf(anao);
        assertEquals(102,anao.getVida());
        orc.atacarDwarf(anao);
        orc.atacarDwarf(anao);
        orc.atacarDwarf(anao);
        orc.atacarDwarf(anao);
        orc.atacarDwarf(anao);
        orc.atacarDwarf(anao);
        assertEquals(quantidadeFlechaEsperada, orc.getInventario().buscarItemPorDescricao("Flecha").getQuantidade());
        assertEquals(statusEsperado, orc.getStatus());

    }
    
    @Test
    public void orcDoTipoSnagaAtacaOrcDoTipoUrukHai(){
        OrcSnaga orcSnaga = new OrcSnaga("orc Snaga");
        OrcUrukHai orcUKH = new OrcUrukHai("pedro");
        
        orcSnaga.atacar(orcUKH);
        
        assertEquals(142,orcUKH.getVida());        
        
    } 
    
        @Test
    public void orcDoTipoSnagaNasceComArcoEFlechaMasPerdeEsses2ItensEGanhaUmEspadao(){
        OrcSnaga orc = new OrcSnaga("orc Snaga");
        ElfoNoturno elfoNotur = new ElfoNoturno("elfao");
        int vidaElfoEsperada = 88;
        
        orc.perderItem(new Item("Flecha",5));
        orc.perderItem(new Item("Arco",1));
        orc.adicionarItem(new Item("Espada",1));
        orc.atacarElfo(elfoNotur);
        
        
        assertEquals(vidaElfoEsperada,elfoNotur.getVida());        
    } 
    
    @Test
    public void orcDoTipoSnagaNasceComArcoEFlechaEGanhaUmEscudo(){
        OrcSnaga orc = new OrcSnaga("orc Snaga");
        ElfoNoturno elfoNotur = new ElfoNoturno("elfao");
        int vidaOrcEsperada = 64;
        
        orc.adicionarItem(new Item("Espada",1));
        orc.adicionarItem(new Item("Escudo Uruk-Hai",1));
        elfoNotur.atacarOrc(orc);
        
        
        assertEquals(vidaOrcEsperada,orc.getVida());        
    } 
    
}
