/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.furb.fixit.model;

/**
 *
 * @author joao
 */
public enum Situacao {
    
    Aberto {

        @Override
        public String getClasseCss() {
            return "label label-default";
        }
    },
    Finalizado {

        @Override
        public String getClasseCss() {
            return "label label-success";
        }
    },
    Execucao {

        @Override
        public String getClasseCss() {
            return "label label-primary";
        }
    };
    
    
    public abstract String getClasseCss();
    
}
