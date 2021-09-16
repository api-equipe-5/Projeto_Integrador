package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import modeloConnection.ConexaoBD;
import modeloDAO.DaoCliente;
import modeloDAO.DaoContaAgua;
import modelo.ModeloCliente;
import modelo.ModeloContaAgua;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FormContaAgua extends JFrame {

	private JPanel contentPane;
	private JTextField JTextFieldNumConta;
	private JTextField JTextFieldGrupo;
	private JTextField JTextFieldRgi;
	private JTextField JTextFieldMesReferencia;
	private JTextField JTextFieldTipoLigacao;
	private JTextField JTextFieldTipoFaturamento;
	private JTextField JTextFieldConsumoMetro;
	private JTextField JTextFieldLeituraAtualData;
	private JTextField JTextFieldLeituraAnteriorData;
	private JTextField JTextFieldLeituraAnterior;
	private JTextField JTextFieldLeituraAtual;
	private JTextField JTextFieldObservacao;
	private JTextField JTextFieldValorAgua;
	private JTextField JTextFieldValorEsgoto;
	private JTextField JTextFieldValorTotal;

	ModeloContaAgua mod = new ModeloContaAgua();
	ModeloCliente mode = new ModeloCliente();
	DaoContaAgua control = new DaoContaAgua();
	ConexaoBD conex = new ConexaoBD();
	int flag = 0;
	private JButton btnCadastrar;
	private JTextField jTextFieldPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormContaAgua frame = new FormContaAgua();
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
	public FormContaAgua() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(12, 53, 758, 569);
		contentPane.add(panel);
		panel.setLayout(null);

		JTextFieldNumConta = new JTextField();
		JTextFieldNumConta.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldNumConta.setColumns(10);
		JTextFieldNumConta.setBounds(271, 143, 155, 20);
		panel.add(JTextFieldNumConta);

		JLabel lblNDaConta = new JLabel("N\u00BA da Conta:");
		lblNDaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblNDaConta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNDaConta.setBounds(293, 115, 97, 28);
		panel.add(lblNDaConta);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGrupo.setBounds(436, 115, 97, 28);
		panel.add(lblGrupo);

		JTextFieldGrupo = new JTextField();
		JTextFieldGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldGrupo.setColumns(10);
		JTextFieldGrupo.setBounds(462, 143, 45, 20);
		panel.add(JTextFieldGrupo);

		JLabel lblCodIdentificador_3 = new JLabel("RGI:");
		lblCodIdentificador_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodIdentificador_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodIdentificador_3.setBounds(130, 115, 97, 28);
		panel.add(lblCodIdentificador_3);

		JTextFieldRgi = new JTextField();
		JTextFieldRgi.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldRgi.setColumns(10);
		JTextFieldRgi.setBounds(108, 143, 155, 20);
		panel.add(JTextFieldRgi);

		JLabel lblMesRef = new JLabel("M\u00EAs Refer\u00EAncia:");
		lblMesRef.setHorizontalAlignment(SwingConstants.CENTER);
		lblMesRef.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMesRef.setBounds(147, 186, 97, 28);
		panel.add(lblMesRef);

		JTextFieldMesReferencia = new JTextField();
		JTextFieldMesReferencia.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldMesReferencia.setColumns(10);
		JTextFieldMesReferencia.setBounds(118, 214, 155, 20);
		panel.add(JTextFieldMesReferencia);

		JLabel lblCodIdentificador_1 = new JLabel("Tipo de Liga\u00E7\u00E3o:");
		lblCodIdentificador_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodIdentificador_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodIdentificador_1.setBounds(557, 115, 97, 28);
		panel.add(lblCodIdentificador_1);

		JTextFieldTipoLigacao = new JTextField();
		JTextFieldTipoLigacao.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldTipoLigacao.setColumns(10);
		JTextFieldTipoLigacao.setBounds(535, 143, 155, 20);
		panel.add(JTextFieldTipoLigacao);

		JLabel lblTipFat = new JLabel("Tipo de Faturamento:");
		lblTipFat.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipFat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipFat.setBounds(330, 186, 120, 28);
		panel.add(lblTipFat);

		JTextFieldTipoFaturamento = new JTextField();
		JTextFieldTipoFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldTipoFaturamento.setColumns(10);
		JTextFieldTipoFaturamento.setBounds(313, 214, 155, 20);
		panel.add(JTextFieldTipoFaturamento);

		JTextFieldConsumoMetro = new JTextField();
		JTextFieldConsumoMetro.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldConsumoMetro.setColumns(10);
		JTextFieldConsumoMetro.setBounds(521, 214, 155, 20);
		panel.add(JTextFieldConsumoMetro);

		JLabel lblConsumoM = new JLabel("Consumo m\u00B3:");
		lblConsumoM.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsumoM.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConsumoM.setBounds(538, 186, 120, 28);
		panel.add(lblConsumoM);

		JLabel lblLeitAtual = new JLabel("Leitura Atual:");
		lblLeitAtual.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeitAtual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLeitAtual.setBounds(211, 297, 120, 28);
		panel.add(lblLeitAtual);

		JTextFieldLeituraAtualData = new JTextField();
		JTextFieldLeituraAtualData.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldLeituraAtualData.setColumns(10);
		JTextFieldLeituraAtualData.setBounds(318, 301, 120, 20);
		panel.add(JTextFieldLeituraAtualData);

		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblData.setBounds(320, 259, 120, 28);
		panel.add(lblData);

		JLabel lblApresentao = new JLabel("Apresenta\u00E7\u00E3o");
		lblApresentao.setHorizontalAlignment(SwingConstants.CENTER);
		lblApresentao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApresentao.setBounds(211, 259, 120, 28);
		panel.add(lblApresentao);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(238, 288, 355, 2);
		panel.add(separator_1);

		JLabel lblLeitura = new JLabel("Leitura");
		lblLeitura.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeitura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLeitura.setBounds(467, 259, 120, 28);
		panel.add(lblLeitura);

		JLabel lblLeituraAnterior = new JLabel("Leitura Anterior:");
		lblLeituraAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeituraAnterior.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLeituraAnterior.setBounds(209, 324, 120, 28);
		panel.add(lblLeituraAnterior);

		JTextFieldLeituraAnteriorData = new JTextField();
		JTextFieldLeituraAnteriorData.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldLeituraAnteriorData.setColumns(10);
		JTextFieldLeituraAnteriorData.setBounds(318, 328, 120, 20);
		panel.add(JTextFieldLeituraAnteriorData);

		JTextFieldLeituraAnterior = new JTextField();
		JTextFieldLeituraAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldLeituraAnterior.setColumns(10);
		JTextFieldLeituraAnterior.setBounds(467, 328, 120, 20);
		panel.add(JTextFieldLeituraAnterior);

		JTextFieldLeituraAtual = new JTextField();
		JTextFieldLeituraAtual.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldLeituraAtual.setColumns(10);
		JTextFieldLeituraAtual.setBounds(467, 301, 120, 20);
		panel.add(JTextFieldLeituraAtual);

		JLabel lblObservacao = new JLabel("Observa\u00E7\u00E3o:");
		lblObservacao.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservacao.setBounds(12, 426, 120, 28);
		panel.add(lblObservacao);

		JTextFieldObservacao = new JTextField();
		JTextFieldObservacao.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldObservacao.setColumns(10);
		JTextFieldObservacao.setBounds(116, 426, 630, 57);
		panel.add(JTextFieldObservacao);

		JLabel lblValorAgua = new JLabel("Valor \u00C1gua");
		lblValorAgua.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorAgua.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorAgua.setBounds(184, 365, 149, 28);
		panel.add(lblValorAgua);

		JLabel lblValorEsgoto = new JLabel("Valor Esgoto");
		lblValorEsgoto.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorEsgoto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorEsgoto.setBounds(344, 365, 149, 28);
		panel.add(lblValorEsgoto);

		JTextFieldValorAgua = new JTextField();
		JTextFieldValorAgua.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldValorAgua.setColumns(10);
		JTextFieldValorAgua.setBounds(208, 393, 106, 20);
		panel.add(JTextFieldValorAgua);

		JTextFieldValorEsgoto = new JTextField();
		JTextFieldValorEsgoto.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldValorEsgoto.setColumns(10);
		JTextFieldValorEsgoto.setBounds(365, 393, 106, 20);
		panel.add(JTextFieldValorEsgoto);

		JLabel lblValorTotal = new JLabel("Valor Total");
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorTotal.setBounds(505, 365, 149, 28);
		panel.add(lblValorTotal);

		JTextFieldValorTotal = new JTextField();
		JTextFieldValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		JTextFieldValorTotal.setColumns(10);
		JTextFieldValorTotal.setBounds(524, 393, 106, 20);
		panel.add(JTextFieldValorTotal);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mod.setContaAguaRGI((Integer.parseInt(JTextFieldRgi.getText())));
				mod.setContaAguaNConta((Integer.parseInt(JTextFieldNumConta.getText())));
				mod.setContaAguaGrupo((Integer.parseInt(JTextFieldGrupo.getText())));
				mod.setContaAguaTipoLigacao((JTextFieldTipoLigacao.getText()));
				mod.setContaAguaMesRef((JTextFieldMesReferencia.getText()));
				mod.setContaAguaTipoFaturamento((JTextFieldTipoFaturamento.getText()));
				mod.setContaAguaConsumo((Integer.parseInt(JTextFieldConsumoMetro.getText())));
				mod.setContaAguaDataLeituraAtual((JTextFieldLeituraAtualData.getText()));
				mod.setContaAguaLeituraAtual((JTextFieldLeituraAtual.getText()));
				mod.setContaAguaDataLeituraAnterior((JTextFieldLeituraAnteriorData.getText()));
				mod.setContaAguaLeituraAnterior((JTextFieldLeituraAnterior.getText()));
				mod.setContaAguaValorAgua((JTextFieldValorAgua.getText()));
				mod.setContaAguaValorEsgoto((JTextFieldValorEsgoto.getText()));
				mod.setContaAguaValorTotal((JTextFieldValorTotal.getText()));
				mod.setContaAguaObservacao((JTextFieldObservacao.getText()));
				control.salvar(mod);

				JTextFieldRgi.setText("");
				JTextFieldNumConta.setText("");
				JTextFieldGrupo.setText("");
				JTextFieldTipoLigacao.setText("");
				JTextFieldMesReferencia.setText("");
				JTextFieldTipoFaturamento.setText("");
				JTextFieldConsumoMetro.setText("");
				JTextFieldLeituraAtualData.setText("");
				JTextFieldLeituraAtual.setText("");
				JTextFieldLeituraAnteriorData.setText("");
				JTextFieldLeituraAnterior.setText("");
				JTextFieldValorAgua.setText("");
				JTextFieldValorEsgoto.setText("");
				JTextFieldValorTotal.setText("");
				JTextFieldObservacao.setText("");

			}
		});
		btnCadastrar.setBounds(293, 522, 97, 25);
		panel.add(btnCadastrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mod.setContaAguaRGI((Integer.parseInt(JTextFieldRgi.getText())));
				mod.setContaAguaNConta((Integer.parseInt(JTextFieldNumConta.getText())));
				mod.setContaAguaGrupo((Integer.parseInt(JTextFieldGrupo.getText())));
				mod.setContaAguaTipoLigacao((JTextFieldTipoLigacao.getText()));
				mod.setContaAguaMesRef((JTextFieldMesReferencia.getText()));
				mod.setContaAguaTipoFaturamento((JTextFieldTipoFaturamento.getText()));
				mod.setContaAguaConsumo((Integer.parseInt(JTextFieldConsumoMetro.getText())));
				mod.setContaAguaDataLeituraAtual((JTextFieldLeituraAtualData.getText()));
				mod.setContaAguaLeituraAtual((JTextFieldLeituraAtual.getText()));
				mod.setContaAguaDataLeituraAnterior((JTextFieldLeituraAnteriorData.getText()));
				mod.setContaAguaLeituraAnterior((JTextFieldLeituraAnterior.getText()));
				mod.setContaAguaValorAgua((JTextFieldValorAgua.getText()));
				mod.setContaAguaValorEsgoto((JTextFieldValorEsgoto.getText()));
				mod.setContaAguaValorTotal((JTextFieldValorTotal.getText()));
				mod.setContaAguaObservacao((JTextFieldObservacao.getText()));
				control.Editar(mod);

				JTextFieldNumConta.setText("");
				JTextFieldGrupo.setText("");
				JTextFieldTipoLigacao.setText("");
				JTextFieldMesReferencia.setText("");
				JTextFieldTipoFaturamento.setText("");
				JTextFieldConsumoMetro.setText("");
				JTextFieldLeituraAtualData.setText("");
				JTextFieldLeituraAtual.setText("");
				JTextFieldLeituraAnteriorData.setText("");
				JTextFieldLeituraAnterior.setText("");
				JTextFieldValorAgua.setText("");
				JTextFieldValorEsgoto.setText("");
				JTextFieldValorTotal.setText("");
				JTextFieldObservacao.setText("");
				JTextFieldRgi.setEnabled(true);
				JTextFieldRgi.setText("");
				btnCadastrar.setEnabled(true);
				btnEditar.setEnabled(false);

			}
		});
		btnEditar.setBounds(412, 522, 97, 25);
		panel.add(btnEditar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(475, 39, 97, 25);
		panel.add(btnPesquisar);
		
		jTextFieldPesquisar = new JTextField();
		jTextFieldPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldPesquisar.setColumns(10);
		jTextFieldPesquisar.setBounds(299, 41, 155, 20);
		panel.add(jTextFieldPesquisar);
		
		JLabel lblInsiraORgi = new JLabel("Insira o RGI:");
		lblInsiraORgi.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraORgi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsiraORgi.setBounds(188, 36, 120, 28);
		panel.add(lblInsiraORgi);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaprin = new TelaPrincipal();
				telaprin.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(24, 523, 97, 25);
		panel.add(btnVoltar);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mod.setPesquisa(jTextFieldPesquisar.getText());
				ModeloContaAgua model = control.buscaContaAgua(mod);
				JTextFieldRgi.setText(String.valueOf(model.getContaAguaRGI()));
				JTextFieldNumConta.setText(String.valueOf(model.getContaAguaNConta()));
				JTextFieldGrupo.setText(String.valueOf(model.getContaAguaGrupo()));
				JTextFieldTipoLigacao.setText(model.getContaAguaTipoLigacao());
				JTextFieldMesReferencia.setText(model.getContaAguaMesRef());
				JTextFieldTipoFaturamento.setText(model.getContaAguaTipoFaturamento());
				JTextFieldConsumoMetro.setText(String.valueOf(model.getContaAguaConsumo()));
				JTextFieldLeituraAtualData.setText(model.getContaAguaDataLeituraAtual());
				JTextFieldLeituraAtual.setText(model.getContaAguaLeituraAtual());
				JTextFieldLeituraAnteriorData.setText(model.getContaAguaDataLeituraAnterior());
				JTextFieldLeituraAnterior.setText(model.getContaAguaLeituraAnterior());
				JTextFieldValorAgua.setText(model.getContaAguaValorAgua());
				JTextFieldValorEsgoto.setText(model.getContaAguaValorEsgoto());
				JTextFieldValorTotal.setText(model.getContaAguaValorTotal());
				JTextFieldObservacao.setText(model.getContaAguaObservacao());
				
				jTextFieldPesquisar.setText("");
				
				JTextFieldRgi.setEnabled(false);
				btnCadastrar.setEnabled(false);

			}
		});

		JLabel lblNewLabel = new JLabel("CADASTRO DE CONTA DE \u00C1GUA");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(257, 13, 267, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormContaAgua.class.getResource("/imagens/IconAgua.png")));
		lblNewLabel_1.setBounds(12, 0, 30, 30);
		contentPane.add(lblNewLabel_1);
	}
}
