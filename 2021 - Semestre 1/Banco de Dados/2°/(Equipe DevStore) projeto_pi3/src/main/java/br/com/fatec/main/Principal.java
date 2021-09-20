package br.com.fatec.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import br.com.fatec.banco.Conexao;
import br.com.fatec.model.Estado;
import br.com.fatec.model.Integracao;
import br.com.fatec.model.Municipio;
import br.com.fatec.model.Parametro;
import br.com.fatec.model.service.EstadoDaoImpl;
import br.com.fatec.model.service.IntegracaoDaoImp;
import br.com.fatec.model.service.MunicipioDaoImpl;
import br.com.fatec.model.service.ParametroDaoImpl;
import br.com.fatec.model.service.TipoAreaDaoImpl;
import br.com.fatec.model.service.UtilsDaoImpl;
import br.com.fatec.utils.Utils;
import br.com.fatec.utils.ZipUtils;
import br.com.fatec.view.Janela;

public class Principal {
	
	private static Conexao conexao;
	
	private static String codigoIBGE;
	
	private static Estado estado;
	
	private static EstadoDaoImpl estadoDaoImpl;
	
	private static Municipio municipio;
	
	private static MunicipioDaoImpl municipioDaoImpl;
	
	private static Integracao integracao;
	
	private static IntegracaoDaoImp integracaoDaoImp;
	
	private static TipoAreaDaoImpl areaDaoImpl;
    
	private static String tipoArea;

