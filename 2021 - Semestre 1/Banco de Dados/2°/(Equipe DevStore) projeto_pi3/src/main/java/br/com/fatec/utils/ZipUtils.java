package br.com.fatec.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.IOUtils;


public class ZipUtils {
	
	private static final int BUFFER_SIZE = 4096;
    
    public void unzip(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry entry = zipIn.getNextEntry();
        
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
               
                extractFile(zipIn, filePath);
            } else {
                
                File dir = new File(filePath);
                dir.mkdirs();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }
    
    private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[BUFFER_SIZE];
        int read = 0;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }
    
    
    public void lerShapeFile(String arquivoShape) throws IOException {
    	
    	ZipFile zipFile = new ZipFile(arquivoShape);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        System.out.println(entries); //objeto que esta manipulando o arquivo zip
        


        while(entries.hasMoreElements()){
            ZipEntry entry = entries.nextElement();
            System.out.println(entry.getName());//cada arquivo dentro do zip
            if(entry.getName().contains("dbf")){
                InputStream stream = zipFile.getInputStream(entry);
                System.out.println(IOUtils.toString(stream, StandardCharsets.UTF_8));//conteudo do arquivo dentro do zip
            }
        }
    }
    
    public Boolean verificaExtensao(String arquivo, String extensao) {
    	 
    	try {
    	
    		ZipFile zipFile = new ZipFile(arquivo);
    		Enumeration<? extends ZipEntry> entries = zipFile.entries();

    		while(entries.hasMoreElements()){
    			ZipEntry entry = entries.nextElement();
            	
    			if(entry.getName().contains(extensao)) {
    				zipFile.close();
    				return true;
    			}
    			
    		}
    		zipFile.close();
    		
    	}catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
        return false;
    }

}
