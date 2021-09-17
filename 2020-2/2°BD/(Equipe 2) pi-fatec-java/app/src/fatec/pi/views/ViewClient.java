package fatec.pi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fatec.pi.controllers.ClientController;
import fatec.pi.controllers.SupplierController;
import fatec.pi.daos.ClientDao;
import fatec.pi.services.CepAPI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class ViewClient extends JFrame {

	private JPanel contentPane;
	private JTextField txt_clientName;
	private JTextField txt_clientCpf;
	private JTextField txt_clientCpf_1;
	private JTextField txt_streetName;
	private JTextField txt_streetNumber;
	private JTextField txt_streetComplement;
	private JTextField txt_city;
	private JTextField txt_state;
	private JTextField txt_meterNumber;
	private JTextField txt_measurementOrder;
	private JTextField txt_normalTax;
	private JTextField txt_tributeTax;
	private JTextField txt_zipCode;
	private JTextField txt_supplierCnpj;
	private JTextField txt_neighborhood;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClient frame = new ViewClient();
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
	public ViewClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204,223,214));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204,223,214));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(224)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
					.addGap(252))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 758, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		
		JLabel lblCadastroCliente = new JLabel("CADASTRO CLIENTE");
		lblCadastroCliente.setForeground(Color.WHITE);
		lblCadastroCliente.setFont(new Font("Arial", Font.BOLD, 12));
		panel_1.add(lblCadastroCliente);
		
		JLabel lbl_cnpj = new JLabel("CNPJ - Fornecedora");
		lbl_cnpj.setFont(new Font("Arial", Font.BOLD, 11));
		
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##.###.###/####-##");
			txt_supplierCnpj= new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		txt_supplierCnpj.setForeground(Color.BLACK);
		txt_supplierCnpj.setColumns(10);
						
		JButton btnNewButton_searchcnpj = new JButton("");
		btnNewButton_searchcnpj.setIcon(new ImageIcon(ViewClient.class.getResource("/img/rsz_search-icon.png")));
		
		JLabel lbl_clientname = new JLabel("NOME");
		lbl_clientname.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_clientName = new JTextField();
		txt_clientName.setColumns(10);
		
		JLabel lbl_clientcnpjcpf = new JLabel("CPF do Cliente");
		lbl_clientcnpjcpf.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_clientCpf = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("###.###.###-##");
			txt_clientCpf_1 = new javax.swing.JFormattedTextField(format_textField3);
			} catch (Exception e){}
		txt_clientCpf_1.setForeground(Color.BLACK);
		txt_clientCpf_1.setColumns(10);
		
		JLabel lbl_zip = new JLabel("CEP");
		lbl_zip.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_zipCode = new JTextField();
		try {
			javax.swing.text.MaskFormatter cepMask = new javax.swing.text.MaskFormatter("##.###-###");
			txt_zipCode = new javax.swing.JFormattedTextField(cepMask);
		} catch (Exception e){}
		txt_zipCode.setColumns(10);
		
		JButton btnNewButton_searchcep = new JButton("");
		btnNewButton_searchcep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CepAPI adress = new CepAPI("", "", "", "");
				adress = adress.buscarCep(formataDados(txt_zipCode.getText()));
				txt_streetName.setText(adress.getLogradouro());
				txt_neighborhood.setText(adress.getBairro());
				txt_city.setText(adress.getCidade());
				txt_state.setText(adress.getUf());
				
			}
		});
		btnNewButton_searchcep.setIcon(new ImageIcon(ViewClient.class.getResource("/img/rsz_search-icon.png")));
		
		JLabel lbl_street = new JLabel("Logradouro");
		lbl_street.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_streetName = new JTextField();
		txt_streetName.setColumns(10);
		
		JLabel lbl_num = new JLabel("N\u00FAmero");
		lbl_num.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_streetNumber = new JTextField();
		txt_streetNumber.setColumns(10);
		
		JLabel lbl_adress = new JLabel("Complemento");
		lbl_adress.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_streetComplement = new JTextField();
		txt_streetComplement.setColumns(10);
		
		JLabel lbl_city = new JLabel("Cidade");
		lbl_city.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_city = new JTextField();
		txt_city.setColumns(10);
		
		JLabel lbl_state = new JLabel("UF");
		lbl_state.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_state = new JTextField();
		txt_state.setColumns(10);
		
		JLabel lbl_meterNumber = new JLabel("N\u00FAmero da Instalação");
		lbl_meterNumber.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_meterNumber = new JTextField();
		txt_meterNumber.setColumns(10);
		
		JLabel lbl_measurementOrder = new JLabel("Roteiro de Leitura");
		lbl_measurementOrder.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_measurementOrder = new JTextField();
		txt_measurementOrder.setColumns(10);
		
		JLabel lbl_class = new JLabel("Classe");
		lbl_class.setFont(new Font("Arial", Font.BOLD, 11));
		
		JLabel lbl_subclass = new JLabel("Subclasse");
		lbl_subclass.setFont(new Font("Arial", Font.BOLD, 11));
		
		JComboBox box_lightClass = new JComboBox();
		box_lightClass.setBackground(Color.WHITE);
		box_lightClass.addItem("-");
		box_lightClass.addItem("RESIDENCIAL");
		box_lightClass.addItem("INDUSTRIAL");
		box_lightClass.addItem("COMERCIAL");
		box_lightClass.addItem("RURAL");
		box_lightClass.addItem("PODER PUBLICO");
		
		
		JComboBox box_lightSubclass = new JComboBox();
		box_lightSubclass.setBackground(Color.WHITE);
		box_lightSubclass.addItem("-");
		box_lightSubclass.addItem("BAIXA RENDA");
		box_lightSubclass.addItem("BAIXA RENDA INDIGENA");
		box_lightSubclass.addItem("BAIXA RENDA BENEF�CIO PREST CONT");
		box_lightSubclass.addItem("BAIXA RENDA MULTIFAMILIAR");
		box_lightSubclass.addItem("SERVI�O DE TRANSPORTE");
		box_lightSubclass.addItem("SERVI�O DE COMUNICA��O");
		box_lightSubclass.addItem("ASSOCIA. FILANTR�PICA");
		box_lightSubclass.addItem("TEMPLOS RELIGIOSOS");
		box_lightSubclass.addItem("ADM CONDOMINIAL");
		box_lightSubclass.addItem("ILUMINA��O RODOVIAS");
		box_lightSubclass.addItem("SEM�FAROS, RADARES E CAMERAS");
		box_lightSubclass.addItem("AGROPECUARIA RURAL");
		box_lightSubclass.addItem("AGROPECUARIA URBANA");
		box_lightSubclass.addItem("RESIDENCIAL RURAL");
		box_lightSubclass.addItem("COOP DE ELETRIF. RURAL");
		box_lightSubclass.addItem("AGROINDUSTRIAL");
		box_lightSubclass.addItem("SERVIÇO PUBLI. IRRIGA��O RURAL");
		box_lightSubclass.addItem("ESCOLA AGROTECNICA");
		box_lightSubclass.addItem("AGRICULTURA");
		box_lightSubclass.addItem("ILUMINA��O PUBLICA");
		box_lightSubclass.addItem("SERVI�O PUBLICO");
		box_lightSubclass.addItem("CONSUMO PROPRIO");
		
		JLabel lbl_normalTax = new JLabel("Tarifa (R$)");
		lbl_normalTax.setFont(new Font("Arial", Font.BOLD, 11));
		
		JLabel lbl_tributeTax = new JLabel("Tarifa com Imposto (R$)");
		lbl_tributeTax.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_normalTax = new JTextField();
		txt_normalTax.setColumns(10);
		
		txt_tributeTax = new JTextField();
		txt_tributeTax.setColumns(10);
		
		JButton btn_save = new JButton("SALVAR");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				BigDecimal normalTax = new BigDecimal(txt_normalTax.getText());
				BigDecimal tributeTax = new BigDecimal(txt_tributeTax.getText());
				Integer meterNumber = Integer.parseInt(txt_streetNumber.getText());
				


				ClientController.saveValues(Long.parseLong(formataDados(txt_supplierCnpj.getText())), Long.parseLong(formataDados(txt_clientCpf_1.getText())), txt_clientName.getText(),

						formataDados(txt_zipCode.getText()), meterNumber, txt_streetName.getText(), txt_streetComplement.getText(),
						txt_city.getText(), txt_state.getText(), Integer.parseInt(txt_meterNumber.getText()), txt_measurementOrder.getText(),
						box_lightClass.getSelectedItem().toString(), box_lightSubclass.getSelectedItem().toString(),
						normalTax, tributeTax, Integer.parseInt(System.getProperty("UserID")), Integer.parseInt(System.getProperty("UserID")));
				txt_supplierCnpj.setText("");

				txt_clientName.setText("");
				txt_clientCpf_1.setText("");
				txt_zipCode.setText("");
				txt_streetName.setText("");
				txt_streetComplement.setText("");
				box_lightClass.setSelectedIndex(0);
				box_lightSubclass.setSelectedIndex(0);
				txt_normalTax.setText("");
				txt_tributeTax.setText("");
				txt_meterNumber.setText("");
				txt_city.setText("");
				txt_state.setText("");
				txt_measurementOrder.setText("");
				txt_streetNumber.setText("");
				txt_tributeTax.setText("");
				txt_neighborhood.setText("");
				
								
			}
		});
		btn_save.setFont(new Font("Arial", Font.BOLD, 13));
		btn_save.setMnemonic(KeyEvent.VK_S);
		
		JButton btn_back = new JButton("VOLTAR");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txt_clientCpf.getText());
				ViewMain voltamenu = new ViewMain();
				voltamenu.setVisible(true);
				setVisible(false);
			}
		});
		btn_back.setFont(new Font("Arial", Font.BOLD, 13));
		btn_back.setMnemonic(KeyEvent.VK_B);
		
		JLabel lbl_neighborhood = new JLabel("Bairro");
		lbl_neighborhood.setFont(new Font("Arial", Font.BOLD, 11));
		
		txt_neighborhood = new JTextField();
		txt_neighborhood.setColumns(10);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_normalTax, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_class, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(box_lightClass, 0, 149, Short.MAX_VALUE)
										.addComponent(txt_normalTax, 144, 144, 144))
									.addGap(36)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
												.addComponent(box_lightSubclass, 0, 149, Short.MAX_VALUE)
												.addComponent(lbl_tributeTax, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
												.addComponent(txt_tributeTax, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
												.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
											.addGap(59))
										.addComponent(lbl_subclass, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_measurementOrder, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_measurementOrder, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
									.addGap(60))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
										.addComponent(lbl_cnpj, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txt_supplierCnpj, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
											.addGap(10)
											.addComponent(btnNewButton_searchcnpj, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
											.addGap(1))
										.addComponent(lbl_clientname, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txt_clientName, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
											.addGap(1))
										.addComponent(lbl_clientcnpjcpf, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txt_clientCpf_1, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
											.addGap(1))
										.addComponent(lbl_zip, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txt_zipCode, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
											.addGap(6)
											.addComponent(btnNewButton_searchcep, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
											.addGap(5))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lbl_num, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addGap(77)
											.addComponent(lbl_adress, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txt_streetNumber, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
											.addGap(46)
											.addComponent(txt_streetComplement, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
											.addGap(1))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(lbl_city, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
											.addComponent(lbl_state, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
											.addGap(99))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txt_city, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txt_state, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
											.addGap(1))
										.addComponent(lbl_meterNumber, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txt_meterNumber, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
											.addGap(1))
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lbl_street, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_streetName, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
											.addGap(18)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lbl_neighborhood, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
												.addComponent(txt_neighborhood, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE))))
									.addGap(13)))
							.addGap(17)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lbl_cnpj)
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_supplierCnpj, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_searchcnpj, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(lbl_clientname)
					.addGap(6)
					.addComponent(txt_clientName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lbl_clientcnpjcpf)
					.addGap(6)
					.addComponent(txt_clientCpf_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lbl_zip)
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_zipCode, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_searchcep, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_street)
						.addComponent(lbl_neighborhood))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txt_streetName, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_neighborhood, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_num)
						.addComponent(lbl_adress))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_streetNumber, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_streetComplement, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_city)
						.addComponent(lbl_state))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txt_city, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lbl_meterNumber))
						.addComponent(txt_state, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addComponent(txt_meterNumber, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl_measurementOrder)
					.addGap(6)
					.addComponent(txt_measurementOrder, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_class)
						.addComponent(lbl_subclass))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(box_lightClass, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(box_lightSubclass, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_normalTax)
						.addComponent(lbl_tributeTax))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txt_normalTax, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_tributeTax, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_save, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_back, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	//Func Trata Dados
	public static String formataDados(String dado){
		
		   return dado.replaceAll("[^0-9]+", "");
		}
}