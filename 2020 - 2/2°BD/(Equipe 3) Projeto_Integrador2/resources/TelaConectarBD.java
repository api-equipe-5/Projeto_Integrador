package source;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaConectarBD extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaConectarBD frame = new TelaConectarBD();
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
	public TelaConectarBD() {
		setTitle("Conectar ao BD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(20, 20, 300, 300);
		JPanel panel_main = new JPanel();
		panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel_main);
		panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(panel_main.getLayout());
		
		JPanel panel00 = new JPanel();
		panel_main.add(panel00, "0");
		panel00.setLayout(null);
		
		JLabel Luser = new JLabel("User do Banco:");
		Luser.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Luser.setBounds(25, 10, 150, 30);
		panel00.add(Luser);
		
		JLabel Lsenha = new JLabel("Senha do Banco:");
		Lsenha.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lsenha.setBounds(25, 80, 150, 30);
		panel00.add(Lsenha);
		
		JTextField Tuser = new JTextField();
		Tuser.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Tuser.setBounds(25, 40, 226, 30);
		panel00.add(Tuser);
		Tuser.setColumns(10);
		
		JPasswordField Password = new JPasswordField();
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Password.setBounds(25, 110, 226, 30);
		panel00.add(Password);
		
		JButton Bcriar = new JButton("Conectar");
		Bcriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FabricaConexao.setUser(Tuser.getText());
				FabricaConexao.setPassword(String.valueOf(Password.getPassword()));
				FabricaConexao.getConexao();			
				new TelaLogin().setVisible(true);
				dispose();
			}
		});
		Bcriar.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
					FabricaConexao.setUser(Tuser.getText());
					FabricaConexao.setPassword(String.valueOf(Password.getPassword()));
					FabricaConexao.getConexao();
					new TelaLogin().setVisible(true);
					dispose();
		        }
			}
		});
		Bcriar.setToolTipText("Para conectar ao Banco");
		Bcriar.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Bcriar.setBounds(75, 165, 119, 50);
		panel00.add(Bcriar);
		
	}

}
