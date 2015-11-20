package testes.na.mao;

import java.io.IOException;

import br.com.cwi.crescer.LinkedList;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import br.com.cwi.crescer.menus.MenuPrincipal;

public class ExportandoTXTConsoleApp {
	
	//Testando exportação de txt da lista simples e a duplamente encadeada
	public static void main(String[] args)throws IOException {
		
		//ListaSimples
		/*LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo");

        linkedList.add(1, "segundo");
        linkedList.add(2, "terceiro");
        
        linkedList.exportarTxtDaLista();*/
		
		
		//Lista Duplamente Encadeada
		ListaDuplamenteEncadeada<String> linkedList = new ListaDuplamenteEncadeada<String>();

        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo2");

        linkedList.add(1, "segundo");
        linkedList.add(2, "terceiro");
        
        linkedList.exportarTxtDaLista();
		
    }				   
}
