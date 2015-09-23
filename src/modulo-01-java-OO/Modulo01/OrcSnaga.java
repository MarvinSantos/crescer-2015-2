
public class OrcSnaga extends Orc
{
  public OrcSnaga(String nome){
       super(nome);
       super.adicionarItem(new Item("Arco",1));
       super.adicionarItem(new Item("Flecha",5));
       this.vida = 70;
  }    
}
