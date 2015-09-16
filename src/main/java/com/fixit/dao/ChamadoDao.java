/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.dao;

import com.fixit.model.Atendimento;
import com.fixit.model.Chamado;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joaorodrigo
 */
@Repository
public class ChamadoDao extends AbstractDAO<Chamado>{
    
    @PersistenceContext
    private EntityManager manager;
    
    @Autowired
    private AtendimentoDAO atendimentoDAO;
    
    @Override
    public Chamado find(Serializable id) {
        return manager.createQuery("Select c from Chamado c "
                + "join fetch c.produto "
                + "join fetch c.cliente "
                + "join fetch c.atendente "
                + "where c.id = :id", Chamado.class)
                                            .setParameter("id", id)
                                            .getSingleResult();
    }
        
    @Transactional
    public List<Chamado> getList() {
        return manager.createQuery("Select c from Chamado c "
                + "join fetch c.produto "
                + "join fetch c.cliente "
                + "join fetch c.atendente").getResultList();
    }    

    @Override
    public EntityManager getManager() {
        return manager;
    }

    @Override
    public Class<Chamado> getClassType() {
        return Chamado.class;
    }
    
    @Override    
    public void remove(int id) {        
        List<Atendimento> atendimentos = atendimentoDAO.getListByChamado(id);
        atendimentos.forEach(p -> manager.remove(p));
        getManager().remove(find(id));
    }     

}
