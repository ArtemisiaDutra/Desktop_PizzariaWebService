/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.tela;

import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.dao.UsuarioDao;
import br.com.pizzaria.dao.UsuarioDaoImpl;
import br.com.pizzaria.entidade.EnderecoDTO;
import br.com.pizzaria.entidade.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author maria.sousa9
 */
public class UsuarioCadastro extends javax.swing.JFrame {

    private UsuarioDao usuarioDao;
    private Session sessao;
    private Usuario usuario;

    public UsuarioCadastro() {
        initComponents();
        usuarioDao = new UsuarioDaoImpl();
    }

    public UsuarioCadastro(Usuario usuario) {
        initComponents();
        usuarioDao = new UsuarioDaoImpl();
        this.usuario = usuario;
        carregarDadosUsuario();
    }

    private void carregarDadosUsuario() {
        varNome.setText(usuario.getNome());
        varLogin.setText(usuario.getLogin());
        varSenha.setText(usuario.getSenha());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        varLogin = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        varSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gupy Sistemas - Tela Cadastro de Usuário");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Usuário");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nome:");

        varNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varNome.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btSalvar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Login:");

        varLogin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        varLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varLoginFocusLost(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Senha:");

        varSenha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varSenha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        varSenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varSenhaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(varNome)
                                .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validarFormulario()) {

            UsuarioDao usuarioDao = new UsuarioDaoImpl();
            Session sessao = HibernateUtil.abrirConexao();
            Usuario usuario1 = carregarUsuario();
            if (usuario != null) {
                usuario1.setId(usuario.getId());

            }
            try {
                usuarioDao.salvarOuAlterar(usuario1, sessao);
                dispose();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!!");
            }

        }

    }//GEN-LAST:event_btSalvarActionPerformed
    private Usuario carregarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNome(varNome.getText().trim());
        usuario.setLogin(varLogin.getText().trim());
        usuario.setSenha(varSenha.getText().trim());

        return usuario;
    }

    private boolean validarFormulario() {

        String nome = varNome.getText().trim();
        if (verificarCampoMaior2(nome)) {//pegar o falso
            JOptionPane.showMessageDialog(null, "O nome tem que ter pelo menos3 letras");
            return false;
        }

        String login = varLogin.getText().trim();
        if (verificarLogin(login)) {
            JOptionPane.showMessageDialog(null, "Digite E-mail para Login correto");
            return false;
        }

        String senha = varSenha.getText().trim();
        if (verificarSenha(senha)) {
            JOptionPane.showMessageDialog(null, "Digite uma Senha correto");
            return false;
        }

//        Esse return tem que ser a última linha do método
        return true;
    }

// validadar
    private boolean verificarCampoMaior2(String campo) {

        return campo.length() < 3;
    }

    private boolean verificarLogin(String login) {

        return !login.contains("@") && !login.contains(".");
    }

    private boolean verificarSenha(String senha) {
        return senha.length() == 5;
    }

    private void varLoginFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varLoginFocusLost
//     String login = varLogin.getText().trim();
//        if (login.contains("@")) {
//            sessao = HibernateUtil.abrirConexao();
//            Usuario existe = usuarioDao.pesquisarLogin(login, sessao);
//            sessao.close();
//
//            if (existe) {
//                JOptionPane.showMessageDialog(null, "Esse Login já está cadastrado!");
//            }
//        }
    }//GEN-LAST:event_varLoginFocusLost

    private void varSenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varSenhaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_varSenhaFocusLost

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
            java.util.logging.Logger.getLogger(UsuarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField varLogin;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varSenha;
    // End of variables declaration//GEN-END:variables
}
