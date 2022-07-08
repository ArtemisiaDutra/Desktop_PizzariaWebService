/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author maria.sousa9
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao{

    private Session sessao;
    
    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Usuario.class, id);
    }

    @Override
    public Usuario pesquisarLogin(String login, String senha, Session sessao) throws HibernateException {
        Query<Usuario> consulta = sessao.createQuery("from Usuario u where u.login = :login and u.senha = :senha");
        consulta.setParameter("login", login);
        consulta.setParameter("senha", senha);
        return consulta.uniqueResult();
    }
    
}
