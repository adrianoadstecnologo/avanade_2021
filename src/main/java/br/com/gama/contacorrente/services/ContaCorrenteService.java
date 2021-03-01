package br.com.gama.contacorrente.services;

import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gama.contacorrente.dto.ContaCorrenteDto;
import br.com.gama.contacorrente.entidades.ContaCorrente;
import br.com.gama.contacorrente.factories.ContaCorrenteDtoFactory;
import br.com.gama.contacorrente.forms.ContaCorrenteForm;
import br.com.gama.contacorrente.repositorios.ClienteRepository;
import br.com.gama.contacorrente.repositorios.ContaCorrenteRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public ContaCorrenteDto add(ContaCorrenteForm form) {
		
		var cliente = clienteRepository.getOne(form.getClienteId());
		
		if(cliente == null) return null;
		
		var cc = new ContaCorrente(0.0, null);
		
		cliente.getContas().add(cc);
		
		clienteRepository.save(cliente);
		
		return ContaCorrenteDtoFactory.Create(cc);
	}
	
	public ContaCorrenteDto findById(UUID id) {
		
		var optional = repository.findById(id);
		
		if(!optional.isPresent()) return null;
		
		return ContaCorrenteDtoFactory.Create(optional.get());
		
	}
	
	public void delete(UUID id) throws Exception {
	
		var cliente = clienteRepository.findByContas_Id(id);
		
		if(cliente == null) throw new Exception("Conta inválida");
		
		if(cliente.getContas().size() == 1) throw new Exception("O cliente possui apenas uma conta");
		
		var conta = cliente.getContas().stream().filter(cc -> cc.getId().equals(id)).findFirst().get();
		
		if(!conta.getSaldo().equals(0.0)) throw new Exception("O conta possui saldo diferente de 0");
		
		cliente.getContas().remove(conta);
	}
}
