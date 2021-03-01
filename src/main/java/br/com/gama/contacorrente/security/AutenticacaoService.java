package br.com.gama.contacorrente.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.gama.contacorrente.repositorios.LoginRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	@Autowired
	private LoginRepository repository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		var login = repository.findByUsuario(username);
		
		if(login == null) throw new UsernameNotFoundException("Usuário inválido");
		
		return login;
	}

}
