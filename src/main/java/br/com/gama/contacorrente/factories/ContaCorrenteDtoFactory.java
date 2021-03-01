package br.com.gama.contacorrente.factories;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gama.contacorrente.dto.ContaCorrenteDto;
import br.com.gama.contacorrente.entidades.ContaCorrente;

public class ContaCorrenteDtoFactory {

	public static ContaCorrenteDto Create(ContaCorrente cc) {

		return new ContaCorrenteDto(cc.getId(), cc.getSaldo(), cc.getAtivo());
	}

	public static List<ContaCorrenteDto> Create(List<ContaCorrente> ccs) {

		return ccs.stream().map(ContaCorrenteDtoFactory::Create).collect(Collectors.toList());
		
	}

}
