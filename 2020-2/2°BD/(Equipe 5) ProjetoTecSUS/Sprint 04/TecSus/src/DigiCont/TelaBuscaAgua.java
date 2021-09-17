package DigiCont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import DAO.CadastroAguaDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaBuscaAgua {

	private JFrame frmTelaBusca;
	private JTextField textField;
	private final JButton lblNewLabel_3 = new JButton("New label");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaBuscaAgua window = new TelaBuscaAgua();
					window.frmTelaBusca.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaBuscaAgua() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaBusca = new JFrame();
		frmTelaBusca.setBounds(100, 100, 960, 720);
		frmTelaBusca.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaBusca.getContentPane().setBackground(Color.WHITE);
		frmTelaBusca.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSIRA O N\u00BA DE INSTALA\u00C7\u00C3O ");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		lblNewLabel.setBounds(343, 202, 245, 30);
		frmTelaBusca.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(343, 232, 245, 20);
		frmTelaBusca.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(" Insira apenas n\u00FAmeros");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(343, 256, 129, 14);
		frmTelaBusca.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconAgua.png"));
		lblNewLabel_1_1.setBounds(10, 11, 30, 30);
		frmTelaBusca.getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuEnergia window = new MenuEnergia();
				window.frmMenuEnergia.setVisible(true);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconReturn.png"));
		lblNewLabel_3.setBounds(40, 609, 69, 54);
		frmTelaBusca.getContentPane().add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.WHITE);
		
		JButton btnCadastrarFor = new JButton("Buscar");
		btnCadastrarFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuEnergia window = new MenuEnergia();
				window.frmMenuEnergia.setVisible(true);
				
			}
		});
		
		btnCadastrarFor.setBounds(399, 313, 129, 40);
		frmTelaBusca.getContentPane().add(btnCadastrarFor);
		frmTelaBusca.setTitle("BUSCAR CONTA");
		frmTelaBusca.setResizable(false);
		frmTelaBusca.setLocationRelativeTo(null);

			}
	}
