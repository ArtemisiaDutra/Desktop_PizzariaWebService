/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.dao;

import br.com.pizzaria.entidade.Endereco;
import br.com.pizzaria.entidade.Fornecedor;
import static br.com.pizzaria.util.GeradorUtil.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Artemisia Dutra
 */
public class FornecedorDaoImplTest {

    private Fornecedor fornecedor;
    private FornecedorDao fornecedorDao;
    private Session sessao;

    public FornecedorDaoImplTest() {

        fornecedorDao = new FornecedorDaoImpl();
    }

//  @Test
    public void testSalvar() {
        System.out.println("salvar");
        fornecedor = new Fornecedor(gerarCnpj(), gerarInscricaoEstadual(), gerarNome(), gerarEmail(), gerarTelefoneFixo());

        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(gerarEndereco());
        enderecos.add(gerarEndereco());
        fornecedor.setEnderecos(enderecos);

        for (Endereco endereco : enderecos) {
            endereco.setPessoa(fornecedor);
        }
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();
        assertNotNull(fornecedor.getId());

    }

//    @Test   
    public void testAlterar() {
        System.out.println("alterar");
        buscarFornecedorBd();
        fornecedor.setNome(gerarNome());
        fornecedor.setEmail(gerarEmail());
        fornecedor.setCnpj(gerarCnpj());
        fornecedor.setInscricaoEstadual(gerarInscricaoEstadual());
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.salvarOuAlterar(fornecedor, sessao);
        sessao.close();

        sessao = HibernateUtil.abrirConexao();
        Fornecedor fornAlt = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        assertEquals(fornecedor.getNome(), fornAlt.getNome());
        assertEquals(fornecedor.getEmail(), fornAlt.getEmail());
        assertEquals(fornecedor.getTelefone(), fornAlt.getTelefone());
        assertEquals(fornecedor.getCnpj(), fornAlt.getCnpj());
        assertEquals(fornecedor.getInscricaoEstadual(), fornAlt.getInscricaoEstadual());

    }

//    @Test
    public void testExcluir() {
        System.out.println("excluir");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        fornecedorDao.excluir(fornecedor, sessao);

        Fornecedor pesFornExc = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);
        sessao.close();
        assertNull(pesFornExc);
    }

//    @Test
    public void testPesquisarPorId() {
        System.out.println("pesquisarPorId");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        Fornecedor pesqForn = fornecedorDao.pesquisarPorId(fornecedor.getId(), sessao);

    }

//    @Test
    public void testPesquisarPorNome() {
        System.out.println("pesquisarPorNome");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();

        List<Fornecedor> fornecedores = fornecedorDao.pesquisarPorNome(fornecedor.getNome(), sessao);
        sessao.close();
        assertTrue(!fornecedores.isEmpty());
    }


//  @Test    
    public void testPesquisarPorTelefone() {
        System.out.println("pesquisarPorTelefone");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        Fornecedor fornecedorTelefone = fornecedorDao.pesquisarPorTelefone(fornecedor.getTelefone(), sessao);
        sessao.close();;
        assertNotNull(fornecedorTelefone);

    }

    public Fornecedor buscarFornecedorBd() {
        sessao = HibernateUtil.abrirConexao();
        Query<Fornecedor> consulta = sessao.createQuery("from Fornecedor f");
        List<Fornecedor> fornecedores = consulta.getResultList();
        sessao.close();
        if (fornecedores.isEmpty()) {
            testSalvar();
        } else {
            fornecedor = fornecedores.get(0);
        }
        return fornecedor;
    }

//  @Test
    public void testVerificarEmailCadastrado() {
        System.out.println("verificarEmailCadastrado");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        boolean existeEmail = fornecedorDao.verificarEmailCadastrado(fornecedor.getEmail(), sessao);
        sessao.close();
        assertTrue(existeEmail);

    }

//     @Test
    public void testVerificarTelefoneCadastrado() {
        System.out.println("verificarTelefoneCadastrado");
        buscarFornecedorBd();
        sessao = HibernateUtil.abrirConexao();
        boolean existeTel = fornecedorDao.verificarTelefoneCadastrado(fornecedor.getTelefone(), sessao);
        sessao.close();
        assertTrue(existeTel);

    }

}
