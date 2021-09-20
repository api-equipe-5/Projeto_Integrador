/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import ModeloConection.ConexaoBD;
import ModeloDao.DaoUsuario;
import ModeloDao.DaoVeiculo;
import static java.awt.SystemColor.control;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modeloBeans.BeansFuncionario;
import modeloBeans.BeansVeiculo;
import modeloBeans.ModeloTabela;

/**
 *
 * @author Daniel
 */
public class FormVeiculos extends javax.swing.JFrame {
     BeansVeiculo mod = new BeansVeiculo();
     DaoVeiculo dao = new DaoVeiculo();
     ConexaoBD conex = new ConexaoBD();
     int flag=0;
    /**
     * Creates new form FormVeiculos
     */
    public FormVeiculos() {
        initComponents();
        preenchertabela("select *from base_veiculo order by modelo");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonNovo = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jTextFieldId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCor = new javax.swing.JTextField();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldAnoVeiculo = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeiculo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonStatus = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonNovo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 75, 30));

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 75, 30));

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, -1, 30));

        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 75, 30));

        jTextFieldId.setEditable(false);
        jTextFieldId.setEnabled(false);
        getContentPane().add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 129, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("id: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Cor: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, 20));

        jTextFieldCor.setEnabled(false);
        getContentPane().add(jTextFieldCor, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 128, 30));

        jTextFieldPlaca.setEnabled(false);
        getContentPane().add(jTextFieldPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 128, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Placa :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, 20));

        jTextFieldPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 128, 30));

        jButtonPesquisar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonPesquisar.setText("Buscar por Modelo");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Ano do Veiculo :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 160, -1, 20));

        jTextFieldAnoVeiculo.setEnabled(false);
        getContentPane().add(jTextFieldAnoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 128, 30));

        jTextFieldModelo.setEnabled(false);
        getContentPane().add(jTextFieldModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 128, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Modelo :");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, 20));

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 75, 30));

        jTableVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVeiculoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVeiculo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 600, 230));

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));

        jButtonStatus.setText("Veiculos");
        jButtonStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStatusActionPerformed(evt);
            }
        });

        jButton5.setText("Funcionarios");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Jornadas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("Inicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -2, 120, 560));

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel1.setText("Cadastro De Veiculos");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 516, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 650, 560));

        setSize(new java.awt.Dimension(805, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
       flag = 1;
        jTextFieldCor.setEnabled(true);
       
       jTextFieldAnoVeiculo.setEnabled(true);
       jTextFieldModelo.setEnabled(true);
       jTextFieldPlaca.setEnabled(true);
       jButtonCancelar.setEnabled(true);
       jButtonSalvar.setEnabled(true);
       jTextFieldPesquisar.setEnabled(false);
       jButtonPesquisar.setEnabled(false);
       
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
       
        if(flag ==1){         
      
        
      mod.setCor(jTextFieldCor.getText());
      mod.setPlaca(jTextFieldPlaca.getText());
      mod.setAno(jTextFieldAnoVeiculo.getText());
      mod.setModelo(jTextFieldModelo.getText());
      dao.Salvara(mod);
      jTextFieldAnoVeiculo.setEnabled(false);
        jTextFieldModelo.setEnabled(false);
        jTextFieldCor.setEnabled(false);
        jTextFieldPlaca.setEnabled(false);
      
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
      
      jTextFieldCor.setText("");
      jTextFieldAnoVeiculo.setText("");
      jTextFieldPlaca.setText("");
      jTextFieldModelo.setText("");
     preenchertabela("select *from base_veiculo order by modelo");
}else{
      mod.setCod(Integer.valueOf(jTextFieldId.getText()));
      mod.setCor(jTextFieldCor.getText());
      mod.setPlaca(jTextFieldPlaca.getText());
      mod.setAno(jTextFieldAnoVeiculo.getText());
   
      mod.setModelo(jTextFieldModelo.getText());
      
            JOptionPane.showMessageDialog(null,"editado com sucesso");
      dao.Editar(mod);
jTextFieldCor.setText("");
      jTextFieldAnoVeiculo.setText("");
      jTextFieldPlaca.setText("");
      jTextFieldModelo.setText("");
      jTextFieldAnoVeiculo.setEnabled(false);
        jTextFieldModelo.setEnabled(false);
        jTextFieldCor.setEnabled(false);
        jTextFieldPlaca.setEnabled(false);
      
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
preenchertabela("select *from base_veiculo order by modelo");

}
         
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
       flag = 2;
        jTableVeiculo.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonExcluir.setEnabled(false);
        jTextFieldCor.setEnabled(true);
        jTextFieldAnoVeiculo.setEnabled(true);
        jTextFieldPlaca.setEnabled(true);

        jTextFieldModelo.setEnabled(true);
         
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jTextFieldAnoVeiculo.setEnabled(false);
        jTextFieldModelo.setEnabled(false);
        jTextFieldCor.setEnabled(false);
        jTextFieldPlaca.setEnabled(false);
 
        jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        jButtonNovo.setEnabled(true);
        
        jTextFieldCor.setText("");
        jTextFieldAnoVeiculo.setText("");
        jTextFieldPlaca.setText("");
         jTextFieldModelo.setText("");
         
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane,"Deseja realmente excluir");
        if(resposta == JOptionPane.YES_OPTION){
        mod.setCod(Integer.parseInt(jTextFieldId.getText()));
        dao.Excluir(mod);
        
        jTextFieldCor.setText("");
        jTextFieldAnoVeiculo.setText("");
        jTextFieldPlaca.setText("");
         jTextFieldModelo.setText("");
        
         jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jTextFieldAnoVeiculo.setEnabled(false);
        jTextFieldModelo.setEnabled(false);
        jTextFieldCor.setEnabled(false);
        jTextFieldPlaca.setEnabled(false);
         preenchertabela("select *from base_veiculo order by modelo");
      
      
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
    mod.setVpesquisa(jTextFieldPesquisar.getText());
        BeansVeiculo model = dao.buscaUsuario(mod);
        
        
        jTextFieldId.setText(String.valueOf(model.getCod()));
        jTextFieldCor.setText(model.getCor());
        jTextFieldPlaca.setText(model.getPlaca());
        jTextFieldAnoVeiculo.setText(model.getAno());
        
        
        
        preenchertabela("select *from base_veiculo where modelo like'%"+mod.getVpesquisa()+"%'");
        jTextFieldModelo.setText(model.getModelo());
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        
        
                
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTableVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVeiculoMouseClicked
       String nome_veiculo = ""+jTableVeiculo.getValueAt(jTableVeiculo.getSelectedRow(),1 );
       conex.conexao();
       
       conex.executasql("select *from base_veiculo where modelo='"+nome_veiculo+"'");
        try {
            conex.rs.first();
        jTextFieldId.setText(String.valueOf(conex.rs.getInt("codigo")));
        jTextFieldCor.setText(conex.rs.getString("cor"));
        jTextFieldModelo.setText(conex.rs.getString("modelo"));
        jTextFieldPlaca.setText(conex.rs.getString("placa"));
        jTextFieldAnoVeiculo.setText(conex.rs.getString("ano"));
     
      
        } catch (SQLException ex) {
            
        }
       
       
       
       conex.desconecta();
       jButtonEditar.setEnabled(true);
       jButtonExcluir.setEnabled(true);
     
    }//GEN-LAST:event_jTableVeiculoMouseClicked

    private void jTextFieldPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPesquisarActionPerformed
        
    }//GEN-LAST:event_jTextFieldPesquisarActionPerformed

    private void jButtonStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStatusActionPerformed

  
    }//GEN-LAST:event_jButtonStatusActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        FormCadastroFuncionario tela = new FormCadastroFuncionario();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        CriarEntrega tela = new CriarEntrega();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        TelaPrincipalAdministrador tela = new TelaPrincipalAdministrador();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
