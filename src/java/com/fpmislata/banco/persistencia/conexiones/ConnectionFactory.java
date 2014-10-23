
package com.fpmislata.banco.persistencia.conexiones;

import java.sql.Connection;


public interface ConnectionFactory {
    
    public Connection getConnection();
    
    void close(Connection connection);
    
}
