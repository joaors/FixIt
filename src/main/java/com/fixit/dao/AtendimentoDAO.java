/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.dao;

import com.fixit.model.Atendimento;
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
public class AtendimentoDAO extends AbstractDAO<Atendimento>{

    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public EntityManager getManager() {
        return manager;
    }

    @Override
    public Class<Atendimento> getClassType() {
        return Atendimento.class;
    }
    
    @Transactional
    public List<Atendimento> getList() {
        List<Atendimento> list = manager.createQuery("Select a from Atendimento a "
                + "join fetch a.atendenteOrigem "
                + "join fetch a.atendenteDestino ").getResultList();
        return list;
    }
    
    @Transactional
    public List<Atendimento> getListByChamado(Integer idChamado) {
        List<Atendimento> list = manager.createQuery("Select a from Atendimento a "
                + "join fetch a.atendenteOrigem "
                + "join fetch a.atendenteDestino "
                + "where a.chamado.id = :id")
                                            .setParameter("id", idChamado)
                                            .getResultList();
        return list;
    }    
}
