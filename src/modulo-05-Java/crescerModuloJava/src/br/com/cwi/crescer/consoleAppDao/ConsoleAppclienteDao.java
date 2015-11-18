package br.com.cwi.crescer.consoleAppDao;

import br.com.cwi.crescer.interfaces.MinhaLinkedList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.cwi.crescer.ConnectionFactory;
import br.com.cwi.crescer.LinkedList;
import br.com.cwi.crescer.dao.ClienteDao;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;
import br.com.cwi.crescer.menus.MenuPrincipal;
import br.com.cwi.crescer.model.Cliente;

public class ConsoleAppclienteDao {	
	
	public static void main(String[] args)throws SQLException {
		/*try(Connection conexao = new ConnectionFactory().getConnection()){
            
			ClienteDao clienteDao = new ClienteDao();
			Cliente cliente = new Cliente();
			cliente.setIdCliente(2l);
			cliente.setNmCliente("joao");
			cliente.setNrCpf("12345");
			
			clienteDao.insert(cliente);
			
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
		
		
        ClienteDao clienteDao = new ClienteDao();
        List<Cliente> lista = clienteDao.listAll();
			
    }			   
		
}
