/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Endereco;
import static br.com.pizzaria.util.GeradorUtil.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maria.sousa9
 */
public class ClienteDaoImplTest {

    private Cliente cliente;
    private ClienteDao clienteDao;
    private Session sessao;

    // clienteDao e faz receber o cliente daoimpl = polimofismo
    public ClienteDaoImplTest() {

        clienteDao = new ClienteDaoImpl();
    }

//    @Test
    public void testSalvar() {
        System.out.println("salvar");
        cliente = new Cliente(gerarNome(), gerarEmail(), gerarTelefoneFixo(), true);

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(gerarEndereco());
        enderecos.add(gerarEndereco());
        cliente.setEnderecos(enderecos);
        
        for (Endereco endereco : enderecos) {
            endereco.setPessoa(cliente);
        }
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();
        assertNotNull(cliente.getId());

    }
//       @Test   
    public void testAlterar() {
        System.out.println("alterar");
        buscarClienteBd();
        cliente.setNome(gerarNome());
        cliente.setEmail(gerarEmail());
        sessao = HibernateUtil.abrirConexao();
        clienteDao.salvarOuAlterar(cliente, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Cliente cliAlt = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertEquals(cliente.getNome(), cliAlt.getNome());
        assertEquals(cliente.getEmail(), cliAlt.getEmail());
        assertEquals(cliente.getTelefone(), cliAlt.getTelefone());

    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        clienteDao.excluir(cliente, sessao);

        Cliente pesCliExc = clienteDao.pesquisarPorId(cliente.getId(), sessao);
        sessao.close();
        assertNull(pesCliExc);
    }

//    @Test   
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        Cliente pesqCli = clienteDao.pesquisarPorId(cliente.getId(), sessao);
    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();

        List<Cliente> clientes = clienteDao.pesquisarPorNome(cliente.getNome(), sessao);
        sessao.close();
        assertTrue(!clientes.isEmpty());

    }

//    @Test
    public void testPesquisarPorTelefone() {
        System.out.println("pesquisarPorTelefone");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        Cliente clienteTelefone = clienteDao.pesquisarPorTelefone(cliente.getTelefone(), sessao);
        sessao.close();
        assertNotNull(clienteTelefone);

    }

    public Cliente buscarClienteBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Cliente> consulta = sessao.createQuery("from Cliente c");
        List<Cliente> clientes = consulta.getResultList();
        sessao.close();
        if (clientes.isEmpty()) {
            testSalvar();
        } else {
            cliente = clientes.get(0);
        }
        return cliente;
    }

//    @Test
    public void testVerificarEmailCadastrado() {
        System.out.println("verificarEmailCadastrado");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        boolean existeEmail = clienteDao.verificarEmailCadastrado(cliente.getEmail(), sessao);
        sessao.close();
        assertTrue(existeEmail);

    }

//    @Test
    public void testVerificarTelefoneCadastrado() {
        System.out.println("verificarTelefoneCadastrado");
        buscarClienteBd();
        sessao = HibernateUtil.abrirConexao();
        boolean existeTel = clienteDao.verificarTelefoneCadastrado(cliente.getTelefone(), sessao);
        sessao.close();
        assertTrue(existeTel);

    }

}
