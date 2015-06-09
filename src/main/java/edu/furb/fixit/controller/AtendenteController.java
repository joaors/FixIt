/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.furb.fixit.controller;

import edu.furb.fixit.dao.AtendenteDao;
import edu.furb.fixit.model.Atendente;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.Mensagem;
import util.Mensagem.TipoMensagem;

/**
 *
 * @author joao
 */
@Controller
@RequestMapping("/atendentes")
public class AtendenteController {
    
    @Autowired
    private AtendenteDao atendenteDAO;
    
        
	@RequestMapping(value="/preparaCadastroAtendente")
	public String redirecionaCadastroCliente(Map<String, Object> map) {
		map.put("atendente", new Atendente());		
		return "/atendentes/atendente";
	}    
    
        @RequestMapping(value="/cadastrar", method=RequestMethod.POST) 
        public String cadastrar(Atendente atendente, Model model) {
            atendenteDAO.save(atendente);
            model.addAttribute("atendente", new Atendente()); 
            model.addAttribute("mensagem", new Mensagem("Atendente cadastrado com sucesso", TipoMensagem.SUCESSO)); 
            return "atendentes/atendente"; 
        } 
        
        @RequestMapping(value="/listar", method=RequestMethod.GET) 
        public String listar(Model model) { 
            List<Atendente> atendentes = atendenteDAO.getList(); 
            model.addAttribute("atendentes", atendentes); 
            return "atendentes/lista";
        }
        
	@RequestMapping(value="/excluir", method=RequestMethod.GET)
	public String excluir(Integer idAtendente, Model model) {
		atendenteDAO.remove(idAtendente);
		model.addAttribute("mensagem", new Mensagem("Sucesso ao excluir o atendente", TipoMensagem.SUCESSO));		
		return "forward:/atendentes/listar";
	}
        
        
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(Integer idAtendente, Model model) {
            Atendente atendente = (Atendente) atendenteDAO.find(idAtendente);
            model.addAttribute("atendente", atendente);
            return "atendentes/atendente"; 
	}           
    
}
