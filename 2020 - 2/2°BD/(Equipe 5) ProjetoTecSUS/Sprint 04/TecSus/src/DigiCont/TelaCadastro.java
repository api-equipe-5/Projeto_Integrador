package DigiCont;

import DAO.CadastroAguaDAO;
import DigiCont.CadastroCliente;

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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.JSeparator;

public class TelaCadastro {

	private CadastroAguaDAO consultaagua;
	JFrame frmTelaCadastro;
	private ImageIcon imageIcon;
	protected Object frmTelaCadastroEnergia;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JLabel lblNome;
	private JLabel lblEndereco;
	private JLabel lblhidrometro;
	private JTabbedPane tabbedPane;
	private JPanel panel1;
	private JTextField textNConta;
	private JLabel lblNDaConta;
	private JLabel lblGrupo;
	private JTextField textGrupo;
	private JLabel lblCodIdentificador_3;
	private JTextField textRGI;
	private JLabel lblMesRef;
	private JTextField textMesRef;
	private JLabel lblCodIdentificador_1;
	private JTextField textTipoLig;
	private JLabel lblTipFat;
	private JTextField textTipoFat;
	private JTextField textConsumo;
	private JLabel lblConsumoM;
	private JLabel lblLeitAtual;
	private JTextField textDataAtual;
	private JTextField textDataAnterior;
	private JTextField textLeituraAnterior;
	private JTextField textLeituraAtual;
	private JLabel lblObservacao;
	private JTextField textObs;
	private JTextField txtValorAgua;
	private JTextField txtValorEsgoto;
	private JTextField textField_5;
	private JTextField textValorTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
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
	public TelaCadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaCadastro = new JFrame();
		frmTelaCadastro.getContentPane().setBackground(Color.WHITE);
		frmTelaCadastro.getContentPane().setLayout(null);

		consultaagua = new CadastroAguaDAO();

		panel = new JPanel();
		panel.setBounds(80, 24, 832, 94);
		panel.setLayout(null);
		frmTelaCadastro.getContentPane().add(panel);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBounds(64, 37, 242, 20);
		panel.add(textField);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(414, 34, 347, 20);
		panel.add(textField_1);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(105, 60, 112, 20);
		panel.add(textField_4);

		lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 32, 65, 28);
		panel.add(lblNome);

		lblEndereco = new JLabel("Endereco:");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEndereco.setBounds(356, 29, 65, 28);
		panel.add(lblEndereco);

		lblhidrometro = new JLabel("Hidr\u00F4metro:");
		lblhidrometro.setHorizontalAlignment(SwingConstants.CENTER);
		lblhidrometro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblhidrometro.setBounds(20, 55, 75, 28);
		panel.add(lblhidrometro);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				List<CadastroAgua> cadagua = new ArrayList<CadastroAgua>();

				CadastroAgua c = new CadastroAgua();
				cadagua = consultaagua.getCadastroAgua("8");
				for (int i = 0; i < cadagua.size(); i++)

				{
					c = (CadastroAgua) cadagua.get(i);

					textRGI.setText(c.getContaAguaRGI());
					textGrupo.setText(c.getContaAguaGrupo());
					textNConta.setText(c.getContaAguaNConta());
					textGrupo.setText(c.getContaAguaGrupo());
					textMesRef.setText(c.getContaAguaMesRef());
					textTipoLig.setText(c.getContaAguaTipoLigacao());
					textTipoFat.setText(c.getContaAguaTipoFaturamento());
					textConsumo.setText(c.getContaAguaConsumo());
					textDataAtual.setText(c.getContaAguaDataLeituraAtual());
					textLeituraAtual.setText(c.getContaAguaLeituraAtual());
					textDataAnterior.setText(c.getContaAguaDataLeituraAnterior());
					textLeituraAnterior.setText(c.getContaAguaLeituraAnterior());
					textObs.setText(c.getContaAguaObservacao());
					txtValorAgua.setText(c.getContaAguaValorAgua());
					txtValorEsgoto.setText(c.getContaAguaValorEsgoto());
					textValorTotal.setText(c.getContaAguaValorTotal());

				}

			}
		});
		btnNewButton.setBounds(414, 65, 89, 23);
		panel.add(btnNewButton);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(80, 144, 832, 425);
		frmTelaCadastro.getContentPane().add(tabbedPane);

		panel1 = new JPanel();
		tabbedPane.addTab("Dados Conta", null, panel1, null);
		panel1.setLayout(null);

		textNConta = new JTextField();
		textNConta.setBounds(193, 54, 155, 20);
		textNConta.setHorizontalAlignment(SwingConstants.CENTER);
		textNConta.setColumns(10);
		panel1.add(textNConta);

		lblNDaConta = new JLabel("N\u00BA da Conta:");
		lblNDaConta.setBounds(215, 26, 97, 28);
		lblNDaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNDaConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblNDaConta);

		lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(358, 26, 97, 28);
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblGrupo);

		textGrupo = new JTextField();
		textGrupo.setBounds(384, 54, 45, 20);
		textGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		textGrupo.setColumns(10);
		panel1.add(textGrupo);

		lblCodIdentificador_3 = new JLabel("RGI:");
		lblCodIdentificador_3.setBounds(52, 26, 97, 28);
		lblCodIdentificador_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodIdentificador_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblCodIdentificador_3);

		textRGI = new JTextField();
		textRGI.setBounds(30, 54, 155, 20);
		textRGI.setHorizontalAlignment(SwingConstants.CENTER);
		textRGI.setColumns(10);
		panel1.add(textRGI);

		lblMesRef = new JLabel("M\u00EAs Refer\u00EAncia:");
		lblMesRef.setBounds(484, 26, 97, 28);
		lblMesRef.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesRef.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblMesRef);

		textMesRef = new JTextField();
		textMesRef.setBounds(455, 54, 155, 20);
		textMesRef.setHorizontalAlignment(SwingConstants.CENTER);
		textMesRef.setColumns(10);
		panel1.add(textMesRef);

		lblCodIdentificador_1 = new JLabel("Tipo de Liga\u00E7\u00E3o:");
		lblCodIdentificador_1.setBounds(658, 26, 97, 28);
		lblCodIdentificador_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodIdentificador_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblCodIdentificador_1);

		textTipoLig = new JTextField();
		textTipoLig.setBounds(636, 54, 155, 20);
		textTipoLig.setHorizontalAlignment(SwingConstants.CENTER);
		textTipoLig.setColumns(10);
		panel1.add(textTipoLig);

		lblTipFat = new JLabel("Tipo de Faturamento:");
		lblTipFat.setBounds(215, 100, 120, 28);
		lblTipFat.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipFat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblTipFat);

		textTipoFat = new JTextField();
		textTipoFat.setBounds(198, 128, 155, 20);
		textTipoFat.setHorizontalAlignment(SwingConstants.CENTER);
		textTipoFat.setColumns(10);
		panel1.add(textTipoFat);

		textConsumo = new JTextField();
		textConsumo.setBounds(455, 128, 155, 20);
		textConsumo.setHorizontalAlignment(SwingConstants.CENTER);
		textConsumo.setColumns(10);
		panel1.add(textConsumo);

		lblConsumoM = new JLabel("Consumo m\u00B3:");
		lblConsumoM.setBounds(472, 100, 120, 28);
		lblConsumoM.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumoM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblConsumoM);

		lblLeitAtual = new JLabel("Leitura Atual:");
		lblLeitAtual.setBounds(203, 223, 120, 28);
		lblLeitAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeitAtual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblLeitAtual);

		textDataAtual = new JTextField();
		textDataAtual.setBounds(312, 227, 120, 20);
		textDataAtual.setHorizontalAlignment(SwingConstants.CENTER);
		textDataAtual.setColumns(10);
		panel1.add(textDataAtual);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(314, 185, 120, 28);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblData);

		JLabel lblApresentao = new JLabel("Apresenta\u00E7\u00E3o");
		lblApresentao.setBounds(205, 185, 120, 28);
		lblApresentao.setHorizontalAlignment(SwingConstants.CENTER);
		lblApresentao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblApresentao);

		JSeparator separator = new JSeparator();
		separator.setBounds(130, 202, 0, 35);
		panel1.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(232, 214, 355, 2);
		panel1.add(separator_1);

		JLabel lblLeitura = new JLabel("Leitura");
		lblLeitura.setBounds(461, 185, 120, 28);
		lblLeitura.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeitura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblLeitura);

		JLabel lblLeituraAnterior = new JLabel("Leitura Anterior:");
		lblLeituraAnterior.setBounds(203, 250, 120, 28);
		lblLeituraAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeituraAnterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel1.add(lblLeituraAnterior);

		textDataAnterior = new JTextField();
		textDataAnterior.setBounds(312, 254, 120, 20);
		textDataAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		textDataAnterior.setColumns(10);
		panel1.add(textDataAnterior);

		textLeituraAnterior = new JTextField();
		textLeituraAnterior.setBounds(461, 254, 120, 20);
		textLeituraAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		textLeituraAnterior.setColumns(10);
		panel1.add(textLeituraAnterior);

		textLeituraAtual = new JTextField();
		textLeituraAtual.setBounds(461, 227, 120, 20);
		textLeituraAtual.setHorizontalAlignment(SwingConstants.CENTER);
		textLeituraAtual.setColumns(10);
		panel1.add(textLeituraAtual);

		lblObservacao = new JLabel("Observa\u00E7\u00E3o:");
		lblObservacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservacao.setBounds(358, 288, 120, 28);
		panel1.add(lblObservacao);

		textObs = new JTextField();
		textObs.setHorizontalAlignment(SwingConstants.CENTER);
		textObs.setColumns(10);
		textObs.setBounds(35, 314, 767, 20);
		panel1.add(textObs);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(444, 211, 0, 78);
		panel1.add(separator_2);
		JLabel lblValorAgua = new JLabel("Valor \u00C1gua");
		lblValorAgua.setBounds(130, 345, 149, 28);
		panel1.add(lblValorAgua);
		lblValorAgua.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorAgua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtValorAgua = new JTextField();
		txtValorAgua.setBounds(151, 366, 106, 20);
		panel1.add(txtValorAgua);
		txtValorAgua.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorAgua.setColumns(10);
		txtValorEsgoto = new JTextField();
		txtValorEsgoto.setBounds(352, 366, 106, 20);
		panel1.add(txtValorEsgoto);
		txtValorEsgoto.setHorizontalAlignment(SwingConstants.CENTER);
		txtValorEsgoto.setColumns(10);
		JLabel lblValorEsgoto = new JLabel("Valor Esgoto");
		lblValorEsgoto.setBounds(331, 345, 149, 28);
		panel1.add(lblValorEsgoto);
		lblValorEsgoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorEsgoto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setBounds(524, 345, 149, 28);
		panel1.add(lblValorTotal);
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));

		textValorTotal = new JTextField();
		textValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		textValorTotal.setColumns(10);
		textValorTotal.setBounds(547, 366, 106, 20);
		panel1.add(textValorTotal);

		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroAgua cadaguadao = new CadastroAgua();

				cadaguadao.setContaAguaRGI(textRGI.getText());
				cadaguadao.setContaAguaNConta(textNConta.getText());
				cadaguadao.setContaAguaGrupo(textGrupo.getText());
				cadaguadao.setContaAguaMesRef(textMesRef.getText());
				cadaguadao.setContaAguaTipoLigacao(textTipoLig.getText());
				cadaguadao.setContaAguaTipoFaturamento(textTipoFat.getText());
				cadaguadao.setContaAguaConsumo(textConsumo.getText());
				cadaguadao.setContaAguaDataLeituraAtual(textDataAtual.getText());
				cadaguadao.setContaAguaLeituraAtual(textLeituraAtual.getText());
				cadaguadao.setContaAguaDataLeituraAnterior(textDataAnterior.getText());
				cadaguadao.setContaAguaLeituraAnterior(textLeituraAnterior.getText());
				cadaguadao.setContaAguaObservacao(textObs.getText());
				cadaguadao.setContaAguaValorAgua(txtValorAgua.getText());
				cadaguadao.setContaAguaValorEsgoto(txtValorEsgoto.getText());
				cadaguadao.setContaAguaValorTotal(textValorTotal.getText());

				if ((textRGI.getText().isEmpty()) || (textNConta.getText().isEmpty()) || (textGrupo.getText().isEmpty())
						|| (textMesRef.getText().isEmpty()) || (textTipoLig.getText().isEmpty())
						|| (textTipoFat.getText().isEmpty()) || (textConsumo.getText().isEmpty())
						|| (textDataAtual.getText().isEmpty()) || (textLeituraAtual.getText().isEmpty())
						|| (textDataAnterior.getText().isEmpty()) || (textLeituraAnterior.getText().isEmpty())
						|| (textObs.getText().isEmpty()) || (txtValorAgua.getText().isEmpty())
						|| (txtValorEsgoto.getText().isEmpty()) || (textValorTotal.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Os campos não podem estar vazios");
				}

				else {

					CadastroAguaDAO cadagua = new CadastroAguaDAO();
					cadagua.adiciona(cadaguadao);
					JOptionPane.showMessageDialog(null, "Conta registrada com sucesso! ");
				}

				textRGI.setText("");
				textNConta.setText("");
				textGrupo.setText("");
				textMesRef.setText("");
				textTipoLig.setText("");
				textTipoFat.setText("");
				textConsumo.setText("");
				textDataAtual.setText("");
				textLeituraAtual.setText("");
				textDataAnterior.setText("");
				textLeituraAnterior.setText("");
				textObs.setText("");
				txtValorAgua.setText("");
				txtValorEsgoto.setText("");
				textValorTotal.setText("");

			}
		});

		btnCadastro.setBounds(423, 623, 107, 23);
		frmTelaCadastro.getContentPane().add(btnCadastro);

		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconAgua.png"));
		lblNewLabel_1_1.setBounds(10, 11, 30, 30);
		frmTelaCadastro.getContentPane().add(lblNewLabel_1_1);

		JButton lblNewLabel_3 = new JButton("New label");
		lblNewLabel_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MenuEnergia window = new MenuEnergia();
				window.frmMenuEnergia.setVisible(true);
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\assen\\eclipse-workspace\\TecSus\\img\\IconReturn.png"));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(31, 611, 60, 54);
		frmTelaCadastro.getContentPane().add(lblNewLabel_3);
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(292, 702, 106, 20);
		frmTelaCadastro.getContentPane().add(textField_5);
		frmTelaCadastro.setResizable(false);
		frmTelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaCadastro.setForeground(Color.WHITE);
		frmTelaCadastro.setTitle("TELA CADASTRO \u00C1GUA");
		frmTelaCadastro.setBounds(100, 100, 960, 720);
		frmTelaCadastro.setLocationRelativeTo(null);

		imageIcon = new ImageIcon("img/IconAgua.png");

	}
}
