package br.com.cwi.crescer.consoleAppDao;

import java.sql.SQLException;

public class ConsoleAppclienteDao {

    public static void main(String[] args)throws SQLException {
        // insere cliente

        /*
         * try (Connection conexao = new ConnectionFactory().getConnection()) {
         * ClienteDao clienteDao = new ClienteDao();
         * Cliente cliente = new Cliente();
         * cliente.setNmCliente("joao4");
         * cliente.setNrCpf("000");
         * clienteDao.insert(cliente);
         * } catch (SQLException e) {
         * e.printStackTrace();
         * }
         */

        // seleciona lista de clientes
        /*
         * ClienteDao clienteDao = new ClienteDao();
         * List<Cliente> lista = clienteDao.listAll();
         */

        // deleta cliente
        /*
         * try (Connection conexao = new ConnectionFactory().getConnection()) {
         * ClienteDao clienteDao = new ClienteDao();
         * clienteDao.delete(1l);
         * } catch (SQLException e) {
         * e.printStackTrace();
         * }
         */

        // carrega cliente conforme o id passado
        /*
         * try (Connection conexao = new ConnectionFactory().getConnection()) {
         * ClienteDao clienteDao = new ClienteDao();
         * Cliente cliente = clienteDao.load(2l);
         * System.out.println(cliente.getNmCliente());
         * } catch (SQLException e) {
         * e.printStackTrace();
         * }
         */

        // update cliente
        /*
         * try (Connection conexao = new ConnectionFactory().getConnection()) {
         * ClienteDao clienteDao = new ClienteDao();
         * Cliente cliente = new Cliente();
         * cliente.setIdCliente(2l);
         * cliente.setNmCliente("joaoModificado");
         * cliente.setNrCpf("123454");
         * clienteDao.update(cliente);
         * } catch (SQLException e) {
         * e.printStackTrace();
         * }
         */

        // busca uma lista de clientes conforme os filtros
        /*
         * Cliente cliente = new Cliente();
         * cliente.setIdCliente(null);
         * cliente.setNmCliente(null);
         * cliente.setNrCpf("000");
         * ClienteDao clienteDao = new ClienteDao();
         * List<Cliente> lista = clienteDao.find(cliente);
         */

    }

}
