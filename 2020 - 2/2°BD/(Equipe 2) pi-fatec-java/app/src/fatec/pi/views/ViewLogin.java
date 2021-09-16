package fatec.pi.views;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fatec.pi.controllers.UserController;
import fatec.pi.daos.UserDao;
import fatec.pi.entities.User;

import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin extends JFrame {

	private JPanel contentPane;
	Color fundo = new Color(204, 223,214);
	Color text  = new Color(218,218,217);
	Color botao  = new Color(156,183,170);
	private JTextField txtLogin;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLogin frame = new ViewLogin();
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
	public ViewLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(fundo);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{353, 331, 0};
		gbl_contentPane.rowHeights = new int[]{31, 184, 206, 106, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabelIMG = new JLabel("");
		lblNewLabelIMG.setIcon(new ImageIcon(ViewLogin.class.getResource("/img/rsz_1user.png")));
		GridBagConstraints gbc_lblNewLabelIMG = new GridBagConstraints();
		gbc_lblNewLabelIMG.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabelIMG.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabelIMG.gridx = 1;
		gbc_lblNewLabelIMG.gridy = 1;
		contentPane.add(lblNewLabelIMG, gbc_lblNewLabelIMG);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(57, 23, 248, 36);
		panel.add(txtLogin);
		txtLogin.setBackground(text);
		txtLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("");
		passwordField.setBounds(57, 70, 248, 36);
		passwordField.setBackground(text);
		panel.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = String.valueOf(passwordField.getPassword());
				User login = UserController.checkLogin(txtLogin.getText(), password);
				System.setProperty("UserID", login.getId().toString());
				adminValidate(login);
				
			}
		});
		btnLogin.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(51, 160, 230, 30);
		btnLogin.setBackground(botao);
		panel.add(btnLogin);
		
		JCheckBox CheckBoxRemember = new JCheckBox("Lembre-me");
		CheckBoxRemember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CheckBoxRemember.setBounds(20, 117, 97, 14);
		panel.add(CheckBoxRemember);
		
		JLabel lblNewLabel = new JLabel("Esqueceu a senha?");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setBounds(208, 118, 97, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(ViewLogin.class.getResource("/img/rsz_user_login.png")));
		lblNewLabel_3.setBounds(20, 23, 35, 36);
		lblNewLabel_3.setBackground(text);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(ViewLogin.class.getResource("/img/rsz_password.png")));
		lblNewLabel_4.setBounds(20, 67, 30, 36);
		lblNewLabel_4.setBackground(Color.GRAY);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabelIMG2 = new JLabel("");
		lblNewLabelIMG2.setIcon(new ImageIcon(ViewLogin.class.getResource("/img/rsz_poc_verde.png")));
		GridBagConstraints gbc_lblNewLabelIMG2 = new GridBagConstraints();
		gbc_lblNewLabelIMG2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabelIMG2.gridx = 1;
		gbc_lblNewLabelIMG2.gridy = 3;
		contentPane.add(lblNewLabelIMG2, gbc_lblNewLabelIMG2);
	}
	
	public void adminValidate(User adm) {
		if(adm.getAdmin().equals(true)) {
			ViewMainAdmin menu = new ViewMainAdmin();
			menu.setVisible(true);
			setVisible(false);
		}
		else if(adm.getAdmin().equals(false)) {
			ViewMain menu = new ViewMain();
			menu.setVisible(true);
			dispose();
		}
	}
}

