package br.com.gama.contacorrente.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;


public class LoginForm {
	
	@NotNull @NotBlank
	private String usuario;
	
	@NotNull @NotBlank
	private String senha;


	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
