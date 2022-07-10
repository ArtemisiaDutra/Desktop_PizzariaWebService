/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.tela;

import br.com.pizzaria.dao.ClienteDao;
import br.com.pizzaria.dao.ClienteDaoImpl;
import br.com.pizzaria.dao.FornecedorDao;
import br.com.pizzaria.dao.FornecedorDaoImpl;
import br.com.pizzaria.dao.HibernateUtil;
import br.com.pizzaria.entidade.Cliente;
import br.com.pizzaria.entidade.Endereco;
import br.com.pizzaria.entidade.EnderecoDTO;
import br.com.pizzaria.entidade.Fornecedor;
import br.com.pizzaria.webservice.CepRest;
import com.sun.jersey.api.client.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *@author maria.sousa9@author Silvio
 */
public class FornecedorCadastro extends javax.swing.JFrame {

    private FornecedorDao fornecedorDao;
    private Session sessao;
    private Fornecedor fornecedor;
    private Endereco endereco;

    public FornecedorCadastro() {
        initComponents();
        fornecedorDao = new FornecedorDaoImpl();
    }

    public FornecedorCadastro(Cliente cliente) {
        initComponents();
        fornecedorDao = new FornecedorDaoImpl();
        this.fornecedor = fornecedor;
        carregarDadosFornecedor();
    }

    private void carregarDadosFornecedor() {
        varNome.setText(fornecedor.getNome());
        varCnpj.setText(fornecedor.getCnpj());
        varInscricaoestadual.setText(fornecedor.getInscricao_estadual());
        varEmail.setText(fornecedor.getEmail());
        varTelefone.setText(fornecedor.getTelefone());

        Endereco endereco = fornecedor.getEnderecos().get(0);
        varCep.setText(endereco.getCep());
        varRua.setText(endereco.getLogradouro());
        varBairro.setText(endereco.getBairro());
        varBairro.setText(endereco.getBairro());
        varCidade.setText(endereco.getCidade());
        varEstado.setText(endereco.getEstado());
        varObs.setText(endereco.getObservacao());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        varRua = new javax.swing.JTextField();
        varCep = new javax.swing.JTextField();
        varBairro = new javax.swing.JTextField();
        varCidade = new javax.swing.JTextField();
        varEstado = new javax.swing.JTextField();
        btBuscarCep = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        varTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        varNumero = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        varComplemento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varObs = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        varCnpj = new javax.swing.JTextField();
        varInscricaoestadual = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Principal");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Fornecedor");

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Rua:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Cep:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Bairro:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Cidade:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Estado:");

