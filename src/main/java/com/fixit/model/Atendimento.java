/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.model;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author joao
 */
@Entity
public class Atendimento implements BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDATENDENTEORIGEM")
    private Atendente atendenteOrigem;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDATENDENTEDESTINO")
    private Atendente atendenteDestino;    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDCHAMADO")
    private Chamado chamado;
    
    private String observacao;

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    public Atendimento(){}

    public Atendimento(Chamado c) {
        this.chamado = c;
    }

    public Chamado getChamado() {
        return chamado;
    }

    public void setChamado(Chamado chamado) {
        this.chamado = chamado;
    }

    public Atendente getAtendenteOrigem() {
        return atendenteOrigem;
    }

    public void setAtendenteOrigem(Atendente atendenteOrigem) {
        this.atendenteOrigem = atendenteOrigem;
    }

    public Atendente getAtendenteDestino() {
        return atendenteDestino;
    }

    public void setAtendenteDestino(Atendente atendenteDestino) {
        this.atendenteDestino = atendenteDestino;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public Integer getId() {
        return id;
    }
    
    @Override
    public int hashCode() {
        int hash = Objects.hash(id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this, obj);    
    }
    
    @Override
    public String toString() {
        return String.valueOf(id);
    }
    
    
}
