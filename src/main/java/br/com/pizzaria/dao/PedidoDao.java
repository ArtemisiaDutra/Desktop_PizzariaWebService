/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maria.sousa9
 */
public interface PedidoDao extends BaseDao<Pedido, Long> {

    List<Pedido> pesquisarPorNumero(int numero, Session sessao) throws HibernateException;

    List<Pedido> pesquisarPorValorMaiorIgual(BigDecimal valor, Session sessao) throws HibernateException;

    Pedido pesquisarPorTelefone(String telefone, Session sessao) throws HibernateException;

    boolean verificarTelefoneCadastrado(String telefone, Session sessao) throws HibernateException;
}
