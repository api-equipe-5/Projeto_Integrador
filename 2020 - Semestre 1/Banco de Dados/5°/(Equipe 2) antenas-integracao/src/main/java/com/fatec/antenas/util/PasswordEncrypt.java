package com.fatec.antenas.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypt {
	//private BCryptPasswordEncoder passwordEncoder;
	private String passwordEncoder;

	public String getPasswordEncoder() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(this.passwordEncoder);
	}

	public PasswordEncrypt(String password) {
		this.passwordEncoder = password;
	}
	
	
	
}
