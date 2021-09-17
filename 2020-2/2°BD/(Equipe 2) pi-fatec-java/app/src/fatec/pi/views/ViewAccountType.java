package fatec.pi.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewAccountType {

	public static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAccountType window = new ViewAccountType();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewAccountType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 456, 170);
		frame.getContentPane().setBackground(new java.awt.Color(204,223,214));
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					ViewMain voltamenu = new ViewMain();
					voltamenu.setVisible(true);
					frame.setVisible(false);
				}
		});
		
		JLabel lblDadosSalvosCom = new JLabel("Que tipo de conta deseja cadastrar?");
		lblDadosSalvosCom.setFont(new Font("Arial", Font.PLAIN, 16));
		lblDadosSalvosCom.setBounds(97, 11, 279, 36);
		frame.getContentPane().add(lblDadosSalvosCom);
		
		JButton btnagua = new JButton("\u00C1gua");
		btnagua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWaterAccount water = new ViewWaterAccount();
				water.setVisible(true);
				ViewAccountType.frame.setVisible(false);
			}
		});
		btnagua.setFont(new Font("Arial", Font.BOLD, 11));
		btnagua.setBounds(97, 72, 89, 36);
		frame.getContentPane().add(btnagua);
		
		JButton btnLuz = new JButton("Luz");
		btnLuz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLightAccount light = new ViewLightAccount();
				light.setVisible(true);
				ViewAccountType.frame.setVisible(false);
			}
		});
		btnLuz.setFont(new Font("Arial", Font.BOLD, 11));
		btnLuz.setBounds(251, 72, 89, 36);
		frame.getContentPane().add(btnLuz);
		
		
	}
}
