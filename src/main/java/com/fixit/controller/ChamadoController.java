/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controller;

import com.google.common.collect.Lists;
import com.fixit.dao.AtendenteDao;
import com.fixit.dao.AtendimentoDAO;
import com.fixit.dao.ChamadoDao;
import com.fixit.dao.ClienteDao;
import com.fixit.dao.ProdutoDao;
import com.fixit.model.Chamado;
import com.fixit.model.Situacao;
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
@RequestMapping("/chamados")
public class ChamadoController {
    
    @Autowired
    private ChamadoDao chamadoDAO;
    
    @Autowired
    private ProdutoDao produtoDAO;
    
    @Autowired
    private ClienteDao clienteDAO;
    
    @Autowired
    private AtendenteDao atendenteDAO;
    
    @Autowired
    private AtendimentoDAO atendimentoDAO;
    
        
	@RequestMapping(value="/preparaCadastroChamado")
	public String redirecionaCadastroChamado(Map<String, Object> map) {
		map.put("chamado", new Chamado());
                map.put("produtos", produtoDAO.getList());
                map.put("clientes", clienteDAO.getList());
                map.put("atendentes", atendenteDAO.getList());
                map.put("situacoes", Situacao.values());
                map.put("atendimentos", Lists.newLinkedList());
                map.put("disableAddAtendimento", true);
		return "/chamados/chamado";
	}
    
        @RequestMapping(value="/cadastrar", method=RequestMethod.POST) 
        public ModelAndView cadastrar(Chamado chamado, Model model) {
            chamadoDAO.save(chamado);   
            ModelAndView mv = new ModelAndView("redirect:/chamados/listar");
            return mv; 
        } 
        
        @RequestMapping(value="/listar", method=RequestMethod.GET) 
        public String listar(Model model) { 
            List<Chamado> chamados = chamadoDAO.getList(); 
            model.addAttribute("chamados", chamados); 
            return "/chamados/lista";
        }
        
	@RequestMapping(value="/excluir", method=RequestMethod.GET)
	public String excluir(Integer idChamado, Model model) {
		chamadoDAO.remove(idChamado);
		model.addAttribute("mensagem", new Mensagem("Chamado excluido com sucesso", TipoMensagem.SUCESSO));		
		return "forward:/chamados/listar";
	}
        
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(Integer idChamado, Model model) {
            Chamado chamado = chamadoDAO.find(idChamado);
            model.addAttribute("chamado", chamado);
            model.addAttribute("disableAddAtendimento", false);
            fillAttributes(model, chamado);
            return "/chamados/chamado"; 
	}
        
        private void fillAttributes(Model model, Chamado chamado) {
            model.addAttribute("produtos", produtoDAO.getList());
            model.addAttribute("clientes", clienteDAO.getList());
            model.addAttribute("atendentes", atendenteDAO.getList());
            model.addAttribute("atendimentos", atendimentoDAO.getListByChamado(chamado.getId()));
            model.addAttribute("situacoes", Situacao.values());
        }
    
}
