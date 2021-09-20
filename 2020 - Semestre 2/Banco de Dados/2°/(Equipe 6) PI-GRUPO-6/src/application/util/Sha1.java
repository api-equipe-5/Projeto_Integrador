package application.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1 {

	public String encriptarSenha(String senha) throws NoSuchAlgorithmException {
		if (senha.length() == 0) {
			return null;
		} else {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(senha.getBytes());
			byte[] hash = md.digest();
			StringBuffer senhaEncrip = new StringBuffer();
			for (int i = 0; i < hash.length; i++) {
				senhaEncrip.append(Integer.toHexString(hash[i] & 0xff));
			}
			return senhaEncrip.toString();
		}
	}
}