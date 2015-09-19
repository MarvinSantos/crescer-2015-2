

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class InventarioTest
{
   @Test
   public void adcionarItemNaListaDeInventario(){
       Inventario mochila = new Inventario();
       Item faca = new Item("faca",1);
       mochila.adcionarItem(faca);
       assertEquals(faca,mochila.getItens().get(0));
   }  
   
   @Test
   public void adcionarItemNaListaDeInventarioNoIndice1(){
       //arrange
       Inventario mochila = new Inventario();
       Item faca = new Item("faca",1);
       Item chinelo = new Item("chinelo",2);
       mochila.adcionarItem(faca);
       mochila.adcionarItem(chinelo);
       assertEquals(chinelo,mochila.getItens().get(1));
   }   
}
