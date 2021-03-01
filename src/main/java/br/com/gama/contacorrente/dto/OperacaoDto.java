package br.com.gama.contacorrente.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import br.com.gama.contacorrente.entidades.TipoOperacao;

public class OperacaoDto {
	
	private UUID id;
	private LocalDateTime dataCriacao;
	private Double valor;
	private TipoOperacao tipo;
	
	public OperacaoDto(UUID id, LocalDateTime dataCriacao, Double valor, TipoOperacao tipo) {
		this.id = id;
		this.dataCriacao = dataCriacao;
		this.valor = valor;
		this.tipo = tipo;
	}
	
	public UUID getId() {
		return id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public Double getValor() {
		return valor;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}
}
