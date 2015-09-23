
public class Personagem
{
    protected String nome;
    protected int experiencia;
    protected Status status;
    protected int vida;
    protected final Inventario mochila;
    
    public Personagem(String nome){
        this.nome = nome;
        this.status = Status.VIVO;
        this.experiencia = 0;
        this.mochila = new Inventario();
    } 
    
    public String getNome(){
        return this.nome;
    }
    public int getExperiencia(){
        return this.experiencia;
    }   
    
    public Inventario getInventario(){
        return this.mochila;
    } 
    
    public int getVida(){
        return this.vida;
    }   
    
    public Status getStatus(){
        return status;
    
    }
    
     public void perderItem(Item item){
        this.mochila.getItens().remove(item);
    }  
    
    public void adicionarItem(Item item){
        this.mochila.getItens().add(item);
    }
    
    public void recebeAtaqueDoOrc(Orc orc){
        if(this.status == Status.VIVO){      
           this.vida -= orc.getDanoDeAtaque();
        }         
    }    
}


