
public class DataTerceiraEra
{
   private int dia;
   private String mes;
   private int ano;
   
   public DataTerceiraEra(int dia, String mes, int ano){
       this.dia = dia;
       this.mes = mes;
       this.ano = ano;
   }    
   
   public int getDia(){
       return this.dia;
   }
   
   public int getAno(){
       return this.ano;
   }   
   
   public String getMes(){
       return this.mes;
   }    
}
