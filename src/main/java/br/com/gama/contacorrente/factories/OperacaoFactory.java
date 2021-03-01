package br.com.gama.contacorrente.factories;

import br.com.gama.contacorrente.entidades.Operacao;
import br.com.gama.contacorrente.forms.OperacaoForm;

public class OperacaoFactory {

	public static Operacao Create(OperacaoForm form) {
		return new Operacao(form.getContaId(), form.getValor(), form.getTipo());
	}
}
