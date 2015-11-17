package br.com.cwi.crescer.menus;

public class MenuPrincipal {
	
	public void mostrarOpcoesDeLista(){
		String cabecalho = "        Escolha o tipo de lista que preferir";
		String opcao1 = "1- lista encadeada simples";
		String opcao2 = "2- lista duplamente encadeada";
		String opcao3 = "3- Sair";
		String quebraLinha = "\r\n";
		System.out.println(cabecalho +quebraLinha+ opcao1 +quebraLinha+ opcao2 +quebraLinha+ opcao3);
	}
	
	public void mostrarMenuManter(){
		String cabecalho = "        Escolha o que deseja fazer";
		String adicionar = "1- adicionar na lista";
		String remover = "2- remover da lista";
		String listar = "3- Ver a lista";
		String sair = "4- Sair";
		String quebraLinha = "\r\n";
		System.out.println(cabecalho +quebraLinha+ adicionar +quebraLinha+ remover +quebraLinha+ listar +quebraLinha+ sair);
	}
}
