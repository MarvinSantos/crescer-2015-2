

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
   public void itemComMaiorQuantiadeIgualA1NoMeioDeItensNegativos(){
       //arrange
       Item faca = new Item("faca",-500);
       Item remedio = new Item("remedio",1);
       Item desodorante = new Item("desodorante",-6);
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
   
    @Test
   public void ordenando15ItensNoInventarioEmOrdemAscendenteDaQualtidade(){
       //arrange
       Item faca = new Item("faca",50);
       Item remedio = new Item("remedio",1);
       Item desodorante = new Item("desodorante",30);
       Item balao = new Item("balao",6);
       Item carneAssada = new Item("carne assada",7);
       Item carne = new Item("carne",23);
       Item carro = new Item("carro",8);
       Item agua = new Item("agua",9);
       Item bit = new Item("bit",45);
       Item pc = new Item("pc",36);
       Item madeira = new Item("madeira",29);
       Item pedra = new Item("pedra",18);
       Item ouro = new Item("ouro",200);
       Item cash = new Item("cash",3);
       Item dollar = new Item("doallar",72);
       Inventario mochila = new Inventario();
       
       mochila.adcionarItem(faca);
       mochila.adcionarItem(remedio);
       mochila.adcionarItem(desodorante);
       mochila.adcionarItem(carneAssada);
       mochila.adcionarItem(balao);
       mochila.adcionarItem(carne);
       mochila.adcionarItem(carro);
       mochila.adcionarItem(agua);
       mochila.adcionarItem(bit);
       mochila.adcionarItem(pc);
       mochila.adcionarItem(madeira);
       mochila.adcionarItem(pedra);
       mochila.adcionarItem(ouro);
       mochila.adcionarItem(cash);
       mochila.adcionarItem(dollar);
       //act
       mochila.ordenarItens();
       //assert
       assertEquals(remedio,mochila.getItens().get(0));
       assertEquals(cash,mochila.getItens().get(1));
       assertEquals(balao,mochila.getItens().get(2));  
       assertEquals(carneAssada,mochila.getItens().get(3));  
       assertEquals(carro,mochila.getItens().get(4));  
       assertEquals(agua,mochila.getItens().get(5));  
       assertEquals(pedra,mochila.getItens().get(6));
       assertEquals(carne,mochila.getItens().get(7));
       assertEquals(madeira,mochila.getItens().get(8)); 
       assertEquals(desodorante,mochila.getItens().get(9));
       assertEquals(pc,mochila.getItens().get(10)); 
       assertEquals(bit,mochila.getItens().get(11)); 
       assertEquals(faca,mochila.getItens().get(12)); 
       assertEquals(dollar,mochila.getItens().get(13)); 
       assertEquals(ouro,mochila.getItens().get(14)); 
   }
   
   @Test
   public void ordenarItensComQuantidadeNegativa(){
        //arrange
       Item faca = new Item("faca",-1);
       Item remedio = new Item("remedio",-5);
       Item desodorante = new Item("desodorante",30);
       Item balao = new Item("balao",6);
       Inventario mochila = new Inventario();       
        
       mochila.adcionarItem(faca);
       mochila.adcionarItem(remedio);
       mochila.adcionarItem(desodorante);
       mochila.adcionarItem(balao);
       
       //act
       mochila.ordenarItens();
       //assert
       assertEquals(remedio,mochila.getItens().get(0));
       assertEquals(faca,mochila.getItens().get(1));
       assertEquals(balao,mochila.getItens().get(2));  
       assertEquals(desodorante,mochila.getItens().get(3));  
       
   }
   
     @Test
   public void ordenar1Itens(){
        //arrange
       Item faca = new Item("faca",-1);  
       Inventario mochila = new Inventario(); 
       mochila.adcionarItem(faca);       
       //act
       mochila.ordenarItens();
       //assert
       assertEquals(faca,mochila.getItens().get(0));       
   }
   
      @Test
   public void ordenar2Itens(){
        //arrange
       Item faca = new Item("faca",2);  
       Item remedio = new Item("remedio",5);
       Inventario mochila = new Inventario(); 
       mochila.adcionarItem(faca);
       mochila.adcionarItem(remedio);
       //act
       mochila.ordenarItens();
       //assert
       assertEquals(faca,mochila.getItens().get(0)); 
       assertEquals(remedio,mochila.getItens().get(1));
   }  
   
}
