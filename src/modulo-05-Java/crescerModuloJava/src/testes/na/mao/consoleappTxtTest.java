package testes.na.mao;

import java.io.IOException;

import br.com.cwi.crescer.LinkedList;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import br.com.cwi.crescer.menus.MenuPrincipal;

public class consoleappTxtTest {

	public static void main(String[] args)throws IOException {
		LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo");

        linkedList.add(1, "segundo");
        linkedList.add(2, "terceiro");
        
        linkedList.exportarTxtDaLista();
    }				   
}
