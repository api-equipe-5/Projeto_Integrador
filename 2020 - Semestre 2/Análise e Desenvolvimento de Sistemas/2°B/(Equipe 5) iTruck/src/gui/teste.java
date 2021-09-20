package gui;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import modelo.funcionario;
import dao.funcionarioDAO;
import modelo.motorista;
import dao.motoristaDAO;
import modelo.veiculo;
import dao.veiculoDAO;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class teste extends javax.swing.JFrame {
    
     String Rua;
     String Estado;
     String Cidade;
     String Bairro;
     String Endereco;
    
    public void buscarCep(String cep) 
    {
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            Rua = array[7];            
            Cidade = array[19]; 
            Estado = array[23];
            Bairro = array[15];
            
            Endereco = Rua + " - " + Bairro;
            
            txtEndereco.setText(Endereco);
            txtCidade.setText(Cidade);
            txtEstado.setText(Estado);
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void buscarCep1(String cep) 
    {
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            Rua = array[7];            
            Cidade = array[19]; 
            Estado = array[23];
            Bairro = array[15];
            
            Endereco = Rua + " - " + Bairro;
            
            txtEndereco1.setText(Endereco);
            txtCidade1.setText(Cidade);
            txtEstado1.setText(Estado);
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void buscarCep2(String cep) 
    {
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            Rua = array[7];            
            Cidade = array[19]; 
            Estado = array[23];
            Bairro = array[15];
            
            Endereco = Rua + " - " + Bairro;
            
            txtEndereco2.setText(Endereco);
            txtCidade2.setText(Cidade);
            txtEstado2.setText(Estado);
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void buscarCep3(String cep) 
    {
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            Rua = array[7];            
            Cidade = array[19]; 
            Estado = array[23];
            Bairro = array[15];
            
            Endereco = Rua + " - " + Bairro;
            
            txtEndereco3.setText(Endereco);
            txtCidade3.setText(Cidade);
            txtEstado3.setText(Estado);
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public teste() {
        initComponents();
  
    }     
        
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtCargo5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnPesq2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtCliente2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        Painel2 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        btnCadastrar2 = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtRG = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtCodFilial = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtCEP = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        txtNum = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        lblMensagem = new java.awt.Label();
        jPanel7 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        txtSenha = new javax.swing.JPasswordField();
        btnBuscar = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Painel3 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        txtNome1 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtRG1 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        txtCPF1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        txtCodFilial1 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtCargo1 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        txtCEP1 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtNum1 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txtEndereco1 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtCidade1 = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtEstado1 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtTelefone1 = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtCelular1 = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        txtEmail1 = new javax.swing.JTextField();
        txtLogin1 = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        lblMensagem1 = new java.awt.Label();
        jPanel8 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        txtSenha1 = new javax.swing.JPasswordField();
        btnBuscar1 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        txtPesq = new javax.swing.JTextField();
        btnPesq = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtCPFpesq = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnPesq1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtCliente1 = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtCargoPesq = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnPesq3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtCliente3 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        Painel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCadastrar = new javax.swing.JButton();
        txtNome2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtRG2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCPF2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCEP2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNum2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtEndereco2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCidade2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEstado2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTelefone2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCelular2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtEmail2 = new javax.swing.JTextField();
        txtLogin2 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        lblMensagem2 = new java.awt.Label();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtSenha2 = new javax.swing.JPasswordField();
        btnBuscar2 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        Painel1 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        txtNome3 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtRG3 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtCPF3 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtCEP3 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtNum3 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtEndereco3 = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtCidade3 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txtEstado3 = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtTelefone3 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtCelular3 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txtEmail3 = new javax.swing.JTextField();
        txtLogin3 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        lblMensagem3 = new java.awt.Label();
        jPanel14 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        btnBuscar3 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txtPesq1 = new javax.swing.JTextField();
        btnPesq4 = new javax.swing.JButton();
        btnAtualizar1 = new javax.swing.JButton();
        txtSenha3 = new javax.swing.JPasswordField();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel77 = new javax.swing.JLabel();
        txtPesq2 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        btnPesq5 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtCliente4 = new javax.swing.JTable();
        jLabel79 = new javax.swing.JLabel();
        btnExcluir1 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        txtNome4 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        btnPesq6 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtCliente5 = new javax.swing.JTable();
        jLabel82 = new javax.swing.JLabel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        Painel5 = new javax.swing.JPanel();
        jLabel95 = new javax.swing.JLabel();
        btnCadastrar1 = new javax.swing.JButton();
        txtMarca = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtEstado4 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        lblMensagem5 = new java.awt.Label();
        jPanel28 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        Painel6 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        btnAtualizar2 = new javax.swing.JButton();
        txtMarca1 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        txtModelo1 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        txtAno1 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        txtCor1 = new javax.swing.JTextField();
        jLabel105 = new javax.swing.JLabel();
        txtPlaca1 = new javax.swing.JTextField();
        txtEstado5 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        lblMensagem6 = new java.awt.Label();
        jPanel19 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        txtPesq3 = new javax.swing.JTextField();
        btnPesq9 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        txtPlaca2 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        btnPesq10 = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtCliente8 = new javax.swing.JTable();
        btnExcluir2 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        txtMarca2 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        btnPesq11 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtCliente9 = new javax.swing.JTable();
        jLabel115 = new javax.swing.JLabel();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        Painel4 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        btnCadFim = new javax.swing.JButton();
        txtVeiculo = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        lblMensagem4 = new java.awt.Label();
        jPanel25 = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        btnInciar = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContratempos = new javax.swing.JTextArea();
        lblMensagemJ = new java.awt.Label();
        jPanel26 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        txtData1 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        btnPesq7 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtCliente6 = new javax.swing.JTable();
        jLabel94 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        btnPesq8 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtCliente7 = new javax.swing.JTable();
        jLabel89 = new javax.swing.JLabel();

        jMenu4.setText("jMenu4");

        jPanel9.setBackground(new java.awt.Color(240, 252, 255));

        jPanel10.setBackground(new java.awt.Color(0, 100, 120));

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(87, 220, 255));
        jLabel18.setText("VISUALIZAR FUNCIONÁRIOS");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel18)
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCargo5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCargo5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCargo5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargo5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 100, 120));
        jLabel5.setText("Cargo:");

        btnPesq2.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq2.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq2.setText("Pesquisar");
        btnPesq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq2ActionPerformed(evt);
            }
        });

        jtCliente2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente2.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filial", "Nome", "Telefone", "Email", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente2.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente2.setInheritsPopupMenu(true);
        jtCliente2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente2.setRowHeight(25);
        jtCliente2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtCliente2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(45, 45, 45)
                                .addComponent(txtCargo5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))))
                .addGap(45, 45, 45))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargo5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(btnPesq2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Painel2.setBackground(new java.awt.Color(240, 252, 255));
        Painel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 100, 120));
        jLabel34.setText("Nome: ");

        btnCadastrar2.setBackground(new java.awt.Color(0, 176, 211));
        btnCadastrar2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCadastrar2.setForeground(new java.awt.Color(0, 105, 120));
        btnCadastrar2.setText("Cadastrar");
        btnCadastrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar2ActionPerformed(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 100, 120));
        jLabel35.setText("CPF:");

        txtRG.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 100, 120));
        jLabel36.setText("RG:");

        txtCPF.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel37.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 100, 120));
        jLabel37.setText("Cod. Filial:");

        txtCodFilial.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCodFilial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCodFilial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodFilialActionPerformed(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 100, 120));
        jLabel38.setText("Cargo:");

        txtCargo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoActionPerformed(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 100, 120));
        jLabel39.setText("CEP:");

        txtCEP.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCEP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel40.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 100, 120));
        jLabel40.setText("N°:");

        txtNum.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNum.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 100, 120));
        jLabel41.setText("Endereço:");

        txtEndereco.setEditable(false);
        txtEndereco.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEndereco.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel42.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 100, 120));
        jLabel42.setText("Cidade:");

        txtCidade.setEditable(false);
        txtCidade.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 100, 120));
        jLabel43.setText("Estado:");

        txtEstado.setEditable(false);
        txtEstado.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel44.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 100, 120));
        jLabel44.setText("Telefone:");

        txtTelefone.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel45.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 100, 120));
        jLabel45.setText("Celular:");

        txtCelular.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelularActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 100, 120));
        jLabel46.setText("Email:");

        jLabel47.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 100, 120));
        jLabel47.setText("Login:");

        txtEmail.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtLogin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel48.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 100, 120));
        jLabel48.setText("Senha:");

        lblMensagem.setAlignment(java.awt.Label.CENTER);
        lblMensagem.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagem.setForeground(new java.awt.Color(0, 100, 120));

        jPanel7.setBackground(new java.awt.Color(0, 100, 120));

        jLabel49.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(87, 220, 255));
        jLabel49.setText("CADASTRO FUNCIONÁRIO");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(95, 95, 95))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        btnBuscar.setBackground(new java.awt.Color(0, 176, 211));
        btnBuscar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(0, 105, 120));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Painel2Layout = new javax.swing.GroupLayout(Painel2);
        Painel2.setLayout(Painel2Layout);
        Painel2Layout.setHorizontalGroup(
            Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel2Layout.createSequentialGroup()
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel2Layout.createSequentialGroup()
                                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel39)
                                    .addComponent(jLabel41)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel44))
                                .addGap(19, 19, 19)
                                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Painel2Layout.createSequentialGroup()
                                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel2Layout.createSequentialGroup()
                                                .addComponent(txtEstado)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel42))
                                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCidade)
                                            .addGroup(Painel2Layout.createSequentialGroup()
                                                .addComponent(jLabel45)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCelular))))
                                    .addComponent(txtEndereco, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(Painel2Layout.createSequentialGroup()
                                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46)
                                    .addComponent(jLabel47))
                                .addGap(47, 47, 47)
                                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail)
                                    .addGroup(Painel2Layout.createSequentialGroup()
                                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel48)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSenha))
                                    .addComponent(lblMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(Painel2Layout.createSequentialGroup()
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel2Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel34)
                                    .addComponent(jLabel35))
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel50)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel2Layout.createSequentialGroup()
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRG))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Painel2Layout.createSequentialGroup()
                                .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel40)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNum))
                            .addComponent(txtNome)
                            .addGroup(Painel2Layout.createSequentialGroup()
                                .addComponent(txtCodFilial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCadastrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );
        Painel2Layout.setVerticalGroup(
            Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50))
                .addGap(18, 18, 18)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel35)
                        .addComponent(jLabel36)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodFilial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(jLabel40)
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41))
                .addGap(14, 14, 14)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(jLabel42)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel44)
                        .addComponent(jLabel45))
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel47)
                        .addComponent(jLabel48))
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCadastrar2)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cadastrar", jPanel1);

        Painel3.setBackground(new java.awt.Color(240, 252, 255));
        Painel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 100, 120));
        jLabel51.setText("Nome: ");

        btnAtualizar.setBackground(new java.awt.Color(0, 176, 211));
        btnAtualizar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(0, 105, 120));
        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        txtNome1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNome1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome1ActionPerformed(evt);
            }
        });

        jLabel52.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 100, 120));
        jLabel52.setText("CPF:");

        txtRG1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRG1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel53.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 100, 120));
        jLabel53.setText("RG:");

        txtCPF1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCPF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel54.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 100, 120));
        jLabel54.setText("Cod. Filial:");

        txtCodFilial1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCodFilial1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCodFilial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodFilial1ActionPerformed(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 100, 120));
        jLabel55.setText("Cargo:");

        txtCargo1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCargo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCargo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargo1ActionPerformed(evt);
            }
        });

        jLabel56.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 100, 120));
        jLabel56.setText("CEP:");

        txtCEP1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCEP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel57.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 100, 120));
        jLabel57.setText("N°:");

        txtNum1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNum1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNum1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum1ActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 100, 120));
        jLabel58.setText("Endereço:");

        txtEndereco1.setEditable(false);
        txtEndereco1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEndereco1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel59.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 100, 120));
        jLabel59.setText("Cidade:");

        txtCidade1.setEditable(false);
        txtCidade1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCidade1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCidade1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidade1ActionPerformed(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 100, 120));
        jLabel60.setText("Estado:");

        txtEstado1.setEditable(false);
        txtEstado1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEstado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel61.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 100, 120));
        jLabel61.setText("Telefone:");

        txtTelefone1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtTelefone1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel62.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 100, 120));
        jLabel62.setText("Celular:");

        txtCelular1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCelular1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCelular1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelular1ActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(0, 100, 120));
        jLabel63.setText("Email:");

        jLabel64.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 100, 120));
        jLabel64.setText("Login:");

        txtEmail1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEmail1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtEmail1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail1ActionPerformed(evt);
            }
        });

        txtLogin1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtLogin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel65.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(0, 100, 120));
        jLabel65.setText("Senha:");

        lblMensagem1.setAlignment(java.awt.Label.CENTER);
        lblMensagem1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagem1.setForeground(new java.awt.Color(0, 100, 120));

        jPanel8.setBackground(new java.awt.Color(0, 100, 120));

        jLabel66.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(87, 220, 255));
        jLabel66.setText("ATUALIZAR FUNCIONÁRIO");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel66)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSenha1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSenha1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        btnBuscar1.setBackground(new java.awt.Color(0, 176, 211));
        btnBuscar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscar1.setForeground(new java.awt.Color(0, 105, 120));
        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        txtPesq.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPesq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesqActionPerformed(evt);
            }
        });

        btnPesq.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq.setText("Pesquisar");
        btnPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesqActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 100, 120));
        jLabel19.setText("CPF:");

        javax.swing.GroupLayout Painel3Layout = new javax.swing.GroupLayout(Painel3);
        Painel3.setLayout(Painel3Layout);
        Painel3Layout.setHorizontalGroup(
            Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel3Layout.createSequentialGroup()
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Painel3Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel3Layout.createSequentialGroup()
                                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54)
                                    .addComponent(jLabel56)
                                    .addComponent(jLabel58)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel61))
                                .addGap(19, 19, 19)
                                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Painel3Layout.createSequentialGroup()
                                        .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel3Layout.createSequentialGroup()
                                                .addComponent(txtEstado1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel59))
                                            .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCidade1)
                                            .addGroup(Painel3Layout.createSequentialGroup()
                                                .addComponent(jLabel62)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtCelular1))))
                                    .addComponent(txtEndereco1, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(Painel3Layout.createSequentialGroup()
                                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel63)
                                    .addComponent(jLabel64))
                                .addGap(47, 47, 47)
                                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail1)
                                    .addGroup(Painel3Layout.createSequentialGroup()
                                        .addComponent(txtLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel65)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSenha1))
                                    .addComponent(lblMensagem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(Painel3Layout.createSequentialGroup()
                                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel52))
                                .addGap(42, 42, 42)
                                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Painel3Layout.createSequentialGroup()
                                        .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel53)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRG1))
                                    .addGroup(Painel3Layout.createSequentialGroup()
                                        .addComponent(txtCEP1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(16, 16, 16)
                                        .addComponent(jLabel57)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNum1))
                                    .addComponent(txtNome1)
                                    .addGroup(Painel3Layout.createSequentialGroup()
                                        .addComponent(txtCodFilial1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel55)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel3Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 101))
                            .addGroup(Painel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(60, 60, 60)
                                .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))))
                    .addGroup(Painel3Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jLabel67)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        Painel3Layout.setVerticalGroup(
            Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel67))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesq)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRG1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCPF1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52)
                        .addComponent(jLabel53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodFilial1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(txtCargo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel55)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(txtCEP1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1)
                    .addComponent(jLabel57)
                    .addComponent(txtNum1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addGap(14, 14, 14)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel60)
                    .addComponent(jLabel59)
                    .addComponent(txtCidade1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel61)
                        .addComponent(jLabel62))
                    .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel64)
                        .addComponent(jLabel65))
                    .addComponent(txtSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnAtualizar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Alterar", jPanel2);

        jPanel5.setBackground(new java.awt.Color(240, 252, 255));

        jPanel6.setBackground(new java.awt.Color(0, 100, 120));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(87, 220, 255));
        jLabel17.setText("EXCLUIR FUNCIONÁRIO");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(110, 110, 110))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCPFpesq.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCPFpesq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCPFpesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFpesqActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 100, 120));
        jLabel3.setText("CPF:");

        btnPesq1.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq1.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq1.setText("Pesquisar");
        btnPesq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq1ActionPerformed(evt);
            }
        });

        jtCliente1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente1.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "Telefone", "Email", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente1.setGridColor(new java.awt.Color(255, 255, 255));
        jtCliente1.setInheritsPopupMenu(true);
        jtCliente1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente1.setRowHeight(25);
        jtCliente1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtCliente1);

        btnExcluir.setBackground(new java.awt.Color(0, 176, 211));
        btnExcluir.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(0, 105, 120));
        btnExcluir.setLabel("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel3)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txtCPFpesq, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(45, 45, 45))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPFpesq, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnPesq1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Excluir", jPanel3);

        jPanel11.setBackground(new java.awt.Color(240, 252, 255));

        jPanel12.setBackground(new java.awt.Color(0, 100, 120));

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(87, 220, 255));
        jLabel20.setText("VISUALIZAR FUNCIONÁRIOS");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCargoPesq.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCargoPesq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCargoPesq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCargoPesqActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 100, 120));
        jLabel7.setText("Cargo:");

        btnPesq3.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq3.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq3.setText("Pesquisar");
        btnPesq3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq3ActionPerformed(evt);
            }
        });

        jtCliente3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente3.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Filial", "Nome", "Telefone", "Email", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente3.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente3.setInheritsPopupMenu(true);
        jtCliente3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente3.setRowHeight(25);
        jtCliente3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente3.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtCliente3);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(112, 112, 112)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(23, 23, 23)
                                .addComponent(txtCargoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))))
                .addGap(45, 45, 45))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCargoPesq, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(btnPesq3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consultar", jPanel4);

        jTabbedPane2.addTab("Funcionário", jTabbedPane1);
        jTabbedPane1.getAccessibleContext().setAccessibleName("Cadastro");

        Painel.setBackground(new java.awt.Color(240, 252, 255));
        Painel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 100, 120));
        jLabel1.setText("Nome: ");

        btnCadastrar.setBackground(new java.awt.Color(0, 176, 211));
        btnCadastrar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCadastrar.setForeground(new java.awt.Color(0, 105, 120));
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        txtNome2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNome2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNome2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome2ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 100, 120));
        jLabel9.setText("CPF:");

        txtRG2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRG2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 100, 120));
        jLabel10.setText("RG:");

        txtCPF2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCPF2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 100, 120));
        jLabel11.setText("CEP:");

        txtCEP2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCEP2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 100, 120));
        jLabel12.setText("N°:");

        txtNum2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNum2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNum2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 100, 120));
        jLabel13.setText("Endereço:");

        txtEndereco2.setEditable(false);
        txtEndereco2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEndereco2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 100, 120));
        jLabel14.setText("Cidade:");

        txtCidade2.setEditable(false);
        txtCidade2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCidade2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCidade2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidade2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 100, 120));
        jLabel15.setText("Estado:");

        txtEstado2.setEditable(false);
        txtEstado2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEstado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 100, 120));
        jLabel16.setText("Telefone:");

        txtTelefone2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtTelefone2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 100, 120));
        jLabel21.setText("Celular:");

        txtCelular2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCelular2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCelular2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelular2ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 100, 120));
        jLabel22.setText("Email:");

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 100, 120));
        jLabel23.setText("Login:");

        txtEmail2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEmail2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtEmail2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail2ActionPerformed(evt);
            }
        });

        txtLogin2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtLogin2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 100, 120));
        jLabel24.setText("Senha:");

        lblMensagem2.setAlignment(java.awt.Label.CENTER);
        lblMensagem2.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagem2.setForeground(new java.awt.Color(0, 100, 120));

        jPanel13.setBackground(new java.awt.Color(0, 100, 120));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(87, 220, 255));
        jLabel25.setText("CADASTRO MOTORISTA");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtSenha2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSenha2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        btnBuscar2.setBackground(new java.awt.Color(0, 176, 211));
        btnBuscar2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscar2.setForeground(new java.awt.Color(0, 105, 120));
        btnBuscar2.setText("Buscar");
        btnBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(23, 23, 23)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCelular2))
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(txtEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel14)
                                        .addGap(9, 9, 9)
                                        .addComponent(txtCidade2))
                                    .addComponent(txtEndereco2, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addGap(47, 47, 47)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail2)
                                    .addGroup(PainelLayout.createSequentialGroup()
                                        .addComponent(txtLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSenha2))
                                    .addComponent(lblMensagem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1))
                                .addGap(42, 42, 42)))
                        .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addComponent(txtCEP2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNum2))
                            .addComponent(txtNome2, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                            .addGroup(PainelLayout.createSequentialGroup()
                                .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(10, 10, 10)
                                .addComponent(txtRG2)))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCPF2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRG2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCEP2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar2)
                    .addComponent(jLabel12)
                    .addComponent(txtNum2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEndereco2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(14, 14, 14)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(txtCidade2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16))
                    .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(txtCelular2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLogin2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23))
                    .addComponent(jLabel24)
                    .addComponent(txtSenha2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnCadastrar)
                .addGap(30, 30, 30))
        );

        jTabbedPane4.addTab("Cadastrar", Painel);

        Painel1.setBackground(new java.awt.Color(240, 252, 255));
        Painel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 100, 120));
        jLabel27.setText("Nome: ");

        txtNome3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNome3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome3ActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 100, 120));
        jLabel28.setText("CPF:");

        txtRG3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtRG3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 100, 120));
        jLabel29.setText("RG:");

        txtCPF3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCPF3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 100, 120));
        jLabel30.setText("CEP:");

        txtCEP3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCEP3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 100, 120));
        jLabel31.setText("N°:");

        txtNum3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNum3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNum3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNum3ActionPerformed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 100, 120));
        jLabel32.setText("Endereço:");

        txtEndereco3.setEditable(false);
        txtEndereco3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEndereco3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 100, 120));
        jLabel33.setText("Cidade:");

        txtCidade3.setEditable(false);
        txtCidade3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCidade3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCidade3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidade3ActionPerformed(evt);
            }
        });

        jLabel68.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 100, 120));
        jLabel68.setText("Estado:");

        txtEstado3.setEditable(false);
        txtEstado3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEstado3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel69.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 100, 120));
        jLabel69.setText("Telefone:");

        txtTelefone3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtTelefone3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel70.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 100, 120));
        jLabel70.setText("Celular:");

        txtCelular3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCelular3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCelular3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCelular3ActionPerformed(evt);
            }
        });

        jLabel71.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 100, 120));
        jLabel71.setText("Email:");

        jLabel72.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 100, 120));
        jLabel72.setText("Login:");

        txtEmail3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEmail3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtEmail3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmail3ActionPerformed(evt);
            }
        });

        txtLogin3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtLogin3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel73.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 100, 120));
        jLabel73.setText("Senha:");

        lblMensagem3.setAlignment(java.awt.Label.CENTER);
        lblMensagem3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagem3.setForeground(new java.awt.Color(0, 100, 120));

        jPanel14.setBackground(new java.awt.Color(0, 100, 120));

        jLabel74.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(87, 220, 255));
        jLabel74.setText("ATUALIZAR MOTORISTA");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel74)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel74)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnBuscar3.setBackground(new java.awt.Color(0, 176, 211));
        btnBuscar3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnBuscar3.setForeground(new java.awt.Color(0, 105, 120));
        btnBuscar3.setText("Buscar");
        btnBuscar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar3ActionPerformed(evt);
            }
        });

        jLabel76.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 100, 120));
        jLabel76.setText("CPF:");

        txtPesq1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPesq1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtPesq1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesq1ActionPerformed(evt);
            }
        });

        btnPesq4.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq4.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq4.setText("Pesquisar");
        btnPesq4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq4ActionPerformed(evt);
            }
        });

        btnAtualizar1.setBackground(new java.awt.Color(0, 176, 211));
        btnAtualizar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAtualizar1.setForeground(new java.awt.Color(0, 105, 120));
        btnAtualizar1.setText("Atualizar");
        btnAtualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizar1ActionPerformed(evt);
            }
        });

        txtSenha3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtSenha3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        javax.swing.GroupLayout Painel1Layout = new javax.swing.GroupLayout(Painel1);
        Painel1.setLayout(Painel1Layout);
        Painel1Layout.setHorizontalGroup(
            Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel1Layout.createSequentialGroup()
                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Painel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Painel1Layout.createSequentialGroup()
                                .addComponent(btnAtualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(143, 143, 143))
                            .addComponent(lblMensagem3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Painel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel1Layout.createSequentialGroup()
                                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel68)
                                    .addComponent(jLabel69)
                                    .addComponent(jLabel71)
                                    .addComponent(jLabel72)
                                    .addComponent(jLabel28))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel1Layout.createSequentialGroup()
                                        .addComponent(txtLogin3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel73)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSenha3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEmail3)
                                    .addGroup(Painel1Layout.createSequentialGroup()
                                        .addComponent(txtCEP3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnBuscar3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel31)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Painel1Layout.createSequentialGroup()
                                        .addComponent(txtTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCelular3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Painel1Layout.createSequentialGroup()
                                        .addComponent(txtCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel29)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtRG3, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel1Layout.createSequentialGroup()
                                        .addComponent(txtEstado3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel33)
                                        .addGap(9, 9, 9)
                                        .addComponent(txtCidade3, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtEndereco3, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Painel1Layout.createSequentialGroup()
                                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel76))
                                .addGap(18, 47, Short.MAX_VALUE)
                                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(Painel1Layout.createSequentialGroup()
                                        .addComponent(txtPesq1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesq4, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                                    .addComponent(txtNome3, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel75)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        Painel1Layout.setVerticalGroup(
            Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel75)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel76)
                    .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPesq1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPesq4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel1Layout.createSequentialGroup()
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCPF3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRG3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCEP3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar3)
                            .addComponent(jLabel31)
                            .addComponent(txtNum3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEndereco3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstado3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(txtCidade3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefone3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel70)
                                .addComponent(txtCelular3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Painel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSenha3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel73))))
                    .addGroup(Painel1Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel30)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel68)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel69)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel71)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel72)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Alterar", Painel1);

        jPanel15.setBackground(new java.awt.Color(240, 252, 255));

        jPanel16.setBackground(new java.awt.Color(0, 100, 120));

        jLabel77.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(87, 220, 255));
        jLabel77.setText("EXCLUIR MOTORISTAS");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel77)
                .addContainerGap(104, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel77)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPesq2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPesq2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtPesq2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesq2ActionPerformed(evt);
            }
        });

        jLabel78.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 100, 120));
        jLabel78.setText("CPF:");

        btnPesq5.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq5.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq5.setText("Pesquisar");
        btnPesq5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq5ActionPerformed(evt);
            }
        });

        jtCliente4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente4.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Email", "Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente4.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente4.setInheritsPopupMenu(true);
        jtCliente4.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente4.setRowHeight(25);
        jtCliente4.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente4.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jtCliente4);

        btnExcluir1.setBackground(new java.awt.Color(0, 176, 211));
        btnExcluir1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnExcluir1.setForeground(new java.awt.Color(0, 105, 120));
        btnExcluir1.setLabel("Excluir");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel79)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel78)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPesq2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesq5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel79))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesq2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel78)
                    .addComponent(btnPesq5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Excluir", jPanel15);

        jPanel17.setBackground(new java.awt.Color(240, 252, 255));

        jPanel18.setBackground(new java.awt.Color(0, 100, 120));

        jLabel80.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(87, 220, 255));
        jLabel80.setText("VISUALIZAR MOTORISTAS");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel80)
                .addGap(89, 89, 89))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtNome4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtNome4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtNome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNome4ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 100, 120));
        jLabel81.setText("Nome:");

        btnPesq6.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq6.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq6.setText("Pesquisar");
        btnPesq6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq6ActionPerformed(evt);
            }
        });

        jtCliente5.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente5.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Email", "Login"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente5.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente5.setInheritsPopupMenu(true);
        jtCliente5.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente5.setRowHeight(25);
        jtCliente5.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente5.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jtCliente5);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel82)
                        .addGap(114, 114, 114)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel81)
                                .addGap(45, 45, 45)
                                .addComponent(txtNome4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq6, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)))))
                .addGap(45, 45, 45))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81)
                    .addComponent(btnPesq6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Consultar", jPanel17);

        jTabbedPane2.addTab("Motorista", jTabbedPane4);

        Painel5.setBackground(new java.awt.Color(240, 252, 255));
        Painel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel95.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 100, 120));
        jLabel95.setText("Marca:");

        btnCadastrar1.setBackground(new java.awt.Color(0, 176, 211));
        btnCadastrar1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCadastrar1.setForeground(new java.awt.Color(0, 105, 120));
        btnCadastrar1.setText("Cadastrar");
        btnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar1ActionPerformed(evt);
            }
        });

        txtMarca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });

        jLabel96.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 100, 120));
        jLabel96.setText("Modelo:");

        txtModelo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel97.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 100, 120));
        jLabel97.setText("Ano:");

        txtAno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });

        jLabel98.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 100, 120));
        jLabel98.setText("Cor:");

        txtCor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorActionPerformed(evt);
            }
        });

        jLabel99.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 100, 120));
        jLabel99.setText("Placa:");

        txtPlaca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        txtEstado4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEstado4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtEstado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstado4ActionPerformed(evt);
            }
        });

        jLabel100.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 100, 120));
        jLabel100.setText("Estado:");

        lblMensagem5.setAlignment(java.awt.Label.CENTER);
        lblMensagem5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagem5.setForeground(new java.awt.Color(0, 100, 120));

        jPanel28.setBackground(new java.awt.Color(0, 100, 120));

        jLabel101.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(87, 220, 255));
        jLabel101.setText("CADASTRO VEÍCULO");

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(jLabel101)
                .addGap(115, 115, 115))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel101)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Painel5Layout = new javax.swing.GroupLayout(Painel5);
        Painel5.setLayout(Painel5Layout);
        Painel5Layout.setHorizontalGroup(
            Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel5Layout.createSequentialGroup()
                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel97)
                            .addComponent(jLabel99))
                        .addGap(217, 217, 217)
                        .addComponent(jLabel98)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCor))
                    .addGroup(Painel5Layout.createSequentialGroup()
                        .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel5Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel95)
                                    .addComponent(jLabel96))
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel102)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMensagem5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMarca)
                            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModelo)
                            .addGroup(Painel5Layout.createSequentialGroup()
                                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtAno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel100)
                                .addGap(5, 5, 5)
                                .addComponent(txtEstado4)))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        Painel5Layout.setVerticalGroup(
            Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel5Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel102))
                .addGap(18, 18, 18)
                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel95))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel96))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel97)
                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel98)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel99)
                        .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel100))
                    .addComponent(txtEstado4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(lblMensagem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar1)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Cadastrar", Painel5);

        Painel6.setBackground(new java.awt.Color(240, 252, 255));
        Painel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel83.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 100, 120));
        jLabel83.setText("Marca:");

        btnAtualizar2.setBackground(new java.awt.Color(0, 176, 211));
        btnAtualizar2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAtualizar2.setForeground(new java.awt.Color(0, 105, 120));
        btnAtualizar2.setText("Atualizar");
        btnAtualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizar2ActionPerformed(evt);
            }
        });

        txtMarca1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtMarca1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarca1ActionPerformed(evt);
            }
        });

        jLabel86.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 100, 120));
        jLabel86.setText("Modelo:");

        txtModelo1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtModelo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        jLabel103.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 100, 120));
        jLabel103.setText("Ano:");

        txtAno1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtAno1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtAno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAno1ActionPerformed(evt);
            }
        });

        jLabel104.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 100, 120));
        jLabel104.setText("Cor:");

        txtCor1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtCor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtCor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCor1ActionPerformed(evt);
            }
        });

        jLabel105.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 100, 120));
        jLabel105.setText("Placa:");

        txtPlaca1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPlaca1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));

        txtEstado5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtEstado5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtEstado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstado5ActionPerformed(evt);
            }
        });

        jLabel106.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 100, 120));
        jLabel106.setText("Estado:");

        lblMensagem6.setAlignment(java.awt.Label.CENTER);
        lblMensagem6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagem6.setForeground(new java.awt.Color(0, 100, 120));

        jPanel19.setBackground(new java.awt.Color(0, 100, 120));

        jLabel107.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(87, 220, 255));
        jLabel107.setText("ATUALIZAR VEÍCULO");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addComponent(jLabel107)
                .addGap(115, 115, 115))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel109.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 100, 120));
        jLabel109.setText("Placa:");

        txtPesq3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPesq3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtPesq3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesq3ActionPerformed(evt);
            }
        });

        btnPesq9.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq9.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq9.setText("Pesquisar");
        btnPesq9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Painel6Layout = new javax.swing.GroupLayout(Painel6);
        Painel6.setLayout(Painel6Layout);
        Painel6Layout.setHorizontalGroup(
            Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel6Layout.createSequentialGroup()
                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel6Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel103)
                            .addComponent(jLabel105))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCor1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Painel6Layout.createSequentialGroup()
                        .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Painel6Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel83)
                                    .addComponent(jLabel86)
                                    .addComponent(jLabel109))
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel108)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMensagem6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMarca1)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtModelo1)
                            .addGroup(Painel6Layout.createSequentialGroup()
                                .addComponent(txtPesq3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(Painel6Layout.createSequentialGroup()
                                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPlaca1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(txtAno1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Painel6Layout.createSequentialGroup()
                                        .addComponent(jLabel104)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(Painel6Layout.createSequentialGroup()
                                        .addComponent(jLabel106)
                                        .addGap(5, 5, 5)
                                        .addComponent(txtEstado5)))))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizar2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );
        Painel6Layout.setVerticalGroup(
            Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel6Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel108))
                .addGap(12, 12, 12)
                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel109)
                    .addComponent(txtPesq3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesq9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel83))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtModelo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel86))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAno1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel103)
                        .addComponent(txtCor1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel104)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Painel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel105)
                        .addComponent(txtPlaca1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel106))
                    .addComponent(txtEstado5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(lblMensagem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtualizar2)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Alterar", Painel6);

        jPanel20.setBackground(new java.awt.Color(240, 252, 255));

        jPanel21.setBackground(new java.awt.Color(0, 100, 120));

        jLabel110.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(87, 220, 255));
        jLabel110.setText("EXCLUIR VEÍCULOS");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel110)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel110)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPlaca2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtPlaca2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtPlaca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPlaca2ActionPerformed(evt);
            }
        });

        jLabel111.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 100, 120));
        jLabel111.setText("Placa:");

        btnPesq10.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq10.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq10.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq10.setText("Pesquisar");
        btnPesq10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq10ActionPerformed(evt);
            }
        });

        jtCliente8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente8.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca", "Modelo", "Placa", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente8.setFocusable(false);
        jtCliente8.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente8.setInheritsPopupMenu(true);
        jtCliente8.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente8.setRowHeight(25);
        jtCliente8.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente8.getTableHeader().setResizingAllowed(false);
        jtCliente8.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jtCliente8);

        btnExcluir2.setBackground(new java.awt.Color(0, 176, 211));
        btnExcluir2.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnExcluir2.setForeground(new java.awt.Color(0, 105, 120));
        btnExcluir2.setLabel("Excluir");
        btnExcluir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel111)
                                .addGap(37, 37, 37))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel112)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(txtPlaca2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnExcluir2, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlaca2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(btnPesq10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Excluir", jPanel20);

        jPanel22.setBackground(new java.awt.Color(240, 252, 255));

        jPanel29.setBackground(new java.awt.Color(0, 100, 120));

        jLabel113.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(87, 220, 255));
        jLabel113.setText("VISUALIZAR VEÍCULOS");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel113)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel113)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMarca2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtMarca2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtMarca2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarca2ActionPerformed(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 100, 120));
        jLabel114.setText("Marca:");

        btnPesq11.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq11.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq11.setText("Pesquisar");
        btnPesq11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq11ActionPerformed(evt);
            }
        });

        jtCliente9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente9.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente9.setModel(new javax.swing.table.DefaultTableModel(
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
        jtCliente9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente9.setFocusable(false);
        jtCliente9.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente9.setInheritsPopupMenu(true);
        jtCliente9.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente9.setRowHeight(25);
        jtCliente9.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente9.getTableHeader().setResizingAllowed(false);
        jtCliente9.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(jtCliente9);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane10))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel114)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel115)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(txtMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesq11, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(45, 45, 45))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMarca2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114)
                    .addComponent(btnPesq11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Consultar", jPanel22);

        jTabbedPane2.addTab("Veículo", jTabbedPane5);

        Painel4.setBackground(new java.awt.Color(240, 252, 255));
        Painel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel84.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 100, 120));
        jLabel84.setText("Placa do Veículo:");

        btnCadFim.setBackground(new java.awt.Color(0, 176, 211));
        btnCadFim.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCadFim.setForeground(new java.awt.Color(0, 105, 120));
        btnCadFim.setText("Cadastrar Jornada");
        btnCadFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadFimActionPerformed(evt);
            }
        });

        txtVeiculo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtVeiculo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVeiculoActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 100, 120));
        jLabel85.setText("Contratempos:");

        lblMensagem4.setAlignment(java.awt.Label.CENTER);
        lblMensagem4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagem4.setForeground(new java.awt.Color(0, 100, 120));

        jPanel25.setBackground(new java.awt.Color(0, 100, 120));

        jLabel90.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(87, 220, 255));
        jLabel90.setText("CADASTRO JORNADA");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel90)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel90)
                .addContainerGap())
        );

        btnInciar.setBackground(new java.awt.Color(0, 176, 211));
        btnInciar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnInciar.setForeground(new java.awt.Color(0, 105, 120));
        btnInciar.setText("Iniciar Jornada");
        btnInciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInciarActionPerformed(evt);
            }
        });

        txtContratempos.setColumns(20);
        txtContratempos.setRows(5);
        jScrollPane1.setViewportView(txtContratempos);

        lblMensagemJ.setAlignment(java.awt.Label.CENTER);
        lblMensagemJ.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        lblMensagemJ.setForeground(new java.awt.Color(0, 100, 120));

        javax.swing.GroupLayout Painel4Layout = new javax.swing.GroupLayout(Painel4);
        Painel4.setLayout(Painel4Layout);
        Painel4Layout.setHorizontalGroup(
            Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCadFim, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel4Layout.createSequentialGroup()
                .addGroup(Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel4Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(lblMensagem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Painel4Layout.createSequentialGroup()
                        .addGroup(Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Painel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(Painel4Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85)
                                    .addComponent(jLabel84))
                                .addGap(10, 10, 10)))
                        .addGroup(Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMensagemJ, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(Painel4Layout.createSequentialGroup()
                                .addComponent(txtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInciar, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))))
                .addGap(45, 45, 45))
        );
        Painel4Layout.setVerticalGroup(
            Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Painel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel91))
                .addGap(18, 18, 18)
                .addGroup(Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel84)
                    .addComponent(btnInciar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Painel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel85)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensagemJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadFim)
                .addGap(47, 47, 47)
                .addComponent(lblMensagem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        jTabbedPane6.addTab("Cadastrar", Painel4);

        jPanel26.setBackground(new java.awt.Color(240, 252, 255));

        jPanel27.setBackground(new java.awt.Color(0, 100, 120));

        jLabel92.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(87, 220, 255));
        jLabel92.setText("RELATÓRIOS");

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel92)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel92)
                .addContainerGap())
        );

        txtData1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtData1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtData1ActionPerformed(evt);
            }
        });

        jLabel93.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 100, 120));
        jLabel93.setText("Data:");

        btnPesq7.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq7.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq7.setText("Pesquisar");
        btnPesq7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq7ActionPerformed(evt);
            }
        });

        jtCliente6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente6.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Início", "Fim", "Motorista", "Contratempo"
            }
        ));
        jtCliente6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente6.setFocusable(false);
        jtCliente6.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente6.setInheritsPopupMenu(true);
        jtCliente6.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente6.setRowHeight(25);
        jtCliente6.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente6.getTableHeader().setResizingAllowed(false);
        jtCliente6.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(jtCliente6);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel94))
                            .addGroup(jPanel26Layout.createSequentialGroup()
                                .addComponent(jLabel93)
                                .addGap(12, 12, 12)
                                .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesq7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel94))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel93)
                    .addComponent(btnPesq7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Relatórios", jPanel26);

        jTabbedPane2.addTab("Jornada", jTabbedPane6);

        jPanel23.setBackground(new java.awt.Color(240, 252, 255));

        jPanel24.setBackground(new java.awt.Color(0, 100, 120));

        jLabel87.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(87, 220, 255));
        jLabel87.setText("AUDITORIA");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(jLabel87)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel87)
                .addContainerGap())
        );

        txtData.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 100, 120)));
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jLabel88.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(0, 100, 120));
        jLabel88.setText("Data:");

        btnPesq8.setBackground(new java.awt.Color(0, 176, 211));
        btnPesq8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnPesq8.setForeground(new java.awt.Color(0, 105, 120));
        btnPesq8.setText("Pesquisar");
        btnPesq8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesq8ActionPerformed(evt);
            }
        });

        jtCliente7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jtCliente7.setForeground(new java.awt.Color(0, 100, 120));
        jtCliente7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Usuário", "Querry"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtCliente7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jtCliente7.setFocusable(false);
        jtCliente7.setGridColor(new java.awt.Color(87, 220, 225));
        jtCliente7.setInheritsPopupMenu(true);
        jtCliente7.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jtCliente7.setRowHeight(25);
        jtCliente7.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jtCliente7.getTableHeader().setResizingAllowed(false);
        jtCliente7.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(jtCliente7);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane8)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel89))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel88)
                                .addGap(12, 12, 12)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesq8, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel89))
                .addGap(18, 18, 18)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel88)
                    .addComponent(btnPesq8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Auditoria", jPanel23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(348, 348, 348)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar2ActionPerformed
        funcionario funcionarios = new funcionario();
        funcionarios.setNome_func(txtNome.getText());
        funcionarios.setCpf_func(txtCPF.getText());
        funcionarios.setRg_func(txtRG.getText());
        funcionarios.setId_filial(txtCodFilial.getText());
        funcionarios.setCargo_func(txtCargo.getText());
        funcionarios.setEndereco_func(txtEndereco.getText());
        funcionarios.setNum_func(txtNum.getText());
        funcionarios.setCep_func(txtCEP.getText());
        funcionarios.setCidade_func(txtCidade.getText());
        funcionarios.setEstado_func(txtEstado.getText());
        funcionarios.setTel_func(txtTelefone.getText());
        funcionarios.setCel_func(txtCelular.getText());
        funcionarios.setEmail_func(txtEmail.getText());
        funcionarios.setLogin_func(txtLogin.getText());
        funcionarios.setSenha_func(txtSenha.getText());

        if((txtNome.getText().isEmpty()||txtCPF.getText().isEmpty()||txtRG.getText().isEmpty()||txtCodFilial.getText().isEmpty()||
            txtCargo.getText().isEmpty()||txtCEP.getText().isEmpty()||txtNum.getText().isEmpty()||txtEndereco.getText().isEmpty()||
            txtCidade.getText().isEmpty()||txtEstado.getText().isEmpty()||txtTelefone.getText().isEmpty()||txtCelular.getText().isEmpty()||
            txtEmail.getText().isEmpty()||txtLogin.getText().isEmpty()||txtSenha.getText().isEmpty())){
            lblMensagem.setText("Preencha TODOS os campos!");
        }
        else{
            funcionarioDAO dao = new funcionarioDAO();
            dao.adiciona(funcionarios);
            lblMensagem.setText("Cadastro efetuado com SUCESSO!");

            txtNome.setText("");
            txtCPF.setText("");
            txtRG.setText("");
            txtCodFilial.setText("");
            txtCargo.setText("");
            txtCEP.setText("");
            txtNum.setText("");
            txtEndereco.setText("");
            txtCidade.setText("");
            txtEstado.setText("");
            txtTelefone.setText("");
            txtCelular.setText("");
            txtEmail.setText("");
            txtLogin.setText("");
            txtSenha.setText("");
        }
    }//GEN-LAST:event_btnCadastrar2ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCodFilialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodFilialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodFilialActionPerformed

    private void txtCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoActionPerformed

    private void txtNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumActionPerformed

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelularActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarCep(txtCEP.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
         try{
            if((txtNome1.getText().isEmpty()||txtCPF1.getText().isEmpty()||txtRG1.getText().isEmpty()||txtCodFilial1.getText().isEmpty()||
                txtCargo1.getText().isEmpty()||txtCEP1.getText().isEmpty()||txtNum1.getText().isEmpty()||txtEndereco1.getText().isEmpty()||
                txtCidade1.getText().isEmpty()||txtEstado1.getText().isEmpty()||txtTelefone1.getText().isEmpty()||txtCelular1.getText().isEmpty()||
                txtEmail1.getText().isEmpty()||txtLogin1.getText().isEmpty()||txtSenha1.getText().isEmpty())){
            lblMensagem1.setText("Preencha TODOS os campos!");
        }
        else{
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "update funcionario set nome_func=?,cpf_func=?,rg_func=?,id_filial=?,"
                    + "cargo_func=?,endereco_func=?,cep_func=?,num_func=?,estado_func=?,cidade_func=?,"
                    + "tel_func=?,cel_func=?,email_func=?,login_func=?,senha_func=? where cpf_func = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, this.txtNome1.getText());
            stmt.setString(2, this.txtCPF1.getText());
            stmt.setString(3, this.txtRG1.getText());
            stmt.setString(4, this.txtCodFilial1.getText());
            stmt.setString(5, this.txtCargo1.getText());
            stmt.setString(6, this.txtEndereco1.getText());
            stmt.setString(7, this.txtCEP1.getText());
            stmt.setString(8, this.txtNum1.getText());
            stmt.setString(9, this.txtEstado1.getText());
            stmt.setString(10, this.txtCidade1.getText());
            stmt.setString(11, this.txtTelefone1.getText());
            stmt.setString(12, this.txtCelular1.getText());
            stmt.setString(13, this.txtEmail1.getText());
            stmt.setString(14, this.txtLogin1.getText());
            stmt.setString(15, this.txtSenha1.getText());
            stmt.setString(16, txtPesq.getText());
            stmt.execute();
            con.close();
            lblMensagem1.setText("Funcionário atualizado com SUCESSO!");
            txtNome1.setText("");
            txtCPF1.setText("");
            txtRG1.setText("");
            txtCodFilial1.setText("");
            txtCargo1.setText("");
            txtCEP1.setText("");
            txtNum1.setText("");
            txtEndereco1.setText("");
            txtCidade1.setText("");
            txtEstado1.setText("");
            txtTelefone1.setText("");
            txtCelular1.setText("");
            txtEmail1.setText("");
            txtLogin1.setText("");
            txtSenha1.setText("");
            txtPesq.setText("");
                
         }
        }
        catch(SQLException e)
        {
          JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void txtNome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome1ActionPerformed

    private void txtCodFilial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodFilial1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodFilial1ActionPerformed

    private void txtCargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargo1ActionPerformed

    private void txtNum1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNum1ActionPerformed

    private void txtCidade1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidade1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidade1ActionPerformed

    private void txtCelular1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelular1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelular1ActionPerformed

    private void txtEmail1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail1ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        buscarCep1(txtCEP1.getText());
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void txtPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesqActionPerformed

    private void btnPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesqActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from funcionario where cpf_func = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, txtPesq.getText());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                txtNome1.setText(rs.getString("nome_func"));
                txtCPF1.setText(rs.getString("cpf_func"));
                txtRG1.setText(rs.getString("rg_func"));
                txtCodFilial1.setText(rs.getString("id_filial"));
                txtCargo1.setText(rs.getString("cargo_func"));
                txtEndereco1.setText(rs.getString("endereco_func"));
                txtCEP1.setText(rs.getString("cep_func"));
                txtNum1.setText(rs.getString("num_func"));
                txtEstado1.setText(rs.getString("estado_func"));
                txtCidade1.setText(rs.getString("cidade_func"));
                txtTelefone1.setText(rs.getString("tel_func"));
                txtCelular1.setText(rs.getString("cel_func"));
                txtEmail1.setText(rs.getString("email_func"));
                txtLogin1.setText(rs.getString("login_func"));
                txtSenha1.setText(rs.getString("senha_func"));
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesqActionPerformed

    private void txtCPFpesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFpesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCPFpesqActionPerformed

    private void btnPesq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq1ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from funcionario";

            if(!txtCPFpesq.getText().equals(""))
            sql = sql + " where cpf_func LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtCPFpesq.getText().equals(""))
            stmt.setString(1, "%"+txtCPFpesq.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente1.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("id_func"), rs.getString("nome_func"),
                    rs.getString("cpf_func"),rs.getString("tel_func"),
                    rs.getString("email_func"),rs.getString("cargo_func")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq1ActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        try{
            Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "delete from funcionario where id_func = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            int linha = this.jtCliente1.getSelectedRow();
            stmt.setInt(1, Integer.parseInt(jtCliente1.getValueAt(linha, 0).toString()));
            stmt.execute();
            stmt.close();
            con.close();
            DefaultTableModel model = (DefaultTableModel) jtCliente1.getModel();
            model.removeRow(linha);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtCargo5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargo5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargo5ActionPerformed

    private void btnPesq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq2ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from funcionario";

            if(!txtCargo.getText().equals(""))
            sql = sql + " where cargo_func LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtCargo.getText().equals(""))
            stmt.setString(1, "%"+txtCargo.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente1.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("id_filial"),
                    rs.getString("nome_func"),rs.getString("tel_func"),
                    rs.getString("email_func"),rs.getString("cargo_func")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq2ActionPerformed

    private void txtCargoPesqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCargoPesqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCargoPesqActionPerformed

    private void btnPesq3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq3ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from funcionario";

            if(!txtCargoPesq.getText().equals(""))
            sql = sql + " where cargo_func LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtCargoPesq.getText().equals(""))
            stmt.setString(1, "%"+txtCargoPesq.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente3.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("id_filial"),
                    rs.getString("nome_func"),rs.getString("tel_func"),
                    rs.getString("email_func"),rs.getString("cargo_func")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq3ActionPerformed

    private void btnBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar2ActionPerformed
        // TODO add your handling code here:
        buscarCep2(txtCEP2.getText());
    }//GEN-LAST:event_btnBuscar2ActionPerformed

    private void txtEmail2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail2ActionPerformed

    private void txtCelular2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelular2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelular2ActionPerformed

    private void txtCidade2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidade2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidade2ActionPerformed

    private void txtNum2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNum2ActionPerformed

    private void txtNome2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome2ActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed

        String DateDATA, DateHORA;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date relogio = new Date();
        DateDATA = dateFormat.format(relogio);

        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Date relogio2 = new Date();
        DateHORA = dateFormat2.format(relogio2);

        motorista motoristas = new motorista();
        motoristas.setNome_mot(txtNome2.getText());
        motoristas.setCpf_mot(txtCPF2.getText());
        motoristas.setRg_mot(txtRG2.getText());
        motoristas.setEndereco_mot(txtEndereco2.getText());
        motoristas.setNum_mot(txtNum2.getText());
        motoristas.setCep_mot(txtCEP2.getText());
        motoristas.setCidade_mot(txtCidade2.getText());
        motoristas.setEstado_mot(txtEstado2.getText());
        motoristas.setTel_mot(txtTelefone2.getText());
        motoristas.setCel_mot(txtCelular2.getText());
        motoristas.setEmail_mot(txtEmail2.getText());
        motoristas.setLogin_mot(txtLogin2.getText());
        motoristas.setSenha_mot(txtSenha2.getText());

        if((txtNome2.getText().isEmpty()||txtCPF2.getText().isEmpty()||txtRG2.getText().isEmpty()||
            txtCEP2.getText().isEmpty()||txtNum2.getText().isEmpty()||txtEndereco2.getText().isEmpty()||
            txtCidade2.getText().isEmpty()||txtEstado2.getText().isEmpty()||txtTelefone2.getText().isEmpty()||txtCelular2.getText().isEmpty()||
            txtEmail2.getText().isEmpty()||txtLogin2.getText().isEmpty()||txtSenha2.getText().isEmpty())){
          lblMensagem2.setText("Preencha TODOS os campos!");
        }
        else{
            motoristaDAO dao = new motoristaDAO();
            dao.adiciona(motoristas);

            lblMensagem2.setText("Cadastro efetuado com SUCESSO!");

            txtNome2.setText("");
            txtCPF2.setText("");
            txtRG2.setText("");
            txtCEP2.setText("");
            txtNum2.setText("");
            txtEndereco2.setText("");
            txtCidade2.setText("");
            txtEstado2.setText("");
            txtTelefone2.setText("");
            txtCelular2.setText("");
            txtEmail2.setText("");
            txtLogin2.setText("");
            txtSenha2.setText("");

            try{
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
                String sql = "insert into auditoria(data_aud, hora_aud, usu_aud, querry_aud) values (?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, DateDATA.toString());
                stmt.setString(2, DateHORA.toString());
                stmt.setString(3, "camila_adm");
                stmt.setString(4, "cad_mot");
                stmt.execute();
                con.close();

            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(this, e);
            }

        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void txtNome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome3ActionPerformed

    private void txtNum3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNum3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNum3ActionPerformed

    private void txtCidade3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidade3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidade3ActionPerformed

    private void txtCelular3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCelular3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCelular3ActionPerformed

    private void txtEmail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmail3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmail3ActionPerformed

    private void btnBuscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar3ActionPerformed
        // TODO add your handling code here:
        buscarCep3(txtCEP3.getText());
    }//GEN-LAST:event_btnBuscar3ActionPerformed

    private void txtPesq1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesq1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesq1ActionPerformed

    private void btnPesq4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq4ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from motorista where cpf_mot = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, txtPesq1.getText());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                txtNome3.setText(rs.getString("nome_mot"));
                txtCPF3.setText(rs.getString("cpf_mot"));
                txtRG3.setText(rs.getString("rg_mot"));
                txtEndereco3.setText(rs.getString("endereco_mot"));
                txtCEP3.setText(rs.getString("cep_mot"));
                txtNum3.setText(rs.getString("num_mot"));
                txtEstado3.setText(rs.getString("estado_mot"));
                txtCidade3.setText(rs.getString("cidade_mot"));
                txtTelefone3.setText(rs.getString("tel_mot"));
                txtCelular3.setText(rs.getString("cel_mot"));
                txtEmail3.setText(rs.getString("email_mot"));
                txtLogin3.setText(rs.getString("login_mot"));
                txtSenha3.setText(rs.getString("senha_mot"));
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq4ActionPerformed

    private void btnAtualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizar1ActionPerformed
        try{
            if((txtNome3.getText().isEmpty()||txtCPF3.getText().isEmpty()||txtRG3.getText().isEmpty()||
                txtCEP3.getText().isEmpty()||txtNum3.getText().isEmpty()||txtEndereco3.getText().isEmpty()||
                txtCidade3.getText().isEmpty()||txtEstado3.getText().isEmpty()||txtTelefone3.getText().isEmpty()||txtCelular3.getText().isEmpty()||
                txtEmail3.getText().isEmpty()||txtLogin3.getText().isEmpty()||txtSenha3.getText().isEmpty())){
            lblMensagem3.setText("Preencha TODOS os campos!");
        }
        else{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "update motorista set nome_mot=?,cpf_mot=?,rg_mot=?,"
            + "endereco_mot=?,cep_mot=?,num_mot=?,estado_mot=?,cidade_mot=?,"
            + "tel_mot=?,cel_mot=?,email_mot=?,login_mot=?,senha_mot=? where cpf_mot = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, this.txtNome3.getText());
            stmt.setString(2, this.txtCPF3.getText());
            stmt.setString(3, this.txtRG3.getText());
            stmt.setString(4, this.txtEndereco3.getText());
            stmt.setString(5, this.txtCEP3.getText());
            stmt.setString(6, this.txtNum3.getText());
            stmt.setString(7, this.txtEstado3.getText());
            stmt.setString(8, this.txtCidade3.getText());
            stmt.setString(9, this.txtTelefone3.getText());
            stmt.setString(10, this.txtCelular3.getText());
            stmt.setString(11, this.txtEmail3.getText());
            stmt.setString(12, this.txtLogin3.getText());
            stmt.setString(13, this.txtSenha3.getText());
            stmt.setString(14, txtPesq1.getText());
            stmt.execute();
            con.close();

            lblMensagem3.setText("Motorista atualizado com SUCESSO!");
            txtNome3.setText("");
            txtCPF3.setText("");
            txtRG3.setText("");
            txtCEP3.setText("");
            txtNum3.setText("");
            txtEndereco3.setText("");
            txtCidade3.setText("");
            txtEstado3.setText("");
            txtTelefone3.setText("");
            txtCelular3.setText("");
            txtEmail3.setText("");
            txtLogin3.setText("");
            txtSenha3.setText("");
            txtPesq1.setText("");

        }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnAtualizar1ActionPerformed

    private void txtPesq2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesq2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesq2ActionPerformed

    private void btnPesq5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq5ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from motorista";

            if(!txtPesq2.getText().equals(""))
            sql = sql + " where nome_mot LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtPesq2.getText().equals(""))
            stmt.setString(1, "%"+txtPesq2.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente4.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("nome_mot"),
                    rs.getString("cpf_mot"),rs.getString("tel_mot"),
                    rs.getString("email_mot"),rs.getString("login_mot")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq5ActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        // TODO add your handling code here:

        String DateDATA, DateHORA;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date relogio = new Date();
        DateDATA = dateFormat.format(relogio);

        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Date relogio2 = new Date();
        DateHORA = dateFormat2.format(relogio2);

        try{
            Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "delete from motorista where cpf_mot = ?";
            String sql2 = "insert into auditoria(data_aud, hora_aud, usu_aud, querry_aud) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            PreparedStatement stmt2 = con.prepareStatement(sql2);
            int linha = this.jtCliente4.getSelectedRow();
            stmt.setString(1, jtCliente4.getValueAt(linha, 1).toString());
            stmt2.setString(1, DateDATA.toString());
            stmt2.setString(2, DateHORA.toString());
            stmt2.setString(3, "camila_adm");
            stmt2.setString(4, "excluir_mot");
            stmt.execute();
            stmt.close();
            stmt2.execute();
            stmt2.close();
            con.close();
            DefaultTableModel model = (DefaultTableModel) jtCliente4.getModel();
            model.removeRow(linha);

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_btnExcluir1ActionPerformed

    private void txtNome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNome4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNome4ActionPerformed

    private void btnPesq6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq6ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from motorista";

            if(!txtNome4.getText().equals(""))
            sql = sql + " where nome_mot LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtNome4.getText().equals(""))
            stmt.setString(1, "%"+txtNome4.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente5.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("nome_mot"),
                    rs.getString("cpf_mot"),rs.getString("tel_mot"),
                    rs.getString("email_mot"),rs.getString("login_mot")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq6ActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void btnPesq8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq8ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from auditoria";

            if(!txtData.getText().equals(""))
            sql = sql + " where data_aud LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtData.getText().equals(""))
            stmt.setString(1, "%"+txtData.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente7.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("data_aud"),
                    rs.getString("hora_aud"),rs.getString("usu_aud"),rs.getString("querry_aud")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq8ActionPerformed

    private void btnCadFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadFimActionPerformed
        String DateHORAFIM, DateDATA, DateHORAINICIO;
        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Date relogio2 = new Date();
        DateHORAFIM = dateFormat2.format(relogio2);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date relogio = new Date();
        DateDATA = dateFormat.format(relogio);

        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "update jornada set data_jorn=?, horafim_jorn=?, mot_jorn=?,"
            + " contratempo_jorn=? where vei_jorn=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, DateDATA.toString());
            stmt.setString(2, DateHORAFIM.toString());
            stmt.setString(3, "Carlos Silva");
            stmt.setString(4, this.txtContratempos.getText());
            stmt.setString(5, txtVeiculo.getText());
            stmt.execute();
            con.close();

            txtVeiculo.setText("");
            txtContratempos.setText("");
            lblMensagemJ.setText("Jornada Cadastrada com SUCESSO!!");

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnCadFimActionPerformed

    private void txtVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVeiculoActionPerformed

    private void btnInciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInciarActionPerformed
        // TODO add your handling code here:
        String DateHORAINICIO;

        DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
        Date relogio2 = new Date();
        DateHORAINICIO = dateFormat2.format(relogio2);

        try{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "insert into jornada(horainicio_jorn, vei_jorn) values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, DateHORAINICIO.toString());
            stmt.setString(2, this.txtVeiculo.getText());
            stmt.execute();
            con.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_btnInciarActionPerformed

    private void txtData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtData1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtData1ActionPerformed

    private void btnPesq7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq7ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from jornada";

            if(!txtData1.getText().equals(""))
            sql = sql + " where data_jorn LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtData1.getText().equals(""))
            stmt.setString(1, "%"+txtData1.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente6.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("data_jorn"),
                    rs.getString("horainicio_jorn"),rs.getString("horafim_jorn"),rs.getString("mot_jorn"),rs.getString("contratempo_jorn")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq7ActionPerformed

    private void btnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar1ActionPerformed
        veiculo veiculos = new veiculo();
        veiculos.setMarca_vei(txtMarca.getText());
        veiculos.setModelo_vei(txtModelo.getText());
        veiculos.setAno_vei(txtAno.getText());
        veiculos.setCor_vei(txtCor.getText());
        veiculos.setPlaca_vei(txtPlaca.getText());
        veiculos.setEstado_vei(txtEstado4.getText());

        if((txtMarca.getText().isEmpty()||txtModelo.getText().isEmpty()||txtAno.getText().isEmpty()||
            txtCor.getText().isEmpty()||txtPlaca.getText().isEmpty()||txtEstado4.getText().isEmpty())){
        lblMensagem5.setText("Preencha TODOS os campos!");
        }
        else{
            veiculoDAO dao = new veiculoDAO();
            dao.adiciona(veiculos);
            lblMensagem5.setText("Cadastro efetuado com SUCESSO!");

            txtMarca.setText("");
            txtModelo.setText("");
            txtAno.setText("");
            txtCor.setText("");
            txtPlaca.setText("");
            txtEstado4.setText("");
        }
    }//GEN-LAST:event_btnCadastrar1ActionPerformed

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void txtCorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorActionPerformed

    private void txtEstado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstado4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstado4ActionPerformed

    private void btnAtualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizar2ActionPerformed
        try{
            if((txtMarca1.getText().isEmpty()||txtModelo1.getText().isEmpty()||txtAno1.getText().isEmpty()||
                txtCor1.getText().isEmpty()||txtPlaca1.getText().isEmpty()||txtEstado5.getText().isEmpty())){
            lblMensagem6.setText("Preencha TODOS os campos!");
        }
        else{
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "update veiculo set marca_vei=?,modelo_vei=?,ano_vei=?,cor_vei=?,placa_vei=?,"
            + "estado_vei=? where placa_vei = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, this.txtMarca1.getText());
            stmt.setString(2, this.txtModelo1.getText());
            stmt.setString(3, this.txtAno1.getText());
            stmt.setString(4, this.txtCor1.getText());
            stmt.setString(5, this.txtPlaca1.getText());
            stmt.setString(6, this.txtEstado5.getText());
            stmt.setString(7, txtPesq3.getText());
            stmt.execute();
            con.close();
            lblMensagem6.setText("Veículo atualizado com SUCESSO!");
            txtMarca1.setText("");
            txtModelo1.setText("");
            txtAno1.setText("");
            txtCor1.setText("");
            txtPlaca1.setText("");
            txtEstado5.setText("");
            txtPesq3.setText("");
        }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_btnAtualizar2ActionPerformed

    private void txtMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarca1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarca1ActionPerformed

    private void txtAno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAno1ActionPerformed

    private void txtCor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCor1ActionPerformed

    private void txtEstado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstado5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEstado5ActionPerformed

    private void txtPesq3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesq3ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtPesq3ActionPerformed

    private void btnPesq9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq9ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from veiculo where placa_vei = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, txtPesq3.getText());
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                txtMarca1.setText(rs.getString("marca_vei"));
                txtModelo1.setText(rs.getString("modelo_vei"));
                txtAno1.setText(rs.getString("ano_vei"));
                txtCor1.setText(rs.getString("cor_vei"));
                txtPlaca1.setText(rs.getString("placa_vei"));
                txtEstado5.setText(rs.getString("estado_vei"));
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq9ActionPerformed

    private void txtPlaca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPlaca2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPlaca2ActionPerformed

    private void btnPesq10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq10ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from veiculo";

            if(!txtPlaca2.getText().equals(""))
            sql = sql + " where placa_vei LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtPlaca2.getText().equals(""))
            stmt.setString(1, "%"+txtPlaca2.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente8.getModel();
            model.setNumRows(0);
            while(rs.next()){

                String[] linha = {rs.getString("id_vei"), rs.getString("marca_vei"),
                    rs.getString("modelo_vei"),
                    rs.getString("placa_vei"),rs.getString("estado_vei")};
                model.addRow(linha);
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnPesq10ActionPerformed

    private void btnExcluir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir2ActionPerformed
        // TODO add your handling code here:
        try{
            Connection con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "delete from veiculo where id_vei = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            int linha = this.jtCliente8.getSelectedRow();
            stmt.setInt(1, Integer.parseInt(jtCliente8.getValueAt(linha, 0).toString()));
            stmt.execute();
            stmt.close();
            con.close();
            DefaultTableModel model = (DefaultTableModel) jtCliente8.getModel();
            model.removeRow(linha);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnExcluir2ActionPerformed

    private void txtMarca2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarca2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarca2ActionPerformed

    private void btnPesq11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesq11ActionPerformed
        // TODO add your handling code here:
        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/itruck","postgres","camilafatec");
            String sql = "select * from veiculo";

            if(!txtMarca2.getText().equals(""))
            sql = sql + " where marca_vei LIKE ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            if(!txtMarca2.getText().equals(""))
            stmt.setString(1, "%"+txtMarca2.getText()+"%");
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jtCliente9.getModel();
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
    }//GEN-LAST:event_btnPesq11ActionPerformed

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
            java.util.logging.Logger.getLogger(teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JPanel Painel1;
    private javax.swing.JPanel Painel2;
    private javax.swing.JPanel Painel3;
    private javax.swing.JPanel Painel4;
    private javax.swing.JPanel Painel5;
    private javax.swing.JPanel Painel6;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnAtualizar1;
    private javax.swing.JButton btnAtualizar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnBuscar2;
    private javax.swing.JButton btnBuscar3;
    private javax.swing.JButton btnCadFim;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCadastrar1;
    private javax.swing.JButton btnCadastrar2;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnExcluir2;
    private javax.swing.JButton btnInciar;
    private javax.swing.JButton btnPesq;
    private javax.swing.JButton btnPesq1;
    private javax.swing.JButton btnPesq10;
    private javax.swing.JButton btnPesq11;
    private javax.swing.JButton btnPesq2;
    private javax.swing.JButton btnPesq3;
    private javax.swing.JButton btnPesq4;
    private javax.swing.JButton btnPesq5;
    private javax.swing.JButton btnPesq6;
    private javax.swing.JButton btnPesq7;
    private javax.swing.JButton btnPesq8;
    private javax.swing.JButton btnPesq9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTable jtCliente1;
    private javax.swing.JTable jtCliente2;
    private javax.swing.JTable jtCliente3;
    private javax.swing.JTable jtCliente4;
    private javax.swing.JTable jtCliente5;
    private javax.swing.JTable jtCliente6;
    private javax.swing.JTable jtCliente7;
    private javax.swing.JTable jtCliente8;
    private javax.swing.JTable jtCliente9;
    private java.awt.Label lblMensagem;
    private java.awt.Label lblMensagem1;
    private java.awt.Label lblMensagem2;
    private java.awt.Label lblMensagem3;
    private java.awt.Label lblMensagem4;
    private java.awt.Label lblMensagem5;
    private java.awt.Label lblMensagem6;
    private java.awt.Label lblMensagemJ;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAno1;
    private javax.swing.JTextField txtCEP;
    private javax.swing.JTextField txtCEP1;
    private javax.swing.JTextField txtCEP2;
    private javax.swing.JTextField txtCEP3;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCPF1;
    private javax.swing.JTextField txtCPF2;
    private javax.swing.JTextField txtCPF3;
    private javax.swing.JTextField txtCPFpesq;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCargo1;
    private javax.swing.JTextField txtCargo5;
    private javax.swing.JTextField txtCargoPesq;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCelular1;
    private javax.swing.JTextField txtCelular2;
    private javax.swing.JTextField txtCelular3;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCidade1;
    private javax.swing.JTextField txtCidade2;
    private javax.swing.JTextField txtCidade3;
    private javax.swing.JTextField txtCodFilial;
    private javax.swing.JTextField txtCodFilial1;
    private javax.swing.JTextArea txtContratempos;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtCor1;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtData1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtEmail3;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtEndereco1;
    private javax.swing.JTextField txtEndereco2;
    private javax.swing.JTextField txtEndereco3;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtEstado1;
    private javax.swing.JTextField txtEstado2;
    private javax.swing.JTextField txtEstado3;
    private javax.swing.JTextField txtEstado4;
    private javax.swing.JTextField txtEstado5;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtLogin1;
    private javax.swing.JTextField txtLogin2;
    private javax.swing.JTextField txtLogin3;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtMarca1;
    private javax.swing.JTextField txtMarca2;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtModelo1;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNome2;
    private javax.swing.JTextField txtNome3;
    private javax.swing.JTextField txtNome4;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtNum1;
    private javax.swing.JTextField txtNum2;
    private javax.swing.JTextField txtNum3;
    private javax.swing.JTextField txtPesq;
    private javax.swing.JTextField txtPesq1;
    private javax.swing.JTextField txtPesq2;
    private javax.swing.JTextField txtPesq3;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPlaca1;
    private javax.swing.JTextField txtPlaca2;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtRG1;
    private javax.swing.JTextField txtRG2;
    private javax.swing.JTextField txtRG3;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JPasswordField txtSenha1;
    private javax.swing.JPasswordField txtSenha2;
    private javax.swing.JPasswordField txtSenha3;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTelefone1;
    private javax.swing.JTextField txtTelefone2;
    private javax.swing.JTextField txtTelefone3;
    private javax.swing.JTextField txtVeiculo;
    // End of variables declaration//GEN-END:variables
}
