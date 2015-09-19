

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
   
   @Test
   public void pegarDescricoesDosItens(){
       //arrange
       String textoEsperado = "faca, sprayDePimenta.";
       Inventario mochila = new Inventario();
       Item faca = new Item("faca",1);
       Item spray = new Item("sprayDePimenta",1);
       mochila.adcionarItem(faca);
       mochila.adcionarItem(spray);
       //assert
       assertEquals(textoEsperado,mochila.getDescricaoItens());
   } 
   
   @Test
   public void pegarDescricoesNullDosItens(){
       //arrange
       String textoEsperado = null + ", " + null + ".";
       Inventario mochila = new Inventario();
       Item faca = new Item(null,1);
       Item spray = new Item(null,1);
       mochila.adcionarItem(faca);
       mochila.adcionarItem(spray);
       //assert
       assertEquals(textoEsperado,mochila.getDescricaoItens());
   }   
}
