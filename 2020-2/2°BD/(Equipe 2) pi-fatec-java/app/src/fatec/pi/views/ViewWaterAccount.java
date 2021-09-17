package fatec.pi.views;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fatec.pi.controllers.WaterAccountController;
import fatec.pi.daos.WaterAccountDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class ViewWaterAccount extends JFrame {

	private JPanel contentPane;
	private JTextField text_numhidro;
	private JTextField text_dateleitura;
	private JTextField text_dateleitura_1;
	private JTextField text_datevencimento;
	private JTextField text_datevencimento_1;
	private JTextField text_consumo;
	private JTextField text_watervalue;
	private JTextField text_sewervalue;
	private JTextField text_pollution;
	private JTextField text_PISCOFINS;
	private JTextField text_othervalue;
	private JTextField text_SupplierCnpj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWaterAccount frame = new ViewWaterAccount();
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
	public ViewWaterAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,223,214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		
		JLabel lblCadastroConta = new JLabel("CADASTRO CONTA - \u00C1GUA");
		lblCadastroConta.setForeground(Color.WHITE);
		lblCadastroConta.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(lblCadastroConta);
		
		JLabel lbl_hNumber = new JLabel("N\u00FAmero de Instala\u00E7\u00E3o (Hidr\u00F4metro)");
		lbl_hNumber.setFont(new Font("Arial", Font.BOLD, 11));
		
		text_numhidro = new JTextField();
		text_numhidro.setColumns(10);
		
		text_dateleitura = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/####");
			text_dateleitura_1 = new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		text_dateleitura_1.setForeground(Color.BLACK);
		text_dateleitura_1.setFont(new Font("Arial", Font.PLAIN, 11));
		text_dateleitura_1.setColumns(10);
		
		JLabel lbl_dueDate = new JLabel("Leitura Atual");
		lbl_dueDate.setFont(new Font("Arial", Font.BOLD, 11));
		
		JLabel lbl_pDate = new JLabel("Vencimento");
		lbl_pDate.setFont(new Font("Arial", Font.BOLD, 11));
		
		text_datevencimento = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/####");
			text_datevencimento_1 = new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		text_datevencimento_1.setForeground(Color.BLACK);
		text_datevencimento_1.setFont(new Font("Arial", Font.PLAIN, 11));
		text_datevencimento_1.setColumns(10);
		
		JLabel lbl_consumption = new JLabel("Consumo (m\u00B3)");
		lbl_consumption.setFont(new Font("Arial", Font.BOLD, 11));
		
		text_consumo = new JTextField();
		text_consumo.setColumns(10);
		
		JLabel lbl_waterValue = new JLabel("Valor \u00C1gua (R$)");
		lbl_waterValue.setFont(new Font("Arial", Font.BOLD, 11));
		
		text_watervalue = new JTextField();
		text_watervalue.setColumns(10);
		
		text_sewervalue = new JTextField();
		text_sewervalue.setColumns(10);
		
		JLabel lbl_pollution = new JLabel("Fator Polui\u00E7\u00E3o (R$)");
		lbl_pollution.setFont(new Font("Arial", Font.BOLD, 11));
		
		text_pollution = new JTextField();
		text_pollution.setColumns(10);
		
		JLabel lbl_sewer = new JLabel("Valor Esgoto (R$)");
		lbl_sewer.setFont(new Font("Arial", Font.BOLD, 11));
		
		JLabel lb_PIS_COFINS = new JLabel("Al\u00EDquota PIS/COFINS (%)");
		lb_PIS_COFINS.setFont(new Font("Arial", Font.BOLD, 11));
		
		text_PISCOFINS = new JTextField();
		text_PISCOFINS.setColumns(10);
		
		JLabel lbl_other = new JLabel("Outros (R$)");
		lbl_other.setFont(new Font("Arial", Font.BOLD, 11));
		
		text_othervalue = new JTextField();
		text_othervalue.setColumns(10);
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Integer teste = 0;
				
				WaterAccountController.saveValues(Integer.parseInt(text_numhidro.getText()),
						text_datevencimento.getText(), 
						new BigDecimal(teste), new BigDecimal(text_consumo.getText()),
						new BigDecimal(text_pollution.getText()),
						new BigDecimal (text_sewervalue.getText()),
						new BigDecimal (text_watervalue.getText()),
						Integer.parseInt(text_PISCOFINS.getText()),
						new BigDecimal (text_othervalue.getText()),
						Long.parseLong(formataDados(text_SupplierCnpj.getText())), Integer.parseInt(System.getProperty("UserID")), 
						Integer.parseInt(System.getProperty("UserID")));
				
				text_numhidro.setText("");
				text_dateleitura.setText("");
				text_datevencimento.setText("");
				text_consumo.setText("");
				text_watervalue.setText("");
				text_sewervalue.setText("");
				text_pollution.setText("");
				text_PISCOFINS.setText("");
				text_othervalue.setText("");
				text_SupplierCnpj.setText("");
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setMnemonic(KeyEvent.VK_S);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMain voltamenu = new ViewMain();
				voltamenu.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 11));
		btnVoltar.setMnemonic(KeyEvent.VK_B);
		
		JLabel lbl_Supplier = new JLabel("CNPJ do Fornecedor");
		lbl_Supplier.setFont(new Font("Arial", Font.BOLD, 11));
		

		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##.###.###/####-##");
			text_SupplierCnpj = new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		text_SupplierCnpj.setForeground(Color.BLACK);
		text_SupplierCnpj.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(331)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(text_SupplierCnpj, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lbl_Supplier, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
											.addGap(92)
											.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lb_PIS_COFINS, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(text_PISCOFINS, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
												.addGap(33)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addComponent(text_othervalue, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
													.addComponent(lbl_other, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lbl_sewer, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
													.addGap(56)
													.addComponent(lbl_pollution, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(text_sewervalue, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
													.addGap(33)
													.addComponent(text_pollution, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lbl_consumption, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
														.addGap(56)
														.addComponent(lbl_waterValue, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(text_consumo, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
														.addGap(33)
														.addComponent(text_watervalue, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
													.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addComponent(lbl_dueDate, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
															.addComponent(text_dateleitura_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
															.addComponent(lbl_pDate, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
															.addComponent(text_datevencimento_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)))
													.addComponent(text_numhidro, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
													.addComponent(lbl_hNumber, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)))))
									.addGap(320))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl_Supplier)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(text_SupplierCnpj, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(lbl_hNumber)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(text_numhidro, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbl_dueDate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(text_dateleitura_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbl_pDate)
							.addGap(6)
							.addComponent(text_datevencimento_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_consumption)
						.addComponent(lbl_waterValue))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(text_consumo, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_watervalue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_pollution)
						.addComponent(lbl_sewer))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(text_sewervalue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_pollution, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lb_PIS_COFINS)
						.addComponent(lbl_other))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(text_PISCOFINS, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(text_othervalue, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(btnVoltar))
					.addGap(62))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//Func Trata Dados
	public static String formataDados(String dado){
		
		   return dado.replaceAll("[^0-9]+", "");
		}
}