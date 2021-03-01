package br.com.gama.contacorrente.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entidade {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataAtualizacao;
	private Boolean ativo;
	
	public Entidade() {
		var now = LocalDateTime.now();
		this.id = UUID.randomUUID();
		this.dataCriacao = now;
		this.dataAtualizacao = now;
		this.ativo = true;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
