/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maria.sousa9
 */
public class UsuarioDaoImpl extends BaseDaoImpl<Usuario, Long> implements UsuarioDao{

    @Override
    public Usuario pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.get(Usuario.class, id);
    }
    
}