public void preenchertabela(String sql){
        ArrayList dados = new ArrayList();
        String[] colunas = new String []{
        "Id","cor","modelo","placa","ano"};
        conex.conexao();
        
        conex.executasql(sql);
        try {
            conex.rs.first();
            do{
            dados.add(new Object[]{conex.rs.getInt("codigo"),conex.rs.getString("cor"),conex.rs.getString("modelo"),conex.rs.getString("placa"),conex.rs.getString("ano")});
            
             }while(conex.rs.next());
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"erro ao prenchher");
        }
        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableVeiculo.setModel(modelo);
        
        jTableVeiculo.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableVeiculo.getColumnModel().getColumn(0).setResizable(false);
           
        jTableVeiculo.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTableVeiculo.getColumnModel().getColumn(1).setResizable(false);
           
        jTableVeiculo.getColumnModel().getColumn(2).setPreferredWidth(120);
        jTableVeiculo.getColumnModel().getColumn(2).setResizable(false);
           
        jTableVeiculo.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTableVeiculo.getColumnModel().getColumn(3).setResizable(false);
           
        jTableVeiculo.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTableVeiculo.getColumnModel().getColumn(4).setResizable(false);
          
        
        
        jTableVeiculo.getTableHeader().setReorderingAllowed(false);
        jTableVeiculo.setAutoResizeMode(jTableVeiculo.AUTO_RESIZE_OFF);
        jTableVeiculo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        conex.desconecta();
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
            java.util.logging.Logger.getLogger(FormVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVeiculo;
    private javax.swing.JTextField jTextFieldAnoVeiculo;
    private javax.swing.JTextField jTextFieldCor;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldPlaca;
    // End of variables declaration//GEN-END:variables
}
