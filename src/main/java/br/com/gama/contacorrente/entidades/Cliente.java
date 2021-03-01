package br.com.gama.contacorrente.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Entidade {

	//propriedades
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;
	
	//relacionamentos
	@OneToOne(cascade = CascadeType.ALL)
	private Login login;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id")
	private List<ContaCorrente> contas;
	
	public Cliente(String nome, String sobrenome, String telefone, String email, Login login, List<ContaCorrente> contas) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.email = email;
		this.login = login;
		this.contas = contas;
	}

	protected Cliente() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<ContaCorrente> getContas() {
		return contas;
	}

	public void setContas(List<ContaCorrente> contas) {
		this.contas = contas;
	}
	
	
	
}
