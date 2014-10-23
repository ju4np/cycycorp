package com.fpmislata.banco.presentacion.controller;

import com.fpmislata.banco.dominio.Cuenta;
import com.fpmislata.banco.persistencia.dao.impl.CuentaDAO;
import com.fpmislata.banco.presentacion.json.JsonConverter;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CuentaController {
    

    @Autowired CuentaDAO cuentaDAO;
    @Autowired JsonConverter json;
    
     public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        
        String method = httpServletRequest.getMethod();
        
        Cuenta cuenta = cuentaDAO.get(1);
        
        if(cuenta==null){
            httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);    
        } else {
            
        httpServletResponse.setContentType("applications/json; charset=UTF-8");
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        httpServletResponse.getWriter().println(json.toJson(cuenta));
            
        }
                   
    }
    
    @RequestMapping(value = {"/EntidadBancaria/{idEntidadBancaria}"}, method = RequestMethod.GET)
    public void get(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuenta") int idEntidadBancaria) throws IOException {
        
        String method = httpServletRequest.getMethod();
        
        httpServletResponse.setContentType("applications/json; charset=UTF-8");
        Cuenta entidadBancaria = cuentaDAO.get(idEntidadBancaria);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        
        httpServletResponse.getWriter().println(json.toJson(entidadBancaria));       
    }
    
    
    @RequestMapping(value = {"/Cuenta/{idCuenta}"}, method = RequestMethod.DELETE)
    public void delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @PathVariable("idCuenta") int idCuenta) throws IOException {
        
        cuentaDAO.delete(idCuenta);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
        
    }
    

    @RequestMapping(value = {"/Cuenta"}, method = RequestMethod.POST)
    public void insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        
        Cuenta entidadBancaria = (Cuenta) json.fromJson(jsonEntrada, Cuenta.class);
        cuentaDAO.insert(entidadBancaria);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    
    @RequestMapping(value = {"/EntidadBancaria"}, method = RequestMethod.PUT)
    public void update(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestBody String jsonEntrada) throws IOException {
        
        Cuenta entidadBancaria = (Cuenta) json.fromJson(jsonEntrada, Cuenta.class);
        cuentaDAO.update(entidadBancaria);
        httpServletResponse.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
    
    @RequestMapping (value = {"/EntidadesBancarias"}, method = RequestMethod.GET)
    public void findAll (HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws IOException{
        List<Cuenta> lista = cuentaDAO.findAll();
        
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        
        String salida = json.toJson(lista);
        httpServletResponse.getWriter().println(salida);
    }
}
