/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.furb.fixit.controller;

import edu.furb.fixit.dao.AtendenteDao;
import edu.furb.fixit.dao.AtendimentoDAO;
import edu.furb.fixit.dao.ChamadoDao;
import edu.furb.fixit.dao.ClienteDao;
import edu.furb.fixit.dao.ProdutoDao;
import edu.furb.fixit.model.Atendimento;
import edu.furb.fixit.model.Chamado;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import util.Mensagem;
import util.Mensagem.TipoMensagem;

/**
 *
 * @author joao
 */
@Controller
@RequestMapping("/atendimentos")
public class AtendimentoController {
    
    @Autowired
    private ChamadoDao chamadoDAO;
        
    @Autowired
    private AtendenteDao atendenteDAO;
    
    @Autowired
    private AtendimentoDAO atendimentoDAO;
    
        
        @RequestMapping(value="/preparaCadastroAtendimento", method=RequestMethod.GET) 
        public String preparaCadastroAtendimento(Chamado chamado, Model model) {            
            Chamado c = chamadoDAO.find(chamado.getId());
            Atendimento atendimento = new Atendimento(c);
            model.addAttribute("atendimento", atendimento);
            fillAttributes(model);
            return "/atendimentos/atendimento";
        } 
    
        @RequestMapping(value="/cadastrar", method=RequestMethod.POST) 
        public ModelAndView cadastrar(Atendimento atendimento, Model model) {
            atendimentoDAO.save(atendimento);
            ModelAndView mv = new ModelAndView("redirect:/chamados/listar");
            return mv;            
        }
                
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(Integer idAtendimento, Model model) {
            Atendimento atendimento = (Atendimento) atendimentoDAO.find(idAtendimento);
            model.addAttribute("atendimento", atendimento);
            fillAttributes(model);
            return "/atendimentos/atendimento"; 
	}
        
        private void fillAttributes(Model model) {
            model.addAttribute("destinos", atendenteDAO.getList());
            model.addAttribute("origens", atendenteDAO.getList());           
        }
    
}
