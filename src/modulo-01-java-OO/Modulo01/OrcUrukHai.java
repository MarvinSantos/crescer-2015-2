
public class OrcUrukHai extends Orc
{
    public OrcUrukHai(String nome){
        super(nome);
        this.mochila.adicionarItem(new Item("Espada",1));
        this.mochila.adicionarItem(new Item("Escudo Uruk-Hai",1));
        this.vida = 150;
    }    
}
