package com.fpmislata.banco.persistencia.dao.impl;

import com.fpmislata.banco.persistencia.conexiones.impl.ConnectionFactoryImplDataSource;
import com.fpmislata.banco.persistencia.conexiones.ConnectionFactory;
import com.fpmislata.banco.dominio.EntidadBancaria;
import com.fpmislata.banco.persistencia.dao.EntidadBancariaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntidadBancariaDAOImplJDBC implements EntidadBancariaDAO {

    ConnectionFactory connectionFactory;

    @Override
    public EntidadBancaria get(Integer idEntidadBancaria) {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        EntidadBancaria entidadBancaria = null;
        Connection connection = null;

        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM entidadbancaria WHERE idEntidadBancaria = ?");
            preparedStatement.setInt(1, idEntidadBancaria);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                entidadBancaria = new EntidadBancaria(resultSet.getInt("idEntidadBancaria"), 
                        resultSet.getString("nombreEntidad"),
                        resultSet.getString("codigoEntidad"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }
        return entidadBancaria;
    }
    
    
    
    

    @Override
    public EntidadBancaria insert(EntidadBancaria entidadBancaria) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO entidadbancaria VALUES (?,?,?)");
            preparedStatement.setInt(1, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.setString(2, entidadBancaria.getNombre());
            preparedStatement.setString(3, entidadBancaria.getCodigoEntidad());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }
        return entidadBancaria;

    }

    @Override
    public EntidadBancaria update(EntidadBancaria entidadBancaria) {
        PreparedStatement preparedStatement;
        Connection connection = null;
        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement(
                    "UPDATE entidadbancaria SET nombreEntidad=?, codigoEntidad=? WHERE idEntidadBancaria=?");
            preparedStatement.setInt(3, entidadBancaria.getIdEntidadBancaria());
            preparedStatement.setString(1, entidadBancaria.getNombre());
            preparedStatement.setString(2, entidadBancaria.getCodigoEntidad());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {

            }
        }
        return entidadBancaria;

    }

    @Override
    public void delete(Integer idEntidadBancaria) {
        PreparedStatement preparedStatement;
        Connection connection = null;

        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM entidadbancaria WHERE idEntidadBancaria = ?");
            preparedStatement.setInt(1, idEntidadBancaria);
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
    public List<EntidadBancaria> findAll() {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection connection = null;
        List entidadesBancarias = new ArrayList();
        connectionFactory = new ConnectionFactoryImplDataSource();
        try {
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM entidadbancaria");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                entidadesBancarias.add(
                        new EntidadBancaria(resultSet.getInt("idEntidadBancaria"),
                                resultSet.getString("nombreEntidad"),
                                resultSet.getString("codigoEntidad")
                        ));
            }

            return entidadesBancarias;
        } catch (SQLException ex) {
                throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {
            }
        }


    }

}
