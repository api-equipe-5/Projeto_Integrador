package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldUsuario;
	private JPasswordField jPasswordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton jButtonAcessar = new JButton("Login");
		jButtonAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(jTextFieldUsuario.getText().equals("admin")&&jPasswordFieldSenha.getText().equals("1234")) {
												
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
				}else {
					JOptionPane.showMessageDialog(rootPane, "Usuário ou/e senha inválido!");
				}
			}
		});
		
		JButton jButtonSair = new JButton("Sair");
		jButtonSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		jButtonSair.setBounds(376, 187, 97, 25);
		contentPane.add(jButtonSair);
		jButtonAcessar.setBounds(241, 187, 97, 25);
		contentPane.add(jButtonAcessar);
		
		JLabel jLabelUsuario = new JLabel("Usu\u00E1rio:");
		jLabelUsuario.setBounds(242, 83, 56, 16);
		contentPane.add(jLabelUsuario);
		
		JLabel jLabelSenha = new JLabel("Senha:");
		jLabelSenha.setBounds(242, 137, 56, 16);
		contentPane.add(jLabelSenha);
		
		jTextFieldUsuario = new JTextField();
		jTextFieldUsuario.setBounds(297, 80, 146, 22);
		contentPane.add(jTextFieldUsuario);
		jTextFieldUsuario.setColumns(10);
		
		jPasswordFieldSenha = new JPasswordField();
		jPasswordFieldSenha.setBounds(297, 134, 146, 22);
		contentPane.add(jPasswordFieldSenha);
		
		JLabel jLabelLogo = new JLabel("");
		jLabelLogo.setForeground(Color.WHITE);
		jLabelLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/DIGI CONT.png")));
		jLabelLogo.setBounds(10, 63, 210, 150);
		contentPane.add(jLabelLogo);
	}
}
