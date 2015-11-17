package br.com.cwi.crescer.dao;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cwi.crescer.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {
	public void insert(Cliente cliente)throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){	
					
			PreparedStatement statement = conexao.prepareStatement("insert into cliente(idCliente,nmCliente,nrCpf) values (?,?,?)");
			
			 statement.setLong(1, cliente.getIdCliente());
	         statement.setString(2, cliente.getNmCliente());
	         statement.setString(3, cliente.getNrCpf());
	         
	         statement.execute();
	         
	         System.out.println("inseriu cliente");
			
		}catch(SQLException e){
			throw e;
		}
		
	}
	
	public List<Cliente> listAll()throws SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("select idCliente,nmCliente,nrCpf from cliente");
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()){
				Cliente cliente = new Cliente();
				cliente.setIdCliente(resultSet.getLong("idCliente"));
				cliente.setNmCliente(resultSet.getString("nmCliente"));
				cliente.setNrCpf(resultSet.getString("nrCpf"));
				lista.add(cliente);
				
			}
		}catch(SQLException e){
			throw e;
		}
		return lista;
	}
}
