public class Dwarf extends Personagem { 
    protected  DataTerceiraEra dataDeNascimento;
    
    public Dwarf(String nome){
        this(nome,new DataTerceiraEra(1,1,1));
        
    } 
    
    public Dwarf(String nome,DataTerceiraEra dataDeNascimento){
        super(nome);
        this.vida = 110;        
        this.dataDeNascimento = dataDeNascimento;
       
    } 
     
    public void atacarOrc(Orc orc){
        orc.receberAtaque();
        this.experiencia++;
    }   
    
    public void recebeFlechada(){
        if(this.status == Status.VIVO){
            double numeroSorteado = getNumeroSorte();
            if(numeroSorteado > 100){
                this.vida -= 10;
                checarStatusDwarf();       
            }else if(numeroSorteado < 0){
                this.experiencia += 2;
            }   
        }     
    }   
    
     public void recebeAtaqueDoOrc(Orc orc){
        if(this.status == Status.VIVO){
            double numeroSorteado = getNumeroSorte();
            if(numeroSorteado > 100){
                this.vida -= orc.getDanoDeAtaque();
                checarStatusDwarf();       
            }else if(numeroSorteado < 0){
                this.experiencia += 2;
            }   
        }     
    }   
    
    public void checarStatusDwarf(){
        if(this.vida == 0){
            status = Status.MORTO;
        } 
    }
    
    public DataTerceiraEra getDataDeNascimento(){
        return this.dataDeNascimento;
    }    
    
    public double getNumeroSorte(){
        double numeroSorte = 101.0;
        
        if((dataDeNascimento.ehBissexto() == true) && ((this.vida >= 80) && (this.vida <= 90))){
            numeroSorte *= -33;
        }  
        
        if(!dataDeNascimento.ehBissexto() && this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            numeroSorte *= 33;
            numeroSorte %= 100;
        } 
        return numeroSorte;
    } 
    
    public void tentarSorte(){
        double numeroDaSorte = getNumeroSorte();
        
        if(numeroDaSorte == -3333.0){
                mochila.quantidadeAumentaEm1000();
               
        }    
    }
    
}
    
