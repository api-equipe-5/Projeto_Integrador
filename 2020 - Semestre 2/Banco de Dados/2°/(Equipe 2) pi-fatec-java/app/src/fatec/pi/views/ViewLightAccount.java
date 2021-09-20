package fatec.pi.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import fatec.pi.controllers.LightAccountController;
import fatec.pi.daos.LightAccountDao;
import fatec.pi.entities.LightAccount;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class ViewLightAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txt_supplierCnpj;
	private JTextField txt_currentDate;
	private JTextField txt_dueDate;
	private JTextField txt_identCod;
	private JTextField txt_invoice;
	private JTextField txt_pisPercentage;
	private JTextField txt_cofinsPercentage;
	private JTextField txt_forfeitValue;
	private JTextField txt_consumptionValue;
	private JTextField txt_otherValues;
	private JTextField txt_interestValue;
	private JTextField txt_icmsPercentage;
	private JTextField txt_consumptionDays;
	private JTextField txt_supplyValue;
	private JTextField txt_meterNumber;
	private JTextField txt_icmsBasis;
	private JTextField txt_icmsValue;
	private JTextField txt_pisCofinsBasis;
	private JTextField txt_pisValue;
	private JTextField txt_cofinsValue;
	private JTextField txt_financialItems;
	private JTextField txt_amount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLightAccount frame = new ViewLightAccount();
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
	public ViewLightAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,223,214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(204,223,214));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 974, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
		);
		
		JPanel pnl_register = new JPanel();
		pnl_register.setBackground(new Color(204,223,214));
		tabbedPane.addTab("cadastro", null, pnl_register, null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		JLabel lbl_supplierCnpj = new JLabel("CNPJ do Fornecedor");
		lbl_supplierCnpj.setFont(new Font("Arial", Font.BOLD, 11));
		

		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##.###.###/####-##");
			txt_supplierCnpj = new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		txt_supplierCnpj.setForeground(Color.BLACK);
		txt_supplierCnpj.setColumns(10);
		lbl_supplierCnpj.setLabelFor(txt_supplierCnpj);
		
		JLabel lbl_currentDate = new JLabel("Leitura Atual");
		lbl_currentDate.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_currentDate = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/####");
			txt_currentDate = new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		lbl_currentDate.setLabelFor(txt_currentDate);
		txt_currentDate.setForeground(Color.BLACK);
		txt_currentDate.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_currentDate.setColumns(10);
		
		JLabel lbl_dueDate = new JLabel("Vencimento");
		lbl_dueDate.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_dueDate = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/####");
			txt_dueDate = new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		lbl_dueDate.setLabelFor(txt_dueDate);
		txt_dueDate.setForeground(Color.BLACK);
		txt_dueDate.setFont(new Font("Arial", Font.PLAIN, 11));
		txt_dueDate.setColumns(10);
		
		JLabel lbl_identCod = new JLabel("C\u00F3digo de Identifica\u00E7\u00E3o");
		lbl_identCod.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_identCod = new JTextField();
		lbl_identCod.setLabelFor(txt_identCod);
		txt_identCod.setColumns(10);
		
		JLabel lbl_invoice = new JLabel("N\u00FAmero da Nota Fiscal");
		lbl_invoice.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_invoice = new JTextField();
		lbl_invoice.setLabelFor(txt_invoice);
		txt_invoice.setColumns(10);
		
		JLabel lbl_flagType = new JLabel("Tipo de Bandeira");
		lbl_flagType.setFont(new Font("Arial", Font.BOLD, 11));
		
		JComboBox box_flagType = new JComboBox();
		lbl_flagType.setLabelFor(box_flagType);
		box_flagType.setModel(new DefaultComboBoxModel(new String[] {"<Selecione>", "Verde", "Amarela", "Vermelha 1", "Vermelha 2"}));
		
		JLabel lbl_consumptionValue = new JLabel("Consumo em kWh m\u00EAs");
		lbl_consumptionValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		JLabel lbl_pisPercentage = new JLabel("Al\u00EDquota PIS");
		lbl_pisPercentage.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_pisPercentage = new JTextField();
		lbl_pisPercentage.setLabelFor(txt_pisPercentage);
		txt_pisPercentage.setColumns(10);
		
		JLabel lbl_cofinsPercentage = new JLabel("Al\u00EDquota COFINS");
		lbl_cofinsPercentage.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_cofinsPercentage = new JTextField();
		lbl_cofinsPercentage.setLabelFor(txt_cofinsPercentage);
		txt_cofinsPercentage.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel lbl_forfeitValue = new JLabel("Multa(R$)");
		lbl_forfeitValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_forfeitValue = new JTextField();
		lbl_forfeitValue.setLabelFor(txt_forfeitValue);
		txt_forfeitValue.setColumns(10);
		
		txt_consumptionValue = new JTextField();
		lbl_consumptionValue.setLabelFor(txt_consumptionValue);
		txt_consumptionValue.setColumns(10);
		
		JPanel pnl_lightAccount = new JPanel();
		pnl_lightAccount.setBackground(new Color(95, 158, 160));
		
		JLabel lbl_lightAccount = new JLabel("CADASTRO CONTA - ENERGIA");
		lbl_lightAccount.setForeground(Color.WHITE);
		lbl_lightAccount.setFont(new Font("Arial", Font.BOLD, 12));
		pnl_lightAccount.add(lbl_lightAccount);
		
		JLabel lbl_otherValues = new JLabel("Outras Contribui\u00E7\u00F5es (R$)");
		lbl_otherValues.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_otherValues = new JTextField();
		lbl_otherValues.setLabelFor(txt_otherValues);
		txt_otherValues.setColumns(10);
		
		JLabel lbl_interestValue = new JLabel("Juros (R$)");
		lbl_interestValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_interestValue = new JTextField();
		lbl_interestValue.setLabelFor(txt_interestValue);
		txt_interestValue.setColumns(10);
		
		JLabel lbl_icmsPercentage = new JLabel("Al\u00EDquota ICMS");
		lbl_icmsPercentage.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_icmsPercentage = new JTextField();
		txt_icmsPercentage.setColumns(10);
		
		txt_meterNumber = new JTextField();
		txt_meterNumber.setColumns(10);
		
		JLabel lbl_meterNumber = new JLabel("N\u00FAmero de Instala\u00E7\u00E3o");
		lbl_meterNumber.setLabelFor(txt_meterNumber);
		lbl_meterNumber.setFont(new Font("Arial", Font.BOLD, 11));
		GroupLayout gl_pnl_register = new GroupLayout(pnl_register);
		gl_pnl_register.setHorizontalGroup(
			gl_pnl_register.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnl_register.createSequentialGroup()
					.addGap(323)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
							.addComponent(lbl_forfeitValue, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addComponent(txt_forfeitValue, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_otherValues, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_otherValues, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(pnl_lightAccount, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
							.addGap(732))
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(txt_supplierCnpj, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(714, Short.MAX_VALUE))
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(txt_invoice, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(313, Short.MAX_VALUE))
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnl_register.createSequentialGroup()
										.addComponent(txt_pisPercentage, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
									.addComponent(lbl_pisPercentage, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnl_register.createSequentialGroup()
										.addComponent(box_flagType, 0, 142, Short.MAX_VALUE)
										.addGap(15))
									.addComponent(lbl_flagType, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnl_register.createSequentialGroup()
										.addComponent(txt_currentDate, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
									.addComponent(lbl_currentDate, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbl_invoice, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbl_identCod, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbl_supplierCnpj, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbl_icmsPercentage, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addComponent(txt_icmsPercentage, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnl_register.createSequentialGroup()
									.addComponent(txt_identCod, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addGap(30)))
							.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnl_register.createSequentialGroup()
									.addGap(12)
									.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnl_register.createSequentialGroup()
											.addGap(10)
											.addComponent(txt_consumptionValue, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
											.addGap(731))
										.addGroup(gl_pnl_register.createSequentialGroup()
											.addGap(402)
											.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
										.addGroup(gl_pnl_register.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_pnl_register.createSequentialGroup()
													.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
														.addComponent(lbl_cofinsPercentage, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
														.addComponent(lbl_consumptionValue, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
														.addComponent(lbl_dueDate, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
													.addGap(732))
												.addGroup(gl_pnl_register.createSequentialGroup()
													.addComponent(txt_dueDate, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
													.addGap(731))))
										.addGroup(gl_pnl_register.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txt_interestValue, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_cofinsPercentage, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
												.addComponent(lbl_interestValue, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
											.addContainerGap(312, Short.MAX_VALUE))))
								.addGroup(gl_pnl_register.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_meterNumber, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_meterNumber, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
									.addContainerGap())))))
		);
		gl_pnl_register.setVerticalGroup(
			gl_pnl_register.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnl_register.createSequentialGroup()
					.addContainerGap()
					.addComponent(pnl_lightAccount, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_supplierCnpj, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt_supplierCnpj, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(lbl_identCod, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txt_identCod, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_invoice, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(lbl_meterNumber, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txt_meterNumber, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt_invoice, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_currentDate, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_dueDate, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_currentDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_dueDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_flagType, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_consumptionValue, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.BASELINE)
						.addComponent(box_flagType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_consumptionValue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_pisPercentage, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_cofinsPercentage, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_pisPercentage, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_cofinsPercentage, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(lbl_icmsPercentage, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(txt_icmsPercentage, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnl_register.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(lbl_forfeitValue, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
							.addGap(32))
						.addGroup(gl_pnl_register.createSequentialGroup()
							.addComponent(lbl_interestValue)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnl_register.createParallelGroup(Alignment.BASELINE)
								.addComponent(txt_forfeitValue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_interestValue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl_otherValues, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt_otherValues, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(42))
		);
		gl_pnl_register.linkSize(SwingConstants.HORIZONTAL, new Component[] {txt_pisPercentage, txt_forfeitValue});
		gl_pnl_register.linkSize(SwingConstants.HORIZONTAL, new Component[] {txt_supplierCnpj, txt_invoice, txt_otherValues});
		gl_pnl_register.linkSize(SwingConstants.HORIZONTAL, new Component[] {txt_cofinsPercentage, txt_interestValue});
		gl_pnl_register.linkSize(SwingConstants.HORIZONTAL, new Component[] {txt_currentDate, txt_identCod});
		pnl_register.setLayout(gl_pnl_register);
		
		JPanel pnl_resume = new JPanel();
		tabbedPane.addTab("resumo", null, pnl_resume, null);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204,223,214));
		GroupLayout gl_pnl_resume = new GroupLayout(pnl_resume);
		gl_pnl_resume.setHorizontalGroup(
			gl_pnl_resume.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 969, Short.MAX_VALUE)
		);
		gl_pnl_resume.setVerticalGroup(
			gl_pnl_resume.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		
		JLabel lblCadastroConta = new JLabel("RESUMO DA CONTA");
		lblCadastroConta.setForeground(Color.WHITE);
		lblCadastroConta.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblCadastroConta);
		
		JLabel lbl_consumptionDays = new JLabel("Dias de Consumo");
		lbl_consumptionDays.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_consumptionDays = new JTextField();
		lbl_consumptionDays.setLabelFor(txt_consumptionDays);
		txt_consumptionDays.setColumns(10);
		
		JLabel lbl_supplyValue = new JLabel("Valor Fornecimento (R$)");
		lbl_supplyValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_supplyValue = new JTextField();
		lbl_supplyValue.setLabelFor(txt_supplyValue);
		txt_supplyValue.setColumns(10);
		
		JLabel lbl_icmsBasis = new JLabel("Base C\u00E1lculo ICMS");
		lbl_icmsBasis.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_icmsBasis = new JTextField();
		lbl_icmsBasis.setLabelFor(txt_icmsBasis);
		txt_icmsBasis.setColumns(10);
		
		JLabel lbl_icmsValue = new JLabel("Valor ICMS (R$)");
		lbl_icmsValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_icmsValue = new JTextField();
		lbl_icmsValue.setLabelFor(txt_icmsValue);
		txt_icmsValue.setColumns(10);
		
		JLabel lbl_pisCofinsBasis = new JLabel("Base C\u00E1lculo PIS/COFINS");
		lbl_pisCofinsBasis.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_pisCofinsBasis = new JTextField();
		lbl_pisCofinsBasis.setLabelFor(txt_pisCofinsBasis);
		txt_pisCofinsBasis.setColumns(10);
		
		JLabel lbl_pisValue = new JLabel("Valor PIS (R$)");
		lbl_pisValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_pisValue = new JTextField();
		lbl_pisValue.setLabelFor(txt_pisValue);
		txt_pisValue.setColumns(10);
		
		JLabel lbl_cofinsValue = new JLabel("Valor COFINS (R$)");
		lbl_cofinsValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_cofinsValue = new JTextField();
		lbl_cofinsValue.setLabelFor(txt_cofinsValue);
		txt_cofinsValue.setColumns(10);
		
		JLabel lbl_financialItems = new JLabel("Itens Financeiros (R$)");
		lbl_financialItems.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_financialItems = new JTextField();
		lbl_financialItems.setLabelFor(txt_financialItems);
		txt_financialItems.setColumns(10);
		
		JLabel lbl_amount = new JLabel("Valor Total Fatura (R$)");
		lbl_amount.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_amount = new JTextField();
		lbl_amount.setLabelFor(txt_amount);
		txt_amount.setColumns(10);
		
		JButton btn_save = new JButton("SALVAR");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Integer identCod = Integer.parseInt(txt_identCod.getText());
				Integer consumptionDays = Integer.parseInt(txt_consumptionDays.getText());
				BigDecimal consumptionValue = new BigDecimal(txt_consumptionValue.getText());
				BigDecimal pisPercentage = new BigDecimal(txt_pisPercentage.getText());
				BigDecimal cofinsPercentage = new BigDecimal(txt_cofinsPercentage.getText());
				BigDecimal icmsBasis = new BigDecimal(txt_icmsBasis.getText());
				BigDecimal icmsPercentage = new BigDecimal(txt_icmsPercentage.getText());
				BigDecimal icmsValue = new BigDecimal(txt_icmsValue.getText());
				BigDecimal pisCofinsBasis = new BigDecimal(txt_pisCofinsBasis.getText());
				BigDecimal pisValue = new BigDecimal(txt_pisValue.getText());
				BigDecimal cofinsValue = new BigDecimal(txt_cofinsValue.getText());
				BigDecimal forfeitValue = new BigDecimal(txt_forfeitValue.getText());
				BigDecimal interestValue = new BigDecimal(txt_interestValue.getText());
				BigDecimal otherValues = new BigDecimal(txt_otherValues.getText());
				BigDecimal supplyValue = new BigDecimal(txt_supplyValue.getText());
				BigDecimal financialItems = new BigDecimal(txt_financialItems.getText());
				BigDecimal amount = new BigDecimal(txt_amount.getText());
				Integer user = Integer.parseInt(System.getProperty("UserID"));
				
				LightAccount teste = new LightAccount(identCod, Integer.parseInt(txt_meterNumber.getText()), txt_invoice.getText(), formataDados(txt_currentDate.getText()),
						formataDados(txt_dueDate.getText()), consumptionDays, box_flagType.getSelectedItem().toString(), consumptionValue,
						pisPercentage, cofinsPercentage, icmsBasis, icmsPercentage, icmsValue, pisCofinsBasis, pisValue,
						cofinsValue, forfeitValue, interestValue, otherValues, supplyValue, financialItems, amount,
						Long.parseLong(formataDados(txt_supplierCnpj.getText())), user, user);
				System.out.println(teste);
				
				LightAccountController.saveValues( identCod, Integer.parseInt(txt_meterNumber.getText()), txt_invoice.getText(), formataDados(txt_currentDate.getText()),
						formataDados(txt_dueDate.getText()), consumptionDays, box_flagType.getSelectedItem().toString(), consumptionValue,
						pisPercentage, cofinsPercentage, icmsBasis, icmsPercentage, icmsValue, pisCofinsBasis, pisValue,
						cofinsValue, forfeitValue, interestValue, otherValues, supplyValue, financialItems, amount,
						Long.parseLong(formataDados(txt_supplierCnpj.getText())), user, user);

				txt_identCod.setText("");
				txt_meterNumber.setText("");
				txt_invoice.setText("");
				txt_currentDate.setText("");
				txt_dueDate.setText("");
				txt_consumptionDays.setText("");
				box_flagType.setSelectedIndex(0);
				txt_consumptionValue.setText("");
				txt_pisPercentage.setText("");
				txt_cofinsPercentage.setText("");
				txt_icmsBasis.setText("");
				txt_icmsPercentage.setText("");
				txt_icmsValue.setText("");
				txt_pisCofinsBasis.setText("");
				txt_pisValue.setText("");
				txt_cofinsValue.setText("");
				txt_forfeitValue.setText("");
				txt_interestValue.setText("");
				txt_otherValues.setText("");
				txt_supplyValue.setText("");
				txt_financialItems.setText("");
				txt_amount.setText("");
				txt_supplierCnpj.setText("");
				
				}
		});
		btn_save.setFont(new Font("Arial", Font.BOLD, 11));
		btn_save.setMnemonic(KeyEvent.VK_S);
		
		JButton btn_back = new JButton("VOLTAR");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	                ViewMain viewMain = new ViewMain();
	                viewMain.setVisible(true);
	                setVisible(false);
	
			}
		});
		btn_back.setFont(new Font("Arial", Font.BOLD, 11));
		btn_back.setMnemonic(KeyEvent.VK_B);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(323)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbl_financialItems, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(lbl_amount, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lbl_pisValue, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(57)
							.addComponent(lbl_cofinsValue, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txt_pisValue, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(txt_cofinsValue, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lbl_icmsBasis, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(57)
								.addComponent(lbl_icmsValue, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txt_icmsBasis, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(txt_icmsValue, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lbl_consumptionDays, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addGap(57)
								.addComponent(lbl_supplyValue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txt_consumptionDays, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(txt_supplyValue, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(txt_pisCofinsBasis)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lbl_pisCofinsBasis, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(txt_financialItems, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addGap(34)
								.addComponent(txt_amount, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_consumptionDays, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_supplyValue, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_consumptionDays, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_supplyValue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_icmsBasis, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_icmsValue, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_icmsBasis, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_icmsValue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_pisCofinsBasis, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txt_pisCofinsBasis, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_pisValue, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_cofinsValue, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_pisValue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_cofinsValue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_financialItems, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_amount, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_financialItems, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_amount, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		panel.setLayout(gl_panel);
		pnl_resume.setLayout(gl_pnl_resume);
		contentPane.setLayout(gl_contentPane);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
	}
	
	//Func Trata Dados
	public static String formataDados(String dado){
		
		   return dado.replaceAll("[^0-9]+", "");
		}
}
