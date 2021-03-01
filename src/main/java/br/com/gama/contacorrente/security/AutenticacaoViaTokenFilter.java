package br.com.gama.contacorrente.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.gama.contacorrente.repositorios.LoginRepository;
import br.com.gama.contacorrente.util.PrintUtil;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

	private TokenService tokenService;
	
	private LoginRepository loginRepository;
	
	
	public AutenticacaoViaTokenFilter(TokenService tokenService, LoginRepository loginRepository) {
		this.tokenService = tokenService;
		this.loginRepository = loginRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = getToken(request);
		
		Boolean tokenValido = tokenService.isValid(token);
		
		if(tokenValido) autenticarCliente(token);
		
		filterChain.doFilter(request, response);
	}
	
	private String getToken(HttpServletRequest request) {
		
		var token = request.getHeader("Authorization");
		
		if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		
		return token.substring(7, token.length());
	}
	
	private void autenticarCliente(String token) {
		
		var usuarioId = tokenService.getUsuarioId(token);
		
		var login  = loginRepository.findById(usuarioId).get();
		
		var autenticacao = new UsernamePasswordAuthenticationToken(login, null, login.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(autenticacao);
	}
}
