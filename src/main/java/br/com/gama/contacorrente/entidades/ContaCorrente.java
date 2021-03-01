package br.com.gama.contacorrente.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class ContaCorrente extends Entidade {

	private Double saldo;
	
	@Transient
	private List<Operacao> operacoes;

	public ContaCorrente(Double saldo, List<Operacao> operacoes) {
		super();
		this.saldo = saldo;
		this.operacoes = operacoes;
	}
	
	protected ContaCorrente() {
		super();
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Operacao> getOperacoes() {
		return operacoes;
	}

	public void setOperacoes(List<Operacao> operacoes) {
		this.operacoes = operacoes;
	}
	
	
}
