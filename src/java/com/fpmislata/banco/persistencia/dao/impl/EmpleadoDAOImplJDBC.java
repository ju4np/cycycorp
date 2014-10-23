
package com.fpmislata.banco.persistencia.dao.impl;

import com.fpmislata.banco.dominio.Empleado;
import com.fpmislata.banco.persistencia.conexiones.ConnectionFactory;
import com.fpmislata.banco.persistencia.conexiones.impl.ConnectionFactoryImplDataSource;
import com.fpmislata.banco.persistencia.dao.EmpleadoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmpleadoDAOImplJDBC implements EmpleadoDAO{
    
    ConnectionFactory connectionFactory;
    
    @Override
    public Empleado get(Integer idEmpleado){
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Empleado empleado = null;
        Connection connection = null;

        try {
            connectionFactory = new ConnectionFactoryImplDataSource();
            connection = connectionFactory.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM empleado WHERE idEmpleado = ?");
            preparedStatement.setInt(1, idEmpleado);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()) {
                empleado = new Empleado(resultSet.getInt("idEmpleado"), resultSet.getString("usuario"),
                        resultSet.getString("contraseña"), resultSet.getString("nombre"),
                        resultSet.getString("dni"), resultSet.getString("sucursal"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connectionFactory.close(connection);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
        return empleado;
    }
    
    
    

    @Override
    public Empleado insert(Empleado object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado update(Empleado object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
