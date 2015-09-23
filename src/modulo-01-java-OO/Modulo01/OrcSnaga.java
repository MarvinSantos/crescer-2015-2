
public class OrcSnaga extends Orc
{
  public OrcSnaga(String nome){
       super(nome);
       mochila.adicionarItem(new Item("Arco",1));
       mochila.adicionarItem(new Item("Flecha",5));
       this.vida = 70;
  }    
}
