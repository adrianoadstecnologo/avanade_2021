package br.com.gama.contacorrente.entidades;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "operacoes")
public class Operacao {

	@Id
	private String id;
	private LocalDateTime dataCricacao;
	private String contaId;
	private Double valor;
	private TipoOperacao tipo;

	public Operacao(UUID contaId, Double valor, TipoOperacao tipo) {

		this.contaId = contaId.toString();
		this.valor = valor;
		this.tipo = tipo;
		this.id = UUID.randomUUID().toString();
		this.dataCricacao = LocalDateTime.now();
	}

	public Operacao(String contaId, Double valor, TipoOperacao tipo) {

		this.contaId = contaId;
		this.valor = valor;
		this.tipo = tipo;
		this.id = UUID.randomUUID().toString();
		this.dataCricacao = LocalDateTime.now();
	}
	
	private Operacao() {}

	// getters e setters customizados

	public UUID getUUId() {
		return UUID.fromString(id);
	}

	public void setUUId(UUID id) {
		this.id = id.toString();
	}

	public UUID getContaUUId() {
		return UUID.fromString(contaId);
	}

	public void setContaUUId(UUID id) {
		this.id = id.toString();
	}

	// ----------------------

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getDataCricacao() {
		return dataCricacao;
	}

	public void setDataCricacao(LocalDateTime dataCricacao) {
		this.dataCricacao = dataCricacao;
	}

	public String getContaId() {
		return contaId;
	}

	public void setContaId(String contaId) {
		this.contaId = contaId;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoOperacao tipo) {
		this.tipo = tipo;
	}

}