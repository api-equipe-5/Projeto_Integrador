package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloCliente;
import modeloConnection.ConexaoBD;
import modeloDAO.DaoCliente;

import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldPesquisa;
	private JTable table;
	private JTextField jTextFieldNome;
	private JTextField jTextFieldCnpj;
	private JTextField jTextFieldHidrometro;

	ModeloCliente mode = new ModeloCliente();
	DaoCliente control = new DaoCliente();
	ConexaoBD conex = new ConexaoBD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 664, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 57, 622, 374);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setBounds(97, 13, 68, 31);
		panel.add(lblNewLabel_1);

		jTextFieldPesquisa = new JTextField();
		jTextFieldPesquisa.setBounds(143, 17, 274, 22);
		panel.add(jTextFieldPesquisa);
		jTextFieldPesquisa.setColumns(10);

		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mode.setPesquisa(jTextFieldPesquisa.getText());
				ModeloCliente model = control.buscaCliente(mode);
				jTextFieldNome.setText(model.getNome());
				jTextFieldCnpj.setText(String.valueOf(model.getCnpj()));
				jTextFieldHidrometro.setText(String.valueOf(model.getHidrometro()));

			}
		});
		btnNewButton.setBounds(429, 16, 97, 25);
		panel.add(btnNewButton);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setModel(
				new DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "", "Nome", "CNPJ", "Hidrometro" }) {
					Class[] columnTypes = new Class[] { Object.class, String.class, String.class, String.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.setBounds(28, 146, 569, 160);
		panel.add(table);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCnpj.setBounds(351, 57, 65, 28);
		panel.add(lblCnpj);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(26, 57, 65, 28);
		panel.add(lblNome);

		jTextFieldNome = new JTextField();
		jTextFieldNome.setEditable(false);
		jTextFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldNome.setColumns(10);
		jTextFieldNome.setBounds(80, 62, 259, 20);
		panel.add(jTextFieldNome);

		jTextFieldCnpj = new JTextField();
		jTextFieldCnpj.setEditable(false);
		jTextFieldCnpj.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldCnpj.setColumns(10);
		jTextFieldCnpj.setBounds(392, 61, 205, 20);
		panel.add(jTextFieldCnpj);

		jTextFieldHidrometro = new JTextField();
		jTextFieldHidrometro.setEditable(false);
		jTextFieldHidrometro.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldHidrometro.setColumns(10);
		jTextFieldHidrometro.setBounds(121, 98, 112, 20);
		panel.add(jTextFieldHidrometro);

		JLabel lblhidrometro = new JLabel("Hidr\u00F4metro:");
		lblhidrometro.setHorizontalAlignment(SwingConstants.CENTER);
		lblhidrometro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblhidrometro.setBounds(36, 93, 75, 28);
		panel.add(lblhidrometro);

		JButton btnNewButton_1 = new JButton("Cadastrar Conta");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FormContaAgua cadagua = new FormContaAgua();
				cadagua.setVisible(true);
				dispose();

			}
		});
		btnNewButton_1.setBounds(183, 336, 138, 25);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setBounds(333, 336, 97, 25);
		panel.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel("Selecionar Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(236, 13, 173, 31);
		contentPane.add(lblNewLabel);
	}
}
