package br.com.cwi.crescer.menus;

import br.com.cwi.crescer.LinkedList;

public class MenuPrincipal {
	
	public void mostrarOpcoesDeLista(){
		String cabecalho = "        Escolha o tipo de lista que preferir";
		String opcao1 = "1- lista encadeada simples";
		String opcao2 = "2- lista duplamente encadeada";
		String opcao3 = "0- Para SAIR digite 0(zero)";
		String quebraLinha = "\r\n";
		System.out.println(cabecalho +quebraLinha+ opcao1 +quebraLinha+ opcao2 +quebraLinha+ opcao3);
	}
	
	public void mostrarMenuManter(){
		String cabecalho = "        Escolha o que deseja fazer";
		String adicionar = "1- adicionar na lista";
		String remover = "2- remover da lista";
		String listar = "3- Ver a lista";
		String exportarTxt = "4- Exportar Txt";
		String sair = "0- Para SAIR digite 0(zero)";
		String quebraLinha = "\r\n";
		System.out.println(cabecalho +quebraLinha+ adicionar +quebraLinha+ remover +quebraLinha+ listar +quebraLinha+ exportarTxt +quebraLinha+ sair);
	}
	
	public void pedirIndice(){
		String texto = "digite o indice do nodo que quer remover";
		System.out.println(texto);
	}
	
	public void pedirValor(){
		String texto = "digite o valor em texto que quer add na lista";
		System.out.println(texto);
	}
	
	public void listar(String texto){
		System.out.println(texto);
	}
}
