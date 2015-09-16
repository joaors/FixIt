/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fixit.controller;

import com.fixit.dao.ClienteDao;
import com.fixit.model.Cliente;
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
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteDao clienteDAO;
    
        
	@RequestMapping(value="/preparaCadastroCliente")
	public String redirecionaCadastroCliente(Map<String, Object> map) {
		map.put("cliente", new Cliente());		
		return "/clientes/cliente";
	}    
    
        @RequestMapping(value="/cadastrar", method=RequestMethod.POST) 
        public String cadastrar(Cliente cliente, Model model) {
            clienteDAO.save(cliente);
            model.addAttribute("cliente", new Cliente()); 
            model.addAttribute("mensagem", new Mensagem("Cliente cadastrado com sucesso", TipoMensagem.SUCESSO)); 
            return "clientes/cliente"; 
        } 
        
        @RequestMapping(value="/listar", method=RequestMethod.GET) 
        public String listar(Model model) { 
            List<Cliente> clientes = clienteDAO.getList(); 
            model.addAttribute("clientes", clientes); 
            return "clientes/lista";
        }
        
	@RequestMapping(value="/excluir", method=RequestMethod.GET)
	public String excluir(Integer idCliente, Model model) {
		clienteDAO.remove(idCliente);
		model.addAttribute("mensagem", new Mensagem("Sucesso ao excluir o cliente", TipoMensagem.SUCESSO));		
		return "forward:/clientes/listar";
	}
        
        
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(Integer idCliente, Model model) {
            Cliente cliente = (Cliente) clienteDAO.find(idCliente);
            model.addAttribute("cliente", cliente);
            return "clientes/cliente"; 
	}           
    
}
