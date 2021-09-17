package DigiCont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TelaEditar {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textStatus;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textNomeCliente;
	private JTextField textEndereco;
	private JTextField textNMedidor;
	private JTextField textTensao;
	private JTextField textCodIdentificacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEditar window = new TelaEditar();
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
	public TelaEditar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 960, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(55, 115, 832, 501);
		tabbedPane.setBackground(Color.GRAY);
		frame.getContentPane().add(tabbedPane);
		
		JPanel paneldadosconta = new JPanel();
		paneldadosconta.setBackground(UIManager.getColor("CheckBox.background"));
		tabbedPane.addTab("Dados Conta", null, paneldadosconta, null);
		tabbedPane.setForegroundAt(0, Color.BLACK);
		tabbedPane.setBackgroundAt(0, Color.LIGHT_GRAY);
		paneldadosconta.setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(37, 70, 140, 20);
		paneldadosconta.add(textField);
		
		JLabel lblNewLabel = new JLabel("N\u00FAmero Instala\u00E7\u00E3o:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(37, 42, 140, 28);
		paneldadosconta.add(lblNewLabel);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorTotal.setBounds(220, 42, 140, 28);
		paneldadosconta.add(lblValorTotal);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(220, 70, 140, 20);
		paneldadosconta.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Data Vencimento:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(402, 42, 140, 28);
		paneldadosconta.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(402, 70, 140, 20);
		paneldadosconta.add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("M\u00EAs da Conta:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(584, 42, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(584, 70, 140, 20);
		paneldadosconta.add(textField_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("N\u00BA Dias Faturamento:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(577, 168, 160, 28);
		paneldadosconta.add(lblNewLabel_1_4);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(584, 196, 140, 20);
		paneldadosconta.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(402, 196, 140, 20);
		paneldadosconta.add(textField_5);
		
		JLabel lblNewLabel_1_3 = new JLabel("Leitura Atual:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(402, 168, 140, 28);
		paneldadosconta.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("FATURAMENTO");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_3.setBounds(225, 129, 323, 28);
		paneldadosconta.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_2 = new JLabel("Leitura Anterior:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(220, 168, 140, 28);
		paneldadosconta.add(lblNewLabel_2);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		textField_6.setBounds(220, 196, 140, 20);
		paneldadosconta.add(textField_6);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Data Emiss\u00E3o:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(37, 168, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_1);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		textField_7.setBounds(37, 196, 140, 20);
		paneldadosconta.add(textField_7);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Prev Prox Leitura:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(225, 227, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_2);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setColumns(10);
		textField_8.setBounds(220, 255, 140, 20);
		paneldadosconta.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setColumns(10);
		textField_9.setBounds(402, 315, 322, 20);
		paneldadosconta.add(textField_9);
		
		JLabel lblNewLabel_3 = new JLabel("Aviso:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(498, 286, 140, 28);
		paneldadosconta.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Valor Fornecedor:");
		lblNewLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_1.setBounds(402, 227, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_2_1);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setColumns(10);
		textField_10.setBounds(402, 255, 140, 20);
		paneldadosconta.add(textField_10);
		
		JLabel lblNewLabel_1_2_2_3 = new JLabel("Bandeira:");
		lblNewLabel_1_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_3.setBounds(220, 286, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_2_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Verde", "Amarelo", "Vermelho I", "Vermelho II"}));
		comboBox.setBounds(220, 313, 140, 22);
		paneldadosconta.add(comboBox);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("Status:");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2.setBounds(37, 227, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_1_2);
		
		textStatus = new JTextField();
		textStatus.setHorizontalAlignment(SwingConstants.CENTER);
		textStatus.setColumns(10);
		textStatus.setBounds(37, 255, 140, 20);
		paneldadosconta.add(textStatus);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("Data Faturamento:");
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(577, 227, 160, 28);
		paneldadosconta.add(lblNewLabel_1_4_2);
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setColumns(10);
		textField_22.setBounds(584, 255, 140, 20);
		paneldadosconta.add(textField_22);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Qts kWh:");
		lblNewLabel_1_2_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_1.setBounds(37, 286, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_1_2_1);
		
		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setColumns(10);
		textField_23.setBounds(37, 314, 140, 20);
		paneldadosconta.add(textField_23);
		
		JPanel paneldadosfiscais = new JPanel();
		tabbedPane.addTab("Dados Fiscais", null, paneldadosfiscais, null);
		paneldadosfiscais.setLayout(null);
		
		JLabel lblCfop = new JLabel("CFOP:");
		lblCfop.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCfop.setBounds(40, 48, 140, 28);
		paneldadosfiscais.add(lblCfop);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setColumns(10);
		textField_11.setBounds(40, 76, 140, 20);
		paneldadosfiscais.add(textField_11);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrupo.setBounds(223, 48, 140, 28);
		paneldadosfiscais.add(lblGrupo);
		
		textField_12 = new JTextField();
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setColumns(10);
		textField_12.setBounds(223, 76, 140, 20);
		paneldadosfiscais.add(textField_12);
		
		JLabel lblSubGrupo = new JLabel("Sub Grupo:");
		lblSubGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubGrupo.setBounds(405, 48, 140, 28);
		paneldadosfiscais.add(lblSubGrupo);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setColumns(10);
		textField_13.setBounds(405, 76, 140, 20);
		paneldadosfiscais.add(textField_13);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Classe:");
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_4.setBounds(587, 48, 140, 28);
		paneldadosfiscais.add(lblNewLabel_1_2_4);
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setColumns(10);
		textField_14.setBounds(587, 76, 140, 20);
		paneldadosfiscais.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setColumns(10);
		textField_15.setBounds(587, 163, 140, 20);
		paneldadosfiscais.add(textField_15);
		
		JLabel lblTipoFornecimento = new JLabel("Tipo Fornecimento:");
		lblTipoFornecimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoFornecimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoFornecimento.setBounds(580, 135, 160, 28);
		paneldadosfiscais.add(lblTipoFornecimento);
		
		JLabel lblMulta = new JLabel("Juros Multa:");
		lblMulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMulta.setBounds(405, 135, 140, 28);
		paneldadosfiscais.add(lblMulta);
		
		textField_16 = new JTextField();
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setColumns(10);
		textField_16.setBounds(405, 163, 140, 20);
		paneldadosfiscais.add(textField_16);
		
		JLabel lblNewLabel_2_1 = new JLabel("Multa:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(223, 135, 140, 28);
		paneldadosfiscais.add(lblNewLabel_2_1);
		
		textField_17 = new JTextField();
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setColumns(10);
		textField_17.setBounds(223, 163, 140, 20);
		paneldadosfiscais.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);
		textField_18.setBounds(40, 163, 140, 20);
		paneldadosfiscais.add(textField_18);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Sub Classe:");
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(40, 135, 140, 28);
		paneldadosfiscais.add(lblNewLabel_1_2_1_1);
		
		JLabel lblModalidade = new JLabel("Modalidade Tarifaria:");
		lblModalidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblModalidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModalidade.setBounds(40, 217, 140, 28);
		paneldadosfiscais.add(lblModalidade);
		
		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);
		textField_19.setBounds(40, 245, 140, 20);
		paneldadosfiscais.add(textField_19);
		
		JLabel lblNotaFiscal = new JLabel("Valor Fornecedor:");
		lblNotaFiscal.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotaFiscal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNotaFiscal.setBounds(223, 217, 140, 28);
		paneldadosfiscais.add(lblNotaFiscal);
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setColumns(10);
		textField_20.setBounds(223, 245, 140, 20);
		paneldadosfiscais.add(textField_20);
		tabbedPane.setBackgroundAt(1, Color.LIGHT_GRAY);
		
		JLabel lblIconAgua = new JLabel(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconEnergia.png"));
		lblIconAgua.setBounds(10, 11, 30, 30);
		frame.getContentPane().add(lblIconAgua);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(431, 627, 100, 29);
		frame.getContentPane().add(btnCadastrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(55, 11, 832, 94);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textNomeCliente = new JTextField();
		textNomeCliente.setHorizontalAlignment(SwingConstants.CENTER);
		textNomeCliente.setColumns(10);
		textNomeCliente.setBounds(74, 11, 242, 20);
		panel.add(textNomeCliente);
		
		textEndereco = new JTextField();
		textEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		textEndereco.setColumns(10);
		textEndereco.setBounds(420, 11, 344, 20);
		panel.add(textEndereco);
		
		textNMedidor = new JTextField();
		textNMedidor.setHorizontalAlignment(SwingConstants.CENTER);
		textNMedidor.setColumns(10);
		textNMedidor.setBounds(171, 37, 106, 20);
		panel.add(textNMedidor);
		
		textTensao = new JTextField();
		textTensao.setHorizontalAlignment(SwingConstants.CENTER);
		textTensao.setColumns(10);
		textTensao.setBounds(346, 37, 60, 20);
		panel.add(textTensao);
		
		textCodIdentificacao = new JTextField();
		textCodIdentificacao.setHorizontalAlignment(SwingConstants.CENTER);
		textCodIdentificacao.setColumns(10);
		textCodIdentificacao.setBounds(523, 37, 155, 20);
		panel.add(textCodIdentificacao);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(20, 6, 65, 28);
		panel.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEndereco.setBounds(345, 6, 65, 28);
		panel.add(lblEndereco);
		
		JLabel lblNMedidor = new JLabel("N\u00BA Medidor:");
		lblNMedidor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNMedidor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNMedidor.setBounds(97, 33, 65, 28);
		panel.add(lblNMedidor);
		
		JLabel lblTenso = new JLabel("Tens\u00E3o:");
		lblTenso.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTenso.setBounds(287, 33, 65, 28);
		panel.add(lblTenso);
		
		JLabel lblCodIdentificador = new JLabel("Cod Identificador:");
		lblCodIdentificador.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodIdentificador.setBounds(416, 33, 97, 28);
		panel.add(lblCodIdentificador);
		
	
		
	}
}
