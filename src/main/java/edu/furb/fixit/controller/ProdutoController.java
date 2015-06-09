/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.furb.fixit.controller;

import edu.furb.fixit.dao.ProdutoDao;
import edu.furb.fixit.model.Produto;
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
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoDao produtoDAO;
    
        
	@RequestMapping(value="/preparaCadastroProduto")
	public String redirecionaCadastroProduto(Map<String, Object> map) {
		map.put("produto", new Produto());		
		return "/produtos/produto";
	}    
    
        @RequestMapping(value="/cadastrar", method=RequestMethod.POST) 
        public String cadastrar(Produto produto, Model model) {
            produtoDAO.save(produto);
            model.addAttribute("produto", new Produto()); 
            model.addAttribute("mensagem", new Mensagem("Produto cadastrado com sucesso", TipoMensagem.SUCESSO)); 
            return "produtos/produto"; 
        } 
        
        @RequestMapping(value="/listar", method=RequestMethod.GET) 
        public String listar(Model model) { 
            List<Produto> produtos = produtoDAO.getList(); 
            model.addAttribute("produtos", produtos); 
            return "produtos/lista";
        }
        
	@RequestMapping(value="/excluir", method=RequestMethod.GET)
	public String excluir(Integer idProduto, Model model) {
            try {
                produtoDAO.remove(idProduto);
                model.addAttribute("mensagem", new Mensagem("Sucesso ao excluir o produto", TipoMensagem.SUCESSO));		
            } catch (Exception e) {
                model.addAttribute("mensagem", new Mensagem(e.getMessage(), TipoMensagem.ERRO));		
            }            
                
		return "forward:/produtos/listar";
	}
        
        
	@RequestMapping(value="/editar", method=RequestMethod.GET)
	public String editar(Integer idProduto, Model model) {
            Produto produto = (Produto) produtoDAO.find(idProduto);
            model.addAttribute("produto", produto);
            return "produtos/produto"; 
	}           
    
}
