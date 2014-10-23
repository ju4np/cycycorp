

package com.fpmislata.banco.persistencia.dao;

import java.util.List;


public interface GenericDAO<T, ID> {
      
    public T get(ID id);
    
    public T insert(T object);
    
    public T update(T object);
    
    public void delete(ID id);
    
    public List<T> findAll();
    
}
