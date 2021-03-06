

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IrishDwarfTest
{
   @Test
   public void irishDwarfTentaSorteEGanha(){
       IrishDwarf sortudoIrlandes = new IrishDwarf("sortudo",new DataTerceiraEra(1,1,2016));
       sortudoIrlandes.recebeFlechada();
       sortudoIrlandes.recebeFlechada();
       sortudoIrlandes.recebeFlechada();
       Inventario esperado = new Inventario();
       esperado.adicionarItem(new Item("chapeu",6003));
       
       sortudoIrlandes.adicionarItem(new Item("chapeu",3)); 
       sortudoIrlandes.tentarSorte();
       //assert
       assertEquals(esperado,sortudoIrlandes.getInventario());
     
   }  
   
     @Test
   public void irishDwarfTentaSorteENaoGanha(){
       IrishDwarf sortudoIrlandes = new IrishDwarf("sortudo",new DataTerceiraEra(1,1,2015));
       sortudoIrlandes.recebeFlechada();
       sortudoIrlandes.recebeFlechada();
       sortudoIrlandes.recebeFlechada();
       Inventario esperado = new Inventario();
       esperado.adicionarItem(new Item("chapeu",3));
       
       sortudoIrlandes.getInventario().adicionarItem(new Item("chapeu",3)); 
       sortudoIrlandes.tentarSorte();
       //assert
       assertEquals(esperado,sortudoIrlandes.getInventario());
     
   }  
   
}
