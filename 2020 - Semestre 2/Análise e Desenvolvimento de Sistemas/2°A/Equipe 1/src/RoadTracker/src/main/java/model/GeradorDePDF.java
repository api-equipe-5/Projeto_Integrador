package model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import control.ControlesLogin;

public class GeradorDePDF {
	
	
	
	
	public void gerarRelatorio(String path, String titulo, String especificacao, String entidades, String periodoLogs) {
		Document documento = new Document();
		
		try {
	        PdfWriter.getInstance(documento, new FileOutputStream(path));
	        
	        documento.open();
	        
	        
	        
	        // Adicionando metadados
	        documento.addAuthor(ControlesLogin.nomeLogado);

	        // Criando título
	        Paragraph tituloModel = new Paragraph(titulo);
	        tituloModel.setAlignment(Paragraph.ALIGN_CENTER);
	        documento.add(tituloModel);
	        
	        // Adicionando a lista de especifícações requeridas pelo usuário
	        Paragraph especificacaoModel = new Paragraph(especificacao);
	        especificacaoModel.setAlignment(Paragraph.ALIGN_JUSTIFIED);
	        documento.add(especificacaoModel);

	        // Adicionando quem requisitou o arquivo
	        String requerente = "\nRequisitado por: " + ControlesLogin.nomeLogado;
	        Paragraph requerenteModel = new Paragraph(requerente);
	        documento.add(requerenteModel);

	        // Listando dados de administradores
	        if(entidades.contains("Administradores")) {	
	        	documento.newPage();
	        	
		        Paragraph tituloAdm = new Paragraph("Administradores");
		        tituloAdm.setAlignment(Paragraph.ALIGN_CENTER);
		        documento.add(tituloAdm);
		        
	        	String texto = "";
	        	List<Funcionario> funcionarios = new Funcionario().consultarTodosFuncionarios();
	        	
	        	Object[] funcs = funcionarios.toArray();
	        	
	        	for(int i = 0; i < funcs.length; i++) {
	        		Funcionario func = (Funcionario) funcs[i];
	        		
	        		String[] metadado = func.getMetadados().split(" ");
	        		
	        		if(func.getCargo().equals("Administrador")) {
		        		texto = texto + "\n\n";
		        		
		        		texto = texto + func.getNome() + ": ";
		        		
	        			String[][] dicionario = func.obterDicionarioMetadadosAdm();
	        			
	        			for(int x = 0; x < metadado.length; x++) {
	        				String[] mt = metadado[x].split(":");
	        				
	        				for(int y = 0; y < dicionario.length; y++) {
	        					if(mt[0].equals(dicionario[y][0])) {
	        						texto = texto + '\n' + "    - " + dicionario[y][1] + ": " + mt[1];
	        					}
	        				}
	        			}
	        		}
	        	}
	        	
		        Paragraph infosAdmins = new Paragraph(texto);
		        documento.add(infosAdmins);
	        }
	        
	        
	        // Listando dados de supervisores
	        if(entidades.contains("Supervisores")) {
	        	documento.newPage();
	        	
		        Paragraph tituloSup = new Paragraph("Supervisores");
		        tituloSup.setAlignment(Paragraph.ALIGN_CENTER);
		        documento.add(tituloSup);
		        
	        	String texto = "";
	        	List<Funcionario> funcionarios = new Funcionario().consultarTodosFuncionarios();
	        	
	        	Object[] funcs = funcionarios.toArray();
	        	
	        	for(int i = 0; i < funcs.length; i++) {
	        		Funcionario func = (Funcionario) funcs[i];
	        		
	        		String[] metadado = func.getMetadados().split(" ");
	        		
	        		if(func.getCargo().equals("Supervisor")) {
		        		texto = texto + "\n\n";
		        		
		        		texto = texto + func.getNome() + ": ";
		        		
	        			String[][] dicionario = func.obterDicionarioMetadadosSup();
	        			
	        			for(int x = 0; x < metadado.length; x++) {
	        				String[] mt = metadado[x].split(":");
	        				
	        				for(int y = 0; y < dicionario.length; y++) {
	        					if(mt[0].equals(dicionario[y][0])) {
	        						texto = texto + '\n' + "    - " + dicionario[y][1] + ": " + mt[1];
	        					}
	        				}
	        			}
	        		}
	        	}
	        	
		        Paragraph infosSup = new Paragraph(texto);
		        documento.add(infosSup);
	        }
	        
	        
	        // Listando dados de motoristas
	        if(entidades.contains("Motoristas")) {	
	        	documento.newPage();
	        	
		        Paragraph tituloMot = new Paragraph("Motoristas");
		        tituloMot.setAlignment(Paragraph.ALIGN_CENTER);
		        documento.add(tituloMot);
		        
	        	String texto = "";
	        	List<Motorista> motoristas = new Motorista().consultarTodosMotoristas();
	        	
	        	Object[] mots = motoristas.toArray();
	        	
	        	for(int i = 0; i < mots.length; i++) {
	        		texto = texto + "\n\n";
	        		Motorista mot = (Motorista) mots[i];
	        		
	        		texto = texto + mot.getNome() + ": ";
	        		
	        		String[] metadado = mot.getMetadados().split(" ");
	        		
	        		if(mot.getCargo().equals("Motorista")) {
	        			String[][] dicionario = mot.obterDicionarioMetadados();
	        			for(int x = 0; x < metadado.length; x++) {
	        				String[] mt = metadado[x].split(":");
	        				
	        				for(int y = 0; y < dicionario.length; y++) {
	        					if(mt[0].equals(dicionario[y][0])) {
	        						texto = texto + '\n' + "    - " + dicionario[y][1] + ": " + mt[1];
	        					}
	        				}
	        			}
	        		}
	        	}
	        	
		        Paragraph infosMot = new Paragraph(texto);
		        documento.add(infosMot);
	        }
	        
	        // Listando dados das filiais
	        if(entidades.contains("Filiais")) {
	        	documento.newPage();
	        	
		        Paragraph tituloFil = new Paragraph("Filiais");
		        tituloFil.setAlignment(Paragraph.ALIGN_CENTER);
		        documento.add(tituloFil);
	        	
	        	String texto = "";
	        	List<Filial> filiais = new Filial().consultarTodasFiliais();
	        	
	        	Object[] arrayFiliais = filiais.toArray();
	        	
	        	for(int i = 0; i < arrayFiliais.length; i++) {
	        		Filial filial = (Filial) arrayFiliais[i];
	        		
	        		String funcAss = "";
	        		String veicAss = "";
	        		
	        		String[] metadado = filial.getMetadados().split(" ");
	        		
        			for(int x = 0; x < metadado.length; x++) {
        				String[] mt = metadado[x].split(":");

        				if(mt[0].equals("FncAss")) {
        					funcAss = mt[1];
        				}else {
        					veicAss = mt[1];
        				}
        			}
        			
	        		texto = texto + filial.getNome() + ":"
	        				+ "\n    - " + "CNPJ: " + filial.getCnpj()
	        				+ "\n    - " + "RNTRC: "+ filial.getRntrc()
	        				+ "\n    - " + "ID no sistema: " + filial.getId()
	        				+ "\n    - " + "Estado: " + filial.getEstado()
	        				+ "\n    - " + "Cidade: " + filial.getCidade()
	        				+ "\n    - " + "Funcionários associados: " + funcAss
	        				+ "\n    - " + "Veículos associados: " + veicAss + "\n\n";
	        		
	        	}
	        	
		        Paragraph infosFiliais = new Paragraph(texto);
		        documento.add(infosFiliais);
	        	
	        }
	        
	        
	        // Listando dados dos veículos
	        if(entidades.contains("Veículos")) {
	        	documento.newPage();
	        	
		        Paragraph tituloVeic = new Paragraph("Veículos");
		        tituloVeic.setAlignment(Paragraph.ALIGN_CENTER);
		        documento.add(tituloVeic);
		        
	        	String texto = "";
	        	List<Veiculo> veiculos = new Veiculo().consultarTodosVeiculos();
	        	
	        	Object[] arrayVeiculos = veiculos.toArray();
	        	
	        	for(int i = 0; i < arrayVeiculos.length; i++) {
	        		Veiculo veiculo = (Veiculo) arrayVeiculos[i];
        			
	        		texto = texto + "Placa: " + veiculo.getPlaca()
	        				+ "\n    - " + "Modelo: " + veiculo.getModelo_veiculo()
	        				+ "\n    - " + "Nome da filial pertencente: "+ veiculo.getFilial().getNome()
	        				+ "\n    - " + "ID do rastreador: " + veiculo.getId_rastreador()
	        				+ "\n    - " + "Marca do rastreador: " + veiculo.getMarca_rastreador()
	        				+ "\n    - " + "Modelo do rastreador: " + veiculo.getModelo_rastreador() + "\n\n";
	        		
	        	}
	        	
		        Paragraph infosVeic = new Paragraph(texto);
		        documento.add(infosVeic);
	        }
	        
	        // Listando dados das viagens
	        if(entidades.contains("Viagens")) {
	        	documento.newPage();
	        	
		        Paragraph tituloViag = new Paragraph("Viagens");
		        tituloViag.setAlignment(Paragraph.ALIGN_CENTER);
		        documento.add(tituloViag);
		        
	        	String texto = "";
	        	List<Viagem> viagens = new Viagem().consultarTodasViagens();
	        	
	        	Object[] arrayViagens = viagens.toArray();
	        	
	        	for(int i = 0; i < arrayViagens.length; i++) {
	        		Viagem viagem = (Viagem) arrayViagens[i];
        			
	        		texto = texto + "Destino: " + viagem.getDestino()
	        				+ "\n    - " + "Carga: " + viagem.getCarga()
	        				+ "\n    - " + "CPF do motorista associado: "+ viagem.getMotorista().getCpf()
	        				+ "\n    - " + "Placa do veículo associado: " + viagem.getVeiculo().getPlaca()
	        				+ "\n    - " + "ID da viagem no sistema: " + viagem.getId()
	        				+ "\n    - " + "Situação da viagem: " + viagem.getSituacao() + "\n\n";
	        		
	        	}
	        	
		        Paragraph infosViag = new Paragraph(texto);
		        documento.add(infosViag);
		        
	        }
	        
	        
	        // Registros de logs
	        if(!periodoLogs.equals("Não incluir registros")) {
	        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        	documento.newPage();

	        	Paragraph tituloViag = new Paragraph("Registro de logs " + "- " + periodoLogs.substring(0, 1).toLowerCase() + periodoLogs.substring(1));
	        	tituloViag.setAlignment(Paragraph.ALIGN_CENTER);
	        	documento.add(tituloViag);


	        	List<Logs> logs = new Logs().consultarTodosLogs();

	        	Object[] arrayLogs = logs.toArray();

        		String texto = "";
	        	
	        	if(periodoLogs.contains("20")) {
	        		for(int i = 0; i < arrayLogs.length; i++) {
	        			Logs log = (Logs) arrayLogs[i];

	        			texto = texto + "\nCPF do emissor do registro: " + log.getCpfEmissor()
	        					+ "\n    - Data da emissão: " + log.getData()
	        					+ "\n    - Horário da emissão: " + log.getHorario()
	        					+ "\n    - ID do registro: " + String.valueOf(log.getId())
	        					+ "\n    - Registro: \n" + log.getRegistro() + '\n'; 

	        			if(i >= 20) {
	        				break;
	        			}
	        		}
	        	}else if(periodoLogs.contains("40")) {
	        		for(int i = 0; i < arrayLogs.length; i++) {
	        			Logs log = (Logs) arrayLogs[i];

	        			texto = texto + "\nCPF do emissor do registro: " + log.getCpfEmissor()
	        					+ "\n    - Data da emissão: " + log.getData()
	        					+ "\n    - Horário da emissão: " + log.getHorario()
	        					+ "\n    - ID do registro: " + String.valueOf(log.getId())
	        					+ "\n    - Registro: \n" + log.getRegistro() + '\n'; 

	        			if(i >= 40) {
	        				break;
	        			}
	        		}
	        	}else if(periodoLogs.contains("100")) {
	        		for(int i = 0; i < arrayLogs.length; i++) {
	        			Logs log = (Logs) arrayLogs[i];

	        			texto = texto + "\nCPF do emissor do registro: " + log.getCpfEmissor()
	        					+ "\n    - Data da emissão: " + log.getData()
	        					+ "\n    - Horário da emissão: " + log.getHorario()
	        					+ "\n    - ID do registro: " + String.valueOf(log.getId())
	        					+ "\n    - Registro: \n" + log.getRegistro() + '\n'; 

	        			if(i >= 100) {
	        				break;
	        			}
	        		}
	        	}else if(periodoLogs.contains("dia")) {
	        		for(int i = 0; i < arrayLogs.length; i++) {
	        			Logs log = (Logs) arrayLogs[i];
	        			        			
	        	    	LocalDate data = LocalDate.parse(log.getData(), formatter);
	        	    	
	        	    	if(data.until(LocalDate.now(), ChronoUnit.DAYS) <= 1) {
		        			texto = texto + "\nCPF do emissor do registro: " + log.getCpfEmissor()
		        					+ "\n    - Data da emissão: " + log.getData()
		        					+ "\n    - Horário da emissão: " + log.getHorario()
		        					+ "\n    - ID do registro: " + String.valueOf(log.getId())
		        					+ "\n    - Registro: \n" + log.getRegistro() + '\n'; 
	        	    	}
	        			
	        		}
	        	}else if(periodoLogs.contains("semana")) {
	        		for(int i = 0; i < arrayLogs.length; i++) {
	        			Logs log = (Logs) arrayLogs[i];
	        			        			
	        	    	LocalDate data = LocalDate.parse(log.getData(), formatter);
	        	    	
	        	    	if(data.until(LocalDate.now(), ChronoUnit.DAYS) <= 7) {
		        			texto = texto + "\nCPF do emissor do registro: " + log.getCpfEmissor()
		        					+ "\n    - Data da emissão: " + log.getData()
		        					+ "\n    - Horário da emissão: " + log.getHorario()
		        					+ "\n    - ID do registro: " + String.valueOf(log.getId())
		        					+ "\n    - Registro: \n" + log.getRegistro() + '\n'; 	        	    	
		        			}
	        			
	        		}
	        	}else if(periodoLogs.contains("mês")) {
	        		for(int i = 0; i < arrayLogs.length; i++) {
	        			Logs log = (Logs) arrayLogs[i];
	        			        			
	        	    	LocalDate data = LocalDate.parse(log.getData(), formatter);
	        	    	
	        	    	if(data.until(LocalDate.now(), ChronoUnit.DAYS) <= 31) {
		        			texto = texto + "\nCPF do emissor do registro: " + log.getCpfEmissor()
		        					+ "\n    - Data da emissão: " + log.getData()
		        					+ "\n   - Horário da emissão: " + log.getHorario()
		        					+ "\n    - ID do registro: " + String.valueOf(log.getId())
		        					+ "\n    - Registro: \n" + log.getRegistro() + '\n'; 
	        	    	}
	        			
	        		}
	        	}else {
	        		for(int i = 0; i < arrayLogs.length; i++) {
	        			Logs log = (Logs) arrayLogs[i];

	        			texto = texto + "\nCPF do emissor do registro: " + log.getCpfEmissor()
	        					+ "\n    - Data da emissão: " + log.getData()
	        					+ "\n    - Horário da emissão: " + log.getHorario()
	        					+ "\n    - ID do registro: " + String.valueOf(log.getId())
	        					+ "\n    - Registro: \n" + log.getRegistro() + '\n'; 

	        		}
	        	}
	        	
		        Paragraph infosLogs = new Paragraph(texto);
		        documento.add(infosLogs);
	        	

	        }
	       
	        
		}catch(DocumentException de) {
			System.err.println(de.getMessage());
		}catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
		
		
		documento.close();

	}
}
