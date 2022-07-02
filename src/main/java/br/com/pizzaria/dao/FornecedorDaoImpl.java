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
        Query<Fornecedor> consulta = sessao.createQuery("from Fornecedor f join fetch f.enderecos where f.nome like :nome");
        consulta.setParameter("nome", "%" + nome + "%");
        return consulta.getResultList();
    }

    @Override
    public List<Fornecedor> pesquisarFornecedorEProdutoPorNome(String nome, Session sessao) throws HibernateException {
        Query<Fornecedor> consulta = sessao.createQuery("from Fornecedor f join fetch f.produtos p where f.nome like :nomeFornecedor");// o f representa o fornecedor - f.produtos representa a associação com o fornecdor
        consulta.setParameter("nomeFornecedor", "%" + nome + "%");
        return consulta.list();
    }

}
