package org.XpertCode.VengadoresDeLaLimpieza.models;


public class Token {
 // final para que no cambie
	private final String accessToken;
	
	public Token(String accessToken) {
		this.accessToken = accessToken;
	} //constructor
	
	public String getAccesToken() {
		return accessToken;
	}
	
}
