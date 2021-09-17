package DigiCont;

import DAO.CadastroAguaDAO;



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


public class TelaCadastro {

	JFrame frmTelaCadastro;
	private JTextField tFConsumo;
	private JTextField textFValorTotal;
	private JTextField textMesConta;
	private JLabel lblNewLabel_1;
	private JTextField textValorAgua;
	private JTextField textValorEsgoto;
	private JTextField textField_7;
	private ImageIcon imageIcon;
	private JLabel lblNewLabel_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frmTelaCadastro.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastro = new JFrame();
		frmTelaCadastro.setResizable(false);
		frmTelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCadastro.getContentPane().setBackground(Color.WHITE);
		frmTelaCadastro.setForeground(Color.LIGHT_GRAY);
		frmTelaCadastro.setTitle("Tela Cadastro de \u00C1gua");
		frmTelaCadastro.setBounds(100, 100, 960, 720);
		frmTelaCadastro.getContentPane().setLayout(null);
		frmTelaCadastro.setLocationRelativeTo(null);
		

		
		JLabel lblNewLabel = new JLabel("Consumo M3");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(102, 143, 91, 28);
		frmTelaCadastro.getContentPane().add(lblNewLabel);
		
		tFConsumo = new JTextField();
		tFConsumo.setHorizontalAlignment(SwingConstants.CENTER);
		tFConsumo.setBounds(96, 171, 103, 20);
		frmTelaCadastro.getContentPane().add(tFConsumo);
		tFConsumo.setColumns(10);
		
		JLabel tFValorTotal = new JLabel("Valor Total");
		tFValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tFValorTotal.setBounds(434, 143, 78, 28);
		frmTelaCadastro.getContentPane().add(tFValorTotal);
		
		textFValorTotal = new JTextField();
		textFValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textFValorTotal.setColumns(10);
		textFValorTotal.setBounds(422, 171, 103, 20);
		frmTelaCadastro.getContentPane().add(textFValorTotal);
		
		JLabel lblMsDaConta = new JLabel("M\u00EAs da Conta");
		lblMsDaConta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMsDaConta.setBounds(787, 143, 91, 28);
		frmTelaCadastro.getContentPane().add(lblMsDaConta);
		
		textMesConta = new JTextField();
		textMesConta.setForeground(Color.BLACK);
		textMesConta.setHorizontalAlignment(SwingConstants.CENTER);
		textMesConta.setColumns(10);
		textMesConta.setBounds(781, 171, 103, 20);
		frmTelaCadastro.getContentPane().add(textMesConta);
		
		lblNewLabel_1 = new JLabel("CALCULO DO VALOR DA CONTA");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(356, 254, 261, 14);
		frmTelaCadastro.getContentPane().add(lblNewLabel_1);
		
		JLabel lblValorgua = new JLabel("Valor \u00C1gua:");
		lblValorgua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorgua.setBounds(145, 359, 78, 28);
		frmTelaCadastro.getContentPane().add(lblValorgua);
		
		JLabel lblValorEsgoto = new JLabel("Valor Esgoto:");
		lblValorEsgoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorEsgoto.setBounds(405, 359, 91, 28);
		frmTelaCadastro.getContentPane().add(lblValorEsgoto);
		
		textValorAgua = new JTextField();
		textValorAgua.setHorizontalAlignment(SwingConstants.CENTER);
		textValorAgua.setBounds(233, 365, 86, 20);
		frmTelaCadastro.getContentPane().add(textValorAgua);
		textValorAgua.setColumns(10);
		
		textValorEsgoto = new JTextField();
		textValorEsgoto.setHorizontalAlignment(SwingConstants.CENTER);
		textValorEsgoto.setColumns(10);
		textValorEsgoto.setBounds(493, 365, 86, 20);
		frmTelaCadastro.getContentPane().add(textValorEsgoto);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorTotal.setBounds(633, 359, 78, 28);
		frmTelaCadastro.getContentPane().add(lblValorTotal);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setEnabled(false);
		textField_7.setColumns(10);
		textField_7.setBounds(721, 365, 86, 20);
		frmTelaCadastro.getContentPane().add(textField_7);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroAgua cadaguadao = new CadastroAgua();
				
				cadaguadao.setConsumo(tFConsumo.getText());
				cadaguadao.setValorTotal(textFValorTotal.getText());
				cadaguadao.setMesConta(textMesConta.getText());
				cadaguadao.setValorAgua(textValorAgua.getText());
				cadaguadao.setValorEsgoto(textValorEsgoto.getText());
				
				if ((tFConsumo.getText().isEmpty()) || (textFValorTotal.getText().isEmpty()) || (textMesConta.getText().isEmpty()) || (textValorAgua.getText().isEmpty())  ||  (textValorEsgoto.getText().isEmpty())) {
					   JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
					}
				else {

				    CadastroAguaDAO cadagua = new CadastroAguaDAO();
				    cadagua.adiciona(cadaguadao);
				    JOptionPane.showMessageDialog(null, "Conta registrada com sucesso! ");
				}
				
				tFConsumo.setText("");
				textFValorTotal.setText("");
				textMesConta.setText("");
				textValorAgua.setText("");
				textValorEsgoto.setText("");
									
			}
		});
		
		
		btnCadastrar.setBackground(Color.GRAY);
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBounds(422, 610, 103, 28);
		frmTelaCadastro.getContentPane().add(btnCadastrar);
		
		imageIcon = new ImageIcon("img/IconAgua.png");
		lblNewLabel_2 = new JLabel(imageIcon);
		lblNewLabel_2.setBounds(10, 10, 30, 30);
		frmTelaCadastro.getContentPane().add(lblNewLabel_2);
		

		
		
	

		
	

	}
}
	
