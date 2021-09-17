package DigiCont;

import DAO.CadastroEnergiaDAO;



import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLayeredPane;


public class TelaCadastroEnergia {

	JFrame frmTelaCadastroEnergia;
	private JTextField nintalacao;
	private ImageIcon imageIcon;
	private JLabel lblIconAgua;
	private JTextField lblVTotal;
	private JTextField lblDataVencimento;
	private JTextField lblMesConta;
	private JTextField lblDataEmissao;
	private JLabel lblNewLabel_2;
	private JTextField lblLeituraAnterior;
	private JLabel lblNewLabel_1_3;
	private JTextField lblLeituraAtual;
	private JLabel lblNewLabel_1_4;
	private JTextField lblDiasFaturamento;
	private JLabel lblNewLabel_1_2_2;
	private JTextField lblProxLeitu;
	private JLabel lblNewLabel_3;
	private JTextField lblAviso;
	private JLabel lblNewLabel_1_2_3;
	private JButton btnNewButton;
	private JButton btnCadastrar;
	private JButton btnCad;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEnergia window = new TelaCadastroEnergia();
					window.frmTelaCadastroEnergia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastroEnergia() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastroEnergia = new JFrame();
		frmTelaCadastroEnergia.setResizable(false);
		frmTelaCadastroEnergia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCadastroEnergia.getContentPane().setBackground(Color.WHITE);
		frmTelaCadastroEnergia.setForeground(Color.LIGHT_GRAY);
		frmTelaCadastroEnergia.setTitle("TELA CADASTRO ENERGIA");
		frmTelaCadastroEnergia.setBounds(100, 100, 960, 720);
		frmTelaCadastroEnergia.getContentPane().setLayout(null);
		frmTelaCadastroEnergia.setLocationRelativeTo(null);
		

		
		JLabel lblNewLabel = new JLabel("N\u00FAmero Instala\u00E7\u00E3o:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(121, 135, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel);
		
		nintalacao = new JTextField();
		nintalacao.setHorizontalAlignment(SwingConstants.CENTER);
		nintalacao.setBounds(121, 163, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(nintalacao);
		nintalacao.setColumns(10);

		
		imageIcon = new ImageIcon("img/IconAgua.png");
		lblIconAgua = new JLabel(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconEnergia.png"));
		lblIconAgua.setBounds(10, 10, 30, 30);
		frmTelaCadastroEnergia.getContentPane().add(lblIconAgua);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorTotal.setBounds(304, 135, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblValorTotal);
		
		lblVTotal = new JTextField();
		lblVTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblVTotal.setColumns(10);
		lblVTotal.setBounds(304, 163, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblVTotal);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Vencimento:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(486, 135, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_1_1);
		
		lblDataVencimento = new JTextField();
		lblDataVencimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataVencimento.setColumns(10);
		lblDataVencimento.setBounds(486, 163, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblDataVencimento);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00EAs da Conta:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(668, 135, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_1_2);
		
		lblMesConta = new JTextField();
		lblMesConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesConta.setColumns(10);
		lblMesConta.setBounds(668, 163, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblMesConta);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Data Emiss\u00E3o:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(121, 282, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_1_2_1);
		
		lblDataEmissao = new JTextField();
		lblDataEmissao.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataEmissao.setColumns(10);
		lblDataEmissao.setBounds(121, 310, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblDataEmissao);
		
		lblNewLabel_2 = new JLabel("Leitura Anterior:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(304, 282, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_2);
		
		lblLeituraAnterior = new JTextField();
		lblLeituraAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeituraAnterior.setColumns(10);
		lblLeituraAnterior.setBounds(304, 310, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblLeituraAnterior);
		
		lblNewLabel_1_3 = new JLabel("Leitura Atual:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(486, 282, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_1_3);
		
		lblLeituraAtual = new JTextField();
		lblLeituraAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeituraAtual.setColumns(10);
		lblLeituraAtual.setBounds(486, 310, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblLeituraAtual);
		
		lblNewLabel_1_4 = new JLabel("N\u00BA Dias Faturamento:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(661, 282, 160, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_1_4);
		
		lblDiasFaturamento = new JTextField();
		lblDiasFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiasFaturamento.setColumns(10);
		lblDiasFaturamento.setBounds(668, 310, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblDiasFaturamento);
		
		lblNewLabel_1_2_2 = new JLabel("Prev Prox Leitura:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(121, 401, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_1_2_2);
		
		lblProxLeitu = new JTextField();
		lblProxLeitu.setHorizontalAlignment(SwingConstants.CENTER);
		lblProxLeitu.setColumns(10);
		lblProxLeitu.setBounds(121, 429, 140, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblProxLeitu);
		
		lblNewLabel_3 = new JLabel("Aviso:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(255, 401, 140, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_3);
		
		lblAviso = new JTextField();
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setColumns(10);
		lblAviso.setBounds(304, 429, 504, 20);
		frmTelaCadastroEnergia.getContentPane().add(lblAviso);
		
		lblNewLabel_1_2_3 = new JLabel("PER\u00CDODO DE FATURAMENTO");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_3.setBounds(322, 243, 323, 28);
		frmTelaCadastroEnergia.getContentPane().add(lblNewLabel_1_2_3);
		
		btnCad = new JButton("Cadastrar");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroEnegia cadenergiadao = new CadastroEnegia();
				
				cadenergiadao.setContaLuzID(nintalacao.getText());
				cadenergiadao.setContaLuzValorTotal(lblVTotal.getText());
				cadenergiadao.setContaLuzDataVencimento(lblDataVencimento.getText());
				cadenergiadao.setContaLuzMes(lblMesConta.getText());
				cadenergiadao.setContaLuzEmissao(lblDataEmissao.getText());
				cadenergiadao.setContaLuzAnterior(lblLeituraAnterior.getText());
				cadenergiadao.setContaLuzAtual(lblLeituraAtual.getText());
				cadenergiadao.setContaLuzDiasFaturamento(lblDiasFaturamento.getText());
				cadenergiadao.setContaLuzPrevisaoProximaLuz(lblProxLeitu.getText());
				cadenergiadao.setContaLuzAviso(lblAviso.getText());

				if ((nintalacao.getText().isEmpty()) || (lblVTotal.getText().isEmpty()) || (lblDataVencimento.getText().isEmpty()) || (lblMesConta.getText().isEmpty())  ||  (lblDataEmissao.getText().isEmpty()) || (lblLeituraAnterior.getText().isEmpty()) || (lblLeituraAtual.getText().isEmpty()) || (lblDiasFaturamento.getText().isEmpty()) || (lblProxLeitu.getText().isEmpty()) || (lblAviso.getText().isEmpty())) {
					   JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
				}
				
				else {
		
				    CadastroEnergiaDAO cadenergia = new CadastroEnergiaDAO();
				    cadenergia.adiciona(cadenergiadao);
				    JOptionPane.showMessageDialog(null, "Conta registrada com sucesso! ");
				}				
			
				nintalacao.setText("");
				lblVTotal.setText("");
				lblDataVencimento.setText("");
				lblMesConta.setText("");
				lblDataEmissao.setText("");
				lblLeituraAnterior.setText("");
				lblLeituraAtual.setText("");
				lblDiasFaturamento.setText("");
				lblProxLeitu.setText("");
				lblAviso.setText("");
				
			}
		});
		btnCad.setBounds(410, 612, 105, 28);
		frmTelaCadastroEnergia.getContentPane().add(btnCad);
		
		
			
	
	}
		}
