/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Fornecedor;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Artemisia Dutra
 */
public class FornecedorDaoImpl extends BaseDaoImpl<Fornecedor, Long> implements FornecedorDao, Serializable {

    @Override
    public Fornecedor pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Fornecedor.class, id);
    }

    @Override
    public List<Fornecedor> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao.createQuery("select distinct(f) from Fornecedor f join fetch f.enderecos where f.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public Fornecedor pesquisarPorTelefone(String telefone, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao.createQuery("from Fornecedor f where f.telefone = :tel");
        consulta.setParameter("tel", telefone);
        return consulta.getSingleResult();
    }

    @Override
    public boolean verificarEmailCadastrado(String email, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao.createQuery("from Fornecedor f where f.email = :email");
        consulta.setParameter("email", email);
        Fornecedor fornecedor = consulta.uniqueResult();
        return fornecedor != null;
    }

    @Override
    public boolean verificarTelefoneCadastrado(String telefoneCadastrado, Session sessao) throws HibernateException {
        Query<String> consulta = sessao.createQuery("select c.telefone from Fornecedor c where c.telefone  = :telCadastrado");
        consulta.setParameter("telCadastrado", telefoneCadastrado);
        String resultadoTel = consulta.uniqueResult();
        return resultadoTel != null;
    }

}
