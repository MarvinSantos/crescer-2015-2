

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
   
   @Test
   public void itemComMaiorQuantiade(){
       //arrange
       Item faca = new Item("faca",1);
       Item remedio = new Item("remedio",10);
       Item desodorante = new Item("desodorante",33);
       Item carneAssada = new Item("carne assada",103);
       Item itemEsperado = carneAssada;
       Inventario mochila = new Inventario();
       //act
       mochila.adcionarItem(faca);
       mochila.adcionarItem(remedio);
       mochila.adcionarItem(desodorante);
       mochila.adcionarItem(carneAssada);
       Item itemObtido = mochila.getItemComMaiorQuantidade();
       //assert
       assertEquals(itemEsperado, itemObtido);                     
   } 
   
    @Test
   public void itemComMaiorQuantiadeE1(){
       //arrange
       Item faca = new Item("faca",0);
       Item remedio = new Item("remedio",1);
       Item desodorante = new Item("desodorante",0);
       Item carneAssada = new Item("carne assada",0);
       Item itemEsperado = remedio;
       Inventario mochila = new Inventario();
       //act
       mochila.adcionarItem(faca);
       mochila.adcionarItem(remedio);
       mochila.adcionarItem(desodorante);
       mochila.adcionarItem(carneAssada);
       Item itemObtido = mochila.getItemComMaiorQuantidade();
       //assert
       assertEquals(itemEsperado, itemObtido);                     
   }   
}
