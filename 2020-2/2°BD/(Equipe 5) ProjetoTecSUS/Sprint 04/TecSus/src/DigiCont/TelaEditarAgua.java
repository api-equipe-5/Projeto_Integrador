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


public class TelaEditarAgua {

	JFrame frmTelaCadastro;
	private ImageIcon imageIcon;
	private JLabel lblIconAgua;
	protected Object frmTelaCadastroEnergia;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditarAgua window = new TelaEditarAgua();
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
	public TelaEditarAgua() {
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
		frmTelaCadastro.setTitle("TELA EDITAR \u00C1GUA");
		frmTelaCadastro.setBounds(100, 100, 960, 720);
		frmTelaCadastro.getContentPane().setLayout(null);
		frmTelaCadastro.setLocationRelativeTo(null);
		
		imageIcon = new ImageIcon("img/IconAgua.png");
		lblIconAgua = new JLabel(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconAgua.png"));
		lblIconAgua.setBounds(10, 10, 30, 30);
		frmTelaCadastro.getContentPane().add(lblIconAgua);
		
	

	}
}
	
