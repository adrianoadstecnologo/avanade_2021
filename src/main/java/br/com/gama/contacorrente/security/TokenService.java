package br.com.gama.contacorrente.security;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.gama.contacorrente.entidades.Login;
import br.com.gama.contacorrente.util.PrintUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	@Value("${security.jwt.secret}")
	private String secret;

	
	@Value("${security.jwt.expiration}")
	private String expiration;
	
	public String gerar(Authentication authentication) {
				
		Login logado = (Login) authentication.getPrincipal();
		
		Date hoje = new Date();
		
		Date expiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return Jwts.builder()
				.setIssuer("Gama.ContaCorrenteApp")
				.setSubject(logado.getId().toString())
				.setIssuedAt(hoje)
				.setExpiration(expiracao)
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	
	public boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public UUID getUsuarioId(String token) {
		
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		
		return UUID.fromString(claims.getSubject());
	}

}
