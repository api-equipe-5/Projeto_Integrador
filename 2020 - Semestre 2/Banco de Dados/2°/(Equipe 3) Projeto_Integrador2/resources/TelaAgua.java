package source;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class TelaAgua extends javax.swing.JFrame {
	private ArrayList rgi;
	private ArrayList id_conta;
	private ArrayList id_loc;
	private ArrayList id_cli;
	private ArrayList nome;

    /**
     * Creates new form TelaAgua
     */
    public TelaAgua() {
    	setTitle("Cadastrar Conta Água");
    	setResizable(false);
        initComponents();
        this.historico = new ArrayList<>();
        this.clientes = new HashMap<>();
        
        try {
			rgi = new ArrayList(getD("conta_agua", "rgi"));
			id_conta = new ArrayList(getD("conta_agua", "id_local"));
			id_loc = new ArrayList(getD("local", "id_loc"));
			id_cli = new ArrayList(getD("local", "id_cli"));
			nome = new ArrayList(getD("cliente", "nome_cli"));
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        
        Action saveAction = new AbstractAction("save") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                save();   
            }
        };
    
    String key = "save";
    
    salvarButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK), key);
    
    salvarButton.getActionMap().put(key, saveAction);


        Action searchAction = new AbstractAction("search") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try {
					search();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
            }
        };
    
    String key2 = "search";
    
    procurarButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK), key2);
    
    procurarButton.getActionMap().put(key2, searchAction);
    
    
        Action clearAction = new AbstractAction("clear") {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                clear();   
            }
        };
    
    String key3 = "clear";
    
    limparButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK), key3);
    
    limparButton.getActionMap().put(key3, clearAction);
    
    
    
   // Atalho botao Atualizar
    
	    Action updateAction = new AbstractAction("update") {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            
	        	try {
					update();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
	        }
	    };
	
	String key4 = "update";
	
	btnAtualizar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK), key4);
	
	btnAtualizar.getActionMap().put(key4, updateAction);
	
	
	// Atalho botao Excluir
	
	    Action deleteAction = new AbstractAction("delete") {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            
	        	try {
	        		delete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}   
	        }
	    };
	
	String key5 = "delete";
	
	btnExcluir.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK), key5);
	
	btnExcluir.getActionMap().put(key5, deleteAction);
    
    }
    
    
    public void save() {
        ContaAgua cliente = new ContaAgua(rgiField_1.getText(), clienteField.getText(), contaField_1.getText(), mesField.getText(), consumoField.getText(), totalField.getText(), vencimentoField_1.getText());
        
        try {
			post(rgiField_1.getText(), clienteField.getText(), contaField_1.getText(), mesField.getText(), consumoField.getText(), totalField.getText(), vencimentoField_1.getText(), TelaLogin.getDigitador());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(checarCampos(cliente)==0) {
            if(!clientes.containsKey(rgiField_1.getText())) {
                this.clientes.put(rgiField_1.getText(), cliente);
                this.historico.add(cliente);            
            } else {
                clientes.get(rgiField_1.getText()).setNome(clienteField.getText());
                clientes.get(rgiField_1.getText()).setConta(contaField_1.getText());
                clientes.get(rgiField_1.getText()).setMes(mesField.getText());
                clientes.get(rgiField_1.getText()).setConsumo(consumoField.getText());
                clientes.get(rgiField_1.getText()).setTotal(totalField.getText());
                clientes.get(rgiField_1.getText()).setVencimento(vencimentoField_1.getText());
            }
            
            limparDados();
        }
        
        rgiField_1.requestFocus();
    }
    
    public static void post(String rgi, String nome, String conta, String mes, String consumo, String total, String vencimento, String digitador) throws Exception {
		try {
			Connection conexao = FabricaConexao.getConexao();

			String sql = "INSERT INTO ref_agua (rgi, nome, conta, mes, consumo, total, vencimento, digitador) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement posted = conexao.prepareStatement(sql);
			posted.setString(1, rgi);
			posted.setString(2, nome);
			posted.setString(3, conta);
			posted.setString(4, mes);
			posted.setString(5, consumo);
			posted.setString(6, total); 
			posted.setString(7, vencimento);
			posted.setString(8, digitador);
			posted.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("catch do post " + e);
		}
		finally {
			System.out.println("dados inseridos");
		}
	}
    
    
    //public void search() {
    //    clienteField.setText(clientes.get(rgiField.getText()).getNome().toUpperCase());
    //    contaField.setText(clientes.get(rgiField.getText()).getConta());
    //    mesField.setText(clientes.get(rgiField.getText()).getMes());
    //    consumoField.setText(clientes.get(rgiField.getText()).getConsumo());
    //    totalField.setText(clientes.get(rgiField.getText()).getTotal());
    //    vencimentoField.setText(clientes.get(rgiField.getText()).getVencimento());        
    //}
    
    
    public void clear() {
        limparDados();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clienteField = new javax.swing.JTextField();
        clienteField.setEnabled(false);
        clienteField.setEditable(false);
        jLabel1 = new javax.swing.JLabel();
        rgiField = new javax.swing.JTextField();
        try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("########/##");
			rgiField_1= new javax.swing.JFormattedTextField(format_textField3);
			rgiField_1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent arg0) {
					if (rgiField_1.getText().equals("        /  ")) {
					}
					else if (rgi.indexOf(rgiField_1.getText()) >= 0) {
						String id_l = (String) id_conta.get(rgi.indexOf(rgiField_1.getText()));
						String id_c = (String) id_cli.get((id_loc.indexOf(id_l)));
						clienteField.setText(String.valueOf(nome.get(Integer.parseInt(id_c))));
					}
					else {
						int input = JOptionPane.showConfirmDialog(null, "Oh não!\n"
								+ "Parece que o cliente com essa\n"
								+ "Instalação ainda não existe.", "Erro - Cliente", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
						if (input == 0) {
							rgiField_1.setText("");
							rgiField_1.requestFocus();
						}
					}
				}
			});
			} 
		catch (Exception e){}
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        contaField = new javax.swing.JTextField();
        try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("#############");
			contaField_1= new javax.swing.JFormattedTextField(format_textField3);
			} 
		catch (Exception e){}
        jLabel5 = new javax.swing.JLabel();
        mesField = new javax.swing.JTextField();
        mesField.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		String s = mesField.getText();
        		mesField.setText(s.substring(0, 1).toUpperCase() + s.substring(1));
        	}
        });
        jLabel6 = new javax.swing.JLabel();
        vencimentoField = new javax.swing.JTextField();
        try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/####");
			vencimentoField_1= new javax.swing.JFormattedTextField(format_textField3);
			} 
		catch (Exception e){}
        jLabel7 = new javax.swing.JLabel();
        consumoField = new javax.swing.JTextField();
        salvarButton = new javax.swing.JButton();
        arquivoButton = new javax.swing.JButton();
        procurarButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        limparButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);


        jLabel1.setText("Cliente");

        jLabel2.setText("RGI");

        jLabel3.setText("No da Conta");

        jLabel4.setText("Mes de Referencia (por extenso)");

        jLabel5.setText("Total a Pagar");

        jLabel6.setText("Consumo m3");

        jLabel7.setText("Vencimento");

        salvarButton.setText("Salvar");
        salvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarButtonActionPerformed(evt);
            }
        });

        arquivoButton.setText("Criar Arquivo");
        arquivoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arquivoButtonActionPerformed(evt);
            }
        });

        procurarButton.setText("Procurar");
        procurarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("ctrl + s");

        jLabel9.setText("ctrl + d");

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("ctrl + f");
        
        btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					update();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					delete();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        lblNewLabel = new JLabel("ctrl + g");
        
        lblNewLabel_1 = new JLabel("ctrl + z");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(contaField_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel6))
        					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel5)
        						.addComponent(mesField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(consumoField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
        					.addComponent(totalField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(rgiField_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(clienteField, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
        								.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))
        						.addComponent(jLabel7)
        						.addComponent(vencimentoField_1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(lblNewLabel_1)
        								.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        									.addComponent(btnAtualizar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        									.addComponent(salvarButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        									.addComponent(jLabel8, Alignment.LEADING)))
        							.addGap(18)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        										.addComponent(btnExcluir, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        										.addComponent(arquivoButton, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
        									.addGap(18)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(procurarButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        										.addComponent(jLabel9))
        									.addGap(18)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(limparButton, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
        										.addComponent(jLabel10)))
        								.addComponent(lblNewLabel))))
        					.addGap(0, 0, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(rgiField_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(clienteField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(contaField_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(mesField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(totalField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(consumoField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(vencimentoField_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(48)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(jLabel9)
        				.addComponent(jLabel10))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(salvarButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(arquivoButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(procurarButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(limparButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1)
        				.addComponent(lblNewLabel))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnAtualizar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnExcluir, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
        			.addGap(53))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void procurarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarButtonActionPerformed
        // TODO add your handling code here:
    	
    	try {
			search();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //clienteField.setText(clientes.get(rgiField.getText()).getNome().toUpperCase());
        //contaField.setText(clientes.get(rgiField.getText()).getConta());
        //mesField.setText(clientes.get(rgiField.getText()).getMes());
        //consumoField.setText(clientes.get(rgiField.getText()).getConsumo());
        //totalField.setText(clientes.get(rgiField.getText()).getTotal());
        //vencimentoField.setText(clientes.get(rgiField.getText()).getVencimento());
    }//GEN-LAST:event_procurarButtonActionPerformed

    private void salvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarButtonActionPerformed

    	
		if (rgiField_1.getText().equals("        /  ")) {
			rgiField_1.requestFocus();
			JOptionPane.showMessageDialog(null, "O campo RGI é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (clienteField.getText().equals("")) {
			clienteField.requestFocus();
			JOptionPane.showMessageDialog(null, "O campo CLIENTE é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (contaField_1.getText().equals("             ")) {
			contaField_1.requestFocus();
			JOptionPane.showMessageDialog(null, "O campo NUMERO DA CONTA é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (mesField.getText().equals("")) {
			mesField.requestFocus();
			JOptionPane.showMessageDialog(null, "O campo MES DE REFERENCIA é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (consumoField.getText().equals("")) {
			consumoField.requestFocus();
			JOptionPane.showMessageDialog(null, "O campo CONSUMO M3 é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (totalField.getText().equals("")) {
			totalField.requestFocus();
			JOptionPane.showMessageDialog(null, "O campo TOTAL A PAGAR é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
		if (vencimentoField_1.getText().equals("  /  /    ")) {
			vencimentoField_1.requestFocus();
			JOptionPane.showMessageDialog(null, "O campo VENCIMENTO é obrigatório", "Aviso", JOptionPane.WARNING_MESSAGE);
			return;
		}
    	

    	
        // TODO add your handling code here:
        ContaAgua cliente = new ContaAgua(rgiField_1.getText(), clienteField.getText(), contaField_1.getText(), mesField.getText(), consumoField.getText(), totalField.getText(), vencimentoField_1.getText());
        
        try {
			post(rgiField_1.getText(), clienteField.getText(), contaField_1.getText(), mesField.getText(), consumoField.getText(), totalField.getText(), vencimentoField_1.getText(), TelaLogin.getDigitador());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        if(checarCampos(cliente)==0) {
            if(!clientes.containsKey(rgiField_1.getText())) {
            this.clientes.put(rgiField_1.getText(), cliente);
            this.historico.add(cliente);            
            } else {
                clientes.get(rgiField_1.getText()).setNome(clienteField.getText());
                clientes.get(rgiField_1.getText()).setConta(contaField_1.getText());
                clientes.get(rgiField_1.getText()).setMes(mesField.getText());
                clientes.get(rgiField_1.getText()).setConsumo(consumoField.getText());
                clientes.get(rgiField_1.getText()).setTotal(totalField.getText());
                clientes.get(rgiField_1.getText()).setVencimento(vencimentoField_1.getText());
            }
            limparDados();
        }
        
        rgiField_1.requestFocus();
        
        
       
        
    }//GEN-LAST:event_salvarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        // TODO add your handling code here:
        limparDados();
        rgiField_1.requestFocus();
    }//GEN-LAST:event_limparButtonActionPerformed
    
    
    public int checarCampos(ContaAgua cliente) {
        int count = 0;
        
        if(cliente.getRgi().equals("")) {
            count++;
        } else if(cliente.getNome().equals("")) {
            count++;
        } else if(cliente.getConta().equals("")) {
            count++;
        } else if(cliente.getMes().equals("")) {
            count++;
        } else if(cliente.getConsumo().equals("")) {
            count++;
        } else if(cliente.getTotal().equals("")) {
            count++;
        } else if(cliente.getVencimento().equals("")) {
            count++;
        } else {
            return count;
        }
        
        return count;
        
    }
    
    public void limparDados() {
        rgiField_1.setText("");
        clienteField.setText("");
        contaField_1.setText("");
        mesField.setText("");
        consumoField.setText("");
        totalField.setText("");
        vencimentoField_1.setText("");
    }
    
    
    private void arquivoButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        try {
            SalvarDados();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar arquivo");
        }
    }   
    
    public void SalvarDados() throws IOException {
        
        try (FileWriter myWriter = new FileWriter("contaAguaDataBase.txt")) {
            for (String key: this.clientes.keySet()) {
                
                myWriter.write(this.clientes.get(key).toString());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar arquivo");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-foprocurarButtonate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(TelaAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAgua.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAgua().setVisible(true);
            }
        });
    }
    
    
	public void search() throws SQLException {
			
	    	Connection conexao = FabricaConexao.getConexao();
	    	
	    	// Atribuindo oque foi digitado no textField a variavel x
	    	String x = rgiField_1.getText();
	    	
	    	// Pesquisando no BD oque foi digitado no textField
			String sql = "SELECT * FROM conta_agua WHERE rgi='"+ x + "'";
			
			Statement stmt = conexao.createStatement();
			
			// ESTA SENDO ATRIBUIDO A VARIAVEL RESULTADO O RETORNO DA VARIAVEL SQL COM A CONSULTA DO BANCO
			ResultSet resultado = stmt.executeQuery(sql);
			
			resultado.next();
			
			// Setando o retorno do BD nos textField
			rgiField_1.setText(resultado.getString("rgi"));
			clienteField.setText(resultado.getString("nome"));
			contaField_1.setText(resultado.getString("conta"));
			mesField.setText(resultado.getString("mes"));
			consumoField.setText(resultado.getString("consumo"));
			totalField.setText(resultado.getString("total"));
			vencimentoField_1.setText(resultado.getString("vencimento"));

			
			conexao.close();
		}
	
	
	public void update() throws SQLException {
	    	
	    	Connection conexao = FabricaConexao.getConexao();
	    	
	    	// Atribuindo oque foi digitado no textField a variavel x
	    	String x = rgiField_1.getText();
			
	    	// String SQL
			String updateSQL = "UPDATE conta_agua SET nome = ?, conta = ?, mes = ?, consumo = ?, total = ?, vencimento = ? WHERE rgi='"+ x + "'";
			
			// Recebendo o updateSQL
			PreparedStatement stmt = conexao.prepareStatement(updateSQL);		
			
			// Setando no banco
			stmt.setString(1, clienteField.getText());
			stmt.setString(2, contaField_1.getText());
			stmt.setString(3, mesField.getText());
			stmt.setString(4, consumoField.getText());
			stmt.setString(5, totalField.getText());
			stmt.setString(6, vencimentoField_1.getText());
			stmt.executeUpdate();
			
			System.out.println("Dados atualizados");
			
			// Fechando conexoes
			stmt.close();
			conexao.close();
	    }
	
	
	public void delete() throws SQLException {
	    	
	    	Connection conexao = FabricaConexao.getConexao();
	    	
	    	// Atribuindo oque foi digitado no textField a variavel x
	    	String x = rgiField_1.getText();
	    	
	    	String deleteSQL = "DELETE FROM conta_agua WHERE rgi='"+ x + "'";
	    	
	    	PreparedStatement stmt = conexao.prepareStatement(deleteSQL);
	    	
	    	stmt.execute();
	    	
	    	rgiField_1.setText("");
	    	clienteField.setText("");
	    	contaField_1.setText("");
	    	mesField.setText("");
	    	consumoField.setText("");
	    	totalField.setText("");
	    	vencimentoField_1.setText("");
	    	
	    	System.out.println("Dados excluidos com sucesso");
	
	    	
	    	conexao.close(); 	
	    }
	
	
	
	public static ArrayList getD(String tabela, String coluna) throws Exception{
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement  pegar = con.prepareStatement("SELECT * FROM " + tabela);
			ResultSet resultado = pegar.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(coluna));
			}
		
			System.out.println("Get finalizado");
			System.out.println(array);
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton arquivoButton;
    private javax.swing.JTextField clienteField;
    private javax.swing.JTextField consumoField;
    private javax.swing.JTextField contaField;
    private JTextField contaField_1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton limparButton;
    private javax.swing.JTextField mesField;
    private javax.swing.JButton procurarButton;
    private javax.swing.JTextField rgiField;
    private JTextField rgiField_1;
    private javax.swing.JButton salvarButton;
    private javax.swing.JTextField totalField;
    private javax.swing.JTextField vencimentoField;
    private JTextField vencimentoField_1;
    // End of variables declaration//GEN-END:variables
    private ArrayList<ContaAgua> historico;
    private HashMap<String, ContaAgua> clientes;
    private JButton btnExcluir;
    private JButton btnAtualizar;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
}