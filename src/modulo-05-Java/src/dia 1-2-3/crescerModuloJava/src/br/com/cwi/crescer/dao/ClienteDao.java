package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;

public class ClienteDao {
    public void insert(Cliente cliente)throws SQLException{
        try(Connection conexao = new ConnectionFactory().getConnection()){

            PreparedStatement statement = conexao.prepareStatement("insert into cliente(idCliente,nmCliente,nrCpf) values (cliente_seq.nextVal,?,?)");

            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());

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

    public void delete(Long idCliente) throws SQLException {

        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from cliente where idCliente = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idCliente);
            statement.executeQuery();

        } catch (SQLException e) {
            throw e;
        }

    }

    public Cliente load(Long idCliente) throws SQLException {

        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("select idCliente,nmCliente,nrCpf from cliente where idCliente = ?");
            statement.setLong(1, idCliente);
            ResultSet resultSet = statement.executeQuery();

            Cliente cliente = new Cliente();
            if (resultSet.next()) {
                cliente.setIdCliente(resultSet.getLong("idCliente"));
                cliente.setNmCliente(resultSet.getString("nmCliente"));
                cliente.setNrCpf(resultSet.getString("nrCpf"));
            } else {
                throw new RuntimeException("Registro não enconrado");
            }

            return cliente;

        } catch (SQLException e) {
            throw e;
        }

    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder sql = new StringBuilder();
            sql.append("update cliente set nmCliente = ?,nrCpf = ? where idCliente = ? ");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            statement.setString(1, cliente.getNmCliente());
            statement.setString(2, cliente.getNrCpf());
            statement.setLong(3, cliente.getIdCliente());

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Cliente> find(Cliente clienteP) throws SQLException {
        List<Cliente> lista = new ArrayList<Cliente>();
        List<Object> listaParameters = new ArrayList<Object>();

        int contadorParam = 0;

        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder("select idCliente,nmCliente,nrCpf from cliente where ");


            if (clienteP.getIdCliente() != null) {
                contadorParam++;
                sql.append(" idCliente = ? ");
                listaParameters.add(clienteP.getIdCliente());
            }

            if (clienteP.getNmCliente() != null) {
                if (contadorParam > 0) {
                    sql.append(" AND nmCliente = ? ");
                } else {
                    sql.append(" nmCliente = ? ");
                }
                contadorParam++;
                listaParameters.add(clienteP.getNmCliente());

            }

            if (clienteP.getNrCpf() != null) {
                if (contadorParam > 0) {
                    sql.append(" AND nrCpf = ? ");
                } else {
                    sql.append(" nrCpf = ? ");
                }
                contadorParam++;
                listaParameters.add(clienteP.getNrCpf());
            }
            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < listaParameters.size(); i++) {
                Object objeto = listaParameters.get(i);
                if(objeto instanceof String){
                	 statement.setString(i + 1, (String) objeto);
                }else if(objeto instanceof Long){
                	 statement.setLong(i + 1, (Long) objeto);
                }
               

            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getLong("idCliente"));
                cliente.setNmCliente(resultSet.getString("nmCliente"));
                cliente.setNrCpf(resultSet.getString("nrCpf"));
                lista.add(cliente);

            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }

    }

}
