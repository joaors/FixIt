/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.furb.fixit.dao;

import edu.furb.fixit.model.BaseModel;
import edu.furb.fixit.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joao
 */
@Repository
public class ClienteDao extends AbstractDAO<Cliente>{
    
    @PersistenceContext
    private EntityManager manager;

    
    @Transactional
    public List<Cliente> getList() {
	return manager.createQuery(
			"Select p from Cliente p ",
			Cliente.class).getResultList();        
    }

    @Override
    public EntityManager getManager() {
        return manager;
    }

    @Override
    public Class<Cliente> getClassType() {
        return Cliente.class;
    }

}
