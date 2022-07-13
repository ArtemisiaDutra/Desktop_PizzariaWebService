/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Fornecedor;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maria.sousa9
 */
public interface FornecedorDao extends BaseDao<Fornecedor, Long> {

    List<Fornecedor> pesquisarPorNome(String nome, Session sessao) throws HibernateException;

    Fornecedor pesquisarPorTelefone(String telefone, Session sessao) throws HibernateException;

    boolean verificarEmailCadastrado(String email, Session sessao) throws HibernateException;

    boolean verificarTelefoneCadastrado(String telefone, Session sessao) throws HibernateException;

}
