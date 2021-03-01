package br.com.gama.contacorrente.forms;

import java.util.UUID;

import br.com.gama.contacorrente.entidades.TipoOperacao;

public class OperacaoForm {

	private UUID contaId;
	private Double valor;
	private TipoOperacao tipo;
	
	public OperacaoForm(UUID contaId, Double valor) {
		this.contaId = contaId;
		this.valor = valor;
		
		tipo = valor > 0 ? TipoOperacao.DEPOSITO : TipoOperacao.RETIRADA;
	}

	public UUID getContaId() {
		return contaId;
	}

	public Double getValor() {
		return valor;
	}

	public TipoOperacao getTipo() {
		return tipo;
	}
	
	
}
