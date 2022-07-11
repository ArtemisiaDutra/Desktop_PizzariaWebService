/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.tela;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.entidade.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maria.sousa9
 */
public class ClientePesquisado extends javax.swing.JFrame {

    private ClienteDao clienteDao;
    private Session sessao;
    private Cliente cliente;
    private List<Cliente> clientes;
    private DefaultTableModel tabelaModelo;

    public ClientePesquisado() {
        initComponents();
        clienteDao = new ClienteDaoImpl();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        varTabela = new javax.swing.JTable();
        btExcluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gupy Sistemas - Tela Pesquisa de Cliente");

        lbTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Pesquisar Cliente");

        lbNome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNome.setText("Nome:");

        btPesquisar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        varTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Email", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(varTabela);

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(varNome)
                        .addGap(18, 18, 18)
                        .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        String nome = varNome.getText().trim();
        if (nome.length() < 3) {
            JOptionPane.showMessageDialog(null, "Digite um nome com no mínimo três letras");
        } else {
            sessao = HibernateUtil.abrirConexao();
            clientes = clienteDao.pesquisarPorNome(nome, sessao);
            sessao.close();
            if (clientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhum valor encontrado");
            } else {
                popularTabela();
            }

        }


    }//GEN-LAST:event_btPesquisarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int numeroLinha = varTabela.getSelectedRow();
        if (numeroLinha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        } else {
            Cliente clienteSelecionado = clientes.get(numeroLinha);
            sessao = HibernateUtil.abrirConexao();
            try {
                clienteDao.excluir(clienteSelecionado, sessao);
                varNome.setText("");
                JOptionPane.showMessageDialog(null, clienteSelecionado.getNome() + " excluído com sucesso!");
                tabelaModelo.setNumRows(0);

            } catch (HibernateException e) {
                System.out.println("Erro ao excluir " + e.getMessage());
            } finally {
                sessao.close();
            }
        }


    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
//        int numeroLinha = varTabela.getSelectedRow();
//        Cliente clienteSelecionado = clientes.get(numeroLinha);
//        new ClienteCadastro(clienteSelecionado).setVisible(true);
//        dispose();
        int numeroLinha = varTabela.getSelectedRow();
        if (numeroLinha == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha");
        } else {
            Cliente clienteSelecionado = clientes.get(numeroLinha);
            new ClienteCadastro(clienteSelecionado).setVisible(true);
            sessao = HibernateUtil.abrirConexao();
            try {
                varNome.setText("");
                dispose();
                tabelaModelo.setNumRows(0);

            } catch (HibernateException e) {
                System.out.println("Erro ao alterar " + e.getMessage());
            } finally {
                sessao.close();
            }

        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void popularTabela() {
        tabelaModelo = (DefaultTableModel) varTabela.getModel();
        tabelaModelo.setNumRows(0);
        for (Cliente cliente1 : clientes) {
            tabelaModelo.addRow(new Object[]{
                cliente1.getNome(), cliente1.getTelefone(), cliente1.getEmail()});
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientePesquisado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientePesquisado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientePesquisado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientePesquisado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientePesquisado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField varNome;
    private javax.swing.JTable varTabela;
    // End of variables declaration//GEN-END:variables
}
