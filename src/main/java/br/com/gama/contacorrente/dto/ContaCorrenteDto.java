package br.com.gama.contacorrente.dto;

import java.util.UUID;

public class ContaCorrenteDto {

	private UUID id;
	private Double saldo;
	private Boolean status;
	
	public ContaCorrenteDto(UUID id, Double saldo, Boolean status) {
		this.id = id;
		this.saldo = saldo;
		this.status = status;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	
}
