package fatec.pi.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import fatec.pi.controllers.LightAccountController;
import fatec.pi.entities.Client;
import fatec.pi.entities.LightAccount;
import fatec.pi.controllers.ClientController;
import fatec.pi.controllers.SupplierController;


import fatec.pi.controllers.WaterAccountController;

import fatec.pi.entities.Supplier;
import fatec.pi.entities.WaterAccount;
import fatec.pi.entities.Client;
import fatec.pi.services.TableColumnAdjuster;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class ViewSearch extends JFrame {

	private JPanel contentPane;
	Color fundo = new Color(204, 223,214);
	Color text  = new Color(218,218,217);
	Color botao  = new Color(156,183,170);
	Color jpanel = new Color(95, 158, 160);
	private JTextField txtPesquisa;
	private JTextField textFieldCNPJ;
	private JTextField textFieldCNPJ_1;
	private JTextField textFieldCPF;
	private JTextField textFieldCPF_1;
	private JTextField textField_Account;
	private JTextField textFieldNOME;
	private DefaultTableModel dtm = new DefaultTableModel();;
	private JTable table_data;
	private String type = "";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSearch frame = new ViewSearch();
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
	public ViewSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(fundo);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPesquisa = new JTextField();
		txtPesquisa.setBounds(209, 46, 524, 38);
		txtPesquisa.setEditable(false);
		txtPesquisa.setHorizontalAlignment(SwingConstants.CENTER);
		txtPesquisa.setText("Pesquisa ");
		txtPesquisa.setForeground(Color.WHITE);
		txtPesquisa.setBackground(jpanel);
		txtPesquisa.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		JLabel LabelCNPJ = new JLabel("CNPJ");
		LabelCNPJ.setBounds(308, 140, 94, 25);
		contentPane.add(LabelCNPJ);
		
		textFieldCNPJ = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##.###.###/####-##");
			textFieldCNPJ_1= new javax.swing.JFormattedTextField(format_textField3);
			textFieldCNPJ_1.setBounds(407, 140, 192, 25);
			} catch (Exception e){}
		contentPane.add(textFieldCNPJ_1);
		textFieldCNPJ_1.setColumns(10);
		
		JComboBox comboBoxConta = new JComboBox();
		comboBoxConta.setBounds(407, 245, 94, 20);
		comboBoxConta.setModel(new DefaultComboBoxModel(new String[] {"\u00C1gua", "Luz"}));
		contentPane.add(comboBoxConta);
		
		
		JLabel LabelTipodeConta = new JLabel("Tipo de conta");
		LabelTipodeConta.setBounds(308, 247, 94, 17);
		contentPane.add(LabelTipodeConta);
		
		JLabel LabelLogo = new JLabel("");
		LabelLogo.setBounds(473, 689, 126, 71);
		LabelLogo.setIcon(new ImageIcon(ViewSearch.class.getResource("/img/rsz_poc_verde.png")));
		contentPane.add(LabelLogo);
		
		JComboBox comboBoxBusca = new JComboBox();
		comboBoxBusca.setBounds(407, 109, 94, 20);
		comboBoxBusca.setModel(new DefaultComboBoxModel(new String[] {"Cliente", "Conta", "Fornecedor"}));
		contentPane.add(comboBoxBusca);
		

		JScrollPane scrollPane_table = new JScrollPane();
		scrollPane_table.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_table.setBounds(209, 378, 524, 220);
		contentPane.add(scrollPane_table);
		
		table_data = new JTable();
		scrollPane_table.setViewportView(table_data);
		JScrollPane forTable = new JScrollPane();
		getContentPane().add(forTable);
		table_data.setModel(dtm);
		table_data.setBounds(297, 393, 476, 203);
		table_data.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumnAdjuster tca = new TableColumnAdjuster(table_data);
		DefaultTableModel modelo = (DefaultTableModel) table_data.getModel();
		
		JButton btnRelatorio = new JButton("Gerar Relat\u00F3rio");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRelatorio.setBounds(209, 621, 151, 23);
		contentPane.add(btnRelatorio);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewMain voltamenu = new ViewMain();
				voltamenu.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(582, 621, 151, 23);
		contentPane.add(btnVoltar);
		
		textFieldNOME = new JTextField();
		textFieldNOME.setBounds(407, 212, 192, 25);
		textFieldNOME.setColumns(10);
		contentPane.add(textFieldNOME);		
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(308, 176, 94, 25);
		contentPane.add(lblCpf);
		
		textFieldCPF = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("###.###.###.-##");
			textFieldCPF_1 = new javax.swing.JFormattedTextField(format_textField3);
			textFieldCPF_1.setBounds(407, 176, 192, 25);
			} catch (Exception e){}
		textFieldCPF_1.setColumns(10);
		contentPane.add(textFieldCPF_1);
		

		JLabel lblAccount = new JLabel("Número de Instalação");
		lblAccount.setBounds(263, 212, 135, 25);
		contentPane.add(lblAccount);


		JLabel LabelBusca = new JLabel("Buscar por");
		LabelBusca.setBounds(308, 109, 74, 20);
		contentPane.add(LabelBusca);
		

		JButton btnPesquisa = new JButton("Pesquisar");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modelo.setNumRows(0);
				type = comboBoxBusca.getSelectedItem().toString();
				String accountType = comboBoxConta.getSelectedItem().toString(); 
				String cnpj = formataDados(textFieldCNPJ_1.getText());
				String installation = textFieldNOME.getText();
				String identCod = textFieldNOME.getText();
				System.out.println(installation);
				dtm.setColumnIdentifiers(searchTitles(type, accountType));
				String clientCpf = formataDados(textFieldCPF_1.getText());
				searchResult(modelo, type, cnpj, clientCpf, installation, accountType, identCod);
				tca.adjustColumns();
				textFieldCNPJ_1.setText("");
				textFieldCPF_1.setText("");
				textFieldNOME.setText("");

				
			}
		});
		btnPesquisa.setBounds(625, 344, 108, 23);
		contentPane.add(btnPesquisa);
		


		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String accountType = comboBoxConta.getSelectedItem().toString();
				updateData(table_data, modelo, type, accountType);
			}
		});
		btnUpdate.setBounds(402, 621, 151, 23);
		contentPane.add(btnUpdate);
		

		

	}
	//Func Trata Dados
		public static String formataDados(String dado){
			
			   return dado.replaceAll("[^0-9]+", "");
			}
		

	
		public static String[] searchTitles(String search, String accountType) {

			String[] result = {"", "", "", "", ""};
			if(search.equals("Fornecedor")) {
				result = new String[]{"ID", "CNPJ", "NAME", "SITE", "TYPE"};
			}


			else if (search.equals("Cliente")) {
				result = new String[]{"ID","SUPPLIER CNPJ", "CPF", "NAME", "ZIP COD", "STREET NAME", "STREET NUMBER", "STREET COMPLEMENT", "CITY", "STATE",
						"METER NUMBER", "MEASUREMENT ORDER", "LIGHT CLASS ", "LIGHT SUBCLASS", "NORMAL TAX", "TRIBUTE TAX "};
			}
			else if (search.equals("Conta")) { // CONTA AGUA e LUZ

				if(accountType.equals("Luz")) {
					result = new String[]{"ID", "IDENT COD", "METERNUMBER", "INVOICE", "CURRENT DATE","DUE DATE","CONSUMPTION DAYS", "FLAG TYPE","CONSUMPTION VALUE","PIS PERCENTAGE","COFINS PERCENTAGE",
							"ICMS BASIS","ICMS PERCENTAGE","ICMS VALUE","PIS COFINS BASIS","PIS VALUE","COFINS VALUE","FORFEIT VALUE","INTEREST VALUE", "OTHER VALUES", "SUPPLY VALUES","FINANCIAL ITEMS", "ACCOUNT AMOUNT", "SUPPLIER CNPJ"};
				}
				
				else {
					result = new String[]{"ID", "NUMBER", "DUA DATE", "PENALTY", "CONSUMPTION", "POLLUTION", "SEWER", "WATER", "PIS", "OTHERS","SUPPLIER CNPJ"};
				}
				
			}


			return result;
		}


		//search

		public static void searchResult(DefaultTableModel table, String type, String cnpj, String clientCpf, String installation, String accountType, String identCod) {


			if(type.equals("Fornecedor")) {
				List<Supplier> sup = SupplierController.getValues(cnpj);
				for(Supplier sp: sup) {
					table.addRow(new Object[] {
							sp.getId(),
							sp.getCnpj(),
							sp.getName(),
							sp.getSite(),
							sp.toType()
					});
				}
			}
			else if (type.equals("Conta")) {
				if (accountType.equals("Luz")) {
				List <LightAccount> lgh = LightAccountController.getValues(identCod);
				for(LightAccount la: lgh) {
					table.addRow(new Object[] {
							la.getId(),
							la.getIdentCod(),
							la.getMeterNumber(),
							la.getInvoice(),
							la.getCurrentDate(),
							la.getDueDate(),
							la.getConsumptionDays(),
							la.getFlagType(),
							la.getConsumptionValue(),
							la.getPisPercentage(),
							la.getCofinsPercentage(),
							la.getIcmsBasis(),
							la.getIcmsPercentage(),
							la.getIcmsValue(),
							la.getPisCofinsBasis(),
							la.getPisValue(),
							la.getCofinsValue(),
							la.getForfeitValue(),
							la.getInterestValue(),
							la.getOtherValues(),
							la.getSupplyValue(),
							la.getFinancialItems(),
							la.getAmount(),
							la.getSupplierCnpj(),
							
					});
				}
			}
				else if(accountType.equals("Água")) {
					List<WaterAccount> wtr = WaterAccountController.getValues(installation);
					for(WaterAccount wt: wtr) {
						table.addRow(new Object[] {
							wt.getId(),
							wt.getNumber(),
							wt.getDueDate(),
							wt.getPenalty(),
							wt.getConsumptionValue(),
							wt.getPollutionValue(),
							wt.getSewerValue(),
							wt.getWaterValue(),
							wt.getPisPercentage(),
							wt.getOtherValues(),
							wt.getSupplierCnpj()
						});
					}
				}
			}
			else if(type.contentEquals("Cliente")) {
					List<Client> clt = ClientController.getValues(clientCpf);
					for(Client cl: clt) {
						table.addRow(new Object[] {
							cl.getId(),
							cl.getSupplierCnpj(),
							cl.getClientCpf(),
							cl.getClientName(),
							cl.getZipCode(),
							cl.getStreetName(),
							cl.getStreetNumber(),
							cl.getStreetComplement(),
							cl.getCity(),
							cl.getState(),
							cl.getMeterNumber(),
							cl.getMeasurementOrder(),
							cl.getLightClass(),
							cl.getLightSubclass(),
							cl.getNormalTax(),
							cl.getTributeTax()
						
							
					});
				}		
			}
	}


        
		//update
		public static void updateData(JTable table, DefaultTableModel modelTable, String type, String accountType){
		
			Integer row = table.getSelectedRow();
			String rowValues = modelTable.getDataVector().elementAt(row).toString();
			rowValues = rowValues.replaceAll("\\[", "");
			rowValues = rowValues.replaceAll("\\]", "");
			String[] objectValues = rowValues.split(", ");
			
			if(type.equals("Fornecedor")) {
				Integer supType = 3;
				if(objectValues[4].equals("Energia")) {
					supType = 0;
				}

				else if (objectValues[4].equals("Água")) {
					supType = 1;
				}
				Supplier sup = new Supplier(Integer.parseInt(objectValues[0]),Long.parseLong(objectValues[1]), objectValues[2], objectValues[3], supType, Integer.parseInt(System.getProperty("UserID")));
				SupplierController.updateValues(sup);
				
			} else if (type.equals("Cliente")) {
				BigDecimal normalTax = new BigDecimal(objectValues[14]);
				BigDecimal tributeTax = new BigDecimal(objectValues[15]);
				
				Client clt = new Client(Integer.parseInt(objectValues[0]), Long.parseLong(objectValues[1]),Long.parseLong(objectValues[2]), objectValues[3], objectValues[4], objectValues[5],
						Integer.parseInt(objectValues[6]), objectValues[7], objectValues[8], objectValues[9], Integer.parseInt(objectValues[10]), objectValues[11], objectValues[12], objectValues[13], 
						normalTax, tributeTax, Integer.parseInt(System.getProperty("UserID")));
				ClientController.updateValues(clt);
				
			}
			
			else if(type.equals("Conta")) {
				if(accountType.equals("Água")) {
					BigDecimal penalty = new BigDecimal(objectValues[3]); 
					BigDecimal consumptionValue = new BigDecimal(objectValues[4]);
					BigDecimal pollutionValue = new BigDecimal(objectValues[5]);
					BigDecimal sewerValue = new BigDecimal(objectValues[6]); 
					BigDecimal waterValue = new BigDecimal(objectValues[7]);
					BigDecimal otherValues = new BigDecimal(objectValues[9]);
					WaterAccount nWaterAccount = new WaterAccount(Integer.parseInt(objectValues[0]), Integer.parseInt(objectValues[1]), objectValues[2], penalty, consumptionValue, pollutionValue, sewerValue, waterValue, Integer.parseInt(objectValues[8]),
							otherValues, Long.parseLong(objectValues[10]), Integer.parseInt(System.getProperty("UserID")));
					WaterAccountController.updateValues(nWaterAccount);
					
				}else if (accountType.equals("Luz")){
					  
					BigDecimal consumptionValue = new BigDecimal(objectValues[8]);
					BigDecimal pisPercentage = new BigDecimal(objectValues[9]);
					BigDecimal cofinsPercentage = new BigDecimal(objectValues[10]);
					BigDecimal icmsBasis = new BigDecimal(objectValues[11]);
					BigDecimal icmsPercentage = new BigDecimal(objectValues[12]);
					BigDecimal icmsValue = new BigDecimal(objectValues[13]);
					BigDecimal pisCofinsBasis = new BigDecimal(objectValues[14]);
					BigDecimal pisValue = new BigDecimal(objectValues[15]);
					BigDecimal cofinsValue = new BigDecimal(objectValues[16]);
					BigDecimal forfeitValue = new BigDecimal(objectValues[17]);
					BigDecimal interestValue = new BigDecimal(objectValues[18]);
					BigDecimal otherValues = new BigDecimal(objectValues[19]);
					BigDecimal supplyValue = new BigDecimal(objectValues[20]);
					BigDecimal financialItems = new BigDecimal(objectValues[21]);
					BigDecimal amount = new BigDecimal(objectValues[22]);
					
					
					LightAccount nlight = new LightAccount (Integer.parseInt(objectValues[0]),Integer.parseInt(objectValues[1]), Integer.parseInt(objectValues[2]), objectValues[3], objectValues[4],
							objectValues[5],Integer.parseInt(objectValues[6]),objectValues[7], consumptionValue,pisPercentage,cofinsPercentage,icmsBasis,icmsPercentage,icmsValue,
							pisCofinsBasis,pisValue,cofinsValue,forfeitValue,interestValue,otherValues,supplyValue,financialItems,amount, Long.parseLong(objectValues[23]),
							Integer.parseInt(System.getProperty("UserID")));
					LightAccountController.updateValues(nlight);
				}

			}
			
			else if(type.equals("Conta")) {
				if(accountType.equals("Água")) {
					BigDecimal penalty = new BigDecimal(objectValues[3]); 
					BigDecimal consumptionValue = new BigDecimal(objectValues[4]);
					BigDecimal pollutionValue = new BigDecimal(objectValues[5]);
					BigDecimal sewerValue = new BigDecimal(objectValues[6]); 
					BigDecimal waterValue = new BigDecimal(objectValues[7]);
					BigDecimal otherValues = new BigDecimal(objectValues[9]);
					WaterAccount nWaterAccount = new WaterAccount(Integer.parseInt(objectValues[0]), Integer.parseInt(objectValues[1]), objectValues[2], penalty, consumptionValue, pollutionValue, sewerValue, waterValue, Integer.parseInt(objectValues[8]),
							otherValues, Long.parseLong(objectValues[10]), Integer.parseInt(System.getProperty("UserID")));
					WaterAccountController.updateValues(nWaterAccount);
				}
				
			}
		}
	}	


