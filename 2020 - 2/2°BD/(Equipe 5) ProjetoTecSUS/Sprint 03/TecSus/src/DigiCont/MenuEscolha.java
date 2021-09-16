package DigiCont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEscolha {

	public JFrame frmMenuEscolherConta;
	protected Object frmMenuEscolhaConta;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEscolha window = new MenuEscolha();
					window.frmMenuEscolherConta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuEscolha() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMenuEscolherConta = new JFrame();
		frmMenuEscolherConta.setBounds(100, 100, 960, 720);
		frmMenuEscolherConta.getContentPane().setForeground(Color.WHITE);
		frmMenuEscolherConta.setResizable(false);
		frmMenuEscolherConta.setBackground(Color.LIGHT_GRAY);
		frmMenuEscolherConta.setTitle("MENU ESCOLHER CONTA");
		frmMenuEscolherConta.getContentPane().setBackground(Color.WHITE);
		frmMenuEscolherConta.getContentPane().setLayout(null);
		frmMenuEscolherConta.setLocationRelativeTo(null);
		frmMenuEscolherConta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		
		JButton lblAgua = new JButton("New label");
		lblAgua.setForeground(Color.WHITE);
		lblAgua.setBackground(Color.WHITE);
		lblAgua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu window = new Menu();
				window.frmMenu.setVisible(true);					
			}
		});
		lblAgua.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconeAguaMenu.png"));
		lblAgua.setBounds(177, 170, 298, 298);
		frmMenuEscolherConta.getContentPane().add(lblAgua);
		
				
		JButton lblEnegia = new JButton("New label");
		lblEnegia.setForeground(Color.WHITE);
		lblEnegia.setBackground(Color.WHITE);
		lblEnegia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuEnergia window = new MenuEnergia();
				window.frmMenuEnergia.setVisible(true);
				
			}
		});
		lblEnegia.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconeEnergiaMenu.png"));
		lblEnegia.setBounds(514, 170, 298, 298);
		frmMenuEscolherConta.getContentPane().add(lblEnegia);
		
		JLabel lblNewLabel = new JLabel("ESCOLHA QUAL CONTA DESEJA CADASTAR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(303, 64, 363, 28);
		frmMenuEscolherConta.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u00C1GUA");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(294, 479, 55, 17);
		frmMenuEscolherConta.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("ENERGIA");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(633, 476, 76, 17);
		frmMenuEscolherConta.getContentPane().add(lblNewLabel_2_1);
		
	}
}
