/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.furb.fixit.dao;

import edu.furb.fixit.model.Atendente;
import edu.furb.fixit.model.Cliente;
import edu.furb.fixit.model.Produto;
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
public class AtendenteDao extends AbstractDAO<Atendente>{
    
    @PersistenceContext
    private EntityManager manager;

    
    @Transactional
    public List<Atendente> getList() {
	return manager.createQuery(
			"Select p from Atendente p ",
			Atendente.class).getResultList();        
    }

    @Override
    public EntityManager getManager() {
        return manager;
    }

    @Override
    public Class<Atendente> getClassType() {
        return Atendente.class;
    }


}
