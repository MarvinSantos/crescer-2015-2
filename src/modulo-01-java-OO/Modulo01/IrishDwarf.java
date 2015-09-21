public class IrishDwarf extends Dwarf{
   
   
    public IrishDwarf(String nome){
        super(nome);
    } 
    
    public IrishDwarf(String nome,DataTerceiraEra dataDeNascimento){
        super(nome,dataDeNascimento);
    } 
  

    public void tentarSorte(){
        double numeroDaSorte = getNumeroSorte();
        
        if(numeroDaSorte == -3333.0){
                mochila.quantidadeAumentaEmMilESoma3VezesAAual();
               
        }    
    }
    
}
