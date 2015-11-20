package br.com.cwi.crescer.menus;

public class TelaPedido {
	
	public void mostrarTelaPrincipal(){
		String cabecalho = "        Escolha o que deseja fazer";
		String opcao1 = "1- Inserir pedido";
		String opcao2 = "2- Listar pedidos de cliente";
		String opcao3 = "3- Buscar pedido";
		String opcao4 = "0- Para SAIR digite 0(zero)";
		String quebraLinha = "\r\n";
		System.out.println(cabecalho +quebraLinha+ opcao1 +quebraLinha+ opcao2 +quebraLinha+ opcao3 +quebraLinha+ opcao4);
	}
	
	public void pedirDescricao(){
		System.out.println("insira a descricao do pedido, MAX 50 charac");
	}
	
	public void pedirIdPedido(){
		System.out.println("insira o id do pedido");
	}
}
