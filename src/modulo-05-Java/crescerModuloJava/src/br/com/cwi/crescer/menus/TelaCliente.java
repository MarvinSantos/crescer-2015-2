package br.com.cwi.crescer.menus;

public class TelaCliente {
	
	public void pedirNome(){
		System.out.println("digite o nome do cliente");
	}
	
	public void pedirCpf(){
		System.out.println("digite o cpf do cliente");
	}
	
	public void pedirId(){
		System.out.println("digite o id do cliente");
	}

	public void telaPrincipalCliente() {
		String quebraLinha = "\r\n";
		String cabecalho = "voce deve dizer para qual cliente é o pedido ou incluir um novo" + quebraLinha;
		String opcao1 = "1- Buscar cliente";
		String opcao2 = "2- inserir cliente";
		String opcao3 = "0- Para SAIR digite 0(zero)";
		
		System.out.println(cabecalho +quebraLinha+ opcao1 +quebraLinha+ opcao2 +quebraLinha+ opcao3);
		
	}
}
