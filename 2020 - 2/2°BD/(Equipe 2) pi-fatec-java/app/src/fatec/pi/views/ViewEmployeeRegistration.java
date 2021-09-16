package fatec.pi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fatec.pi.controllers.UserController;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;

public class ViewEmployeeRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldSenha;
	
	Color fundo = new Color(204, 223,214);
	Color text  = new Color(218,218,217);
	Color botao  = new Color(156,183,170);
	Color title  = new Color(95,158,160);
	private JTextField Title;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployeeRegistration frame = new ViewEmployeeRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEmployeeRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(fundo);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{252, 500, 0};
		gbl_contentPane.rowHeights = new int[]{85, 34, 300, 33, 97, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Title = new JTextField();
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Arial", Font.BOLD, 14));
		Title.setText("Cadastro de Cliente");
		Title.setForeground(Color.BLACK);
		Title.setEditable(false);
		Title.setEnabled(false);
		Title.setBackground(Color.BLACK);
		GridBagConstraints gbc_Title = new GridBagConstraints();
		gbc_Title.fill = GridBagConstraints.BOTH;
		gbc_Title.insets = new Insets(0, 0, 5, 0);
		gbc_Title.gridx = 1;
		gbc_Title.gridy = 1;
		contentPane.add(Title, gbc_Title);
		Title.setColumns(10);
		Title.setBackground(title);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setBackground(fundo);
		
		JLabel LabelNome = new JLabel("Nome");
		LabelNome.setFont(new Font("Arial", Font.PLAIN, 12));
		LabelNome.setBounds(50, 65, 46, 14);
		panel.add(LabelNome);
		
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(106, 62, 316, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		textFieldNome.setBackground(Color.WHITE);
		
		JLabel LabelEmail = new JLabel("Email");
		LabelEmail.setBounds(50, 111, 46, 14);
		panel.add(LabelEmail);
		LabelEmail.setFont(new Font("Arial", Font.PLAIN, 12));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(106, 109, 316, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setBackground(Color.WHITE);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 12));
		lblSenha.setBounds(50, 155, 46, 14);
		panel.add(lblSenha);
		
		passwordFieldSenha = new JPasswordField();
		passwordFieldSenha.setBounds(106, 153, 316, 20);
		panel.add(passwordFieldSenha);
		passwordFieldSenha.setBackground(Color.WHITE);
		
		JComboBox comboBox_Adm = new JComboBox();
		comboBox_Adm.setModel(new DefaultComboBoxModel(new String[] {"Sim", "Nao"}));
		comboBox_Adm.setBounds(132, 196, 104, 20);
		panel.add(comboBox_Adm);
		
		JButton btnCadastro = new JButton("Cadastrar");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String adm = comboBox_Adm.getSelectedItem().toString();
				String password = String.valueOf(passwordFieldSenha.getPassword());
				UserController.saveValues(textFieldNome.getText(), textFieldEmail.getText(), password, adminValidate(adm));
			}
		});
		btnCadastro.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCadastro.setBounds(106, 236, 145, 23);
		panel.add(btnCadastro);
		btnCadastro.setBackground(botao);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMain viewMain = new ViewMain();
				viewMain.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setMnemonic(KeyEvent.VK_B);
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVoltar.setBackground(new Color(156, 183, 170));
		btnVoltar.setBounds(277, 236, 145, 23);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("Administrador");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 198, 77, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabelIMG = new JLabel("");
		lblNewLabelIMG.setIcon(new ImageIcon(ViewEmployeeRegistration.class.getResource("/img/rsz_poc_verde.png")));
		GridBagConstraints gbc_lblNewLabelIMG = new GridBagConstraints();
		gbc_lblNewLabelIMG.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabelIMG.gridx = 1;
		gbc_lblNewLabelIMG.gridy = 4;
		contentPane.add(lblNewLabelIMG, gbc_lblNewLabelIMG);
	}
	
	public static Boolean adminValidate(String adm) {
		if(adm == "Sim") {
			return true;
		}
		else {
			return false;
		}
	}
}
