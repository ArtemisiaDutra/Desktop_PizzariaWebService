/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.tela;

import br.com.pizzaria.entidade.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author maria.sousa9
 */
public class Principal extends javax.swing.JFrame {

    private Usuario usuarioLogado;

    public Principal() {
        initComponents();
    }

    public Principal(Usuario usuario) {
        initComponents();
        usuarioLogado = usuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        titulo = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        menuBarra = new javax.swing.JMenuBar();
        cadastro = new javax.swing.JMenu();
        clienteCadastro = new javax.swing.JMenuItem();
        UsuarioCadastro = new javax.swing.JMenuItem();
        FornecedorCadastro = new javax.swing.JMenuItem();
        Pesquisa = new javax.swing.JMenu();
        clientePesquisado = new javax.swing.JMenuItem();
        usuarioPesquisado = new javax.swing.JMenuItem();
        fornecedorPesquisado = new javax.swing.JMenuItem();
        ajuda = new javax.swing.JMenu();
        sair = new javax.swing.JMenu();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("© 2022 Todos os Direitos Reservados | Gupy Sistemas");

        titulo1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("La Louca Pizza");

        cadastro.setText("Cadastro");

        clienteCadastro.setText("Cliente");
        clienteCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteCadastroActionPerformed(evt);
            }
        });
        cadastro.add(clienteCadastro);

        UsuarioCadastro.setText("Usuário");
        UsuarioCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioCadastroActionPerformed(evt);
            }
        });
        cadastro.add(UsuarioCadastro);

        FornecedorCadastro.setText("Fornecedor");
        FornecedorCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FornecedorCadastroActionPerformed(evt);
            }
        });
        cadastro.add(FornecedorCadastro);

        menuBarra.add(cadastro);

        Pesquisa.setText("Pesquisa");

        clientePesquisado.setText("Cliente");
        clientePesquisado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientePesquisadoActionPerformed(evt);
            }
        });
        Pesquisa.add(clientePesquisado);

        usuarioPesquisado.setText("Usuário");
        usuarioPesquisado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioPesquisadoActionPerformed(evt);
            }
        });
        Pesquisa.add(usuarioPesquisado);

        fornecedorPesquisado.setText("Fornecedor");
        fornecedorPesquisado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedorPesquisadoActionPerformed(evt);
            }
        });
        Pesquisa.add(fornecedorPesquisado);

        menuBarra.add(Pesquisa);

        ajuda.setText("Pedidos");
        menuBarra.add(ajuda);

        sair.setText("Sair");
        sair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sairMouseClicked(evt);
            }
        });
        menuBarra.add(sair);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(175, Short.MAX_VALUE)
                .addComponent(titulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sairMouseClicked
        int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
        dispose();
        if (sair == 0) {
            System.exit(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_sairMouseClicked

    private void UsuarioCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioCadastroActionPerformed
        new UsuarioCadastro().setVisible(true);
    }//GEN-LAST:event_UsuarioCadastroActionPerformed

    private void clienteCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteCadastroActionPerformed
        new ClienteCadastro().setVisible(true);
    }//GEN-LAST:event_clienteCadastroActionPerformed

    private void clientePesquisadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientePesquisadoActionPerformed
        new ClientePesquisado().setVisible(true);
    }//GEN-LAST:event_clientePesquisadoActionPerformed

    private void usuarioPesquisadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioPesquisadoActionPerformed
        new UsuarioPesquisado().setVisible(true);
    }//GEN-LAST:event_usuarioPesquisadoActionPerformed

    private void FornecedorCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FornecedorCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FornecedorCadastroActionPerformed

    private void fornecedorPesquisadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedorPesquisadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fornecedorPesquisadoActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem FornecedorCadastro;
    private javax.swing.JMenu Pesquisa;
    private javax.swing.JMenuItem UsuarioCadastro;
    private javax.swing.JMenu ajuda;
    private javax.swing.JMenu cadastro;
    private javax.swing.JMenuItem clienteCadastro;
    private javax.swing.JMenuItem clientePesquisado;
    private javax.swing.JMenuItem fornecedorPesquisado;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu sair;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel titulo1;
    private javax.swing.JMenuItem usuarioPesquisado;
    // End of variables declaration//GEN-END:variables
}
