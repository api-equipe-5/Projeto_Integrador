package source;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {
	
	private static String digitador;
	private JPanel Panel_main;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Login");
		setBounds(20, 20, 390, 400);
		setResizable(false);
		Panel_main = new JPanel();
		Panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_main);
		Panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel_main.getLayout());
		
		JPanel Plogin = new JPanel();
		Panel_main.add(Plogin, "1");
		Plogin.setLayout(null);
		
		
		
		JLabel Ltitle = new JLabel("Login Necess\u00E1rio");
		Ltitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		Ltitle.setHorizontalAlignment(SwingConstants.CENTER);
		Ltitle.setBounds(0, 10, 374, 45);
		Plogin.add(Ltitle);

		
		
		JLabel Lnome = new JLabel("Nome:");
		Lnome.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lnome.setBounds(20, 76, 80, 34);
		Plogin.add(Lnome);
		
		JTextField Tnome = new JTextField();
		Tnome.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Tnome.setColumns(10);
		Tnome.setBounds(20, 115, 325, 30);
		Plogin.add(Tnome);
		
		JLabel Lsenha = new JLabel("Senha:");
		Lsenha.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lsenha.setBounds(20, 170, 80, 34);
		Plogin.add(Lsenha);
			
		JLabel Laviso = new JLabel("");
		Laviso.setForeground(Color.RED);
		Laviso.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Laviso.setBounds(173, 170, 182, 34);
		Plogin.add(Laviso);
				
		JPasswordField Password = new JPasswordField();
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Password.setBounds(20, 210, 325, 30);
		Plogin.add(Password);
		
		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList nomes = new ArrayList();
				ArrayList senhas = new ArrayList();
				try {
					nomes = get("nome");
					senhas = get("senha");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(nomes.indexOf(Tnome.getText()));
				if (nomes.indexOf(Tnome.getText()) == -1) {
					Laviso.setText("*senha e/ou nome errado(s)");
					
				}
				else if (String.valueOf(Password.getPassword()).equals(senhas.get(nomes.indexOf(Tnome.getText())))) {
					digitador = Tnome.getText();
					new TelaInicial().setVisible(true);
					dispose();
				}
				else {
					Laviso.setText("*senha e/ou nome errado(s)");
				}
					
			}
		});
		btnLogar.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {	
		        	ArrayList nomes = new ArrayList();
					ArrayList senhas = new ArrayList();
					try {
						nomes = get("nome");
						senhas = get("senha");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println(nomes.indexOf(Tnome.getText()));
					if (nomes.indexOf(Tnome.getText()) == -1) {
						Laviso.setText("*senha e/ou nome errado");
						
					}
					else if (String.valueOf(Password.getPassword()).equals(senhas.get(nomes.indexOf(Tnome.getText())))) {
						digitador = Tnome.getText();
						new TelaInicial().setVisible(true);
						dispose();
					}
					else {
						Laviso.setText("*senha e/ou nome errado");
					}
		        }
			}
		});
		btnLogar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogar.setBounds(120, 274, 123, 51);
		Plogin.add(btnLogar);
	}
	
	
	public static ArrayList get(String coluna) throws Exception{
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement tabela = con.prepareStatement("SELECT * FROM login");
			ResultSet resultado = tabela.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(coluna));
			}
		
			System.out.println("Get finalizado");
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}

	public static String getDigitador() {
		return digitador;
	}

	public void setDigitador(String digitador) {
		this.digitador = digitador;
	}
	
}
