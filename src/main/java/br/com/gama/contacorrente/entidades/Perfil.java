package br.com.gama.contacorrente.entidades;

import org.springframework.security.core.GrantedAuthority;

public class Perfil implements GrantedAuthority{

	private String nome;
	
	public Perfil(String nome) {
		this.nome = nome;
	}

	@Override
	public String getAuthority() {
		return this.nome;
	}

}
