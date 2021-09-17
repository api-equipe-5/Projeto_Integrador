package hashCompare;


import java.io.*;
import java.util.*;
import java.security.MessageDigest;
 
 
public class FileCompare {
 
    public static void main(String args[]) {
	        //arquivo original
	        String fileName1 = "C:/Users/rmsil/eclipse-workspace/hashCompare/assets/informeBiblioteca.pdf";
	        //arquivo cópia Inalterada
	        String fileName2 = "C:/Users/rmsil/eclipse-workspace/hashCompare/assets/informeBibliotecaCopiaIntegra.pdf";
	      //String fileName2 = "C:/Users/rmsil/eclipse-workspace/hashCompare/assets/informeBibliotecaCopiaAdulterada1.pdf";
	        String hashValue1 = "";
	        String hashValue2 = "";
	    
	    try {
	        hashValue1 =sha256HashFile(fileName1);
	        hashValue2=sha256HashFile(fileName2);
	        if (hashValue1.equals(hashValue2)) 
	        	System.out.println("Arquivos IGUAIS utilizando o SHA-256"); 
	        else 
	        	System.out.println("Ambos arquivos NÃO SÃO IGUAIS utilizando o SHA-256");
	    }
	    catch (Exception e) {
	        System.out.println("Error");
	    }
	}
 
   
 
    public static String sha256HashFile(String filename) throws Exception {
      byte[] buf = ChecksumFile(filename);//pega os bytes do arquivo e soma p/ obter-se o checksum que existe p/ garantir a integridade na transferência dos dados
      String res = "";
      for (int i = 0; i < buf.length; i++) {
          res+= Integer.toString((buf[i] & 0xff) + 0x100, 16).substring(1);
      }
      return res;
    }
 
     
     public static byte[]  ChecksumFile(String filename) throws Exception {
	      InputStream fis = new FileInputStream(filename);
	      byte[] buf = new byte[1024];
	      MessageDigest complete = MessageDigest.getInstance("SHA-256");//instância do messageDigest utilizando SHA-256
	      int n;
	      do {
	       n= fis.read(buf);
	       if (n > 0) {
	        complete.update(buf, 0, n);
	       }
	      } while (n != -1);
	      fis.close();
	      return complete.digest();
	     }
	}