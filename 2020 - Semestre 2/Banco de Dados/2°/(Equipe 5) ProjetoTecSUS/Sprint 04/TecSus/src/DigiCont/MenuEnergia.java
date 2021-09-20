package DigiCont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Label;
import java.awt.Color;
import javax.swing.ImageIcon;


public class MenuEnergia {

	JFrame frmMenuEnergia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEnergia window = new MenuEnergia();
					window.frmMenuEnergia.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuEnergia() {
		initialize();
	}
	
	
	private void initialize() {
		frmMenuEnergia = new JFrame();
		frmMenuEnergia.getContentPane().setBackground(Color.WHITE);
		frmMenuEnergia.setBackground(Color.WHITE);
		frmMenuEnergia.setResizable(false);
		frmMenuEnergia.setTitle("MENU ENERGIA");
		frmMenuEnergia.setBounds(100, 100, 960, 720);
		frmMenuEnergia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMenuEnergia.getContentPane().setLayout(null);
		frmMenuEnergia.setLocationRelativeTo(null);
		
		JButton btnCadastrarFor = new JButton("Buscar");
		btnCadastrarFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarFor.setBounds(272, 189, 129, 40);
		frmMenuEnergia.getContentPane().add(btnCadastrarFor);
		
		JButton btnCadastrarCli = new JButton("Cadastrar");
		btnCadastrarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaCadastroEnergia window = new TelaCadastroEnergia();
				window.frame.setVisible(true);
			}
			
		});
		
		btnCadastrarCli.setBounds(549, 189, 129, 40);
		frmMenuEnergia.getContentPane().add(btnCadastrarCli);
		
		JButton btnEditarCli = new JButton("Editar");
		btnEditarCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEditarCli.setBounds(549, 260, 129, 40);
		frmMenuEnergia.getContentPane().add(btnEditarCli);
		
		JButton btnRelatorioCli = new JButton("Relat\u00F3rio");
		btnRelatorioCli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				TelaRelatorio window = new TelaRelatorio();
				window.frmRelatrio.setVisible(true);
			
			}
		});
		btnRelatorioCli.setBounds(549, 326, 129, 40);
		frmMenuEnergia.getContentPane().add(btnRelatorioCli);
		
		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(286, 157, 100, 14);
		frmMenuEnergia.getContentPane().add(lblNewLabel);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCliente.setBounds(563, 157, 100, 14);
		frmMenuEnergia.getContentPane().add(lblCliente);
		
		JButton lblNewLabel_3 = new JButton("New label");
		lblNewLabel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuEscolha window = new MenuEscolha();
				window.frmMenuEscolherConta.setVisible(true);
				
			}
		});
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconReturn.png"));
		lblNewLabel_3.setBounds(40, 591, 81, 69);
		frmMenuEnergia.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconEnergia.png"));
		lblNewLabel_1.setBounds(10, 11, 30, 30);
		frmMenuEnergia.getContentPane().add(lblNewLabel_1);
	}
}
