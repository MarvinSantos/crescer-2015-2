public class Dwarf {
    private int life;
    private String nome;
    private int experiencia;
    private Status statusDwarf;
    private DataTerceiraEra dataDeNascimento;
   
    public Dwarf(String nome){
        this(nome,new DataTerceiraEra(1,1,1));
        
    } 
    
    public Dwarf(String nome,DataTerceiraEra dataDeNascimento){
        this.nome = nome;
        this.experiencia = 0;
        this.life = 110;        
        statusDwarf = Status.VIVO;
        this.dataDeNascimento = dataDeNascimento;
        
    }    
    
    public int getLife(){
        return this.life;
    }
    
    public String getNome(){
        return this.nome;
    }    
    
    public void recebeFlechada(){
        if(this.statusDwarf == Status.VIVO){
            if(getNumeroSorte() > 100){
                this.life -= 10;
                checarStatusDwarf();       
            }else if(getNumeroSorte() < 0){
                this.experiencia++;
            }   
        }     
    }    
    public int getExperiencia(){
        return this.experiencia;
    }    
    
    public Status getStatus(){
        return statusDwarf;
    
    }
    
    public void checarStatusDwarf(){
        if(this.life == 0){
            statusDwarf = Status.MORTO;
        } 
    }
    
    public DataTerceiraEra getDataDeNascimento(){
        return this.dataDeNascimento;
    }    
    
    public double getNumeroSorte(){
        double numeroSorte = 101.0;
        
        if((dataDeNascimento.ehBissexto() == true) && ((this.life >= 80) && (this.life <= 90))){
            numeroSorte *= -33;
        }  
        
        if((dataDeNascimento.ehBissexto() == false) && (this.nome == "Seixas" || this.nome == "Meireles")){
            numeroSorte *= 33;
            numeroSorte %= 100;
        } 
        return numeroSorte;
    }    
}
    
