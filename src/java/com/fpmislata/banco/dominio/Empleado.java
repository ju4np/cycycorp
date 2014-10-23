
package com.fpmislata.banco.dominio;

public class Empleado {
    
    int idEmpleado;
    String usuario, contraseña, nombre;
    String dni;
    String sucursal;

    public Empleado(int idEmpleado, String usuario, String contraseña, String nombre, String dni, String sucursal) {
        this.idEmpleado = idEmpleado;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.dni = dni;
        this.sucursal = sucursal;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
    
}
