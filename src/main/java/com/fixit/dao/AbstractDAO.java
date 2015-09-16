/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.dao;

import com.fixit.model.BaseModel;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author joaorodrigo
 * @param <T extends BaseModel>
 */
public abstract class AbstractDAO<T extends BaseModel> {
    
    public abstract EntityManager getManager();
    public abstract Class<T> getClassType();    
    
    @Transactional
    public void save(T entity) {
        if (entity.getId() > 0) {
            getManager().merge(entity);
        } else {
            getManager().persist(entity);            
        }
    }
       
    public BaseModel find(Serializable id) {
        return (BaseModel) getManager().find(getClassType(), id);
    }
    
    public void remove(int id) {
        getManager().remove(find(id));
    }    
    
}
