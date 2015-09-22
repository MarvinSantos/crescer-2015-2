
public class Personagem
{
    protected String nome;
    protected int experiencia;
    protected Status status;
    protected int vida;
    protected Inventario mochila = new Inventario();
    
    public Personagem(String nome, Status status, int experiencia){
        this.nome = nome;
        this.status = status;
        this.experiencia = experiencia;
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
}


