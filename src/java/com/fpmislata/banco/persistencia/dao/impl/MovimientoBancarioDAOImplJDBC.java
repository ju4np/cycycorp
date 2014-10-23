/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fpmislata.banco.persistencia.dao.impl;

import com.fpmislata.banco.dominio.MovimientoBancario;
import com.fpmislata.banco.persistencia.conexiones.ConnectionFactory;
import com.fpmislata.banco.persistencia.conexiones.impl.ConnectionFactoryImplDataSource;
import com.fpmislata.banco.persistencia.dao.MovimientoBancarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class MovimientoBancarioDAOImplJDBC implements MovimientoBancarioDAO {

    ConnectionFactory connectionFactory;
    MovimientoBancario movimientoBancario;
    @Override
    public MovimientoBancario get(Integer id) {
        
        connectionFactory = new ConnectionFactoryImplDataSource();
        
        Connection connection = connectionFactory.getConnection();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MovimientoBancario WHERE idMovimientoBancario = ?");
            preparedStatement.setInt(1, id);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            
            movimientoBancario = new MovimientoBancario(resultSet.getInt("idMovimientoBancario"), resultSet.getInt("CuentaOrigen"), resultSet.getInt("CuentaDestino"), resultSet.getDouble("cantidad"), resultSet.getString("motivo"));
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
        
        return movimientoBancario;
    }

    @Override
    public MovimientoBancario insert(MovimientoBancario t) {
        connectionFactory = new ConnectionFactoryImplDataSource();
        Connection connection = connectionFactory.getConnection();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MovimientoBancario VALUES (null, ?,?,?,?)");
            
            preparedStatement.setInt(1, t.getCuentaOrigen());
            preparedStatement.setInt(2, t.getCuentaDestino());
            preparedStatement.setDouble(3, t.getCantidad());
            preparedStatement.setString(4, t.getMotivo());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
        return t;
    }

    @Override
    public MovimientoBancario update(MovimientoBancario t) {
        connectionFactory = new  ConnectionFactoryImplDataSource();
        Connection connection = connectionFactory.getConnection();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MovimientoBancario SET CuentaOrigen= ?, CuentaDestino=?, Cantidad=?, Motivo=? WHERE idMovimientoBancario=?");
            
            preparedStatement.setInt(1, t.getCuentaOrigen());
            preparedStatement.setInt(2, t.getCuentaDestino());
            preparedStatement.setDouble(3, t.getCantidad());
            preparedStatement.setString(4, t.getMotivo());
            preparedStatement.setInt(5, t.getIdMovimintoBancario());
            
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
        
        return t;
    }

    @Override
    public void delete(Integer id) {
        connectionFactory = new ConnectionFactoryImplDataSource();
        Connection connection = connectionFactory.getConnection();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MovimientoBancario WHERE idMovimiento=?");
            
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
        
    }

    @Override
    public List<MovimientoBancario> findAll() {
        List<MovimientoBancario> lista = new ArrayList<MovimientoBancario>();
        
        connectionFactory = new ConnectionFactoryImplDataSource();
        Connection connection = connectionFactory.getConnection();
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MovimientoBancario");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                MovimientoBancario movimientoBancario = new MovimientoBancario();
                
                movimientoBancario.setIdMovimientoBancario(resultSet.getInt("idMovimientoBancario"));
                movimientoBancario.setCuentaOrigen(resultSet.getInt("CuentaOrigen"));
                movimientoBancario.setCuentaDestino(resultSet.getInt("CuentaDestino"));
                movimientoBancario.setCantidad(resultSet.getDouble("Cantidad"));
                movimientoBancario.setMotivo("Motivo");
                
                lista.add(movimientoBancario);
            }
            
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        } finally {
            connectionFactory.close(connection);
        }
        
        return lista;
    }

}
