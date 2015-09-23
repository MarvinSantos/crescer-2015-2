
public class OrcUrukHai extends Orc
{
    public OrcUrukHai(String nome){
        super(nome);
        super.adicionarItem(new Item("Espada",1));
        super.adicionarItem(new Item("Escudo Uruk-Hai",1));
        this.vida = 150;
    }    
}
