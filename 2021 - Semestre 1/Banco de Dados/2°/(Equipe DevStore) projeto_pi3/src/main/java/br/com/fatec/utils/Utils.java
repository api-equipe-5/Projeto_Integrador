package br.com.fatec.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import javax.swing.JOptionPane;

import org.apache.commons.io.FilenameUtils;

import br.com.fatec.banco.Conexao;
import br.com.fatec.model.TipoArea;
import br.com.fatec.model.service.TipoAreaDaoImpl;
import br.com.fatec.model.service.UtilsDaoImpl;

public class Utils {

	public final static String PROCESSAR = "processar";
	public final static String PROCESSANDO = "processando";
	public final static String PROCESSADO = "processado";
	public final static String LOG = "log";
	public static String CAMINHOAPLICACAO;

	public static void estruturarDiretorios() {
		CAMINHOAPLICACAO = System.getProperty("user.dir") + File.separator;

		File file = new File(CAMINHOAPLICACAO + PROCESSAR);

		if (!file.exists()) {
			file.mkdirs();
		}

		file = new File(CAMINHOAPLICACAO + PROCESSANDO);

		if (!file.exists()) {
			file.mkdirs();
		}

		file = new File(CAMINHOAPLICACAO + PROCESSADO);

		if (!file.exists()) {
			file.mkdirs();
		}

		file = new File(CAMINHOAPLICACAO + LOG);

		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	public static void escreverLog(String texto) {
		CAMINHOAPLICACAO = System.getProperty("user.dir") + File.separator;
		File file = new File(CAMINHOAPLICACAO + LOG + File.separator + retornaData(1));
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		FileWriter fileWriter;
		BufferedWriter escrever;
		try {
			file = new File(CAMINHOAPLICACAO + LOG + File.separator + retornaData(1) + File.separator + "LOG.txt");
			
			if(file.exists()) {
				fileWriter = new FileWriter(file, true);
			}else {
				fileWriter = new FileWriter(file);
			}
				
			escrever = new BufferedWriter (fileWriter);
	        escrever.append("[" + retornaData(2) + "] " + texto);
	        escrever.newLine();
	        escrever.close();
	        fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String retornaData(Integer tipo) {
		Date data = new Date();
		SimpleDateFormat formatar = new SimpleDateFormat();
		
	    if(tipo == 1) {
	    	formatar = new SimpleDateFormat("ddMMyyyy");
	    }else if(tipo == 2) {
	    	formatar = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss" );
	    }
	    
	    return formatar.format(data);
		
	}
	
	public static void removeExtensoes(String caminho) {
		File arquivos[] = (new File(caminho).listFiles());
		
		for(File arquivo : arquivos) {
			if(FilenameUtils.getExtension(arquivo.getAbsolutePath()) != "zip") {
				arquivo.delete();				
			}
		}
	}
	
	@SuppressWarnings("null")
	public static void gerarSQL(String caminho, String tipoArea, String codigoMunicipio) {
		
		TipoArea ta = new TipoArea();
		
		UtilsDaoImpl utilsDaoImpl = new UtilsDaoImpl();
		TipoAreaDaoImpl tipoAreaDaoImpl = new TipoAreaDaoImpl();
		
		Conexao conexao = new Conexao();
		String line = "";
		
		try {
			
			ta = tipoAreaDaoImpl.findByTipoDescricao(tipoArea.toUpperCase());
			
			if(!ta.getTipoDescricao().equals("") || tipoArea.equals("area_imovel")) {
				ProcessBuilder pb = new ProcessBuilder();
			
				pb.command("shp2pgsql ", caminho + "|psql -U postgres");
				
				Process p = pb.start();
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    
				conexao.Conectar();
				
				while ((line = reader.readLine()) != null){
		        
					if(line.startsWith("INSERT INTO")) {
						
						if(!line.contains("area_imovel")) {
							
							
							if(line.contains("\"tema\"")) {
								utilsDaoImpl.insert(line, conexao);
								utilsDaoImpl.updateNascentelMunicipio(codigoMunicipio, conexao);
							}else{
								line = line.replace(tipoArea, "area");
								utilsDaoImpl.insert(line, conexao);
								utilsDaoImpl.updateIdAreaCodigoMunicipio(ta.getTipoId(), codigoMunicipio, conexao);
								
							}
							
						}else {
							utilsDaoImpl.insert(line, conexao);
							utilsDaoImpl.updateAreaImovelMunicipio(codigoMunicipio, conexao);
						}
					}
				}
		    
				conexao.Desconectar();
		    
			}else {
				
				escreverLog("Tipo de area não encontrado no Banco de dados " + tipoArea);
				
			}
			
		} catch (IOException e) {
			escreverLog("Erro ao inserir tipo " + tipoArea + " : " + e.getMessage());
		}
		
	}
	
	public static String removerAcentos(String str) {
	    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}
	
	public static String removerEspaco(String str) {
		return str.replaceAll(" ", "_");
	}

}
