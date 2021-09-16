package gui;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class consultaveiculoGUI extends javax.swing.JFrame {

    public consultaveiculoGUI() {
        initComponents();
        jtCliente1.getTableHeader().setFont(new Font("Verdana", Font.BOLD, 12));
        jtCliente1.getTableHeader().setOpaque(false);
        jtCliente1.getTableHeader().setBackground(new Color(87,220,255));
        jtCliente1.getTableHeader().setForeground(new Color(0,100,120));
        jtCliente1.setRowHeight(25);
    }
    
    public class ConsultarVeiculo extends javax.swing.JInternalFrame {
    private JDesktopPane jdpPrincipal;
    public ConsultarVeiculo(JDesktopPane jdp) {
        initComponents();
        jdpPrincipal = jdp;
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCliente = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnPesq = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jtCliente.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marca", "Modelo", "Ano", "Cor", "Placa", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente.setFocusable(false);
        jtCliente.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente.setInheritsPopupMenu(true);
        jtCliente.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente.setOpaque(false);
        jtCliente.setRowHeight(25);
        jtCliente.setSelectionBackground(new java.awt.Color(0, 0, 255));
        jtCliente.setSelectionForeground(new java.awt.Color(255, 153, 0));
        jtCliente.getTableHeader().setResizingAllowed(false);
        jtCliente.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtCliente);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(240, 252, 255));

        jPanel2.setBackground(new java.awt.Color(0, 100, 120));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(87, 220, 255));
        jLabel17.setText("VISUALIZAR VEÍCULOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMarca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 100, 120));
        jLabel2.setText("Marca:");

        btnPesq.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq.setText("Pesquisar");
        btnPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqActionPerformed(evt);
            }
        });

        jtCliente1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente1.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marca", "Modelo", "Ano", "Cor", "Placa", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente1.setFocusable(false);
        jtCliente1.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente1.setInheritsPopupMenu(true);
        jtCliente1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente1.setRowHeight(25);
        jtCliente1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente1.getTableHeader().setResizingAllowed(false);
        jtCliente1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtCliente1);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\kiabi\\Desktop\\logo.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnPesq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void btnPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from veiculo";
            
            if(!txtMarca.getText().equals(""))
                sql = sql + " where marca_vei LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtMarca.getText().equals(""))
                stmt.setString(1, "%"+txtMarca.getText()+"%");
            ResultSet rs = stmt.executeQuery();            
            DefaultTableModel model = (DefaultTableModel) jtCliente1.getModel();
            model.setNumRows(0);
            while(rs.next()){
                
                String[] linha = {rs.getString("marca_vei"),
                    rs.getString("modelo_vei"),rs.getString("ano_vei"),rs.getString("cor_vei"),
                    rs.getString("placa_vei"),rs.getString("estado_vei")};
                model.addRow(linha);
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesqActionPerformed

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
            java.util.logging.Logger.getLogger(consultaveiculoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultaveiculoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultaveiculoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultaveiculoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultaveiculoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesq;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtCliente;
    private javax.swing.JTable jtCliente1;
    private javax.swing.JTextField txtMarca;
    // End of variables declaration//GEN-END:variables
}