        varRua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varRua.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        varRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varRuaActionPerformed(evt);
            }
        });

        varCep.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varCep.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        varCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varCepActionPerformed(evt);
            }
        });

        varBairro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varBairro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        varBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varBairroActionPerformed(evt);
            }
        });

        varCidade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varCidade.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        varEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btBuscarCep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBuscarCep.setText("Buscar");
        btBuscarCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarCepActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Telefone:");

        try {
            varTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        varTelefone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Email:");

        varEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        varEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                varEmailFocusLost(evt);
            }
        });

        varNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        varNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNumeroActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Número:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Comp:");

        varComplemento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varComplemento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Obs:");

        varObs.setColumns(20);
        varObs.setRows(5);
        jScrollPane1.setViewportView(varObs);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("CNPJ:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Insc. Estadual:");

        varCnpj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varCnpj.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        varInscricaoestadual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        varInscricaoestadual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel14)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varRua, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(varTelefone, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(varCep, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btBuscarCep))
                            .addComponent(varInscricaoestadual, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel8)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(varEstado, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(varCidade, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(varBairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varInscricaoestadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(varCep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btBuscarCep)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(30, 30, 30)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (validarFormulario()) {

            FornecedorDao fornecedorDao = new FornecedorDaoImpl();
            Session sessao = HibernateUtil.abrirConexao();
            Fornecedor fornecedor1 = carregarFornecedor();
            if (fornecedor != null) {
                fornecedor1.setId(fornecedor.getId());
                endereco = fornecedor1.getEnderecos().get(0);

            } else {
                endereco = new Endereco();
            }
            try {
                fornecedorDao.salvarOuAlterar(fornecedor1, sessao);
            } catch (HibernateException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!!");
            }
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!!");

        }

    }//GEN-LAST:event_btSalvarActionPerformed
    private Fornecedor carregarFornecedor() {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(varNome.getText().trim());
        fornecedor.setCnpj(varCnpj.getText().trim());
        fornecedor.setInscricao_estadual(varInscricaoestadual.getText().trim());
        fornecedor.setEmail(varEmail.getText().trim());
        fornecedor.setTelefone(varTelefone.getText().trim());

        List<Endereco> enderecos = new ArrayList<>();

        endereco.setLogradouro(varRua.getText().trim());
        endereco.setBairro(varBairro.getText().trim());
        endereco.setCep(varCep.getText().trim());
        endereco.setCidade(varCidade.getText().trim());
        endereco.setEstado(varEstado.getText().trim());
        endereco.setNumero(varNumero.getText().trim());
        endereco.setComplemento(varComplemento.getText().trim());
        endereco.setObservacao(varObs.getText().trim());

        enderecos.add(endereco);
        endereco.setPessoa(fornecedor);
        fornecedor.setEnderecos(enderecos);

        return fornecedor;
    }

    private boolean validarFormulario() {

        String nome = varNome.getText().trim();
        if (verificarCampoMaior2(nome)) {//pegar o falso
            JOptionPane.showMessageDialog(null, "O nome tem que ter pelo menos3 letras");
            return false;
        }


        String cnpj = varCnpj.getText().trim();
        if (verificarEmail(cnpj)) {
            JOptionPane.showMessageDialog(null, "Digite um cnpj correto");
            return false;
        }
        String inscricaoEstadual = varInscricaoestadual.getText().trim();
        if (verificarEmail(inscricaoEstadual)) {
            JOptionPane.showMessageDialog(null, "Digite a Inscricao Estadual correto");
            return false;
        }
        String email = varEmail.getText().trim();
        if (verificarEmail(email)) {
            JOptionPane.showMessageDialog(null, "Digite um e-mail correto");
            return false;
        }

        String telefone = varTelefone.getText().trim();
        if (verificarTelefone(telefone)) {
            JOptionPane.showMessageDialog(null, "Digite um telefone correto");
            return false;
        }

//        Esse return tem que ser a última linha do método
        return true;
    }

// validadar
    private boolean verificarCampoMaior2(String campo) {

        return campo.length() < 3;
    }

    private boolean verificarEmail(String email) {

        return !email.contains("@") && !email.contains(".");
    }

    private boolean verificarTelefone(String telefone) {
        return telefone.length() == 10;
    }

    private void varRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varRuaActionPerformed

    private void varBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varBairroActionPerformed

    }//GEN-LAST:event_varBairroActionPerformed

    private void btBuscarCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarCepActionPerformed
        CepRest ceprest = new CepRest();
        EnderecoDTO enderecoDTO = ceprest.pesquisarCep(varCep.getText());
        if (enderecoDTO == null) {
            JOptionPane.showMessageDialog(null, "CEP não encontardo");

        } else {
            varRua.setText(enderecoDTO.getLogradouro());
            varCidade.setText(enderecoDTO.getLocalidade());
            varBairro.setText(enderecoDTO.getBairro());
            varEstado.setText(enderecoDTO.getUf());

        }
    }//GEN-LAST:event_btBuscarCepActionPerformed

    private void varNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNumeroActionPerformed

    private void varEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_varEmailFocusLost
        String email = varEmail.getText().trim();
        if (email.contains("@")) {
            sessao = HibernateUtil.abrirConexao();
            boolean existe = fornecedorDao.verificarEmailCadastrado(email, sessao);
            sessao.close();

            if (existe) {
                JOptionPane.showMessageDialog(null, "Esse e-mail já está cadastrado!");
            }
        }
    }//GEN-LAST:event_varEmailFocusLost

    private void varCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varCepActionPerformed

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
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FornecedorCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FornecedorCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscarCep;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField varBairro;
    private javax.swing.JTextField varCep;
    private javax.swing.JTextField varCidade;
    private javax.swing.JTextField varCnpj;
    private javax.swing.JTextField varComplemento;
    private javax.swing.JTextField varEmail;
    private javax.swing.JTextField varEstado;
    private javax.swing.JTextField varInscricaoestadual;
    private javax.swing.JTextField varNome;
    private javax.swing.JTextField varNumero;
    private javax.swing.JTextArea varObs;
    private javax.swing.JTextField varRua;
    private javax.swing.JFormattedTextField varTelefone;
    // End of variables declaration//GEN-END:variables
}
