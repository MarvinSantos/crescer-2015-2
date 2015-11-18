package br.com.cwi.crescer.consoleAppDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.cwi.crescer.ConnectionFactory;
import br.com.cwi.crescer.dao.ServicoDao;
import br.com.cwi.crescer.model.Servico;

public class ConsoleAppServicoDao {
	public static void main(String[] args)throws SQLException{
		//Insere na tabela servico
		/*try(Connection conexao = new ConnectionFactory().getConnection()){
	        
			ServicoDao servicoDao = new ServicoDao();
			Servico servico = new Servico();
			servico.setIdServico(1l);
			servico.setDsServico("tem direito a lavar roupas");
			
			
			servicoDao.insert(servico);
			
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }*/
	
	
		//faz select de todas as colunas da tabela servico
		ServicoDao servicoDao = new ServicoDao();
		List<Servico> lista = servicoDao.listAll();
		
	}
}
