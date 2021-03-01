package br.com.gama.contacorrente.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClienteDto {
	
	@JsonIgnore
	public UUID id;
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;
	private String usuario;
	private List<ContaCorrenteDto> contas;

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<ContaCorrenteDto> getContas() {
		return contas;
	}

	public void setContas(List<ContaCorrenteDto> contas) {
		this.contas = contas;
	}
	
	
	
}
