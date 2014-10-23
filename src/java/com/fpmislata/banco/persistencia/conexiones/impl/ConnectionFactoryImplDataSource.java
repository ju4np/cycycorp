
package com.fpmislata.banco.persistencia.conexiones.impl;

import com.fpmislata.banco.persistencia.conexiones.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class ConnectionFactoryImplDataSource implements ConnectionFactory{

    @Override
    public Connection getConnection() {
        try {
            InitialContext initialContext = new InitialContext();
            Context context = (Context) initialContext.lookup("java:comp/env");
            DataSource dataSource = (DataSource) context.lookup("jdbc/cycybank");
            return dataSource.getConnection();
        } catch (NamingException|SQLException ex) {
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
