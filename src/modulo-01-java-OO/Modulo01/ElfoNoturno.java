

public class ElfoNoturno extends Elfo
{
    
    public ElfoNoturno(String nome){
        super(nome);
    }    
        
    public void atirarFlecha(Dwarf dwarf){
        dwarf.recebeFlechada();
        atirarFlechaUtilizandoVida();
    }
        
    public void atacarOrc(Orc orc){       
        orc.receberAtaque();
        atirarFlechaUtilizandoVida();
    }
    
    public void atirarFlechaUtilizandoVida(){
        if((int)this.vida > 0){
            this.vida -= this.vida* 0.05;
            this.experiencia += 3;
            flechas--;
        }else if((int)this.vida == 0){
            this.status = Status.MORTO;
        }    
    }    
}
