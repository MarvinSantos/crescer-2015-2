public class Dwarf {
    private int life;
    private String nome;
    private int experiencia;
    private Status statusDwarf;
    private DataTerceiraEra dataDeNascimento;
    private Inventario mochila = new Inventario();
   
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
    
    public Inventario getInventario(){
        return this.mochila;
    }    
    
    public int getLife(){
        return this.life;
    }
    
    public String getNome(){
        return this.nome;
    }    
    
    public void recebeFlechada(){
        if(this.statusDwarf == Status.VIVO){
            double numeroSorteado = getNumeroSorte();
            if(numeroSorteado > 100){
                this.life -= 10;
                checarStatusDwarf();       
            }else if(numeroSorteado < 0){
                this.experiencia += 2;
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
        
        if(!dataDeNascimento.ehBissexto() && this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            numeroSorte *= 33;
            numeroSorte %= 100;
        } 
        return numeroSorte;
    } 
    
    public void tentarSorte(){
        double numeroDaSorte = getNumeroSorte();
        
        if(numeroDaSorte == -3333.0){
            for(int i = 0; i < mochila.listaDeItens.size(); i++){
                mochila.getItens().get(i).quantidadeRecebeMaisMil();
            }    
        }    
    }    
}
    
