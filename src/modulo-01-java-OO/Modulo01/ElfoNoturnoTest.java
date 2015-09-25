

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
  @Test
  public void elfoNoturnoperdeVidaAtirando2Flechas(){
      ElfoNoturno kurt = new ElfoNoturno("kurt");
      int vidaEsperada = 95;
      int vidaEsperada2 = 90;
      Dwarf dwarf = new Dwarf("anao");
      kurt.atirarFlecha(dwarf);
      
      assertEquals(vidaEsperada,kurt.getVida());
      kurt.atirarFlecha(dwarf);
      assertEquals(vidaEsperada2,kurt.getVida());
    
  }  
  
   @Test
  public void elfoNoturnoperdeVidaAtirando3Flechas(){
      ElfoNoturno kurt = new ElfoNoturno("kurt");

      int vidaEsperada = 85;
      Dwarf dwarf = new Dwarf("anao");
      kurt.atirarFlecha(dwarf);
      kurt.atirarFlecha(dwarf);
      kurt.atirarFlecha(dwarf);
      
 
      assertEquals(vidaEsperada,kurt.getVida());
    
  } 
  
    @Test
  public void elfoNoturnoperdeVidaAtirandoMuitasFlechas(){
      ElfoNoturno kurt = new ElfoNoturno("kurt");

      int vidaEsperada = 0;
      Dwarf dwarf = new Dwarf("anao");
      for(int i = 0; i < 45; i++){
          kurt.atirarFlecha(dwarf);
      }
 
      assertEquals(vidaEsperada,kurt.getVida());
    
  } 
  
   @Test
  public void elfoNoturnoGanha6DeExperienciaCom2ataques(){
      ElfoNoturno kurt = new ElfoNoturno("kurt");
      int expEsperado = 6;
     
      Dwarf dwarf = new Dwarf("anao");
      kurt.atirarFlecha(dwarf);
      kurt.atirarFlecha(dwarf);
      
      assertEquals(expEsperado,kurt.getExperiencia());
    
  } 
  
    @Test
  public void elfoNoturnoGanha15DeExperienciaCom5ataques(){
      ElfoNoturno kurt = new ElfoNoturno("kurt");
      int expEsperado = 15;
     
      Dwarf dwarf = new Dwarf("anao");
      kurt.atirarFlecha(dwarf);
      kurt.atirarFlecha(dwarf);
      kurt.atirarFlecha(dwarf);
      kurt.atirarFlecha(dwarf);
      kurt.atirarFlecha(dwarf);
      
      assertEquals(expEsperado,kurt.getExperiencia());
    
  }  
  
}
