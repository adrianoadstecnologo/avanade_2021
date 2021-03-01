package br.com.gama.contacorrente.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gama.contacorrente.dto.ClienteDto;
import br.com.gama.contacorrente.factories.ClienteDtoFactory;
import br.com.gama.contacorrente.factories.ClienteFactory;
import br.com.gama.contacorrente.forms.ClienteForm;
import br.com.gama.contacorrente.repositorios.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public ClienteDto update(UUID id, ClienteForm form) {

		var cliente = repository.getOne(id);

		if (cliente == null) return null;

		cliente.setNome(form.getNome());
		cliente.setSobrenome(form.getSobrenome());
		cliente.setTelefone(form.getTelefone());
		cliente.setEmail(form.getEmail());
		cliente.getLogin().setSenha(CriptografaSenha(form.getSenha()));
		
		return ClienteDtoFactory.Create(cliente);
	}
	
	public ClienteDto findById(UUID id) {
		
		var optional = repository.findById(id);
		
		if(!optional.isPresent()) return null;
			
		return ClienteDtoFactory.Create(optional.get());
	}
	
	public List<ClienteDto> findAll(){
		
		return ClienteDtoFactory.Create(repository.findAll());
	}
	
	public ClienteDto add(ClienteForm form) {
		
		var cliente = ClienteFactory.Create(form);
		
		var senhaCriptografada = CriptografaSenha(cliente.getLogin().getSenha()); 
				
		cliente.getLogin().setSenha(senhaCriptografada);
		
		repository.save(cliente);
		
		return ClienteDtoFactory.Create(cliente);
		
		
	}

	public Boolean delete(UUID id) {
		
		var optional = repository.findById(id);
		
		if(optional.isPresent()) {
			repository.deleteById(id);
			
			return true;
		}
		
		return false;
	}
	
	private String CriptografaSenha(String senha) {
	
		return new BCryptPasswordEncoder().encode(senha);
	}
}

// controller -> service (negocio) -> repository (dados)
