package com.fpmislata.banco.dominio;

import java.util.Date;


public class Cuenta {
    
    /**
     * Variable de tipo Integer que representa el ID de la cuenta.
     */
    int idCuenta;
    
    /**
     * Variable de tipo String que contiene el nombre de usuario del cliente.
     */
    String cliente;
    
    /**
     * Variable de tipo Double que representa el Saldo de la cuenta.
     */
    double saldo;
    
    /**
     * Variable de tipo Date que representa la Fecha de Creación de la cuenta.
     */
    Date fechaCreacion;
    
    /**
     * Variable de tipo Integer que contiene la Sucursal Bancaria de la cuenta.
     */
    int SucursalBancaria;

    public Cuenta(int idCuenta, String cliente, double saldo, Date fechaCreacion, int SucursalBancaria) {
        this.idCuenta = idCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.SucursalBancaria = SucursalBancaria;
    }

    /**
     * Método Consultor de la clase cuenta
     * @return Devuelve un Integer que contiene el ID de la cuenta.
     */
    public int getIdCuenta() {
        return idCuenta;
    }

    /**
     * Método Modificador de la clase cuenta.
     * @param idCuenta Variable que contiene el nuevo ID de la cuenta.
     */
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Método Consultor de la clase cuenta.
     * @return Devuelve un String que contiene el Usuario del cliente.
     */
    public String getCliente() {
        return cliente;
    }

    /**
     * Método Modificador de la clase cuenta.
     * @param cliente Variable que contiene el nuevo Usuario del cliente.
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    /**
     * Método Consultor de la clase cuenta.
     * @return Devuelve un Double que contiene el saldo de la cuenta.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Método Modificador de la clase cuenta.
     * @param saldo Variable que contiene el nuevo saldo del cliente.
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Método consultor de la clase cuenta.
     * @return Devuelve una variable de tipo Date que contiene
     * la Fecha de Creacion de la cuenta.
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Método Modificador de la clase cuenta.
     * @param fechaCreacion Variable que contiene la nueva Fecha de Creación.
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * Método Consultor de la clase cuenta.
     * @return Devuelve un Integer que contiene el valor de la Sucursal Bancaria.
     */
    public int getSucursalBancaria() {
        return SucursalBancaria;
    }

    /**
     * Método Modificador de la clase cuenta.
     * @param SucursalBancaria Variable que contiene la nueva Sucursal Bancaria.
     */
    public void setSucursalBancaria(int SucursalBancaria) {
        this.SucursalBancaria = SucursalBancaria;
    }
    
    
}
