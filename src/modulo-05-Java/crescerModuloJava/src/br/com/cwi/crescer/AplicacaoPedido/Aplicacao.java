package br.com.cwi.crescer.AplicacaoPedido;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.dao.ClienteDao;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.menus.MenuPrincipal;
import br.com.cwi.crescer.menus.TelaCliente;
import br.com.cwi.crescer.menus.TelaPedido;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class Aplicacao {
	
	public static final int INSERIR = 1;
	public static final int LISTAR = 2;
	public static final int BUSCAR = 3;
	
	public static final int SAIR = 0;
	
	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	TelaPedido telaPedido = new TelaPedido();
    	int opcao = 10; 
    	boolean rodando = true;
    	
    	while(rodando){
    		telaPedido.mostrarTelaPrincipal();
    		try{
    			opcao = scan.nextInt();  			
    		}catch(Exception e){ 			
    			System.out.println("voce deve digitar um numero inteiro");
    		}
    		scan.nextLine();
        	if(opcao == INSERIR){
        		TelaInserirPedido();
        	}else if(opcao == LISTAR){
        		listarPedido();
        	}else if(opcao == BUSCAR){
        		buscarPedido();
        	}else if(opcao == SAIR){
        		rodando = false;
        	}
    	}
    	
    }
    
    public static void TelaInserirPedido(){
    	Scanner scan = new Scanner(System.in);
    	TelaPedido telaPedido = new TelaPedido();
    	TelaCliente telaCliente = new TelaCliente();
    	final int BUSCAR = 1;
    	final int INSERIR = 2;
    	
    	int opcao;
    	boolean rodando = true;
    	
    	while(rodando){
    		
    		telaCliente.telaPrincipalCliente();
    		
    		try{
    			opcao = scan.nextInt();
    			
    		}catch(Exception e){
    			System.out.println("o valor deve ser um numero inteiro");
    			continue;
    		}
    		
    		if(opcao == INSERIR){
				Cliente cliente = pedirCliente();
				ClienteDao clienteDao = new ClienteDao();
				try{
					clienteDao.insert(cliente);
					inserirPedido(cliente);
				}catch(SQLException ex){
					System.out.println("desculpa deu erro, vamos consertar");
				}
				
			}else if(opcao == BUSCAR){
				Cliente cliente = pedirCliente();
				ClienteDao clienteDao = new ClienteDao();
				try{
					clienteDao.find(cliente);
					inserirPedido(cliente);
				}catch(SQLException ex){
					System.out.println("desculpa deu erro, vamos consertar");
				}
			}else if(opcao == SAIR){
				rodando = false;
			}
    	}
    }
    
    public static void listarPedido(){
    	Cliente clienteInformado = pedirCliente();
    	ClienteDao clienteDao = new ClienteDao();
    	List<Cliente> clientes;
    	try{
    		
    		Cliente cliente = null;
        	try{
        		clientes = clienteDao.find(clienteInformado);
        		cliente = clientes.get(0);
        	}catch(Exception e){
        		System.out.println("falha ao buscar cliente");
        	}
        	
        	PedidoDao pedidoDao = new PedidoDao(); 	
        	Pedido pedido = new Pedido();
        	pedido.setIdCliente(cliente.getIdCliente());
        	List<Pedido> pedidos;
        	try{
        		pedidos = pedidoDao.find(pedido);
        	}catch(SQLException e){
        		throw new RuntimeException("falha ao procurar pedidos deste cliente");
        	}
        	
        	for(int i =0;i<pedidos.size();i++ ){
        		System.out.println(pedidos.get(i).toString());
        	}
    		
    	}catch(Exception e){
    		System.out.println("falha ao buscar pedidos");
    	}
    	
    	
    }
    
    public static void buscarPedido(){
    	Scanner scan = new Scanner(System.in);
    	TelaPedido telaPedido = new TelaPedido();
    	PedidoDao pedidoDao = new PedidoDao();
    	Pedido pedido;
    	
    	telaPedido.pedirIdPedido();
    	try{
    		Long idPedido = scan.nextLong();
    		pedido = pedidoDao.load(idPedido);
    		if(pedido != null){
    			System.out.println(pedido.toString());
    		}else{
    			System.out.println("não existe um pedido com este id");
    		}
    	}catch(Exception e){
    		System.out.println("o id inserido não é valido, deve ser um numero inteiro");
    	}
    	
    }
    
    public static Cliente pedirCliente(){
    	Scanner scan = new Scanner(System.in);
    	TelaCliente telaCliente = new TelaCliente();
    	String nome = null;
    	String cpf = null;
    	Long id = null;
    	boolean rodando = true;
    	
    	while(rodando){
    		telaCliente.pedirNome();
    		nome = scan.nextLine();
    		if(nome != null && nome != ""){
    			telaCliente.pedirCpf();
    			cpf = scan.nextLine();
    			if(cpf != null && cpf != ""){
    				telaCliente.pedirId();
    				try{
    					id = scan.nextLong();
    					rodando = false;
    				}catch(Exception e){
    					System.out.println("o id deve ser um numero inteiro \r\n se voce não sabe insira qualquer um");
    				}   								
    			}else{
    				continue;
    			}
    		}else{
    			continue;
    		}
    	}
    	
    	Cliente cliente = new Cliente();
    	cliente.setIdCliente(id);
    	cliente.setNmCliente(nome);
    	cliente.setNrCpf(cpf);
    	
    	return cliente;
    }
    
    
    public static void inserirPedido(Cliente clienteP){
    	
    	Scanner scan = new Scanner(System.in);
    	TelaPedido telaPedido = new TelaPedido();
    	ClienteDao clienteDao = new ClienteDao();
    	PedidoDao pedidoDao = new PedidoDao();
    	Cliente cliente ;
    	List<Cliente> clienteFind;
    	
    	boolean rodando = true;
    	
    	while(rodando){
    		telaPedido.pedirDescricao();
    		String descricao = scan.nextLine();
    		if(descricao != null && descricao != "" && descricao.length() < 50){
    			Pedido pedido = new Pedido();
    			try{
    				clienteP.setIdCliente(null);
    				clienteFind = clienteDao.find(clienteP);
    			}catch(SQLException e){
    				throw new RuntimeException("falha na busca de cliente");
    			}
    			try{
    				cliente = clienteFind.get(0);
        			pedido.setIdCliente(cliente.getIdCliente());
        			pedido.setDsPedido(descricao);
    			}catch(Exception e){
    				System.out.println("falha ao buscar cliente da lista");
    			}
    			
    			try{
    				pedidoDao.insert(pedido);
    				rodando = false;
    			}catch(SQLException e){
    				throw new RuntimeException("falha na inserção de pedido");
    			}
    						
    		}else{
    			System.out.println("informe a descricao com no maximo 50 e no minimo 1 caractere");
    		}
    	}
    	
    }
 
}
