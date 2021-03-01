package br.com.gama.contacorrente.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.contacorrente.dto.OperacaoDto;
import br.com.gama.contacorrente.dto.ResponseDto;
import br.com.gama.contacorrente.entidades.Operacao;
import br.com.gama.contacorrente.factories.OperacaoDtoFactory;
import br.com.gama.contacorrente.factories.OperacaoFactory;
import br.com.gama.contacorrente.forms.OperacaoForm;
import br.com.gama.contacorrente.repositorios.ContaCorrenteRepository;
import br.com.gama.contacorrente.repositorios.OperacaoRepository;

@Service
public class OperacaoService {
	
	@Autowired
	private OperacaoRepository repository;
	
	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;
	
	public OperacaoDto add(OperacaoForm form) throws Exception {
		
		var optional = contaCorrenteRepository.findById(form.getContaId());
		
		if(!optional.isPresent()) throw new Exception("Conta inválida");
		
		var conta = optional.get();
		
		if(conta.getAtivo().equals(false)) throw new Exception("Conta inativa");
		
		var operacao = OperacaoFactory.Create(form);
		
		repository.save(operacao);
		
		conta.setSaldo(conta.getSaldo() + form.getValor());
		
		contaCorrenteRepository.save(conta);
		
		return OperacaoDtoFactory.Create(operacao);
	}

	public OperacaoDto findById(UUID id) {
		
		var operacao = repository.findById(id.toString());
		
		if(!operacao.isPresent()) return null;
		
		return OperacaoDtoFactory.Create(operacao.get());
	}

	public List<OperacaoDto> findExtratoByContaCorrenteId(UUID contaCorrenteId) {
		
		List<Operacao> operacoes = repository.findByContaId(contaCorrenteId.toString());
		
		return operacoes.stream().map(OperacaoDtoFactory::Create).collect(Collectors.toList());
	}

}
