

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataTerceiraEraTest
{
   @Test
   public void oAnoEsperadoEhBissexto(){
       DataTerceiraEra anoBissexto = new DataTerceiraEra(1,1,2016);
       
       assertEquals(true, anoBissexto.ehBissexto());
   } 
   
   @Test
   public void oAnonaoEBissexto(){
       DataTerceiraEra anoNaoBissexto = new DataTerceiraEra(1,1,2015);
       
       assertEquals(false, anoNaoBissexto.ehBissexto());
   }    
}
