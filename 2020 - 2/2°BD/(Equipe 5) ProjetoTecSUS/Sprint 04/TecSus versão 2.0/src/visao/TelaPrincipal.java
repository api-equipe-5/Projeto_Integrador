package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.border.MatteBorder;

import modeloConnection.ConexaoBD;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaPrincipal extends JFrame {

	ConexaoBD conecta = new ConexaoBD ();
	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 552);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu jMenuContaAgua = new JMenu("Conta de \u00C1gua");
		menuBar.add(jMenuContaAgua);
		
		JMenuItem jMenuItemCadAgua = new JMenuItem("Cadastro");
		jMenuItemCadAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormContaAgua cadagua = new FormContaAgua();
				cadagua.setVisible(true);
				dispose();
			}
		});
		jMenuContaAgua.add(jMenuItemCadAgua);
		
		JMenu jMenuContaLuz = new JMenu("Conta de Luz");
		menuBar.add(jMenuContaLuz);
		
		JMenuItem jMenuItemCadLuz = new JMenuItem("Cadastro");
		jMenuItemCadLuz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormContaEnergia cadenergia = new FormContaEnergia();
				cadenergia.setVisible(true);
				dispose();
			}
		});
		jMenuContaLuz.add(jMenuItemCadLuz);
		
		
		JMenu jMenuOpcoes = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(jMenuOpcoes);
		
		JMenuItem jMenuItemTelaBemVindo = new JMenuItem("Tela de Bem-Vindo");
		jMenuItemTelaBemVindo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal tela = new TelaPrincipal();
				tela.setVisible(true);
				dispose();
			}
		});
		jMenuOpcoes.add(jMenuItemTelaBemVindo);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JInternalFrame jInternalFrameBemVindo = new JInternalFrame("Bem-Vindo(a)!");
		jInternalFrameBemVindo.setBounds(34, 47, 702, 419);
		contentPane.add(jInternalFrameBemVindo);
		jInternalFrameBemVindo.getContentPane().setLayout(null);
		
		JPanel jPanelInternalFrame = new JPanel();
		jPanelInternalFrame.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		jPanelInternalFrame.setBounds(12, 52, 662, 318);
		jInternalFrameBemVindo.getContentPane().add(jPanelInternalFrame);
		jPanelInternalFrame.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastrar:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(176, 39, 79, 16);
		jPanelInternalFrame.add(lblNewLabel_2);
		
		JButton jButtonCadLuz = new JButton("");
		jButtonCadLuz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormContaEnergia cadenergia = new FormContaEnergia();
				cadenergia.setVisible(true);
				dispose();
			}
		});
		jButtonCadLuz.setForeground(Color.WHITE);
		jButtonCadLuz.setBackground(SystemColor.textHighlightText);
		jButtonCadLuz.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/IconEnergia - M\u00E9dio.png")));
		jButtonCadLuz.setBounds(240, 90, 150, 180);
		jPanelInternalFrame.add(jButtonCadLuz);
		
		JButton jButtonCadAgua = new JButton("");
		jButtonCadAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FormContaAgua cadagua = new FormContaAgua();
				cadagua.setVisible(true);
				dispose();
			}
		});
		jButtonCadAgua.setForeground(Color.WHITE);
		jButtonCadAgua.setBackground(Color.WHITE);
		jButtonCadAgua.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/IconAgua - M\u00E9dio.png")));
		jButtonCadAgua.setBounds(37, 90, 150, 180);
		jPanelInternalFrame.add(jButtonCadAgua);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/internalframe.png")));
		lblNewLabel.setBounds(0, 13, 663, 305);
		jPanelInternalFrame.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de gerenciamento de contas de luz e conta de \u00E1gua");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 13, 548, 26);
		jInternalFrameBemVindo.getContentPane().add(lblNewLabel_1);
		
		JButton jButtonFecharBemVindo = new JButton("");
		jButtonFecharBemVindo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jInternalFrameBemVindo.dispose();			
			}
		});
		jButtonFecharBemVindo.setToolTipText("Fechar Tela Bem-Vindo(a)");
		jButtonFecharBemVindo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagens/exit.png")));
		jButtonFecharBemVindo.setBounds(614, 0, 49, 49);
		jInternalFrameBemVindo.getContentPane().add(jButtonFecharBemVindo);
		jInternalFrameBemVindo.setVisible(true);
	}
}
