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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import DAO.CadastroEnergiaDAO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroEnergia {

	JFrame frame;
	private JTextField txtNInstalacao;
	private JTextField txtValorTotal;
	private JTextField txtDataVencimento;
	private JTextField txtMesConta;
	private JTextField txtNDiasFat;
	private JTextField txtLeituraAtual;
	private JTextField txtLeituraAnterior;
	private JTextField txtDataEmissao;
	private JTextField txtPrevProxLeitura;
	private JTextField txtAviso;
	private JTextField txtValorFornecedor;
	private JTextField textCFOP;
	private JTextField textGrupo;
	private JTextField textSubGrupo;
	private JTextField textClasse;
	private JTextField textTipoForne;
	private JTextField textJurosMulta;
	private JTextField textMulta;
	private JTextField textSubClasse;
	private JTextField textModTarifa;
	private JTextField txtStatus;
	private JTextField txtDataFat;
	private JTextField txtQtdkWh;
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
					TelaCadastroEnergia window = new TelaCadastroEnergia();
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
	public TelaCadastroEnergia() {
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

		txtNInstalacao = new JTextField();
		txtNInstalacao.setHorizontalAlignment(SwingConstants.CENTER);
		txtNInstalacao.setColumns(10);
		txtNInstalacao.setBounds(37, 70, 140, 20);
		paneldadosconta.add(txtNInstalacao);

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

		txtValorTotal = new JTextField();
		txtValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorTotal.setColumns(10);
		txtValorTotal.setBounds(220, 70, 140, 20);
		paneldadosconta.add(txtValorTotal);

		JLabel lblNewLabel_1_1 = new JLabel("Data Vencimento:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(402, 42, 140, 28);
		paneldadosconta.add(lblNewLabel_1_1);

		txtDataVencimento = new JTextField();
		txtDataVencimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataVencimento.setColumns(10);
		txtDataVencimento.setBounds(402, 70, 140, 20);
		paneldadosconta.add(txtDataVencimento);

		JLabel lblNewLabel_1_2 = new JLabel("M\u00EAs da Conta:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(584, 42, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2);

		txtMesConta = new JTextField();
		txtMesConta.setHorizontalAlignment(SwingConstants.CENTER);
		txtMesConta.setColumns(10);
		txtMesConta.setBounds(584, 70, 140, 20);
		paneldadosconta.add(txtMesConta);

		JLabel lblNewLabel_1_4 = new JLabel("N\u00BA Dias Faturamento:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(577, 168, 160, 28);
		paneldadosconta.add(lblNewLabel_1_4);

		txtNDiasFat = new JTextField();
		txtNDiasFat.setHorizontalAlignment(SwingConstants.CENTER);
		txtNDiasFat.setColumns(10);
		txtNDiasFat.setBounds(584, 196, 140, 20);
		paneldadosconta.add(txtNDiasFat);

		txtLeituraAtual = new JTextField();
		txtLeituraAtual.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeituraAtual.setColumns(10);
		txtLeituraAtual.setBounds(402, 196, 140, 20);
		paneldadosconta.add(txtLeituraAtual);

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

		txtLeituraAnterior = new JTextField();
		txtLeituraAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeituraAnterior.setColumns(10);
		txtLeituraAnterior.setBounds(220, 196, 140, 20);
		paneldadosconta.add(txtLeituraAnterior);

		JLabel lblNewLabel_1_2_1 = new JLabel("Data Emiss\u00E3o:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(37, 168, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_1);

		txtDataEmissao = new JTextField();
		txtDataEmissao.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataEmissao.setColumns(10);
		txtDataEmissao.setBounds(37, 196, 140, 20);
		paneldadosconta.add(txtDataEmissao);

		JLabel lblNewLabel_1_2_2 = new JLabel("Prev Prox Leitura:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(225, 227, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_2);

		txtPrevProxLeitura = new JTextField();
		txtPrevProxLeitura.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrevProxLeitura.setColumns(10);
		txtPrevProxLeitura.setBounds(220, 255, 140, 20);
		paneldadosconta.add(txtPrevProxLeitura);

		txtAviso = new JTextField();
		txtAviso.setHorizontalAlignment(SwingConstants.CENTER);
		txtAviso.setColumns(10);
		txtAviso.setBounds(402, 315, 322, 20);
		paneldadosconta.add(txtAviso);

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

		txtValorFornecedor = new JTextField();
		txtValorFornecedor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorFornecedor.setColumns(10);
		txtValorFornecedor.setBounds(402, 255, 140, 20);
		paneldadosconta.add(txtValorFornecedor);

		JLabel lblNewLabel_1_2_2_3 = new JLabel("Bandeira:");
		lblNewLabel_1_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_3.setBounds(220, 286, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_2_3);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Verde", "Amarelo", "Vermelho I", "Vermelho II" }));
		comboBox.setBounds(220, 313, 140, 22);
		paneldadosconta.add(comboBox);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Status:");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2.setBounds(37, 227, 140, 28);
		paneldadosconta.add(lblNewLabel_1_2_1_2);

		txtStatus = new JTextField();
		txtStatus.setHorizontalAlignment(SwingConstants.CENTER);
		txtStatus.setColumns(10);
		txtStatus.setBounds(37, 255, 140, 20);
		paneldadosconta.add(txtStatus);

		JLabel lblNewLabel_1_4_2 = new JLabel("Data Faturamento:");
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(577, 227, 160, 28);
		paneldadosconta.add(lblNewLabel_1_4_2);

		txtDataFat = new JTextField();
		txtDataFat.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataFat.setColumns(10);
		txtDataFat.setBounds(584, 255, 140, 20);
		paneldadosconta.add(txtDataFat);

		JLabel lblQtdkWh = new JLabel("Qtd kWh:");
		lblQtdkWh.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdkWh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQtdkWh.setBounds(37, 286, 140, 28);
		paneldadosconta.add(lblQtdkWh);

		txtQtdkWh = new JTextField();
		txtQtdkWh.setHorizontalAlignment(SwingConstants.CENTER);
		txtQtdkWh.setColumns(10);
		txtQtdkWh.setBounds(37, 314, 140, 20);
		paneldadosconta.add(txtQtdkWh);

		JPanel paneldadosfiscais = new JPanel();
		tabbedPane.addTab("Dados Fiscais", null, paneldadosfiscais, null);
		tabbedPane.setBackgroundAt(1, Color.LIGHT_GRAY);
		paneldadosfiscais.setLayout(null);

		JLabel lblCfop = new JLabel("CFOP:");
		lblCfop.setHorizontalAlignment(SwingConstants.CENTER);
		lblCfop.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCfop.setBounds(40, 48, 140, 28);
		paneldadosfiscais.add(lblCfop);

		textCFOP = new JTextField();
		textCFOP.setHorizontalAlignment(SwingConstants.CENTER);
		textCFOP.setColumns(10);
		textCFOP.setBounds(40, 76, 140, 20);
		paneldadosfiscais.add(textCFOP);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGrupo.setBounds(223, 48, 140, 28);
		paneldadosfiscais.add(lblGrupo);

		textGrupo = new JTextField();
		textGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		textGrupo.setColumns(10);
		textGrupo.setBounds(223, 76, 140, 20);
		paneldadosfiscais.add(textGrupo);

		JLabel lblSubGrupo = new JLabel("Sub Grupo:");
		lblSubGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubGrupo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSubGrupo.setBounds(405, 48, 140, 28);
		paneldadosfiscais.add(lblSubGrupo);

		textSubGrupo = new JTextField();
		textSubGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		textSubGrupo.setColumns(10);
		textSubGrupo.setBounds(405, 76, 140, 20);
		paneldadosfiscais.add(textSubGrupo);

		JLabel lblNewLabel_1_2_4 = new JLabel("Classe:");
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_4.setBounds(587, 48, 140, 28);
		paneldadosfiscais.add(lblNewLabel_1_2_4);

		textClasse = new JTextField();
		textClasse.setHorizontalAlignment(SwingConstants.CENTER);
		textClasse.setColumns(10);
		textClasse.setBounds(587, 76, 140, 20);
		paneldadosfiscais.add(textClasse);

		textTipoForne = new JTextField();
		textTipoForne.setHorizontalAlignment(SwingConstants.CENTER);
		textTipoForne.setColumns(10);
		textTipoForne.setBounds(587, 163, 140, 20);
		paneldadosfiscais.add(textTipoForne);

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

		textJurosMulta = new JTextField();
		textJurosMulta.setHorizontalAlignment(SwingConstants.CENTER);
		textJurosMulta.setColumns(10);
		textJurosMulta.setBounds(405, 163, 140, 20);
		paneldadosfiscais.add(textJurosMulta);

		JLabel lblNewLabel_2_1 = new JLabel("Multa:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(223, 135, 140, 28);
		paneldadosfiscais.add(lblNewLabel_2_1);

		textMulta = new JTextField();
		textMulta.setHorizontalAlignment(SwingConstants.CENTER);
		textMulta.setColumns(10);
		textMulta.setBounds(223, 163, 140, 20);
		paneldadosfiscais.add(textMulta);

		textSubClasse = new JTextField();
		textSubClasse.setHorizontalAlignment(SwingConstants.CENTER);
		textSubClasse.setColumns(10);
		textSubClasse.setBounds(40, 163, 140, 20);
		paneldadosfiscais.add(textSubClasse);

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

		textModTarifa = new JTextField();
		textModTarifa.setHorizontalAlignment(SwingConstants.CENTER);
		textModTarifa.setColumns(10);
		textModTarifa.setBounds(40, 245, 140, 20);
		paneldadosfiscais.add(textModTarifa);

		JLabel lblIconAgua = new JLabel(
				new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconEnergia.png"));
		lblIconAgua.setBounds(10, 11, 30, 30);
		frame.getContentPane().add(lblIconAgua);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroEnegia cadenergiadao = new CadastroEnegia();

				cadenergiadao.setContaLuzID(txtNInstalacao.getText());
				cadenergiadao.setContaLuzValorTotal(txtValorTotal.getText());
				cadenergiadao.setContaLuzDataVencimento(txtDataVencimento.getText());
				cadenergiadao.setContaLuzMes(txtMesConta.getText());
				cadenergiadao.setContaLuzEmissao(txtDataEmissao.getText());
				cadenergiadao.setContaLuzAnterior(txtLeituraAnterior.getText());
				cadenergiadao.setContaLuzAtual(txtLeituraAtual.getText());
				cadenergiadao.setContaLuzDiasFaturamento(txtNDiasFat.getText());
				cadenergiadao.setContaLuzStatus(txtStatus.getText());
				cadenergiadao.setContaLuzPrevisaoProximaLuz(txtPrevProxLeitura.getText());
				cadenergiadao.setContaLuzValorFornecedor(txtValorFornecedor.getText());
				cadenergiadao.setContaLuzDataFaturamento(txtDataFat.getText());
				cadenergiadao.setContaLuzQtdkWh(txtQtdkWh.getText());
				cadenergiadao.setContaLuzAviso(txtAviso.getText());
				cadenergiadao.setContaLuzFiscalCFOP(textCFOP.getText());
				cadenergiadao.setContaLuzFiscalGrupo(textGrupo.getText());
				cadenergiadao.setContaLuzFiscalSubGrupo(textSubGrupo.getText());
				cadenergiadao.setContaLuzFiscalClasse(textClasse.getText());
				cadenergiadao.setContaLuzFiscalSubClasse(textSubClasse.getText());
				cadenergiadao.setContaLuzFiscalMulta(textMulta.getText());
				cadenergiadao.setContaLuzFiscalJurosMulta(textJurosMulta.getText());
				cadenergiadao.setContaLuzFiscalTipoFornecimento(textTipoForne.getText());
				cadenergiadao.setContaLuzFiscalModalidadeTarifaria(textModTarifa.getText());

				if ((txtNInstalacao.getText().isEmpty()) || (txtValorTotal.getText().isEmpty())
						|| (txtDataVencimento.getText().isEmpty()) || (txtMesConta.getText().isEmpty())
						|| (txtDataVencimento.getText().isEmpty()) || (txtDataEmissao.getText().isEmpty())
						|| (txtLeituraAnterior.getText().isEmpty()) || (txtLeituraAtual.getText().isEmpty())
						|| (txtNDiasFat.getText().isEmpty()) || (txtStatus.getText().isEmpty())
						|| (txtPrevProxLeitura.getText().isEmpty()) || (txtValorFornecedor.getText().isEmpty())
						|| (txtDataFat.getText().isEmpty()) || (txtQtdkWh.getText().isEmpty())
						|| (txtAviso.getText().isEmpty()) || (textCFOP.getText().isEmpty())
						|| (textGrupo.getText().isEmpty()) || (textSubGrupo.getText().isEmpty())
						|| (textClasse.getText().isEmpty()) || (textSubClasse.getText().isEmpty())
						|| (textMulta.getText().isEmpty()) || (textJurosMulta.getText().isEmpty())
						|| (textTipoForne.getText().isEmpty()) || (textModTarifa.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
				}

				else {

					CadastroEnergiaDAO cadenergia = new CadastroEnergiaDAO();
					cadenergia.adiciona(cadenergiadao);
					JOptionPane.showMessageDialog(null, "Conta registrada com sucesso! ");
				}

				txtNInstalacao.setText("");
				txtValorTotal.setText("");
				txtDataVencimento.setText("");
				txtMesConta.setText("");
				txtDataEmissao.setText("");
				txtLeituraAnterior.setText("");
				txtLeituraAtual.setText("");
				txtNDiasFat.setText("");
				txtStatus.setText("");
				txtPrevProxLeitura.setText("");
				txtValorFornecedor.setText("");
				txtDataFat.setText("");
				txtQtdkWh.setText("");
				txtAviso.setText("");
				textCFOP.setText("");
				textGrupo.setText("");
				textSubGrupo.setText("");
				textClasse.setText("");
				textSubClasse.setText("");
				textMulta.setText("");
				textJurosMulta.setText("");
				textTipoForne.setText("");
				textModTarifa.setText("");

			}
		});
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

		JButton lblNewLabel_3_1 = new JButton("New label");
		lblNewLabel_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEnergia window = new MenuEnergia();
				window.frmMenuEnergia.setVisible(true);
			}
		});
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconReturn.png"));
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBackground(Color.WHITE);
		lblNewLabel_3_1.setBounds(41, 616, 60, 54);
		frame.getContentPane().add(lblNewLabel_3_1);

	}
}
