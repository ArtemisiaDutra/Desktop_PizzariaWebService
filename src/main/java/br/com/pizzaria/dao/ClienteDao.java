/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Cliente;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maria.sousa9
 */
public interface ClienteDao extends BaseDao<Cliente, Long> {

    List<Cliente> pesquisarPorNome(String nome, Session sessao) throws HibernateException;

    Cliente pesquisarPorTelefone(String telefone, Session sessao) throws HibernateException;

    boolean verificarEmailCadastrado(String email, Session sessao) throws HibernateException;

    boolean verificarTelefoneCadastrado(String telefone, Session sessao) throws HibernateException;
}
