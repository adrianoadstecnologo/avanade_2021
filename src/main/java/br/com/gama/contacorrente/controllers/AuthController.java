package br.com.gama.contacorrente.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gama.contacorrente.dto.TokenDto;
import br.com.gama.contacorrente.factories.ResponseEntityFactory;
import br.com.gama.contacorrente.forms.LoginForm;
import br.com.gama.contacorrente.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping
	@ResponseBody
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form){
		
		var login = new UsernamePasswordAuthenticationToken(form.getUsuario(), form.getSenha());
		
		Authentication authentication = authManager.authenticate(login);
		
		var token = tokenService.gerar(authentication);
		
		var dto = new TokenDto(token, "Bearer");
		
		return ResponseEntityFactory.Create(dto);
		
	}
	
}
