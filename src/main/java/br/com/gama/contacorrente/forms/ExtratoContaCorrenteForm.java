package br.com.gama.contacorrente.forms;

import java.util.UUID;

public class ExtratoContaCorrenteForm {

	private UUID contaCorrenteId;

	private ExtratoContaCorrenteForm() {}

	public ExtratoContaCorrenteForm(UUID contaCorrenteId) {
		this.contaCorrenteId = contaCorrenteId;
	}

	public UUID getContaCorrenteId() {
		return contaCorrenteId;
	}

	public void setContaCorrenteId(UUID contaCorrenteId) {
		this.contaCorrenteId = contaCorrenteId;
	}
}
