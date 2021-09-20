package fatec.pi.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class ViewMainAdmin extends JFrame {


	protected static final String frame = null;
	private JPanel contentPane;
	protected Object btnCadastroColaborator;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMainAdmin frame = new ViewMainAdmin();
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
	public ViewMainAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,223,214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel panel_main = new JPanel();
		panel_main.setBackground(new Color(95, 158, 160));
		
		JLabel lblOQueDeseja = new JLabel("O QUE DESEJA FAZER?");
		lblOQueDeseja.setForeground(Color.WHITE);
		lblOQueDeseja.setFont(new Font("Arial", Font.BOLD, 14));
		panel_main.add(lblOQueDeseja);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewMainAdmin.class.getResource("/img/rsz_poc_verde.png")));
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR CLIENTE");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewClient viewCliente = new ViewClient();
				viewCliente.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarCliente.setMnemonic(KeyEvent.VK_2);
		btnCadastrarCliente.setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnCadastrarNovaConta = new JButton("CADASTRAR NOVA CONTA");
		btnCadastrarNovaConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAccountType view = new ViewAccountType();
				view.frame.setVisible(true);
				setVisible(false);
				
			}
		});
		btnCadastrarNovaConta.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastrarNovaConta.setMnemonic(KeyEvent.VK_3);
		
		JButton btnEditarInformaoCadastrada = new JButton("EDITAR INFORMA\u00C7\u00C3O CADASTRADA");
		btnEditarInformaoCadastrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSearch viewSearch = new ViewSearch();
				viewSearch.setVisible(true);
				setVisible(false);
			}
		});
		btnEditarInformaoCadastrada.setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnGerarRelatrios = new JButton("GERAR RELAT\u00D3RIOS");
		btnGerarRelatrios.setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnRelatriosColaboradores = new JButton("RELAT\u00D3RIOS COLABORADORES");
		btnRelatriosColaboradores.setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnSair = new JButton("SAIR");
		btnSair.setFont(new Font("Arial", Font.BOLD, 13));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ViewLogin login = new ViewLogin();
				login.setVisible(true);
				System.clearProperty("userId");
				setVisible(false);
			}
		});
		
		
		JButton btnCadastrarFornecedor = new JButton("CADASTRAR FORNECEDOR");
		btnCadastrarFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewSupplier sup = new ViewSupplier();
				sup.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastrarFornecedor.setFont(new Font("Arial", Font.BOLD, 13));
		btnCadastrarFornecedor.setMnemonic(KeyEvent.VK_1);
		
		JButton btnCadastroColaborator = new JButton("CADASTRO DE COLABORADOR");
		btnCadastroColaborator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployeeRegistration user = new ViewEmployeeRegistration();
				user.setVisible(true);
				setVisible(false);
			}
		});
		btnCadastroColaborator.setFont(new Font("Arial", Font.BOLD, 13));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(336, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_main, GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(btnCadastrarFornecedor, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnRelatriosColaboradores, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnGerarRelatrios, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEditarInformaoCadastrada, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCadastrarNovaConta, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCadastrarCliente, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnCadastroColaborator, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)))
					.addGap(320))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(436, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(417))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addComponent(panel_main, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(37)
					.addComponent(btnCadastrarFornecedor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrarCliente, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastrarNovaConta, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEditarInformaoCadastrada, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGerarRelatrios, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRelatriosColaboradores, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCadastroColaborator, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
