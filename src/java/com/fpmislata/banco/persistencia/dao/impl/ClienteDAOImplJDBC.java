package com.fpmislata.banco.persistencia.dao.impl;

import com.fpmislata.banco.persistencia.conexiones.impl.ConnectionFactoryImplDataSource;
import com.fpmislata.banco.persistencia.conexiones.ConnectionFactory;
import com.fpmislata.banco.dominio.Cliente;
import com.fpmislata.banco.persistencia.dao.ClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImplJDBC implements ClienteDAO {

    ConnectionFactory connectionFactory;

    @Override
    public Cliente get(Integer idCliente) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Cliente cliente = null;
        Connection connection = null;

        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM cliente WHERE idCliente = ?");
            preparedStatement.setInt(1, idCliente);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente(resultSet.getInt("id"), resultSet.getString("usuario"),
                        resultSet.getString("contraseña"), resultSet.getString("nombre"),
                        resultSet.getString("dni"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }
        return cliente;
    }

    
    @Override
    public Cliente insert(Cliente cliente) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO cliente VALUES (?,?,?,?,?)");
            preparedStatement.setInt(1, cliente.getIdCliente());
            preparedStatement.setString(2, cliente.getUsuario());
            preparedStatement.setString(3, cliente.getContraseña());
            preparedStatement.setString(4, cliente.getNombre());
            preparedStatement.setString(5, cliente.getDni());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }
        return cliente;

    }

    @Override
    public Cliente update(Cliente cliente) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE cliente SET usuario=?, contraseña=?, nombre=?, dni=? WHERE idCliente=?");
            preparedStatement.setInt(5, cliente.getIdCliente());
            preparedStatement.setString(1, cliente.getUsuario());
            preparedStatement.setString(2, cliente.getContraseña());
            preparedStatement.setString(3, cliente.getNombre());
            preparedStatement.setString(4, cliente.getDni());


            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }
        return cliente;

    }

    @Override
    public void delete(Integer idCliente) {
        PreparedStatement preparedStatement;
        Connection connection = null;

        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM cliente WHERE idCliente = ?");
            preparedStatement.setInt(1, idCliente);
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }
    }

    
    @Override
    public List<Cliente> findAll() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = null;
        List clientes = new ArrayList();
        connectionFactory = new ConnectionFactoryImplDataSource();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM entidades_bancarias");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                clientes.add(
                        new Cliente(resultSet.getInt("id"), 
                            resultSet.getString("usuario"),
                            resultSet.getString("contraseña"), 
                            resultSet.getString("nombre"),
                            resultSet.getString("dni")
                        ));
            }

            return clientes;
        } catch (SQLException ex) {

        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }

        return null;

    }

}