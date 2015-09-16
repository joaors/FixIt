/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author joao
 */
@Entity
public class Atendente implements BaseModel{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String descricao;
    
    public Atendente(){}

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        return descricao;
    }
    
}
