
package com.fpmislata.banco.dominio;

public class Cliente {
        
    int idCliente;
    String usuario;
    String contraseña;
    String nombre;
    String dni;

    public Cliente(int idCliente, String usuario, String contraseña, String nombre, String dni) {
        this.idCliente = idCliente;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.dni = dni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
    
}
