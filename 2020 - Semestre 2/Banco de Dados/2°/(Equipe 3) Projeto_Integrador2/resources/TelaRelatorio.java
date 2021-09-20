//baixar o zip do swingX no link: http://www.java2s.com/Code/Jar/s/Downloadswingxall164jar.htm
//extrair o jar
//adicionar o jar no eclipse 
//(eu adicionei pelo JRE System Library, do mesmo jeito q adicionei o jar da conexão com o BD)

package source;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;



public class TelaRelatorio extends JFrame {
	private ArrayList lista_cliente;
	private ArrayList conta_agua_id;
	private ArrayList conta_agua_rgi;
	private ArrayList ref_agua_rgi;
	private ArrayList ref_agua_mes;
	private ArrayList ref_agua_consumo;
	private ArrayList ref_agua_venc;
	private ArrayList ref_agua_numero;
	private ArrayList conta_luz_id;
	private ArrayList conta_luz_instalacao;
	private ArrayList ref_luz_instalacao;
	private ArrayList ref_luz_mes;
	private ArrayList ref_luz_consumo;
	private ArrayList ref_luz_venc;
	private ArrayList consumo;
	private ArrayList vencimento;
	private ArrayList cidade;
	private ArrayList digitador;
	private ArrayList total;
	private ArrayList tarifa;
	private ArrayList pis;
	private ArrayList icms;
	private ArrayList confins;
	private ArrayList rua;
	private ArrayList cep;
	private String rgi;

