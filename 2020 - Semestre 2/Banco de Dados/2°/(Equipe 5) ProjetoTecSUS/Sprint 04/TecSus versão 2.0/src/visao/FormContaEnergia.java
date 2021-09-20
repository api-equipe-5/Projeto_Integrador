package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.ModeloContaEnergia;
import modeloConnection.ConexaoBD;
import modeloDAO.DaoContaEnergia;

import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.ImageIcon;

public class FormContaEnergia extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFieldNumeroInstalacao;
	private JTextField jTextFieldValorTotal;
	private JTextField jTextFieldDataVencimento;
	private JTextField jTextFieldMesConta;
	private JTextField jTextFieldNDiasFaturamento;
	private JTextField jTextFieldLeituraAtual;
	private JTextField jTextFieldLeituraAnterior;
	private JTextField jTextFieldDataEmissao;
	private JTextField jTextFieldPrevProxLeitura;
	private JTextField jTextFieldAviso;
	private JTextField jTextFieldStatus;
	private JTextField jTextFieldDataFaturamento;
	private JTextField jTextFieldQtsKwh;
	private JTextField jTextFieldTipoFornecimento;
	private JTextField jTextFieldJurosMulta;
	private JTextField jTextFieldMulta;
	private JTextField jTextFieldModalidadeTarifa;

	ModeloContaEnergia mod = new ModeloContaEnergia();
	DaoContaEnergia control = new DaoContaEnergia();
	ConexaoBD conex = new ConexaoBD();
	private JTextField jTextFieldPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormContaEnergia frame = new FormContaEnergia();
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
	public FormContaEnergia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 48, 764, 573);
		contentPane.add(panel);
		panel.setLayout(null);

		jTextFieldNumeroInstalacao = new JTextField();
		jTextFieldNumeroInstalacao.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldNumeroInstalacao.setColumns(10);
		jTextFieldNumeroInstalacao.setBounds(34, 81, 140, 20);
		panel.add(jTextFieldNumeroInstalacao);

		JLabel lblNewLabel = new JLabel("N\u00FAmero Instala\u00E7\u00E3o:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(34, 53, 140, 28);
		panel.add(lblNewLabel);

		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValorTotal.setBounds(217, 53, 140, 28);
		panel.add(lblValorTotal);

		jTextFieldValorTotal = new JTextField();
		jTextFieldValorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldValorTotal.setColumns(10);
		jTextFieldValorTotal.setBounds(217, 81, 140, 20);
		panel.add(jTextFieldValorTotal);

		JLabel lblNewLabel_1_1 = new JLabel("Data Vencimento:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(399, 53, 140, 28);
		panel.add(lblNewLabel_1_1);

		jTextFieldDataVencimento = new JTextField();
		jTextFieldDataVencimento.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldDataVencimento.setColumns(10);
		jTextFieldDataVencimento.setBounds(399, 81, 140, 20);
		panel.add(jTextFieldDataVencimento);

		JLabel lblNewLabel_1_2 = new JLabel("M\u00EAs da Conta:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(581, 53, 140, 28);
		panel.add(lblNewLabel_1_2);

		jTextFieldMesConta = new JTextField();
		jTextFieldMesConta.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldMesConta.setColumns(10);
		jTextFieldMesConta.setBounds(581, 81, 140, 20);
		panel.add(jTextFieldMesConta);

		JLabel lblNewLabel_1_4 = new JLabel("N\u00BA Dias Faturamento:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4.setBounds(574, 151, 160, 28);
		panel.add(lblNewLabel_1_4);

		jTextFieldNDiasFaturamento = new JTextField();
		jTextFieldNDiasFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldNDiasFaturamento.setColumns(10);
		jTextFieldNDiasFaturamento.setBounds(581, 179, 140, 20);
		panel.add(jTextFieldNDiasFaturamento);

		jTextFieldLeituraAtual = new JTextField();
		jTextFieldLeituraAtual.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldLeituraAtual.setColumns(10);
		jTextFieldLeituraAtual.setBounds(399, 179, 140, 20);
		panel.add(jTextFieldLeituraAtual);

		JLabel lblNewLabel_1_3 = new JLabel("Leitura Atual:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(399, 151, 140, 28);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_2_3 = new JLabel("FATURAMENTO");
		lblNewLabel_1_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2_3.setBounds(222, 112, 323, 28);
		panel.add(lblNewLabel_1_2_3);

		JLabel lblNewLabel_2 = new JLabel("Leitura Anterior:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(217, 151, 140, 28);
		panel.add(lblNewLabel_2);

		jTextFieldLeituraAnterior = new JTextField();
		jTextFieldLeituraAnterior.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldLeituraAnterior.setColumns(10);
		jTextFieldLeituraAnterior.setBounds(217, 179, 140, 20);
		panel.add(jTextFieldLeituraAnterior);

		JLabel lblNewLabel_1_2_1 = new JLabel("Data Emiss\u00E3o:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(33, 151, 140, 28);
		panel.add(lblNewLabel_1_2_1);

		jTextFieldDataEmissao = new JTextField();
		jTextFieldDataEmissao.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldDataEmissao.setColumns(10);
		jTextFieldDataEmissao.setBounds(33, 179, 140, 20);
		panel.add(jTextFieldDataEmissao);

		JLabel lblNewLabel_1_2_2 = new JLabel("Prev Prox Leitura:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBounds(222, 210, 140, 28);
		panel.add(lblNewLabel_1_2_2);

		jTextFieldPrevProxLeitura = new JTextField();
		jTextFieldPrevProxLeitura.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldPrevProxLeitura.setColumns(10);
		jTextFieldPrevProxLeitura.setBounds(217, 238, 140, 20);
		panel.add(jTextFieldPrevProxLeitura);

		jTextFieldAviso = new JTextField();
		jTextFieldAviso.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldAviso.setColumns(10);
		jTextFieldAviso.setBounds(52, 439, 669, 66);
		panel.add(jTextFieldAviso);

		JLabel lblNewLabel_3 = new JLabel("Aviso:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(303, 411, 140, 28);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_1_2_2_3 = new JLabel("Bandeira:");
		lblNewLabel_1_2_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2_3.setBounds(217, 269, 140, 28);
		panel.add(lblNewLabel_1_2_2_3);

		JComboBox comboBoxBandeira = new JComboBox();
		comboBoxBandeira.setModel(new DefaultComboBoxModel(new String[] {"Verde", "Amarelo", "Vermelho I", "Vermelho II"}));
		comboBoxBandeira.setBounds(217, 296, 140, 22);
		panel.add(comboBoxBandeira);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("Status:");
		lblNewLabel_1_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2.setBounds(399, 210, 140, 28);
		panel.add(lblNewLabel_1_2_1_2);

		jTextFieldStatus = new JTextField();
		jTextFieldStatus.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldStatus.setColumns(10);
		jTextFieldStatus.setBounds(399, 238, 140, 20);
		panel.add(jTextFieldStatus);

		JLabel lblNewLabel_1_4_2 = new JLabel("Data Faturamento:");
		lblNewLabel_1_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_4_2.setBounds(574, 210, 160, 28);
		panel.add(lblNewLabel_1_4_2);

		jTextFieldDataFaturamento = new JTextField();
		jTextFieldDataFaturamento.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldDataFaturamento.setColumns(10);
		jTextFieldDataFaturamento.setBounds(581, 238, 140, 20);
		panel.add(jTextFieldDataFaturamento);

		JLabel lblQtdkWh = new JLabel("Qtd kWh:");
		lblQtdkWh.setHorizontalAlignment(SwingConstants.CENTER);
		lblQtdkWh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQtdkWh.setBounds(33, 210, 140, 28);
		panel.add(lblQtdkWh);

		jTextFieldQtsKwh = new JTextField();
		jTextFieldQtsKwh.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldQtsKwh.setColumns(10);
		jTextFieldQtsKwh.setBounds(33, 238, 140, 20);
		panel.add(jTextFieldQtsKwh);

		jTextFieldTipoFornecimento = new JTextField();
		jTextFieldTipoFornecimento.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldTipoFornecimento.setColumns(10);
		jTextFieldTipoFornecimento.setBounds(33, 298, 140, 20);
		panel.add(jTextFieldTipoFornecimento);

		JLabel lblTipoFornecimento = new JLabel("Tipo Fornecimento:");
		lblTipoFornecimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoFornecimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoFornecimento.setBounds(23, 270, 160, 28);
		panel.add(lblTipoFornecimento);

		JLabel lblMulta = new JLabel("Juros Multa:");
		lblMulta.setHorizontalAlignment(SwingConstants.CENTER);
		lblMulta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMulta.setBounds(582, 270, 140, 28);
		panel.add(lblMulta);

		jTextFieldJurosMulta = new JTextField();
		jTextFieldJurosMulta.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldJurosMulta.setColumns(10);
		jTextFieldJurosMulta.setBounds(582, 298, 140, 20);
		panel.add(jTextFieldJurosMulta);

		JLabel lblNewLabel_2_1 = new JLabel("Multa:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(399, 269, 140, 28);
		panel.add(lblNewLabel_2_1);

		jTextFieldMulta = new JTextField();
		jTextFieldMulta.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldMulta.setColumns(10);
		jTextFieldMulta.setBounds(399, 298, 140, 20);
		panel.add(jTextFieldMulta);

		JLabel lblModalidade = new JLabel("Modalidade Tarifaria:");
		lblModalidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblModalidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModalidade.setBounds(34, 329, 140, 28);
		panel.add(lblModalidade);

		jTextFieldModalidadeTarifa = new JTextField();
		jTextFieldModalidadeTarifa.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldModalidadeTarifa.setColumns(10);
		jTextFieldModalidadeTarifa.setBounds(34, 357, 140, 20);
		panel.add(jTextFieldModalidadeTarifa);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				mod.setContaLuzID((Integer.parseInt(jTextFieldNumeroInstalacao.getText())));
				mod.setContaLuzValorTotal(jTextFieldValorTotal.getText());
				mod.setContaLuzDataVencimento(jTextFieldDataVencimento.getText());
				mod.setContaLuzMes(jTextFieldMesConta.getText());
				mod.setContaLuzEmissao(jTextFieldDataEmissao.getText());
				mod.setContaLuzAnterior(jTextFieldLeituraAnterior.getText());
				mod.setContaLuzAtual(jTextFieldLeituraAtual.getText());
				mod.setContaLuzDiasFaturamento((Integer.parseInt(jTextFieldNDiasFaturamento.getText())));
				mod.setContaLuzStatus(jTextFieldStatus.getText());
				mod.setContaLuzPrevisaoProximaLuz(jTextFieldPrevProxLeitura.getText());
				mod.setContaLuzDataFaturamento(jTextFieldDataFaturamento.getText());
				mod.setContaLuzQtdkWh(jTextFieldQtsKwh.getText());
				mod.setContaLuzFiscalMulta(jTextFieldMulta.getText());
				mod.setContaLuzFiscalJurosMulta(jTextFieldJurosMulta.getText());
				mod.setContaLuzFiscalTipoFornecimento(jTextFieldTipoFornecimento.getText());
				mod.setContaLuzFiscalModalidadeTarifaria(jTextFieldModalidadeTarifa.getText());
				mod.setContaLuzAviso(jTextFieldAviso.getText());
				control.salvar(mod);

				jTextFieldNumeroInstalacao.setText("");
				jTextFieldValorTotal.setText("");
				jTextFieldDataVencimento.setText("");
				jTextFieldMesConta.setText("");
				jTextFieldDataEmissao.setText("");
				jTextFieldLeituraAnterior.setText("");
				jTextFieldLeituraAtual.setText("");
				jTextFieldNDiasFaturamento.setText("");
				jTextFieldStatus.setText("");
				jTextFieldPrevProxLeitura.setText("");
				jTextFieldDataFaturamento.setText("");
				jTextFieldQtsKwh.setText("");
				jTextFieldMulta.setText("");
				jTextFieldJurosMulta.setText("");
				jTextFieldTipoFornecimento.setText("");
				jTextFieldModalidadeTarifa.setText("");
				jTextFieldAviso.setText("");

			}
		});
		btnCadastrar.setBounds(286, 526, 97, 25);
		panel.add(btnCadastrar);

		JButton btnEditar = new JButton("Alterar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mod.setContaLuzID((Integer.parseInt(jTextFieldNumeroInstalacao.getText())));
				mod.setContaLuzValorTotal(jTextFieldValorTotal.getText());
				mod.setContaLuzDataVencimento(jTextFieldDataVencimento.getText());
				mod.setContaLuzMes(jTextFieldMesConta.getText());
				mod.setContaLuzEmissao(jTextFieldDataEmissao.getText());
				mod.setContaLuzAnterior(jTextFieldLeituraAnterior.getText());
				mod.setContaLuzAtual(jTextFieldLeituraAtual.getText());
				mod.setContaLuzDiasFaturamento((Integer.parseInt(jTextFieldNDiasFaturamento.getText())));
				mod.setContaLuzStatus(jTextFieldStatus.getText());
				mod.setContaLuzPrevisaoProximaLuz(jTextFieldPrevProxLeitura.getText());
				mod.setContaLuzDataFaturamento(jTextFieldDataFaturamento.getText());
				mod.setContaLuzQtdkWh(jTextFieldQtsKwh.getText());
				mod.setContaLuzFiscalMulta(jTextFieldMulta.getText());
				mod.setContaLuzFiscalJurosMulta(jTextFieldJurosMulta.getText());
				mod.setContaLuzFiscalTipoFornecimento(jTextFieldTipoFornecimento.getText());
				mod.setContaLuzFiscalModalidadeTarifaria(jTextFieldModalidadeTarifa.getText());
				mod.setContaLuzAviso(jTextFieldAviso.getText());
				control.Editar(mod);
				
				jTextFieldNumeroInstalacao.setText("");
				jTextFieldValorTotal.setText("");
				jTextFieldDataVencimento.setText("");
				jTextFieldMesConta.setText("");
				jTextFieldDataEmissao.setText("");
				jTextFieldLeituraAnterior.setText("");
				jTextFieldLeituraAtual.setText("");
				jTextFieldNDiasFaturamento.setText("");
				jTextFieldStatus.setText("");
				jTextFieldPrevProxLeitura.setText("");
				jTextFieldDataFaturamento.setText("");
				jTextFieldQtsKwh.setText("");
				jTextFieldMulta.setText("");
				jTextFieldJurosMulta.setText("");
				jTextFieldTipoFornecimento.setText("");
				jTextFieldModalidadeTarifa.setText("");
				jTextFieldAviso.setText("");
				
				btnCadastrar.setEnabled(true);
				jTextFieldNumeroInstalacao.setEnabled(true);
				
			
				
			}
		});
		btnEditar.setBounds(405, 526, 97, 25);
		panel.add(btnEditar);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mod.setPesquisa(jTextFieldPesquisar.getText());
				ModeloContaEnergia model = control.buscaContaEnergia(mod);
				jTextFieldNumeroInstalacao.setText((String.valueOf(model.getContaLuzID())));
				jTextFieldValorTotal.setText(model.getContaLuzValorTotal());
				jTextFieldDataVencimento.setText(model.getContaLuzDataVencimento());
				jTextFieldMesConta.setText(model.getContaLuzMes());
				jTextFieldDataEmissao.setText(model.getContaLuzEmissao());
				jTextFieldLeituraAnterior.setText(model.getContaLuzAnterior());
				jTextFieldLeituraAtual.setText(model.getContaLuzAtual());
				jTextFieldNDiasFaturamento.setText((String.valueOf(model.getContaLuzDiasFaturamento())));
				jTextFieldStatus.setText(model.getContaLuzStatus());
				jTextFieldPrevProxLeitura.setText(model.getContaLuzPrevisaoProximaLuz());
				jTextFieldDataFaturamento.setText(model.getContaLuzDataFaturamento());
				jTextFieldQtsKwh.setText(model.getContaLuzQtdkWh());
				jTextFieldMulta.setText(model.getContaLuzFiscalMulta());
				jTextFieldJurosMulta.setText(model.getContaLuzFiscalJurosMulta());
				jTextFieldTipoFornecimento.setText(model.getContaLuzFiscalTipoFornecimento());
				jTextFieldModalidadeTarifa.setText(model.getContaLuzFiscalModalidadeTarifaria());
				jTextFieldAviso.setText(model.getContaLuzAviso());
				
				btnCadastrar.setEnabled(false);
				jTextFieldNumeroInstalacao.setEnabled(false);
				jTextFieldPesquisar.setText("");
				
			
			
			}
		});
		btnPesquisar.setBounds(601, 11, 97, 25);
		panel.add(btnPesquisar);
		
		jTextFieldPesquisar = new JTextField();
		jTextFieldPesquisar.setForeground(Color.LIGHT_GRAY);
		jTextFieldPesquisar.setToolTipText("");
		jTextFieldPesquisar.setHorizontalAlignment(SwingConstants.CENTER);
		jTextFieldPesquisar.setColumns(10);
		jTextFieldPesquisar.setBounds(438, 13, 140, 20);
		panel.add(jTextFieldPesquisar);
		
		JLabel lblInsiraONmero = new JLabel("Insira o N\u00FAmero Instala\u00E7\u00E3o:");
		lblInsiraONmero.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsiraONmero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInsiraONmero.setBounds(259, 8, 184, 28);
		panel.add(lblInsiraONmero);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaPrincipal telaprin = new TelaPrincipal();
				telaprin.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(10, 527, 97, 25);
		panel.add(btnVoltar);

		JLabel lblCadastroDeConta = new JLabel("CADASTRO DE CONTA DE ENERGIA");
		lblCadastroDeConta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastroDeConta.setBounds(234, 21, 289, 16);
		contentPane.add(lblCadastroDeConta);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormContaEnergia.class.getResource("/imagens/IconEnergia.png")));
		lblNewLabel_1.setBounds(22, 7, 30, 30);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);

	}
}
