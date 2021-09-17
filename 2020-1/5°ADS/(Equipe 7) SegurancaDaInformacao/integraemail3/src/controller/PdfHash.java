/* .Pelo que entendemos então, essa função do  sha-256 pega a saída da função checksum
 *  (que é a combinação do valor inteiro da tabela ASCII de cada caracter do arquivo mais a soma do index dela  no array de stream da transmissão de bytes) 
 *  e transforma em  um código de 256 bits ou 32 bytes que será usado para comparação dos arquivos.
*/


package controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;


public class PdfHash {
	
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
		      byte[] buf = new byte[1024];//Lendo 1024 bytes por vez para não sobrecarregar a RAM
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

