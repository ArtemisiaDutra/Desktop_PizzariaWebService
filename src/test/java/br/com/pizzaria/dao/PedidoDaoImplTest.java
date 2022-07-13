/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Pedido;
import br.com.pizzaria.util.GeradorUtil;
import static br.com.pizzaria.util.GeradorUtil.gerarNumero;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maria.sousa9
 */
public class PedidoDaoImplTest {

    private Pedido pedido;
    private PedidoDao pedidoDao;
    private Session sessao;

    public PedidoDaoImplTest() {
        pedidoDao = new PedidoDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        ClienteDaoImplTest cdit = new ClienteDaoImplTest();
        pedido = new Pedido(5, new BigDecimal(gerarNumero(3)), new Date());
        pedido.setCliente(cdit.buscarClienteBd());
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.salvarOuAlterar(pedido, sessao);
        sessao.close();
        assertNotNull(pedido.getId());

    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();
        pedidoDao.excluir(pedido, sessao);

        Pedido pesPedExc = pedidoDao.pesquisarPorId(pedido.getId(), sessao);
        sessao.close();
        assertNull(pesPedExc);
    }
//    @Test

    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();
        Pedido pesqPedido = pedidoDao.pesquisarPorId(pedido.getId(), sessao);

    }

//    @Test
    public void testPesquisarPorNumero() {
        System.out.println("pesquisarPorNumero");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();

        List<Pedido> pedidos = pedidoDao.pesquisarPorNumero(pedido.getNumero(), sessao);
        sessao.close();
        assertTrue(!pedidos.isEmpty());
    }

    @Test
    public void testPesquisarPorValorMaiorIgual() {
        System.out.println("pesquisarPorValorMaiorIgual");
        buscarPedidoBd();
        sessao = HibernateUtil.abrirConexao();

        List<Pedido> pedidos = pedidoDao.pesquisarPorValorMaiorIgual(pedido.getValorTotal(), sessao);
        sessao.close();
        assertTrue(!pedidos.isEmpty());
    }


    public Pedido buscarPedidoBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Pedido> consulta = sessao.createQuery("from Pedido  p");
        List<Pedido> pedidos = consulta.getResultList();
        sessao.close();
        if (pedidos.isEmpty()) {
            testSalvar();
        } else {
            pedido = pedidos.get(0);
        }
        return pedido;
    }

 
}
