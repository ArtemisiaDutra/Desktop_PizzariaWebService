/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author maria.sousa9
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao, Serializable {

    private Session sessao;
    private UsuarioDao usuarioDao;

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

    @Override
    public List<Usuario> pesquisarPorNome(String nome, Session sessao) throws HibernateException {

        Query<Usuario> consulta = sessao.createQuery("select u from Usuario u where u.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

}
