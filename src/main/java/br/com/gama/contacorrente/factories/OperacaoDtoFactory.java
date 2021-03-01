package br.com.gama.contacorrente.factories;

import br.com.gama.contacorrente.dto.OperacaoDto;
import br.com.gama.contacorrente.entidades.Operacao;

public class OperacaoDtoFactory {

	public static OperacaoDto Create(Operacao operacao) {
		return new OperacaoDto(
				operacao.getUUId(), 
				operacao.getDataCricacao(), 
				operacao.getValor(), 
				operacao.getTipo()
			);
	}
}
