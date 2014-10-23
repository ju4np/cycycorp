package com.fpmislata.banco.persistencia.conexiones.impl;

import com.fpmislata.banco.persistencia.conexiones.ConnectionFactory;
import com.fpmislata.banco.persistencia.conexiones.ConnectionFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryImplDriverManager implements ConnectionFactory {

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/banco", "root", "root");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
