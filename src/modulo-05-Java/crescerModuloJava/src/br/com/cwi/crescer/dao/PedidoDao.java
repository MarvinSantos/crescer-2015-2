package br.com.cwi.crescer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.ConnectionFactory;
import br.com.cwi.crescer.model.Cliente;
import br.com.cwi.crescer.model.Pedido;

public class PedidoDao {

    public void insert(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("insert into pedido(idPedido,idCliente,dsPedido) values (pedido_seq.nextVal,?,?)");
            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());

            statement.execute();

            System.out.println("inseriu pedido");

        } catch (SQLException e) {
            throw e;
        }

    }

    public void delete(Long idPedido) throws SQLException {

        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from pedido where idPedido = ?");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());
            statement.setLong(1, idPedido);
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }

    }

    public List<Pedido> listAll() throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();

        try (Connection connection = new ConnectionFactory().getConnection()) {

            String sql = "select idpedido, idcliente, dspedido from pedido";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Pedido pedido = new Pedido();

                pedido.setIdPedido(result.getLong("idpedido"));
                pedido.setIdCliente(result.getLong("idcliente"));
                pedido.setDsPedido(result.getString("dspedido"));

                pedidos.add(pedido);
            }

            return pedidos;

        } catch (SQLException e) {
            System.out.println("Erro sql!!!");
        }

        return pedidos;
    }

    public void update(Pedido pedido) throws SQLException {
        try (Connection conexao = new ConnectionFactory().getConnection()) {

            StringBuilder sql = new StringBuilder();
            sql.append("update pedido set idCliente = ?,dsPedido = ? where idPedido = ? ");

            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            statement.setLong(1, pedido.getIdCliente());
            statement.setString(2, pedido.getDsPedido());
            statement.setLong(3, pedido.getIdPedido());

            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> find(Pedido filtro) throws SQLException {
        List<Pedido> lista = new ArrayList<Pedido>();
        List<Object> listaParameters = new ArrayList<Object>();

        int contadorParam = 0;

        try (Connection conexao = new ConnectionFactory().getConnection()) {
            StringBuilder sql = new StringBuilder("select idCliente,idPedido,dsPedido from pedido where ");

            if (filtro.getIdCliente() != null) {
                contadorParam++;
                sql.append(" idCliente = ? ");
                listaParameters.add(filtro.getIdCliente());
            }

            if (filtro.getIdPedido() != null) {
                if (contadorParam > 0) {
                    sql.append(" AND idPedido = ? ");
                } else {
                    sql.append(" idPedido = ? ");
                }
                contadorParam++;
                listaParameters.add(filtro.getIdPedido());

            }

            if (filtro.getDsPedido() != null) {
                if (contadorParam > 0) {
                    sql.append(" AND dsPedido = ? ");
                } else {
                    sql.append(" dsPedido = ? ");
                }
                contadorParam++;
                listaParameters.add(filtro.getDsPedido());
            }
            PreparedStatement statement = conexao.prepareStatement(sql.toString());

            for (int i = 0; i < listaParameters.size(); i++) {
                Object objeto = listaParameters.get(i);
                if (objeto instanceof String) {
                    statement.setString(i + 1, (String) objeto);
                } else if (objeto instanceof Long) {
                    statement.setLong(i + 1, (Long) objeto);
                }

            }

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdCliente(resultSet.getLong("idCliente"));
                pedido.setIdPedido(resultSet.getLong("idPedido"));
                pedido.setDsPedido(resultSet.getString("dsPedido"));
                lista.add(pedido);

            }
            return lista;
        } catch (SQLException e) {
            throw e;
        }

    }
    
    
    public Pedido load(Long idPedido) throws SQLException {

        try (Connection conexao = new ConnectionFactory().getConnection()) {

            PreparedStatement statement = conexao.prepareStatement("select idCliente,idPedido,dsPedido from pedido where idPedido = ?");
            statement.setLong(1, idPedido);
            ResultSet resultSet = statement.executeQuery();

            Pedido pedido = new Pedido();
            if (resultSet.next()) {
            	pedido.setIdCliente(resultSet.getLong("idCliente"));
            	pedido.setIdPedido(resultSet.getLong("idPedido"));
            	pedido.setDsPedido(resultSet.getString("dsPedido"));
            } else {
                throw new RuntimeException("Registro não enconrado");
            }

            return pedido;

        } catch (SQLException e) {
            throw e;
        }

    }

}
