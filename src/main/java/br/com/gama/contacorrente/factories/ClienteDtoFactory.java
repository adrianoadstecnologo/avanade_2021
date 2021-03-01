package br.com.gama.contacorrente.factories;

import java.util.List;
import java.util.stream.Collectors;

import br.com.gama.contacorrente.dto.ClienteDto;
import br.com.gama.contacorrente.entidades.Cliente;

public class ClienteDtoFactory {
	
	public static ClienteDto Create(Cliente cliente) {
		
		ClienteDto dto = new ClienteDto();
		
		dto.setNome(cliente.getNome());
		dto.setSobrenome(cliente.getSobrenome());
		dto.setTelefone(cliente.getTelefone());
		dto.setEmail(cliente.getEmail());
		dto.setUsuario(cliente.getLogin().getUsuario());
		dto.setId(cliente.getId());
		dto.setContas(ContaCorrenteDtoFactory.Create(cliente.getContas()));
		
		return dto;
	}
	
	public static List<ClienteDto> Create(List<Cliente> clientes) {
		
		return clientes.stream().map(ClienteDtoFactory::Create).collect(Collectors.toList());
	}

}
