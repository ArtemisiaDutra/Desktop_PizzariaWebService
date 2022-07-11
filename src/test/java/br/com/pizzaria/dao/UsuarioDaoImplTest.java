/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import br.com.pizzaria.util.GeradorUtil;
import static br.com.pizzaria.util.GeradorUtil.*;
import org.hibernate.Session;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maria.sousa9
 */
public class UsuarioDaoImplTest {
    
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private Session sessao;
    
    public UsuarioDaoImplTest() {
        usuarioDao = new UsuarioDaoImpl();
    }

    @Test
    public void testSalvar() {
        System.out.println("salvar");
        usuario = new Usuario(null, gerarNome(), gerarLogin(), gerarSenha(5));  
        sessao = HibernateUtil.abrirConexao();
        usuarioDao. salvarOuAlterar(usuario, sessao);
        sessao.close();
        assertNotNull(usuario.getId());

    }
    
//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");

    }
    
}
