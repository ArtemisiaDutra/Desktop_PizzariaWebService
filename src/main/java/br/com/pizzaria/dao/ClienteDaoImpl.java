/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Cliente;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author maria.sousa9
 */
//tipo da chava primaria Long
public class ClienteDaoImpl extends BaseDaoImpl<Cliente, Long> implements ClienteDao, Serializable {

    @Override
    public Cliente pesquisarPorId(Long id, Session sessao) throws HibernateException {
        return sessao.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> pesquisarPorNome(String nome, Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao.createQuery("select distinct(c) from Cliente c join fetch c.enderecos where c.nome like :nome");//opcional: join fech c.enderecos | puxa a lista de endereço e nome nos métodos pode demoar
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }
//Pesquisar cliente por telefone e trazer todos os seus pedidos.

    @Override
    public Cliente pesquisarPorTelefone(String telefone, Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao.createQuery("from Cliente c join fetch c.pedidos where c.telefone = :tel");
        consulta.setParameter("tel", telefone);
        return consulta.getSingleResult();
    }

    @Override
    public boolean verificarEmailCadastrado(String email, Session sessao) throws HibernateException {
        Query<Cliente> consulta = sessao.createQuery("from Cliente c where c.email = :email");
        consulta.setParameter("email", email);
        Cliente cliente = consulta.uniqueResult();
        return cliente != null;
    }

    @Override
    public boolean verificarTelefoneCadastrado(String telefoneCadastrado, Session sessao) throws HibernateException {
        Query<String> consulta = sessao.createQuery("select c.telefone from Cliente c where c.telefone  = :telCadastrado");
        consulta.setParameter("telCadastrado", telefoneCadastrado);
        String resultadoTel = consulta.uniqueResult();
        return resultadoTel != null;
        
        
    }

}