	private String conta;
	
	
	private JPanel Panel_cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setTitle("Relatório");
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		
		JPanel Panel_main = new JPanel();
		Panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_main);
		Panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel_main.getLayout());
		
		
		
		
		
		//tela "relatorio cliente"
		Panel_cliente = new JPanel();
		Panel_main.add(Panel_cliente, "1");
		Panel_cliente.setLayout(null);
		cl.show(Panel_main, "1");
		
		JLabel Lcliente = new JLabel("Nome do Cliente:");
		Lcliente.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lcliente.setBounds(20, 10, 167, 27);
		Panel_cliente.add(Lcliente);	    
		
		JLabel Ltotal = new JLabel("Valor Total:");
	    Ltotal.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Ltotal.setBounds(320, 260, 204, 27);
	    Panel_cliente.add(Ltotal);
	    
	    JLabel Lrgi = new JLabel("RGI/Instala\u00E7\u00E3o:");
		Lrgi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lrgi.setBounds(43, 209, 204, 27);
		Panel_cliente.add(Lrgi);
		
		JLabel Lconsumo = new JLabel("Consumo:");
		Lconsumo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lconsumo.setBounds(44, 260, 167, 27);
		Panel_cliente.add(Lconsumo);
		
		JLabel Lvenc = new JLabel("Vencimento:");
		Lvenc.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lvenc.setBounds(320, 209, 239, 27);
		Panel_cliente.add(Lvenc);
		
		JLabel Lcidade = new JLabel("Cidade:");
		Lcidade.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lcidade.setBounds(43, 314, 215, 27);
		Panel_cliente.add(Lcidade);
		
		JLabel Ldigitador = new JLabel("Digitador:");
		Ldigitador.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Ldigitador.setBounds(320, 314, 215, 27);
		Panel_cliente.add(Ldigitador);
		
		AutoCompleteDecorator decorator;
	    JComboBox combobox_cliente;
	    //cria arraylist com o get, da coluna "cliente" e "rgi"
		lista_cliente = new ArrayList();
		conta_agua_id = new ArrayList();
		conta_agua_rgi = new ArrayList();
		ref_agua_rgi = new ArrayList();
		ref_agua_mes = new ArrayList();
		ref_agua_consumo = new ArrayList();
		ref_agua_venc = new ArrayList();
		conta_luz_id = new ArrayList();
		conta_luz_instalacao = new ArrayList();
		ref_luz_instalacao = new ArrayList();
		ref_luz_mes = new ArrayList();
		ref_luz_consumo = new ArrayList();
		ref_luz_venc = new ArrayList();
	    try {
			lista_cliente = get("cliente", "nome_cli");	   
			conta_agua_id = get("conta_agua", "id_local");
			conta_agua_rgi = get("conta_agua", "rgi");
			ref_agua_rgi = get("ref_agua", "rgi");
			ref_agua_mes = get("ref_agua", "mes");
			ref_agua_consumo = get("ref_agua", "consumo");
			ref_agua_venc = get("ref_agua", "vencimento");
			conta_luz_id = get("conta_luz", "id_local");
			conta_luz_instalacao = get("conta_luz", "instalacao");
			ref_luz_instalacao = get("ref_luz", "instalacao");
			ref_luz_mes = get("ref_luz", "mes");
			ref_luz_consumo = get("ref_luz", "consumo");
			ref_luz_venc = get("ref_luz", "vencimento");
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    combobox_cliente = new JComboBox();
	    combobox_cliente.addItem(""); //combobox.addItem("abacate"); combobox.addItem("abacaxi"); combobox.addItem("amarelo"); combobox.addItem("amanda"); combobox.addItem("amor");
	    //adiciona cada item do arraylist no combobox}
	    for (int i = 0; i < lista_cliente.size(); i++) {
	    	combobox_cliente.addItem(lista_cliente.get(i));
	    }
	    combobox_cliente.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    AutoCompleteDecorator.decorate(combobox_cliente);
	    combobox_cliente.setBounds(20, 40, 510, 39);
	    Panel_cliente.add(combobox_cliente);	    
	    //evento que ocorre quando a combobox muda
	    combobox_cliente.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {
	   		
	    	}
	    });
	    
	    JLabel Lmes = new JLabel("M\u00EAs da conta:");
	    Lmes.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Lmes.setBounds(20, 95, 167, 27);
	    Panel_cliente.add(Lmes);
	    
	    String[] meses = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	    JComboBox combobox_mes = new JComboBox(meses);
	    combobox_mes.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    combobox_mes.setBounds(20, 125, 174, 39);
	    Panel_cliente.add(combobox_mes);
	    AutoCompleteDecorator.decorate(combobox_mes);
	    
	    JRadioButton Ragua = new JRadioButton("\u00C1gua");
		Ragua.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				conta = "agua";
			}
		});
	    Ragua.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Ragua.setBounds(292, 130, 91, 35);
	    Panel_cliente.add(Ragua);
	    
	    JRadioButton Rluz = new JRadioButton("Luz");
	    Rluz.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				conta = "luz";
			}
		});
	    Rluz.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Rluz.setBounds(416, 130, 91, 35);
	    Panel_cliente.add(Rluz);
	    
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(Ragua);
		buttongroup.add(Rluz);
		
		JButton Bver = new JButton("Ver");
		Bver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Lrgi.setText("RGI/Instalação:");
				Lconsumo.setText("Consumo:");
				Lvenc.setText("Vencimento:");
				Ltotal.setText("Valor Total:");
				Ldigitador.setText("Digitador:");
				Lcidade.setText("Cidade:");
				if (conta.equals("agua")) {
					if (conta_agua_id.contains(String.valueOf(combobox_cliente.getSelectedIndex()))) {
						int id = conta_agua_id.indexOf(String.valueOf(combobox_cliente.getSelectedIndex()));
						rgi = String.valueOf(conta_agua_rgi.get(id));
						System.out.print(ref_agua_rgi.indexOf(rgi));
						try {
							consumo = new ArrayList(getWhere("ref_agua", "rgi", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "consumo"));
							vencimento = new ArrayList(getWhere("ref_agua", "rgi", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "vencimento"));
							total = new ArrayList(getWhere("ref_agua", "rgi", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "total"));
							digitador = new ArrayList(getWhere("ref_agua", "rgi", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "digitador"));
							cidade = new ArrayList(getCidade(String.valueOf(combobox_cliente.getSelectedIndex()), "cidade"));
							rua = new ArrayList(getCidade(String.valueOf(combobox_cliente.getSelectedIndex()), "endereco"));
							cep = new ArrayList(getCidade(String.valueOf(combobox_cliente.getSelectedIndex()), "cep"));
							Lrgi.setText("RGI: " + rgi);
							Lcidade.setText("Cidade: " + String.valueOf(cidade.get(0)));
							Lconsumo.setText("Consumo: " + String.valueOf(consumo.get(0)));
							Lvenc.setText("Vencimento: " + String.valueOf(vencimento.get(0)));
							Ltotal.setText("Total:" + String.valueOf(total.get(0)));
							Ldigitador.setText("Digitador: " + String.valueOf(digitador.get(0)));
							
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				else if (conta.equals("luz")) {
					if (conta_luz_id.contains(String.valueOf(combobox_cliente.getSelectedIndex()))) {
						int id = conta_luz_id.indexOf(String.valueOf(combobox_cliente.getSelectedIndex()));
						rgi = String.valueOf(conta_luz_instalacao.get(id));
						System.out.print(ref_luz_instalacao.indexOf(rgi));
						try {
							consumo = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "consumo"));
							vencimento = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "vencimento"));
							total = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "total_pagar"));
							tarifa = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "tarifa"));
							System.out.println("tarifa: " + tarifa.get(0));
							pis = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "pis"));
							confins = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "confins"));
							icms = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "icms"));
							digitador = new ArrayList(getWhere("ref_luz", "instalacao", rgi, "mes", String.valueOf(combobox_mes.getSelectedItem()), "digitador"));
							cidade = new ArrayList(getCidade(String.valueOf(combobox_cliente.getSelectedIndex()), "cidade"));
							rua = new ArrayList(getCidade(String.valueOf(combobox_cliente.getSelectedIndex()), "endereco"));
							cep = new ArrayList(getCidade(String.valueOf(combobox_cliente.getSelectedIndex()), "cep"));
							Lrgi.setText("RGI: " + rgi);
							Lcidade.setText("Cidade: " + String.valueOf(cidade.get(0)));
							Lconsumo.setText("Consumo: " + String.valueOf(consumo.get(0)));
							Lvenc.setText("Vencimento: " + String.valueOf(vencimento.get(0)));
							Ltotal.setText("Total: " + String.valueOf(total.get(0)));
							Ldigitador.setText("Digitador: " + String.valueOf(digitador.get(0)));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}	
				}
			}
		});
		Bver.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Bver.setBounds(77, 379, 140, 50);
		Panel_cliente.add(Bver);
		
		JButton Bcsv = new JButton("Gerar CSV");
		Bcsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (conta.equals("agua")) {
					try {
						PrintWriter file = new PrintWriter("conta_" + conta + "_" + combobox_cliente.getSelectedItem() + "_" + combobox_mes.getSelectedItem() + ".csv");
						StringBuilder sb = new StringBuilder();
						sb.append("Cliente");sb.append(",");sb.append("Cidade");sb.append(",");sb.append("Endereço");sb.append(",");sb.append("CEP");sb.append(",");sb.append("RGI");sb.append(",");sb.append("Mes");sb.append(",");sb.append("Vencimento");sb.append(",");sb.append("Consumo");sb.append(",");
						sb.append("Total");sb.append(",");sb.append("Digitador");
						sb.append("\n");
						sb.append(String.valueOf(combobox_cliente.getSelectedItem()));sb.append(",");sb.append(String.valueOf(cidade.get(0)));sb.append(",");sb.append(String.valueOf(rua.get(0)));sb.append(",");sb.append(String.valueOf(cep.get(0)));sb.append(",");sb.append(rgi);sb.append(",");sb.append(String.valueOf(combobox_mes.getSelectedItem()));sb.append(",");sb.append(vencimento.get(0));
						sb.append(",");sb.append(String.valueOf(consumo.get(0)));sb.append(",");sb.append(String.valueOf(total.get(0)));sb.append(",");sb.append(String.valueOf(digitador.get(0)));sb.append("\n");
						System.out.println(file);
						file.write(sb.toString());
						file.close();
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if (conta.equals("luz")) {
					try {
						PrintWriter file = new PrintWriter("conta_" + conta + "_" + combobox_cliente.getSelectedItem() + "_" + combobox_mes.getSelectedItem() + ".csv");
						StringBuilder sb = new StringBuilder();
						sb.append("Cliente");sb.append(",");sb.append("Cidade");sb.append(",");sb.append("Endereço");sb.append(",");sb.append("CEP");sb.append(",");sb.append("Instação");sb.append(",");sb.append("Mes");sb.append(",");sb.append("Vencimento");sb.append(",");sb.append("Consumo");sb.append(",");sb.append("Tarifa");
						sb.append(",");sb.append("PIS");sb.append(",");sb.append("CONFINS");sb.append(",");sb.append("ICMS");sb.append(",");sb.append("Total");sb.append(",");sb.append("Digitador");
						sb.append("\n");
						sb.append(String.valueOf(combobox_cliente.getSelectedItem()));sb.append(",");sb.append(String.valueOf(cidade.get(0)));sb.append(",");sb.append(String.valueOf(rua.get(0)));sb.append(",");sb.append(String.valueOf(cep.get(0)));sb.append(",");sb.append(rgi);sb.append(",");sb.append(String.valueOf(combobox_mes.getSelectedItem()));sb.append(",");sb.append(vencimento.get(0));
						sb.append(",");sb.append(String.valueOf(consumo.get(0)));sb.append(",");sb.append(String.valueOf("" + tarifa.get(0)));sb.append(",");sb.append(String.valueOf(pis.get(0)));sb.append(",");
						sb.append(String.valueOf(confins.get(0)));sb.append(",");sb.append(String.valueOf(icms.get(0)));sb.append(",");sb.append(String.valueOf(total.get(0)));sb.append(",");sb.append(String.valueOf(digitador.get(0)));
						sb.append("\n");
						System.out.println(file);
						file.write(sb.toString());
						file.close();
						
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				
			}
		});
		Bcsv.setFont(new Font("Times New Roman", Font.BOLD, 22));
		Bcsv.setBounds(343, 380, 140, 50);
		Panel_cliente.add(Bcsv);

		
		

	}
	

	private void setDefaultCloseOperation(Object dispose) {
		// TODO Auto-generated method stub
	}
	
	public static ArrayList get(String tabela, String coluna) throws Exception{
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement  pegar = con.prepareStatement("SELECT * FROM " + tabela);
			ResultSet resultado = pegar.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(coluna));
			}
		
			System.out.println("Get finalizado");
			System.out.println(array);
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
	
	public static ArrayList getWhere(String tabela, String coluna1, String palavra1, String coluna2, String palavra2, String valor) throws Exception{
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement  pegar = con.prepareStatement("SELECT * FROM " + tabela + " WHERE (" + coluna1 + " = '" + palavra1 +"') AND "
					+ "(" + coluna2 +" = '" + palavra2 + "')" );
			ResultSet resultado = pegar.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(valor));
			}
		
			System.out.println("Get finalizado");
			System.out.println(array);
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
	
	public static ArrayList getCidade(String palavra, String valor) throws Exception{
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement  pegar = con.prepareStatement("SELECT * FROM local WHERE ( id_cli = '" + palavra +"')");
			ResultSet resultado = pegar.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(valor));
			}
		
			System.out.println("Get finalizado");
			System.out.println(array);
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
}
