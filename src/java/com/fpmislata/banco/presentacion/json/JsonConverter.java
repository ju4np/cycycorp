
package com.fpmislata.banco.presentacion.json;


public interface JsonConverter {
    
    public String toJson(Object object);
    
    public <T> T fromJson(String json, Class<T> clazz);
    
}