	public static void main(String[] args) {

		Janela janela;
    	ZipUtils zip;
    	File arquivos;
    	UtilsDaoImpl utilsDaoImpl;
    	
    	conexao = new Conexao();
    	
    	try {
    		if (!conexao.Conectar()) {
    			JOptionPane.showMessageDialog(null, "Banco de dados não existe, entre em contato com o suporte!");
                Utils.escreverLog("Banco de dados não existe, entre em contato com o suporte!");
                System.exit(0);
    		}else {
    			if(!conexao.vericarTabelasBanco()) {
    				JOptionPane.showMessageDialog(null, "Problema em criar tabelas, entre em contato com o suporte!");
                    Utils.escreverLog("Problema em criar tabelas, entre em contato com o suporte!");
                    System.exit(0);
    			}
    		}
    		
    	}finally {
    		conexao.Desconectar();
    	}
    	
    	//conexao.testeInsert();
    
    	
    	
    	try {
    		Utils.escreverLog("Criando/Verificando diretórios.");
    		Utils.estruturarDiretorios();
    		
    		janela = new Janela();
    		zip = new ZipUtils();
    		municipioDaoImpl = new MunicipioDaoImpl();
    		estadoDaoImpl = new EstadoDaoImpl();
    		integracaoDaoImp = new IntegracaoDaoImp();
    		utilsDaoImpl = new UtilsDaoImpl();
    		
    		janela.frame.setVisible(true);
    		arquivos = new File(Utils.CAMINHOAPLICACAO + Utils.PROCESSAR + File.separator);
        	
        	janela.btnProcessar.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				
    				Utils.escreverLog("Início de importção de arquivo.");
    				File listaArquivos[] = arquivos.listFiles();
    				File arquivoPara;
    				
    				if(listaArquivos.length == 0){
    					Utils.escreverLog("Nenhum arquivo encontrado.");
    				}
    				
    				for(File lA: listaArquivos) {
    			
    					arquivoPara = new File(lA.getAbsolutePath());
    					
    					boolean foiMovido = arquivoPara.renameTo(new File(Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + 
    							File.separator + lA.getName()));
    					
    					if(foiMovido) {
    						
    						Utils.escreverLog("Arquivo " + lA.getName() + " movido para " + Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + ".");
    						try {
    							
    							zip.unzip(Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + File.separator + lA.getName(), 
    									Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + File.separator);
    							
    							Utils.escreverLog("Arquivo " + lA.getName() + " descompactado.");
    							
    							File listaCar[] = (new File(Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + File.separator).listFiles());
    							
    							codigoIBGE = lA.getName().split("_")[1].substring(0, 7);
    							
    							estado = estadoDaoImpl.findByCodigoEstado(codigoIBGE.substring(0, 2));
    							
    							municipio = municipioDaoImpl.findByCodigoMunicipio(codigoIBGE);
    							
    							for(File lc: listaCar) {
    								integracao = new Integracao();
    								
    								if(!lc.getName().equals(lA.getName())) {
    									Utils.escreverLog("Lendo o arquivo " + lc.getName() + ".");
    									integracao.setExtensaoSHP(zip.verificaExtensao(lc.getAbsolutePath(), "shp"));
    									integracao.setExtensaoSHX(zip.verificaExtensao(lc.getAbsolutePath(), "shx"));
    									integracao.setExtensaoDBF(zip.verificaExtensao(lc.getAbsolutePath(), "dbf"));
    									integracao.setExtensaoPRJ(zip.verificaExtensao(lc.getAbsolutePath(), "prj"));
    									
    									if(integracao.getExtensaoSHP() && integracao.getExtensaoSHX() && integracao.getExtensaoDBF() &&
    											integracao.getExtensaoPRJ()) {
    										integracao.setIntegrado(true);
    										integracao.setDataHoraIntegracao(new Timestamp(System.currentTimeMillis()));
    										integracao.setAreaArquivo(lc.getName());
    										integracao.setShape_arquivo(lA.getName());
    										integracao.setMunicipioCodigo(municipio.getCodigoMunicipio());
    										
    										zip.unzip(Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + File.separator + lc.getName(), 
    		    									Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + File.separator);
    										
    										tipoArea = lc.getName().split("\\.")[0].toLowerCase();
    										
    										utilsDaoImpl.deletePorMunicipio(tipoArea, codigoIBGE);
    										
    										utilsDaoImpl.criarViewMunicipio(tipoArea, estado.getEstadoSigla(), municipio.getMunicipioDescricao(), codigoIBGE);						
    										
    										
    									    Utils.gerarSQL(lc.getAbsolutePath().split("\\.")[0] + ".shp", tipoArea, municipio.getCodigoMunicipio());
    										
    										Utils.escreverLog("Arquivo " + lc.getName() + " Integrado.");
    										janela.txaLog.append("Arquivo " + lc.getName() + " Integrado. \n");
    										
    									}else {
    										integracao.setIntegrado(false);
    										integracao.setDataHoraIntegracao(new Timestamp(System.currentTimeMillis()));
    										integracao.setAreaArquivo(lc.getName());
    										integracao.setShape_arquivo(lA.getName());
    										integracao.setMunicipioCodigo(municipio.getCodigoMunicipio());
    										Utils.escreverLog("Arquivo " + lc.getName() + " não integrado por falta de arquivos.");
    										janela.txaLog.append("Arquivo " + lc.getName() + " não integrado por falta de arquivos. \n");
    									}
    									
    									integracaoDaoImp.save(integracao);
    								}
    							}
    							
    							
    							File listaCarAux[] = (new File(Utils.CAMINHOAPLICACAO + Utils.PROCESSANDO + File.separator).listFiles());
    							
    							for(File lc: listaCarAux) {
    								if(lc.getName().equals(lA.getName())) {
    									arquivoPara = new File(lc.getAbsolutePath());
    			    					
    									File dic = new File(Utils.CAMINHOAPLICACAO + Utils.PROCESSADO + 
    			    							File.separator + Utils.retornaData(1) + File.separator);
    									
    									if(!dic.exists()) {
    										dic.mkdirs();
    									}
    			    							
    									foiMovido = arquivoPara.renameTo(new File(Utils.CAMINHOAPLICACAO + Utils.PROCESSADO + 
    			    							File.separator + Utils.retornaData(1) + File.separator + lc.getName()));
    			    					
    									if(foiMovido) {
    										Utils.escreverLog("Backup do arquivo " + lc.getName() + " salvo no diretorio " + Utils.CAMINHOAPLICACAO + Utils.PROCESSADO + 
        			    							File.separator + Utils.retornaData(1) + ".");
    			    						
    			    					}
    			    					
    								}else {
    									lc.delete();
    									Utils.escreverLog("Arquivo " + lc.getName() + " removido.");
    								}
    							}
    							janela.txaLog.append("Rotina de processamento finalizada. \n");
    							
    						} catch (IOException e1) {
    							Utils.escreverLog("Erro identidifcado: " + e1.getMessage() + ".");
    							e1.printStackTrace();
    						}	
    					}	
    				}
    			}
    		});	
		} catch (Exception e) {
			// TODO: handle exception
		}
    
    }
    
}
